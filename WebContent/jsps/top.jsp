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
			<a href="<c:url value='/jsps/entity1/entity1create.jsp'/>" target="_parent">Create Entity1</a> |&nbsp; 
			<a href="<c:url value='/jsps/entity1/entity1read.jsp'/>" target="_parent">Read Entity1</a> |&nbsp;
			<a href="<c:url value='/jsps/entity1/entity1update.jsp'/>" target="_parent">Update Entity1</a> |&nbsp;	 

			<a href="<c:url value='/jsps/entity1/entity1delete.jsp'/>" target="_parent">Delete Entity1</a>	
			
		
			


			<a href="<c:url value='/jsps/entity1/entity1delete.jsp'/>" target="_parent">Delete Entity1</a>		



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
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/department/department_create.jsp'/>" target="_parent">Create Department</a> |&nbsp; 
			<a href="<c:url value='/jsps/department/department_read.jsp'/>" target="_parent">Read Department</a> |&nbsp;
			<a href="<c:url value='/jsps/department/department_update.jsp'/>" target="_parent">Update Department</a> |&nbsp;	 
			<a href="<c:url value='/jsps/department/department_delete.jsp'/>" target="_parent">Delete Department</a>		

		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/entity1/menu.jsp'/>" target="body">CRUD entity 1</a> |&nbsp;&nbsp;

		</c:otherwise>
	</c:choose>

</div><%-- MANAGER --%>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/manager/manager_create.jsp'/>" target="_parent">Create Manager</a> |&nbsp; 
			<a href="<c:url value='/jsps/manager/manager_read.jsp'/>" target="_parent">Read Manager</a> |&nbsp;
			<a href="<c:url value='/jsps/manager/manager_update.jsp'/>" target="_parent">Update Manager</a> |&nbsp;	 
			<a href="<c:url value='/jsps/manager/manager_delete.jsp'/>" target="_parent">Delete Manager</a>		

		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/entity1/menu.jsp'/>" target="body">CRUD entity 1</a> |&nbsp;&nbsp;

		</c:otherwise>
	</c:choose>

</div>





<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">

			<a href="<c:url value='/jsps/client/client_create.jsp'/>" target="_parent">Create Client</a> |&nbsp; 
			<a href="<c:url value='/jsps/client/clientread.jsp'/>" target="_parent">Read Client</a> |&nbsp;
			<a href="<c:url value='/jsps/client/clientupdate.jsp'/>" target="_parent">Update Client</a> |&nbsp;	 
			<a href="<c:url value='/jsps/client/clientdelete.jsp'/>" target="_parent">Delete Client</a>		

		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/client/menu.jsp'/>" target="body">CRUD Client</a> |&nbsp;&nbsp;

		</c:otherwise>
	</c:choose>

</div>


<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">

			<a href="<c:url value='/jsps/program/program_create.jsp'/>" target="_parent">Create Program</a> |&nbsp; 
			<a href="<c:url value='/jsps/program/programread.jsp'/>" target="_parent">Read Program</a> |&nbsp;
			<a href="<c:url value='/jsps/program/programupdate.jsp'/>" target="_parent">Update Program</a> |&nbsp;	 
			<a href="<c:url value='/jsps/program/programdelete.jsp'/>" target="_parent">Delete Program</a>		

		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/program/menu.jsp'/>" target="body">CRUD Program</a> |&nbsp;&nbsp;

		</c:otherwise>
	</c:choose>

</div>

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




=======
>>>>>>> branch 'main' of git@github.com:CS480UIC/cs480-final-project-getfit_america.git
<%-- CRUD SELECTION FOR ALL ENTITIES --%>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/trainer/menuTrainer.jsp'/>" target="_parent">CRUD Trainer</a> |&nbsp;
			<a href="<c:url value='/jsps/receptionist/menuReceptionist.jsp'/>" target="_parent">CRUD Receptionist</a> |&nbsp;
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

<<<<<<< HEAD


=======
<%-- Receptionist --%>
>>>>>>> branch 'main' of git@github.com:CS480UIC/cs480-final-project-getfit_america.git




  </body>
</html>

