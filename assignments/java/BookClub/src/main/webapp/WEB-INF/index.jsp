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
    <title>Book Club</title>
</head>
<body>
    <!-- HEADER -->
    <header class=container>
	<nav class="navbar navbar-expand-md navbar-light bg-light">
	  <a class="navbar-brand" href="/">Login and Registration</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="/logout">logout</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	<br>
    </header> 
    <!-- MAIN -->
    <main>
	    <div class="container">
	    	<h1>Book Club</h1>
	    </div>
	    <div class="container">
	    	<h5>A place for friends to share thoughts on books.</h5>
		</div>
    
     	<!-- register -->
    	<form:form action="/register" method="POST" modelAttribute="newUser"  class="mx-5 my-2">
            <div class="border text-center py-3">
                <h3>Register</h3>
            </div>
            <div class="border py-2">
                <section>
                    <form:label path="name" class="border-end w-50 ps-2 me-1">Name:</form:label>
                    <form:input type="text" class="input" path="name" />
                </section>
                <form:errors path="name" class="text-danger ps-2" />
            </div>

            <div class="border py-2">
                <section>
                    <form:label path="email" class="border-end w-50 ps-2 me-1">Email:</form:label>
                    <form:input type="email" class="input" path="email" />
                </section>
                <form:errors path="email" class="text-danger ps-2" />
            </div>

            <div class="border py-2">
                <section>
                    <form:label path="password" class="border-end w-50 ps-2 me-1">Password:</form:label>
                    <form:input type="password" class="input" path="password" />
                </section>
                <form:errors path="password" class="text-danger text-right" />
            </div>

            <div class="border py-2">
                <section>
                    <form:label path="confirmPassword" class="border-end w-50 ps-2 me-1">Confirm Password:</form:label>
                    <form:input type="password" class="input" path="confirmPassword" />
                </section>
                <form:errors path="confirmPassword" class="text-danger ps-2" />
            </div>

            <button class="btn btn-secondary my-1 w-100">Register</button>
        </form:form>
        
        
        
        <!-- login box -->
        <form:form action="/login" method="POST" modelAttribute="newLogin" class="mx-5 mt-3">
            <div class="border text-center py-3">
                <h3>Login</h3>
            </div>
            <div class="border py-2">
                <section>
                    <form:label path="email" class="border-end w-50 ps-2 me-1">Email</form:label>
                    <form:input type="email" class="input" path="email" />
                </section>
                <form:errors path="email" class="text-danger" />
            </div>

            <div class="border py-2">
                <section>
                    <form:label path="password" class="border-end w-50 ps-2 me-1">Password</form:label>
                    <form:input type="password" class="input" path="password" />
                </section>
                <form:errors path="password" class="text-danger" />
            </div>

            <button class="btn btn-primary my-1 w-100">Login</button>
        </form:form>

    </main>
    <!-- FOOTER -->
    <footer>

    </footer>
</body>
</html>