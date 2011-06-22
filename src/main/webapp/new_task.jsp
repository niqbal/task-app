 <jsp:useBean id="task" scope="request" class="com.force.model.Task" ></jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:mainlayout>

	<jsp:attribute name="breadcrumb"><a href="index.jsp">Home</a> / <a href="task_list.jsp">Tasks</a> / ${task.name}</jsp:attribute>
    <jsp:attribute name="hidesearch">true</jsp:attribute>

	<jsp:body>
		<form action="SaveTask">
		<table>
			<tr>
                <input type="hidden" size="40" name="id" value="${task.id}" />
				<td>Name:</td><td><input type="text" size="40" name="name" value="${task.name}" /> </td>
			</tr>
			<tr>
				<td>Description:</td><td><input type="text" size="40" name="desc" value="${task.desc}"/></td>
			</tr>
		</table>
		<p/>

		<input type="submit" value="Save"/>
		<input type="button" value="Tasks List" onclick="location.href='TaskList'"/>

		</form>
	</jsp:body>

</tags:mainlayout>
