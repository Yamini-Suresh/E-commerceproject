<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <title>PickFresh</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">PickFresh</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="index"><a href="#">Home</a></li>
        
        <li><a href="cart">View Cart</a></li>
        <li><a href="Contact">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav><br><br>
<br>
<form:form class="form-horizontal"> 
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="15%">Product ID</th>
<th width="15%">Product Name</th>
<th width="10%">Product Quantity</th>
<th width="10%">Product Prize</th>
<th width="10%">Product Description</th>
<th width="10%">Product Category</th>
<th width="10%">Image</th>
<th width="10%">Action</th>
</tr>
</thead>
<tbody>
<c:forEach var="list" items="${lists}">
<tr>
    <td><c:out value="${list.pid}"/></td>
    <td><c:out value="${list.pName}"/></td>
    <td><c:out value="${list.pQuantity}"/></td>
    <td><c:out value="${list.pPrize}"/></td>
    <td><c:out value="${list.pDes}"/></td>
    <td><c:out value="${list.category.name}"/></td>
    <td>
    <img src="${pageContext.request.contextPath}/images/${list.pid}.jpg" height="200" width="200"></td>
    <td>
       <button  class="btn btn-info btn-lg" name="pid" value="${list.pid}" type = "submit" formmethod="GET" formaction="/PickFresh/cart"> 
      <span class="glyphicon glyphicon-shopping-cart"></span></button></td>
</tr>
</c:forEach>
</tbody>
</table>
</form:form>

</body>