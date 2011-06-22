package com.force.sevlets;

import com.force.service.DatabaseService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: niqbal
 * Date: 6/22/11
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class NewTask extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("id"));
        if(request.getParameter("id") != null) {
            request.setAttribute("task", DatabaseService.getTask(request.getParameter("id")));
        }

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/new_task.jsp");
		rd.forward(request, response);
    }
}
