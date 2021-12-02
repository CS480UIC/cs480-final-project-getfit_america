<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Client Create</title>
    
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
<form action="<c:url value='/ClientServletCreate'/>" method="post">

	ID    :<input type="text" name="client_id" value="${form.client_id }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>		
	Trainer ID    :<input type="text" name="trainer_id" value="${form.trainer_id }"/>
	<span style="color: red; font-weight: 900">${errors.trainerid }</span>
	<br/>	
	First Name：<input type="text" name="first_name" value="${form.first_name }"/>
	<span style="color: red; font-weight: 900">${errors.first_name }</span>
	<br/>
	Last Name：<input type="text" name="last_name" value="${form.last_name }"/>
	<span style="color: red; font-weight: 900">${errors.last_name }</span>
	<br/>
	Age	：<input type="text" name="age" value="${form.age }"/>
	<span style="color: red; font-weight: 900">${errors.age }</span>
	<br/>
	Weight	：<input type="text" name="weight" value="${form.weight }"/>
	<span style="color: red; font-weight: 900">${errors.weight }</span>
	<br/>
	Body Fat Percentage	：<input type="text" name="body_fat" value="${form.body_fat }"/>
	<span style="color: red; font-weight: 900">${errors.body_fat }</span>
	<br/>
	
	<input type="submit" value="Create Client"/>
</form>
  </body>
</html>
