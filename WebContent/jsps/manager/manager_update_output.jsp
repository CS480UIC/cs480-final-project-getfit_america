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
	Manager ID    :<input type="text" name="ID" value="${manager.ID }"disabled/>
	<br/>
	
	Assigned Department   :<input type="text" name="assigned department" value="${manager.assignedDepartment }"disabled/>
	<br/>
	
	First Name    :<input type="text" name="first name" value="${manager.firstName }"disabled/>
	<br/>

	Last Name    :<input type="text" name="last name" value="${manager.lastName }"disabled/>
	<br/>
	
	Created at    :<input type="text" name="created at" value="${manager.createdAt }"disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Entity1ServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="username" value="${manager.ID }"/>
				
				
	Assigned Department   :<input type="text" name="assigned department" value="${form.assignedDepartment }"/>
	<br/>
	
	First Name    :<input type="text" name="first name" value="${form.firstName }"/>
	<br/>

	Last Name    :<input type="text" name="last name" value="${form.lastName }"/>
	<br/>
	
	Created at    :<input type="text" name="created at" value="${form.createdAt }"/>
	<br/>
	<input type="submit" value="Update Manager"/>
</form>

</body>
</html>
