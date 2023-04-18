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
    <title>Add Book</title>
</head>
<body>
       <!-- HEADER -->
    <header class=container>
	<nav class="navbar navbar-expand-md navbar-light bg-light">
	  <a class="navbar-brand" href="">Book Club</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="/welcome">back to the shelves</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	<h1 >Add a Book to Your Shelf!</h1>
	<br>
    </header>
    <!-- MAIN -->
    <main>
		<div class="container">
			<div class="form-group">
				<form:form method="post" action="/createBook" modelAttribute="bookForm">

			  		<div class="form-group">
					    <form:label path="title">Title</form:label>
					    <form:input path="title" type="text" class="form-control" />
					    <form:errors path="title" class="text-warning" />
			  		</div>
			  		<div class="form-group">
					    <form:label path="author">Author</form:label>
					    <form:input path="author" type="text" class="form-control" />
					    <form:errors path="author" class="text-warning" />
			  		</div>
			  		<div class="form-group">
					    <form:label path="thoughts">My thoughts</form:label>
					    <form:input path="thoughts" type="text" class="form-control" />
					    <form:errors path="thoughts" class="text-warning" />
				  	</div>
					<div>
						<input type="hidden" name="user" value="${ user_id }" />
					</div>
			  	<div>
			  		<br>
			  		<button class="btn btn-primary">Submit</button>
			  	</div>
			  </form:form>
			</div>
		</div>
		
		
    </main>
    <!-- FOOTER -->
    <footer>

    </footer>
</body>
</html>