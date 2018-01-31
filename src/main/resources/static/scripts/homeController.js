app.controller("homeController", function($scope, $http) {

	$scope.todo={};
	
	$scope.$on('$routeChangeSuccess', function($event, next, current) {
		$scope.listToDos();
	});
	
	$scope.listToDos = function(){
		$http.get("./listToDos").then(function(resp) {
			$scope.toDosList = resp.data.response;
			console.log(JSON.stringify($scope.toDosList));

		});
	}

	$scope.addToDo = function(todo) {
		$http.post('./addToDo',todo).then(function(re){
			alert("Added Successfully!"+JSON.stringify(re));
			$('#addPopup').modal('hide');
			$scope.listToDos();
		});
	}


	$scope.deleteToDo = function(id) {
		$http.post('./deleteToDo?id='+id).then(function(e){
			alert(e.data.response);
			$scope.listToDos();
		});
	}

	
	$scope.completeToDo = function(id) {
		$http.post('./completeToDo?id='+id).then(function(e){
			alert(e.data.response);
			$scope.listToDos();
		});
	}

});