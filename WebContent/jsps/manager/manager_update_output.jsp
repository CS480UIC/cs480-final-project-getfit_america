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
  <h1>Update Manager</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Manager ID    :<input type="text" name="id" value="${manager.id }"disabled/>
	<br/>
	
	Assigned Department   :<input type="text" name="assigned department" value="${manager.department_id }"disabled/>
	<br/>
	
	First Name    :<input type="text" name="first name" value="${manager.first_name }"disabled/>
	<br/>

	Last Name    :<input type="text" name="last name" value="${manager.last_name }"disabled/>
	<br/>
	
	Created at    :<input type="text" name="created at" value="${manager.created_at }"disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/ManagerServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
		<input type="hidden" name="id" value="${manager.id }"/>
				
				
	Assigned Department   :<input type="text" name="assigned department_id" value="${form.department_id }"disabled/>
	<br/>
	
	First Name    :<input type="text" name="first_name" value="${form.first_name }"/>
	<br/>

	Last Name    :<input type="text" name="last_name" value="${form.last_name }"/>
	<br/>
	
	Created at    :<input type="text" name="created_at" value="${form.created_at }"/>
	<br/>

	
	<input type="submit" value="Update Manager"/>
</form>

</body>
</html>
