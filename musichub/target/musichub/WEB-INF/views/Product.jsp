
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- Header file included which contains the menu -->
<!-- ========================================================================================================== -->
<%@include file="/WEB-INF/views/templates/Header.jsp" %>


<div class="cover">

<%-- 	<div class="cover-image">
		<img class="center-block" src="${images}/BB_King_Jerome_Brunet.jpg"
			width="100%">
	</div> --%>

</div>

<!-- retrieving the prodData attribute sent from the controller which contains the JSON as string -->
<!-- ============================================================================================== -->

<%String type=(String)request.getAttribute("prodData"); %>



<!--  -->
<!-- ============================================================================================== -->

<script>

var prod = ${prodData};

angular.module('repeatSample', [])
    .controller('repeatController', function($scope){
    	$scope.products=prod;
    
        $scope.sort = function(keyname){
            $scope.sortKey = keyname;   //set the sortKey to the param passed
            $scope.reverse = !$scope.reverse; //if true make it false and vice versa
        }
    	
    });

</script>

<!-- Textbox used to implement search option using Angular -->
<!-- ============================================================================================== -->

   <div class="bs-component" ng-controller="repeatController">

    <form class="form-inline">
        <div class="form-group">
            <label >Search</label>
            <input type="text" ng-model="search" class="form-control" placeholder="Search">
        </div>
    </form>
                     

<!-- table to show data coming from the JSON file -->
<!-- ============================================================================================== -->
                     
                        
             <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                
<!-- Performing sort functionality using angular both in ascending and descending manner -->
<!-- ============================================================================================== -->
                                
            <th ng-click="sort('id')">ID
                <span class="glyphicon sort-icon" ng-show="sortKey=='id'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
            </th>
            <th ng-click="sort('name')">Product Name
                <span class="glyphicon sort-icon" ng-show="sortKey=='name'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
            </th>
            <th ng-click="sort('price')">Price
                <span class="glyphicon sort-icon" ng-show="sortKey=='price'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
            </th>
            <th ng-click="sort('category')">Category
                <span class="glyphicon sort-icon" ng-show="sortKey=='category'" ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
            </th>
            <th>More Info</th>
            
        </tr>
                            </thead>
                            <tbody>
<!-- dynamically generating the table data -->
<!-- ============================================================================================== -->

                                <tr ng-repeat="product in products|orderBy:sortKey:reverse|filter:search">
                                    <td>{{product.id}}</td>
                                    <td>{{product.name}}</td>
                                    <td>{{product.price}}</td>
                                    <td>{{product.category}}</td>
                                    
                                    
<!-- Info button that maps to the ProductDetails view. Required Info for ProductDetails view is passed through request parameters -->
<!-- ============================================================================================== -->

                                    <td><a href="/musichub/ProductDetails?id={{product.id}}&name={{product.name}}&desc={{product.desc}}&brand={{product.brand}}&price={{product.price}}"><i class="fa fa-3x fa-fw fa-exclamation-circle"></i></a></td>
                                </tr>
                            </tbody>
                        </table>
                          
                    </div>
                </div>
      </div>
    </div>
        <!-- <script src="angular.js"></script> -->
        <!-- <script src="app.js"></script> -->
        
<!-- Footer JSP file included -->
<!-- ===================================================================================================================== -->
 <%@include file="/WEB-INF/views/templates/Footer.jsp" %>