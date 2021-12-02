<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Manager</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

  </head>
  
  <body>
  <h1>Create Manager</h1>
<form action="<c:url value='/ManagerServletCreate'/>" method="post">
	Manager ID    :<input type="text" name="id" value="${form.id }"/>
	<span style="color: red; font-weight: 900">${errors.ID }</span>
	<br/>
	
	Assigned Department   :<input type="text" name="assigned department" value="${form.assignedDepartment }"/>
	<span style="color: red; font-weight: 900">${errors.assignedDepartment }</span>
	<br/>
	
	First Name    :<input type="text" name="first name" value="${form.firstName }"/>
	<span style="color: red; font-weight: 900">${errors.firstName }</span>
	<br/>

	Last Name    :<input type="text" name="last name" value="${form.lastName }"/>
	<span style="color: red; font-weight: 900">${errors.lastName }</span>
	<br/>
	
	Created at    :<input type="text" name="created at" value="${form.createdAt }"/>
	<span style="color: red; font-weight: 900">${errors.createdAt }</span>
	<br/>
		
	<input type="submit" value="Create Manager"/>
</form>
  </body>
</html>
