<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Entity1 Create</title>
    
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
  <h1>Client Create</h1>
<form action="<c:url value='/Entity1ServletCreate'/>" method="post">
	ID    :<input type="text" name="clientID" value="${form.clientid }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	First Name：<input type="text" name="name" value="${form.firstname }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	Last Name：<input type="text" name="name" value="${form.lastname }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	Age	：<input type="text" name="age" value="${form.age }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	Weight	：<input type="text" name="weight" value="${form.weight }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	Body Fat Percentage	：<input type="text" name="bodyfatpercentage" value="${form.bodyfatpercentage }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	
	<input type="submit" value="Create Client"/>
</form>
  </body>
</html>