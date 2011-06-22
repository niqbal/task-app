<jsp:useBean id="list" type="java.util.List"  scope="request"></jsp:useBean>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<tags:mainlayout>


    <jsp:attribute name="breadcrumb"><a href="index.jsp">Home</a> / Tasks</jsp:attribute>
	
	<jsp:body>
		<table class="itemlist" width="100%">
			<tr>
				<th>Name</th><th>Description</th><th>Parent Project</th>
			</tr>
			<c:forEach items="${list}" var="task">
				<tr>
                    <td><a href="NewTask?id=${task.id}">${task.name}</a></td>
					<td>${task.desc}</td>
                    <td>${task.project.name}</td>
				</tr>
			</c:forEach>
		</table>
		<p/>
		<form action="" method="post">
			<input type="button" name="New Task" value="New Task" onclick="location.href='NewTask'"/>
		</form>
	</jsp:body>

</tags:mainlayout>