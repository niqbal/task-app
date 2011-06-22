<%@ page import="com.force.service.DatabaseService" %>
<jsp:useBean id="project" scope="request" class="com.force.model.Project" >

<%--
  Created by IntelliJ IDEA.
  User: niqbal
  Date: 6/21/11
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <jsp:setProperty name="project" property="*"/>

    <%
        DatabaseService.saveProject(project);
        response.sendRedirect("project_list.jsp");
    %>

<html>
<head><title>Save page</title></head>

<body>Redirecting momentarily ...</body>


</html>

</jsp:useBean>