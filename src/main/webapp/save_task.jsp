<%@ page import="com.force.service.DatabaseService" %>
<jsp:useBean id="task" scope="request" class="com.force.model.Task" >

<%--
  Created by IntelliJ IDEA.
  User: niqbal
  Date: 6/21/11
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <jsp:setProperty name="task" property="*"/>

    <%=request.getParameter("project_id")%>
    <%=request.getQueryString()%>
    <%=request.getAttribute("project_id")%>
    <%=request.getRequestURI()%>

    <%
        if (request.getParameter("project_id") != null) {
            DatabaseService.saveTask(request.getParameter("project_id").toString(), task);
            response.sendRedirect("new_project.jsp?id="+request.getParameter("project_id").toString());
        }
        else {
            DatabaseService.saveTask(task);
            response.sendRedirect("task_list.jsp");
        }
    %>

<html>
<head><title>Save page</title></head>

<body>Redirecting momentarily ...</body>


</html>

</jsp:useBean>