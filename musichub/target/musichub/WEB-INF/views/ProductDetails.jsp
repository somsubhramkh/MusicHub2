
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Header file included which contains the menu -->
<!-- ========================================================================================================== -->
<%@include file="/WEB-INF/views/templates/Header.jsp" %>

<br/>
<br/>
<br/>


<div class="section">
      <div class="container">
        <h1>${param.name}</h1>
        <div class="row">
        
          <div class="col-md-6">
            <img src="<c:url value='/resources/${param.id}.jpg' />"
            class="img-responsive">
          </div>
          <div class="col-md-6">
            <ul>

<!-- Showing values taken from the request parameters -->
<!-- ============================================================================================== -->

              <%-- <li>Name:"${param.name}"</li> --%>
              <li>Description:<%=request.getParameter("desc")%></li>
              <li>Brand:<%=request.getParameter("brand")%></li>
              <li>Price:<%=request.getParameter("price")%></li>
              <a class="btn btn-primary">Add to Cart</a>
            </ul>
           
          </div>
           
        </div>
      </div>
    </div>

<!-- Footer JSP file included -->
<!-- ===================================================================================================================== -->
<%@include file="/WEB-INF/views/templates/Footer.jsp" %>
