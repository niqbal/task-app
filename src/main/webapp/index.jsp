<%@ page import="java.util.List" %>
<%@ page import="com.force.service.DatabaseService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<%
    List list = DatabaseService.getTaskList();
    request.setAttribute("list",list);

%>


<tags:mainlayout>


	<jsp:attribute name="breadcrumb"><a href="..">Home</a> / Artists</jsp:attribute>
	
	<jsp:body>
		<table class="itemlist" width="100%">
			<tr>
				<th>Name</th><th>Desc</th>
			</tr>
			<c:forEach items="${list}" var="task">
				<tr>
					<td><a href="${task.id}">${task.name}</a></td>
					<td>${task.desc}</td>
				</tr>
			</c:forEach>
		</table>
		<p/>
		<form action="" method="post">
			<input type="button" name="New Task" value="New Task" onclick="location.href='new.jsp'"/>
		</form>
	</jsp:body>

</tags:mainlayout>