<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Manager</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Read Manager</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Entity1ServletRead'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
	
	Manager ID    :<input type="text" name="first name" value="${form.managerID }"/>
	<span style="color: red; font-weight: 900">${errors.managerID }</span>
	<br/>	

	First Name    :<input type="text" name="first name" value="${form.firstName }"/>
	<span style="color: red; font-weight: 900">${errors.firstName }</span>
	<br/>

	Last Name    :<input type="text" name="first name" value="${form.lastName }"/>
	<span style="color: red; font-weight: 900">${errors.lastName }</span>
	<br/>

	<input type="submit" value="Read Manageer"/>
</form>
  </body>
</html>
