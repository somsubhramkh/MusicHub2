
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <%@include file="/WEB-INF/views/templates/Header.jsp" %>

<div class="section">
      <div class="container">
        <div class="row">
          <form role="form">
            <div class="col-md-6">
              <h1>Billing Address</h1>
              <div class="form-group">
                <label class="control-label" for="exampleInputEmail1">Email address</label>
                <input class="form-control" id="exampleInputEmail1"
                placeholder="Enter email" type="email">
              </div>
              <div class="form-group">
                <label class="control-label" for="exampleInputEmail1">Name</label>
                <input class="form-control" id="exampleInputEmail1" placeholder="Enter Name"
                type="text">
              </div>
              <div class="form-group">
                <label class="control-label">Address</label>
                <textarea class="form-control" placeholder="Enter Address"></textarea>
              </div>
              <div class="form-group">
                <label class="control-label">City</label>
                <input class="form-control" type="text" placeholder="Enter City">
              </div>
              <div class="form-group">
                <label class="control-label">Zip</label>
                <input class="form-control" type="text" placeholder="Enter Zip">
              </div>
              <div class="form-group">
                <label class="control-label">Mobile No</label>
                <input class="form-control" type="text" placeholder="Enter Mobile">
              </div>
            </div>
            <div class="col-md-6">
              <h1>Shipping Address</h1>
              <div class="form-group">
                <label class="control-label" for="exampleInputEmail1">Name</label>
                <input class="form-control" id="exampleInputEmail1" placeholder="Enter Name"
                type="text">
              </div>
              <div class="form-group">
                <label class="control-label">Address</label>
                <textarea class="form-control" placeholder="Enter Address"></textarea>
              </div>
              <div class="form-group">
                <label class="control-label">City</label>
                <input class="form-control" type="text" placeholder="Enter City">
              </div>
              <div class="form-group">
                <label class="control-label">Zip</label>
                <input class="form-control" type="text" placeholder="Enter Zip">
              </div>
              <div class="form-group">
                <label class="control-label">Mobile No</label>
                <input class="form-control" type="text" placeholder="Enter Mobile">
              </div>
            </div>
            <a class="btn btn-primary">next</a>
          </form>
        </div>
      </div>
    </div>
    
  <%@include file="/WEB-INF/views/templates/Footer.jsp" %>