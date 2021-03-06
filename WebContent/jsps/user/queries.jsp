<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>List of Queries</h1>
    <br/>
    <h2>List the users in the user table</h2>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp;  
    <br/>  
    <h2>First three simples queries</h2>
    <br/>
 	<a href="<c:url value='/findAllTrainers'/>" target="body">List trainers with employee id that's less than 200</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/findAllManager_2003_2005'/>" target="body">Manager id between 2003 and 2005</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/findClientWeightBelow180'/>" target="body">Clients below 180 pounds</a>&nbsp;&nbsp;
    <br/>
    <h2>First three aggregate queries</h2>
    <a href="<c:url value='/findKeto'/>" target="body">Number of ketos in program (COUNT)</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/findWeightAvg'/>" target="body">Average weight of client above 18 (AVG)</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/programConcat'/>" target="body">Concatenate program_name and description (CONCAT)</a>&nbsp;&nbsp;
    <br/>
    <h2>First three complex queries</h2>
    <a href="<c:url value='/findTrainerClient'/>" target="body">Trainer and client (JOIN)</a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/findTrainerClientSpecialCondition'/>" target="body">Complex Query 2 (correlated subquery without EXIST): The query identifies trainers that are training unhealthy male individuals within the age range of 20-39 </a>&nbsp;&nbsp;
    <br/>
    <a href="<c:url value='/findTrainerComplexQuery3'/>" target="body">SELECT first_name as complex_query3 from trainer WHERE EXISTS ( SELECT first_name from client WHERE client.trainer_id = trainer.employee_id and age = 19</a>&nbsp;&nbsp;      
  </body>
</html>
