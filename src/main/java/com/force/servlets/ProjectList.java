package com.force.servlets;

import com.force.service.DatabaseService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: niqbal
 * Date: 6/22/11
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProjectList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List list = DatabaseService.getList("Project");
        request.setAttribute("list",list);
        System.out.println(list.size() + " projects.");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/project_list.jsp");
		rd.forward(request, response);
    }
}
