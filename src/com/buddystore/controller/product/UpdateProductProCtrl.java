package com.buddystore.controller.product;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.buddystore.dto.Product;
import com.buddystore.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/UpdateProductPro.do")
public class UpdateProductProCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        ServletContext application = request.getServletContext();
        String home = application.getContextPath();
        try {
            String saveDirectory = application.getRealPath("/storage"); //실제 저장 경로
            File storageDirectory = new File(saveDirectory);
            if (!storageDirectory.exists()) {
                if (storageDirectory.mkdir()) {
                    System.out.println("Storage directory created: " + saveDirectory);
                }
            }

            int maxSize = 1024*1024*10;     //10MB
            String encoding = "UTF-8";

            MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxSize, encoding, new DefaultFileRenamePolicy());
            Product pro = new Product();
            pro.setPname(mr.getParameter("pname"));
            pro.setPcomment(mr.getParameter("pcomment"));
            pro.setPlist(mr.getParameter("plist"));
            pro.setPrice(Integer.parseInt(mr.getParameter("price")));
            pro.setImgSrc1(mr.getParameter("imgSrc1"));
            pro.setImgSrc2(mr.getParameter("imgSrc2"));
            pro.setImgSrc3(mr.getParameter("imgSrc3"));
            pro.setPno(Integer.parseInt(mr.getParameter("pno")));

            File upfile = null;
            Enumeration files = mr.getFileNames();

            while (files.hasMoreElements()) {
                String fieldName = (String) files.nextElement();
                String fileName = mr.getFilesystemName(fieldName);
                if (fileName != null) {
                    upfile = mr.getFile(fieldName); //실제 업로드
                    if (upfile.exists()) {
                        if ("imgsrc1".equals(fieldName)) {
                            pro.setImgSrc1(mr.getFile(fieldName).getName());
                        } else if ("imgsrc2".equals(fieldName)) {
                            pro.setImgSrc2(mr.getFile(fieldName).getName());
                        } else if ("imgsrc3".equals(fieldName)) {
                            pro.setImgSrc3(mr.getFile(fieldName).getName());
                        }
                        msg = "파일 업로드 성공";
                    } else {
                        msg = "파일 업로드 실패";
                    }
                }
            }

            ProductDAO dao = new ProductDAO();
            int cnt = dao.updateProduct(pro);

            response.sendRedirect(home+"/ProList.do");

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
