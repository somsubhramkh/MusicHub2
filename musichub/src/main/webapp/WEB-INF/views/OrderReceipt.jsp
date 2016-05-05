
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- Header file included which contains the menu -->
<!-- ========================================================================================================== -->
<%@include file="/WEB-INF/views/templates/Header.jsp"%>
<br />
<div class="section">
	<div class="container">



		<!-- retrieving the prodData attribute sent from the controller which contains the JSON as string -->
		<!-- ============================================================================================== -->

		<%
			String type = (String) request.getAttribute("prodData");
		%>


		<!-- Angular script to generate the productlist and sorting -->
		<!-- ============================================================================================== -->

		<script>
			var prod = [{"id":82,"brand":"Fender","desc":"The American Special series Jazz Bas guitar puts genuine U.S-made Fender quality into the hands of players at any level","name":"AMERICAN SPECIAL JAZZ BASS","price":118000,"category":"Bass"},
			            {"id":83,"brand":"Fender","desc":"The American Special series Jazz Bas guitar puts genuine U.S-made Fender quality into the hands of players at any level","name":"AMERICAN SPECIAL JAZZ BASS","price":118000,"category":"Bass"}];

			angular.module('repeatSample', []).controller('repeatController',
					function($scope) {
						$scope.products = prod;

						$scope.sort = function(keyname) {
							$scope.sortKey = keyname; //set the sortKey to the param passed
							$scope.reverse = !$scope.reverse; //if true make it false and vice versa
						}
						
						$scope.total = function() {
					        var total = 0;
					        angular.forEach($scope.products, function(product) {
					            total += product.price;
					        })

					        return total;
					    }

					});
		</script>

		<!-- Textbox used to implement search option using Angular -->
		<!-- ============================================================================================== -->

		<div class="bs-component" ng-controller="repeatController">



			<!-- table to show data coming from the JSON file -->
			<!-- ============================================================================================== -->

	<form:form>
		<div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <h1>Shipping Address</h1>
            <ul class="lead list-group">
              <li class="list-group-item">Name</li>
              <li class="list-group-item">Address</li>
              <li class="list-group-item">City</li>
              <li class="list-group-item">Pin</li>
              <li class="list-group-item">Mobile No</li>
            </ul>
          </div>
          <div class="col-md-6">
            <h3>Products</h3>
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                 
						<th ng-click="sort('id')">ID <span class="glyphicon sort-icon" ng-show="sortKey=='id'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th ng-click="sort('name')">Product Name <span class="glyphicon sort-icon" ng-show="sortKey=='name'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th ng-click="sort('price')">Price <span class="glyphicon sort-icon" ng-show="sortKey=='price'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th ng-click="sort('category')">Category <span class="glyphicon sort-icon" ng-show="sortKey=='category'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th></th>

					</tr>
				</thead>
				<tbody>
				
					<tr ng-repeat="product in products|orderBy:sortKey:reverse|filter:search">
						<td>{{product.id}}</td>
						<td>{{product.name}}</td>
						<td>{{product.price}}</td>
						<td>{{product.category}}</td>
	</tr>
					<tr>
					<td></td>
					<td></td>
					<td>Total:</td>
					<td>{{total() | currency}}</td>
					<td><input type="submit" class="btn btn-success" name="_eventId_receiptFormChecked" value="Next"></td>
					<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
					</tr>
				</tbody>

              
            </table>
          </div>
        </div>
      </div>
    </div>
</form:form>
		</div>
	</div>
</div>
</div>
</div>
</div>

<!-- Footer JSP file included -->
<!-- ===================================================================================================================== -->
<%@include file="/WEB-INF/views/templates/Footer.jsp"%>