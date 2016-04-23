<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Header file included which contains the menu -->
<!-- ========================================================================================================== -->
<%@include file="/WEB-INF/views/templates/Header.jsp" %>

<div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <img src=""
            class="img-responsive">
          </div>
          <div class="col-md-6">
            <ul>

<!-- Showing values taken from the request parameters -->
<!-- ============================================================================================== -->

              <li>Name:<%=request.getParameter("name")%></li>
              <li>Description:<%=request.getParameter("desc")%></li>
              <li>Brand:<%=request.getParameter("brand")%></li>
              <li>Price:<%=request.getParameter("price")%></li>
            </ul>
            <a class="btn btn-primary">Add to Cart</a>
          </div>
        </div>
      </div>
    </div>

<!-- Footer JSP file included -->
<!-- ===================================================================================================================== -->
<%@include file="/WEB-INF/views/templates/Footer.jsp" %>
