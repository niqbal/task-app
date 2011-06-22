package com.force.sevlets;

import com.force.model.Project;
import com.force.service.DatabaseService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: niqbal
 * Date: 6/22/11
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class NewProject extends HttpServlet {
    public static Logger logger = Logger.getLogger("com.force.servlets");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") != null) {
            Project p = DatabaseService.getProject(request.getParameter("id"));
            request.setAttribute("project", p);
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/new_project.jsp");
        rd.forward(request, response);
    }
}
