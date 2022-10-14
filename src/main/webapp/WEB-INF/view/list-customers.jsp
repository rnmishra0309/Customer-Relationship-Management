<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Relationship Dashboard</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Customer"
				   onclick="window.location.href='add-customer'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="customer" items="${customers}">
					<c:url var="customerUpdateLink" value="/customer/customer-update-form">
						<c:param name="customerId" value="${customer.customerId}"/>
					</c:url>
					<c:url var="customerDeleteLink" value="/customer/customer-delete-form">
						<c:param name="customerId" value="${customer.customerId}"/>
					</c:url>
					<tr>
						<td> ${customer.firstName} </td>
						<td> ${customer.lastName} </td>
						<td> ${customer.email} </td>
						<td> <a href="${customerUpdateLink}">Update</a> | <a href="${customerDeleteLink}">Delete</a> </td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
</body>
</html>