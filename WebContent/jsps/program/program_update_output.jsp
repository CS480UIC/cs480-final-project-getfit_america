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
  <h1>Update Program</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Enrollment Number    :<input type="text" name="enrollment_number" value="${program.enrollment_number }"disabled/>
	<br/>	
	Program ID    :<input type="text" name="program_id" value="${program.program_id }"disabled/>
	<br/>	
	Program Name    :<input type="text" name="program_name" value="${program.program_name }"disabled/>
	<br/>	
	Description    :<input type="text" name="description" value="${program.description }"disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/ProgramServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
		<input type="hidden" name="enrollment_id" value="${program.enrollment_id }"/>
		
		
	Enrollment Number    :<input type="text" name="enrollment_number" value="${form.enrollment_number }"/>
	<br/>	
	Program ID    :<input type="text" name="program_id" value="${form.program_id }"/>
	<br/>	
	Program Name    :<input type="text" name="program_name" value="${form.program_name }"/>
	<br/>	
	Description    :<input type="text" name="description" value="${form.description }"/>
	<br/>
	
	
	<input type="submit" value="Update Program"/>
</form>

</body>
</html>
