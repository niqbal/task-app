<jsp:useBean id="project" scope="request" class="com.force.model.Project" ></jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:mainlayout>

	<jsp:attribute name="breadcrumb"><a href="index.jsp">Home</a> / <a href="ProjectList">Projects</a> / ${project.name}</jsp:attribute>
    <jsp:attribute name="hidesearch">true</jsp:attribute>
	<jsp:body>

        <form action="SaveProject" >
		<table>
			<tr>
                <input type="hidden" size="40" name="id" value="${project.id}" />
				<td>Name:</td><td><input type="text" size="40" name="name" value="${project.name}" /> </td>
			</tr>
			<tr>
				<td>Description:</td><td><input type="text" size="40" name="desc"  value="${project.desc}" /></td>
			</tr>
		</table>
		<p/>

		<input type="submit" value="Save"/>
		<input type="button" value="Projects List" onclick="location.href='ProjectList'"/>

		</form>


        <c:if test="${project.id!=null}">
        <form action="SaveTask">
            <table>
                <tr>
                    <input type="hidden" size="40" name="project_id" value="${project.id}" />
                    <td>Task Name:</td><td><input type="text" size="40" name="name" /> </td>
                </tr>
                <tr>
                    <td>Task Description:</td><td><input type="text" size="40" name="desc"  /></td>
                </tr>
            </table>
            <input type="submit" value="Add Task"/>
        </form>

        <table border="1">
            <tr>
                <th>Task Name</th>
                <th>Task Description</th>
            </tr>
        <c:forEach items="${project.tasks}" var="t">
                <tr>
                    <td><input type="text" size="40" name="name" value="${t.name}"/> </td>
                    <td><input type="text" size="40" name="desc"  value="${t.desc}"/></td>
                </tr>
        </c:forEach>
        </table>
    </c:if>

	</jsp:body>


</tags:mainlayout>
