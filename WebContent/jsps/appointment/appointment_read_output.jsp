<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Appointment Output</title>
    
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
  <h1>Read Appointment Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Selected Program    :<input type="text" name="selected_prog" value="${appointment.selected_prog }"disabled/>
	<span style="color: red; font-weight: 900">${errors.selected_prog }</span>
	<br/>
	
	Appointment Date    :<input type="text" name="appointment_date" value="${appointment.appointment_date }"disabled/>
	<span style="color: red; font-weight: 900">${errors.appointment_date }</span>
	<br/>
	
	Location    :<input type="text" name="location" value="${appointment.location }"disabled/>
	<span style="color: red; font-weight: 900">${errors.location }</span>
	<br/>
	
	Program app number    :<input type="text" name="program_app_num" value="${appointment.program_app_num }"disabled/>
	<span style="color: red; font-weight: 900">${errors.program_app_num }</span>
	<br/>

</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
