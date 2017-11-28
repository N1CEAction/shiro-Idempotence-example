<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.n1ce.shiro.common.utils.SessionUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h4>Form Page</h4>
	
	<form action="shiro/test/form" method="POST">
		<input type="hidden" name="html_uuid"
			   value="<%=SessionUtils.getSessionUtils().generatorUuid() %>">
		name: <input type="text" name="name"/>
		<br><br>
		
		address: <input type="text" name="address"/>
		<br><br>
		
		<input type="submit" value="Submit"/>
	</form>
	
</body>
</html>