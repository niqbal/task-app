<%@ tag import="com.force.sdk.connector.ForceServiceConnector" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="breadcrumb" required="true" rtexprvalue="true"%>
<%@ attribute name="hidesearch" required="false" rtexprvalue="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>Database.com Projects and Tasks</title>
	<link href="${pageContext.request.contextPath}/resources/layout.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="header"><div id="app_title">Projects and Tasks</div></div>
	<form action="" method="get">
		<div id="navigation">${breadcrumb}
		</div>
	</form>
	<div id="content">
        <%
            ForceServiceConnector c = new ForceServiceConnector();
            request.setAttribute("name", c.getConnection().getUserInfo().getUserName());
            request.setAttribute("orgName", c.getConnection().getUserInfo().getOrganizationName());
            request.setAttribute("orgId", c.getConnection().getUserInfo().getOrganizationId());
        %>
        Hello <%=c.getConnection().getUserInfo().getUserName()%>,
        <p></p>
        You are logged on to organization ${orgName} (Organization Id: ${orgId}).
		<jsp:doBody/>
	
	</div>
	<div id="footer"></div>
</body>
</html>
