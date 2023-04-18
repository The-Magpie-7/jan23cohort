<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- for validation -->
<%@ page isErrorPage="true" %>

<html>
<head>
 <!-- Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Burger Tracker</title>
</head>
<body>
	<nav class="container">
		<div class="nav-item">
			<a href="/" style="float:right">Go Back</a>
			<br>
		</div>
	</nav>
	<div class="container">
		<form:form action="/burger/${burger.id}/update" method="POST" modelAttribute="editBurgerForm">
			<input type="hidden" name="_method" value="put">
			<div class="mb-3">
				<form:label path="name">Burger Name</form:label>
				<form:input type="text" path="name" class="form-control" value="${ burger.name }"/>
				<form:errors path="name" class="text-warning" />
			</div>
			<div class="mb-3">
				<form:label path="restaurant">Restaurant Name</form:label>
				<form:input path="restaurant" type="text" class="form-control" value="${ burger.restaurant }"/>
				<form:errors path="restaurant" class="text-warning" />
			</div>
			<div class="mb-3">
			<form:label path="rating" >Rating</form:label>
				<form:select path="rating" id="dropdown" name="rating" class="form-select" style="width:190px" value="${ burger.rating }">
	              <option value="${burger.rating }" disabled="disabled" selected="selected" >${burger.rating }</option>
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
				<textarea name="notes" class="form-control" rows="5" cols="40"><c:out value="${burger.notes}"/></textarea>
				<form:errors path="notes" class="text-warning" />
			</div>
			<div>
				<button class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>
	
</body>
</html>