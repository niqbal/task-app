package com.force.servlets;

import com.force.model.Project;
import com.force.service.DatabaseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: niqbal
 * Date: 6/22/11
 * Time: 9:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class SaveProject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Project project = new Project();
        project.setId(request.getParameter("id"));
        project.setName(request.getParameter("name"));
        project.setDesc(request.getParameter("desc"));
        DatabaseService.saveProject(project);
        response.sendRedirect("ProjectList");
    }
}
