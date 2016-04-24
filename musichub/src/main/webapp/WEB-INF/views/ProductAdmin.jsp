<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1>
    Add a Product
</h1>
 
<c:url var="addAction" value="/ProductAdmin/add" ></c:url>
 
<form:form action="${addAction}" commandName="product">
<table>
   <c:if test="${!empty product.name}">
    <tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
    <tr>
        <td>
            <form:label path="brand">
                <spring:message text="Brand"/>
            </form:label>
        </td>
        <td>
            <form:input path="brand" />
        </td> 
        <td>
            <form:errors path="brand" cssClass="error"/>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="desc">
                <spring:message text="Description"/>
            </form:label>
        </td>
        <td>
            <form:input path="desc" />
        </td>
        <td>
            <form:errors path="Desc" cssClass="error"/>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="name" />
        </td> 
        <td>
            <form:errors path="name" cssClass="error"/>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="price">
                <spring:message text="Price"/>
            </form:label>
        </td>
        <td>
            <form:input path="price" />
        </td> 
        <td>
            <form:errors path="price" cssClass="error"/>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="category">
                <spring:message text="Category"/>
            </form:label>
        </td>
        <td>
            <form:input path="category" />
        </td> 
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty product.name}">
                <input type="submit"
                    value="<spring:message text="Edit Product"/>" />
            </c:if>
            <c:if test="${empty product.name}">
                <input type="submit"
                    value="<spring:message text="Add Product"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>Products List</h3>
<c:if test="${!empty listProducts}">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Brand</th>
        <th width="120">Description</th>
        <th width="60">Name</th>
        <th width="60">Price</th>
        <th width="60">Category</th>
        
    </tr>
    <c:forEach items="${listProducts}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.brand}</td>
            <td>${product.desc}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.category}</td>
            
            <td><a href="<c:url value='/edit/${product.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/remove/${product.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>