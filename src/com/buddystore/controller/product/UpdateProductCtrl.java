package com.buddystore.controller.product;

import com.buddystore.dto.Category;
import com.buddystore.dto.Notice;
import com.buddystore.dto.Product;
import com.buddystore.model.NoticeDAO;
import com.buddystore.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/UpdateProduct.do")
public class UpdateProductCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "상품 정보를 수정합니다.";
        int pno = Integer.parseInt(request.getParameter("pno"));

        ProductDAO dao = new ProductDAO();
        Product pro = dao.getProduct(pno);
        List<Category> cateList = dao.getCategoryList();

        request.setAttribute("cateList", cateList);
        request.setAttribute("msg", msg);
        request.setAttribute("pro", pro);

        RequestDispatcher view = request.getRequestDispatcher("/product/updateProduct.jsp");
        view.forward(request,response);
    }
}
