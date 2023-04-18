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
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"> 
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <!-- My CSS -->
    <link rel='stylesheet' href='/css/styles.css'>
    <!-- JS for Bootstrap / jQuery -->
    <script src='/webjars/jquery/jquery.min.js'>    </script>
    <script src='/webjars/bootstrap/js/boostrap.min.js'>    </script>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous">    </script>
    <!-- My JS -->
    <script type = "text/javascript" src='/js/scripts.js'></script>
    <meta charset="UTF-8">

    <!-- Title -->
    <title>Save Travels</title>
</head>
<body>
    <!-- HEADER -->
	<nav class="navbar bg-light">
		<div class="container-fluid">
	  		<a class="navbar-brand" href="/">Home</a>
	  		<a class="navbar-brand" href="/addExpense">Expenses</a>
	 	</div>
	</nav>
    <!-- MAIN -->
   	<div class="container">
		<h1>Save Travels</h1>
	</div>
    <main class="">
	    <div class="container">
			<table class="table table-striped">
			  <thead>
			    <tr>
			    	<th scope="col">Expense</th>
				    <th scope="col">Vendor</th>
				    <th scope="col">Amount</th>
				    <th scope="col">Actions</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${ allExpenses }" var="e">
			  	<tr>
			      <td><a href="/expense/${e.id}/view">${ e.expense }</a></td>
			      <td>${ e.vendor }</td>
			      <td>$${ e.amount }</td>
			      <td><a href="/expense/${e.id}/editExpense">edit</a></td>
			   		<td>
						<form:form id="deleteForm" action="/deleteExpense/${e.id}" method="post" modelAttribute="deleteForm">
    						<input type="hidden" name="_method" value="delete">
    						<input type="submit" value="delete" class="btn btn-link" onclick="return confirm('Are you sure you want to delete this item?')">
						</form:form>
					</td>
			    </tr>
			  </c:forEach>
			 </tbody>
		</table>
	</div>
	
	<div class="container">
		<h3>Add an expense:</h3>
		<form:form action="/createExpense" method="POST" modelAttribute="addExpenseForm">
			<div class="mb-3">
				<form:label path="expense">Expense Name:</form:label>
				<form:input type="text" path="expense" class="form-control" />
				<form:errors path="expense" class="text-warning" />
			</div>
			<div class="mb-3">
				<form:label path="vendor">Vendor:</form:label>
				<form:input type="text" path="vendor" class="form-control" />
				<form:errors path="vendor" class="text-warning" />
			</div>
			<div class="mb-3">
				<form:label path="amount">Amount:</form:label>
				<form:input type="currency" currencySymbol="$" path="amount" class="form-control" />
				<form:errors path="amount" class="text-warning" />
			</div>
			<div class="mb-3">
				<form:label path="description">Description:</form:label>
				<form:textarea type="text" path="description" class="form-control" rows="5" />
				<form:errors path="description" class="text-warning" />
			</div>
			<div>
				<button class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>
	
	<div>

	</div>
    </main>
    <!-- FOOTER -->
    <footer>

    </footer>
</body>
</html>