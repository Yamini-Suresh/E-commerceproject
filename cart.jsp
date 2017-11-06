<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<h2 style="color:white;font-family:courier;"><b>Cart Information</b></h2>
<div style="color:red; text-align:center;">Cart Total:${grandtotal}</div>
<br><br><br><br><br>
<div align="center" >
<div class="container">
<table class="table table-striped" border="1px">
<thead>
  		<tr>
  		<th>Product ID</th>
  			<th>ProductName</th>
			<th>Quantity</th>
			<th>SubTotal</th>
			<th>Image</th>
			<th>Operation</th>
			
			
			</tr>
			</thead>
			<tbody>
			<c:forEach var="list1" items="${cart1}">
                <tr>
                <td><c:out value="${list1.productId}"/></td>
                 <td><c:out value="${list1.productName}" /></td>
                 <td><c:out value="${list1.quantity}" /></td>
                  <td><c:out value="${list1.productPrice*list1.quantity}" /></td>
                  <td style="width:171px;">
                  <img src="${pageContext.request.contextPath}/images/${list.productId}.jpg" height="200" width="200"></td>
                  <td><form>
                  <button  class="btn btn-info btn-lg" name = "ProductId" value = "${list1.productId}" type = "submit" formmethod="post" formaction="/PickFresh/delete1"> <span class="glyphicon glyphicon-trash">Remove</span></button></form></td>
                </tr>
            </c:forEach>
            </tbody>
            </table>
            </div>
            </div>