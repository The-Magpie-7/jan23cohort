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
    <title>Book Details</title>
</head>
<body>
    <!-- HEADER -->
    <header class=container>
	<nav class="navbar navbar-expand-md navbar-light bg-light">
	  <a class="navbar-brand" href="/">Book Club</a>
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
	<br>
    </header>

    <!-- MAIN -->
    <main class="container">
	<div>
		<div>
			<h1 class="bookTitle"><c:out value="${ book.title }">${ book.title }</c:out></h1>
		</div>
		<br>
		<br>
		<div>
			
				<c:if test="${ user_id == book.user.id }">
				<div>
					<div class="container">
						<h4 class="row">You read </h4> <h4 class="purple row"><c:out value="${ book.title }">${ book.title }</c:out></h4>
						<h4 class="row">by</h4>
						<h4 class="green row"><c:out value="${ book.author }">${ book.author }.</c:out></h4>
						<br>
					</div>
					<div>
						<br>
						<h4>Here are your thoughts:</h4>
					</div>
				</div>
				</c:if>
				
				
				<c:if test="${ user_id != book.user.id }">
					<div class="container">
						<h4 class="red row"><c:out value="${ book.user.name }">${ book.user.name }</c:out></h4>
						<h4 class="row"> read </h4>
						<h4 class="purple row"><c:out value="${ book.title }">${ book.title }</c:out></h4>
						<h4 class="row"> by </h4>
						<h4 class="green row"><c:out value="${ book.author }">${ book.author }.</c:out></h4>
					</div>
					<div>
					<br>
						<h4>Here are <c:out value="${ book.user.name }">${ book.user.name }</c:out>'s thoughts:</h4>
					</div>
				</c:if>
				
			</div>
		</div>
		<div>
			<hr>
				<p >
					<c:out value="${ book.thoughts }">${ book.thoughts }</c:out>
				</p>
			<hr>
		</div>

	<c:if test="${ user_id == book.user.id }">
		<div class="container d-flex justify-content-end">
			<a href="/editBook/${ book.id }" class="btn btn-info mx-3">edit</a>
			
			<form action="/deleteBook/${book.id}" method="post">
		    	<input type="hidden" name="_method" value="destroy">
		    	<input type="submit" value="destroy" class="btn btn-info">
			</form>
		</div>
	</c:if>
    </main>
    <!-- FOOTER -->
    <footer>

    </footer>
</body>
</html>