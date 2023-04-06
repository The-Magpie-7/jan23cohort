<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- for validation -->
<%@ page isErrorPage="true" %>



<!DOCTYPE html>
<html>
<head>
 <!-- Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Burger Tracker</title>
</head>
<body>
	<div class="container">
		<h1>Burger Tracker</h1>
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th>Burger Name</th>
		      <th>Restaurant Name</th>
		      <th>Rating (out of 5)</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${allBurgers}" var="i">
		    <tr>
		      <td>${i.name}</td>
		      <td>${i.restaurant}</td>
		      <td>${i.rating}</td>
		    </tr>
		   </c:forEach>
		  </tbody>
		</table>
	</div>
	<div class="container">
	<br>
	<br>
		<form:form action="/createBurger" method="post" modelAttribute="addBurger">
			<div class="mb-3">
				<form:label path="name">Burger Name</form:label>
				<form:input type="text" path="name" class="form-control"/>
				<form:errors path="name" class="text-warning" />
			</div>
			<div class="mb-3">
				<form:label path="restaurant">Restaurant Name</form:label>
				<form:input path="restaurant" type="text" class="form-control"/>
				<form:errors path="restaurant" class="text-warning" />
			</div>
			<div class="mb-3">
			<form:label path="rating" >Rating</form:label>
				<form:select path="rating" id="dropdown" name="rating" class="form-select" style="width:190px">
	              <option value="">--Select a Number--</option>
	              <option value="1">1</option>
	              <option value="2">2</option>
	              <option value="3">3</option>
	              <option value="4">4</option>
	              <option value="5">5</option>
	             </form:select>
				
				<form:errors path="rating" class="text-warning" />
			</div>
			<div class="mb-3">
				<form:label path="notes" >Notes</form:label>
				<form:textarea path="notes" class="form-control" type="text" rows="5" cols="40" />
				<form:errors path="notes" class="text-warning" />
			</div>
			<div>
				<button class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>
	

</body>
</html>