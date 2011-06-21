<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page session="false" %>

<tags:mainlayout>

<jsp:attribute name="breadcrumb">Home</jsp:attribute>
<jsp:attribute name="hidesearch">true</jsp:attribute>

<jsp:body>
<p><a href="task_list.jsp">Tasks</a></p>

<p><a href="project_list.jsp">Projects</a></p>

</jsp:body>
</tags:mainlayout>
