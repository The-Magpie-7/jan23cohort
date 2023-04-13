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
    <title>Dojos</title>
</head>
<body>
    <!-- HEADER -->
    <header class=container>
	<nav class="navbar navbar-expand-md navbar-light bg-light">
	  <a class="navbar-brand" href="/">Dojos & Ninjas</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="/newDojo">Add Dojo</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/newNinja">Add Ninja</a>
	      </li>
<!-- 	  <li class="nav-item">
	        <a class="nav-link" href="/viewDojo">View Dojo</a>
	      </li> -->
	    </ul>
	  </div>
	</nav>
	<h1>Dojos and Ninjas</h1>
	<br>
    </header>
    <!-- MAIN -->
    <main>
    <div class="container">
		<h2>Welcome to the Dojo Locator!</h2>
	</div>
	<div class="container">
		<h5>Here you can sign up to attend a Dojo or add a Dojo location.</h5>
		<p>Use the links at the top of the page.</p>
	</div>
    </main>
    <!-- FOOTER -->
    <footer>

    </footer>
</body>
</html>