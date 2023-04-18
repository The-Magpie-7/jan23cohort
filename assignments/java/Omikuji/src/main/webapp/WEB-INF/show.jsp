<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for BOOTSTRAP CSS - **goes in jsp files <head>**  - BOOTSTRAP-->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Show Omikuji</title>
</head>
<body>
	<div class="container">
      <div class="row">
        <div class="col-sm-12">
          <h1>Here's Your Omikuji!</h1>
          <div class="panel panel-info">
           
            <div class="panel-body">
               <h2>In <span><c:out value="${ number }"></c:out></span> years, you will live in <span><c:out value="${ city }"></c:out></span> with <span><c:out value="${ name }"></c:out></span> as your roommate, selling <span><c:out value="${ hobby }"></c:out></span> for a living. The next time you see a <span><c:out value="${ thing }"></c:out></span>, you will have good luck. Also, <span><c:out value="${ say }"></c:out></span>.</h2>
            </div>
          </div>
          <div class="anchor"><a href="/">Go Back</a></div>
          
        </div>
      </div>
    </div>
</body>
</html>