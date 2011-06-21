<jsp:useBean id="project" scope="request" class="com.force.model.Project" >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:mainlayout>

	<jsp:attribute name="breadcrumb"><a href="index.jsp">Home</a> / <a href="project_list.jsp">Projects</a> / ${project.name}</jsp:attribute>
	<jsp:body>
		<form action="save_project.jsp">
		<table>
			<tr>
				<td>Name:</td><td><input type="text" size="40" name="name" /> </td>
			</tr>
			<tr>
				<td>Description:</td><td><input type="text" size="40" name="desc" /></td>
			</tr>
			<tr>
				<td>Active Start:</td><td><input type="text" size="40" name="start-date"/></td>
                <td>Date Format: yyyy-mm-dd</td>
			</tr>
		</table>
		<p/>


    <jsp:setProperty name="project"
                 property="name"
                 param="name" />


		<input type="submit" value="Save"/>
		<input type="button" value="Projects List" onclick="location.href='project_list.jsp'"/>

		</form>
	</jsp:body>
	
</tags:mainlayout>
</jsp:useBean>