<%@page import="jsp.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam04</title>
</head>
<body>

	<h1>JSTL - c:set 2</h1>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%
	   Member member = new Member();
	   pageContext.setAttribute("member", member);
	%>
	
	id: ${member.id}<br>
    email: ${member.email}<br>
    password: ${member.password}<br>
	<hr>
	<c:set target="${member}" property="id" value="user01"/>
	<c:set target="${member}" property="email" value="user01@test.com"/>
    <c:set target="${member}" property="password" value="1111"/>
    
	id: ${member.id}<br>
    email: ${member.email}<br>
    password: ${member.password}<br>
    
</body>
</html>