<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Trainer</title>
    
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
  <h1>Delete Trainer</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/TrainerServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
	<input type="hidden" name="employee_id" value="${trainer.employee_id }"/>
	
	
	
	Employee ID    :<input type="text" name="employee_id" value="${trainer.employee_id }"disabled/>
	<br/>
	First Name：<input type="text" name="First Name" value="${trainer.first_name }"disabled/>
	<br/>
	Last Name	：<input type="text" name="Last Name" value="${trainer.last_name }"disabled/>
	<br/>
	<input type="submit" value="Delete Trainer"/>
</form>

</body>
</html>
 