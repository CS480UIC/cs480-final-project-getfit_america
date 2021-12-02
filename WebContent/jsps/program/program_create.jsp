<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Program Create</title>
    
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
  <h1>Program Create</h1>
<form action="<c:url value='/ProgramServletCreate'/>" method="post">

	Enrollment Number    :<input type="text" name="enrollment_number" value="${form.enrollment_number }"/>
	<span style="color: red; font-weight: 900">${errors.enrollment_number }</span>
	<br/>
	
	Program ID    :<input type="text" name="program_id" value="${form.program_id }"/>
	<span style="color: red; font-weight: 900">${errors.program_id }</span>
	<br/>
	
	Program Name    :<input type="text" name="program_name" value="${form.program_name }"/>
	<span style="color: red; font-weight: 900">${errors.program_name }</span>
	<br/>
	
	Description    :<input type="text" name="description" value="${form.description }"/>
	<span style="color: red; font-weight: 900">${errors.description }</span>
	<br/>
	<input type="submit" value="Create Program"/>
</form>
  </body>
</html>
