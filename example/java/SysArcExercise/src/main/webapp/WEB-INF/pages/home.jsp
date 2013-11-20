<!DOCTYPE html>
<html ng-app>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>System Architecture Exercise</title>
	<link href="assets/lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<!--  link href="assets/lib/bootstrap/css/bootstrap-responsive.css" rel="stylesheet" type="text/css" -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular-resource.min.js"></script>
	<script type="text/javascript" src="assets/js/app.js"></script>
	<style>
	form {
		margin: 50px;
	}
	</style>
</head>
<body>
<div ng-controller="CalculatorCtrl">
    <form role="form">
        <div class="row">
            <div class="col-sm-2"><input type="number" ng-model="firstInput" class="form-control" id="firstInput"></div>
            <div class="col-sm-2"><select id="operation" class="form-control" ng-model="selectedOperation" ng-options="o.name for o in operations"></select></div>
            <div class="col-sm-2"><input type="number" ng-model="secondInput" class="form-control" id="secondInput"></div>
            <div class="col-sm-1"><button type="submit" class="btn btn-primary" ng-click="calculate()" ng-disabled="isCalculationDisabled()" id="calculate">=</button></div>
            <div class="col-sm-5">{{ result }}</div>
        </div>
    </form>
</div>
	
	<div class="container-fluid" ng-view></div>
</body>
</html>