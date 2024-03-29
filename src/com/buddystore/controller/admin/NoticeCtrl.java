package com.buddystore.controller.admin;

import com.buddystore.dto.Notice;
import com.buddystore.model.NoticeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminNotice.do")
public class NoticeCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        NoticeDAO dao = new NoticeDAO();
        Notice noti = dao.getNotice(no);
        request.setAttribute("noti", noti);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/getNotice.jsp");
        view.forward(request, response);
    }
}
