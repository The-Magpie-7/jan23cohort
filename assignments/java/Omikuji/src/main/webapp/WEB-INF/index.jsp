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
	<!-- <link rel="stylesheet" href="/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	 -->	<!-- For any Bootstrap that uses JS -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<title>Omikuji!</title>
</head>
 <body>
    <div class="container">
      <form method="post" action="makeFortune">
        <h2 class="mb-3 text-center">Send an Omikuji!</h2>
        <div class="border p-3 mb-3">
          <div class="mb-3">
            <label for="number" class="form-label">Pick any number from 5 to 25</label>
            <select id="dropdown" name="number" class="form-select">
              <option value="">--Select a Number--</option>
              <option value="5">5</option>
              <option value="6">6</option>
              <option value="7">7</option>
              <option value="8">8</option>
              <option value="9">9</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
              <option value="13">13</option>
              <option value="14">14</option>
              <option value="15">15</option>
              <option value="16">16</option>
              <option value="17">17</option>
              <option value="18">18</option>
              <option value="19">19</option>
              <option value="20">20</option>
              <option value="21">21</option>
              <option value="22">22</option>
              <option value="23">23</option>
              <option value="24">24</option>
              <option value="25">25</option>
            </select>
          </div>
          <div class="mb-3">
            <label for="city" class="form-label">Enter the name of any city</label>
            <input type="text" id="text1" name="city" class="form-control">
          </div>
          <div class="mb-3">
            <label for="name" class="form-label">Enter the name of any real person</label>
            <input type="text" id="text2" name="name" class="form-control">
          </div>
          <div class="mb-3">
            <label for="hobby" class="form-label">Enter professional endeavor or hobby</label>
            <input type="text" id="text3" name="hobby" class="form-control">
          </div>
          <div class="mb-3">
            <label for="thing" class="form-label">Enter any type of living thing</label>
            <input type="text" id="text4" name="thing" class="form-control">
          </div>
          <div class="mb-3">
            <label for="say" class="form-label">Say something nice to someone</label>
            <textarea type="text" id="text5" name="say" class="form-control" rows="3"></textarea>
          </div>
          <div class="text-end">
            <button class="btn btn-primary">Send</button>
          </div>
        </div>
      </form>
    </div>
    
  </body>
</html>