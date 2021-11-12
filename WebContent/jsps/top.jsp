<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #FFC107; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">Get fit America</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> |&nbsp;

	

		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/entity1/menu.jsp'/>" target="body">CRUD entity 1</a> |&nbsp;&nbsp;

		</c:otherwise>
	</c:choose>

</div>


<%-- DEPARTMENT --%>












<%-- 
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">

			<a href="<c:url value='/jsps/appointment/appointment_create.jsp'/>" target="_parent">Create Appointment</a> |&nbsp; 
			<a href="<c:url value='/jsps/appointment/appointmentread.jsp'/>" target="_parent">Read Appointment</a> |&nbsp;
			<a href="<c:url value='/jsps/appointment/appointmentupdate.jsp'/>" target="_parent">Update Appointment</a> |&nbsp;	 
			<a href="<c:url value='/jsps/appointment/appointmentdelete.jsp'/>" target="_parent">Delete Appointment</a>		

		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/appointment/menu.jsp'/>" target="body">CRUD Appointment</a> |&nbsp;&nbsp;

		</c:otherwise>
	</c:choose>

</div>

--%>


<%-- CRUD SELECTION FOR ALL ENTITIES --%>

<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/trainer/menuTrainer.jsp'/>" target="_parent">CRUD Trainer</a> |&nbsp;
			<a href="<c:url value='/jsps/receptionist/menuReceptionist.jsp'/>" target="_parent">CRUD Receptionist</a> |&nbsp;
			<a href="<c:url value='/jsps/client/menuClient.jsp'/>" target="_parent">CRUD Client</a> |&nbsp;
			<a href="<c:url value='/jsps/program/menuProgram.jsp'/>" target="_parent">CRUD Program</a> |&nbsp;
			<a href="<c:url value='/jsps/appointment/menuAppointment.jsp'/>" target="_parent">CRUD Appointment</a> |&nbsp;

			<a href="<c:url value='/jsps/department/department_menu.jsp'/>" target="_parent">CRUD Department</a> |&nbsp;
			<a href="<c:url value='/jsps/manager/manager_menu.jsp'/>" target="_parent">CRUD Manager</a> |&nbsp;
			

		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/entity1/menu.jsp'/>" target="body">CRUD entity 1</a> |&nbsp;&nbsp;

		</c:otherwise>
	</c:choose>

</div>


<%-- Receptionist --%>





  </body>
</html>

