<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
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
  <h1>Delete Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/ClientServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
	<input type="hidden" name="client_id" value="${client.client_id }"/>
	
	
	
	Client ID    :<input type="text" name="client_id" value="${client.client_id }"disabled/>
	<br/>		
	Trainer ID    :<input type="text" name="trainer_id" value="${client.trainer_id }"disabled/>
	<br/>	
	First Name：<input type="text" name="first_name" value="${client.first_name }"disabled/>
	<br/>
	Last Name：<input type="text" name="Last_name" value="${client.last_name }"disabled/>
	<br/>
	Age	：<input type="text" name="age" value="${client.age }"disabled/>
	<br/>
	Weight	：<input type="text" name="weight" value="${client.weight }"disabled/>
	<br/>
	Body Fat Percentage	：<input type="text" name="body_fat" value="${client.body_fat }"disabled/>
	<br/>
	
	
	<input type="submit" value="Delete Client"/>
	
	
</form>

</body>
</html>
 