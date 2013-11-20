function CalculatorCtrl($scope) {
    var divisionOperationName = '/';
    $scope.firstInput;
    $scope.secondInput;
    $scope.result;
    $scope.operations = [
        { name: '+', operation: function (input1, input2) { return input1 + input2; } },
        { name: '-', operation: function (input1, input2) { return input1 - input2; } },
        { name: '*', operation: function (input1, input2) { return input1 * input2; } },
        { name: divisionOperationName, operation: function (input1, input2) { return input1 / input2; } }
    ];
    $scope.selectedOperation = $scope.operations[0];

    $scope.calculate = function () {
        $scope.result = $scope.selectedOperation.operation($scope.firstInput, $scope.secondInput);
    }

    $scope.isCalculationDisabled = function () {
        return isDivisionByZero();
    }

    var isDivisionByZero = function () {
        return isDivision($scope.selectedOperation) && ($scope.firstInput == 0 || $scope.secondInput == 0);
    }

    var isDivision = function (operation) {
        return operation.name == divisionOperationName;
    }
}