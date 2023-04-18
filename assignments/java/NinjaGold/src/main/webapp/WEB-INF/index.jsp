<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!-- Bootstrap CSS -->
<!-- <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"> -->
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<!-- My CSS -->
<link rel='stylesheet' href='/css/style.css'>
<!-- JS for Bootstrap / jQuery -->
<script src='/webjars/jquery/jquery.min.js'></script>
<!-- <script src='/webjars/bootstrap/js/boostrap.min.js'></script> -->
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<!-- My JS -->
<script type = "text/javascript" src='/js/scripts.js'></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
</head>
<body>

	<main>
		<div class="container">
			<div class="row">
				<div class="col-2">
					<h4>Your gold:</h4>
				</div>
				<div >
					<span id="count"><c:out value="${count}"> </c:out></span>
				</div>
			</div>
			<div class="col-1 mt-4">
				<button disabled="true">Reset</button>
				<br>
			</div>
		</div>
	
	
	<div class="container mt-3">
		<div class="row">
		
			<div class="col-md-3">
				<div class="box">
					<h2>Farm</h2>
					<p>(Earns 10-20 gold)</p>
					<form action="/gold/farm" method="post">
						<button value="farm">Find Gold!</button>
					</form>
				</div>
			</div>
				

			<div class="col-md-3">
				<div class="box">
					<h2>Cave</h2>
					<p>(Earns 5-10 gold)</p>
					<form action="/gold/cave" method="post">
						<button value="cave">Find Gold!</button>
					</form>
				</div>
			</div>
				

			<div class="col-md-3">
				<div class="box">
					<h2>House</h2>
					<p>(Earns 2-5 gold)</p>
					<form action="/gold/house" method="post">
						<button value="house">Find Gold!</button>
					</form>
				</div>
			</div>
				

			<div class="col-md-3">
				<div class="box">
					<h2>Quest</h2>
					<p>(Earns/takes 0-50 gold)</p>
					<form action="/gold/quest" method="post">
						<button value="quest">Find Gold!</button>
					</form>
				</div>
			</div>
				
		</div>
	</div>

	
	<div id="activities" class="container mt-3">
		<h3>Activities</h3>
		<div class="box ">
			<c:if test="${ count == 0 }">
			<p>No gold yet.</p>
			 </c:if>
			 
			 <c:if test="${ count != 0 }">
				<c:forEach var = "i" items="${activity}">
					<c:if test="${ i.contains('earned') }" >
						<h5 style="color: green"><c:out value="${ i }" /></h5>
					</c:if>
					<c:if test="${ i.contains('lost') }" >
						<h5 style="color: red"><c:out value="${ i }" /></h5>
					</c:if>
				</c:forEach>
			 </c:if>
			 
		</div>
	</div>
	
	
	
	</main>
</body>
</html>