<div class="container">
	<div>
		<button style="float: right;" data-toggle="modal"
			data-target="#addPopup" class="btn btn-success">Add</button>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>To Do Name</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
		</thead>
		
		<tbody>
			<tr ng-repeat="todo in toDosList">
				<td>{{todo.id}}</td>
				<td>{{todo.toDoName}}</td>
				<td>{{todo.description}}</td>
				<td>{{todo.done}}
				<a href="" ng-hide="todo.done" ng-click="completeToDo(todo.id)"	 title="complete!"><i class="fa fa-tasks" aria-hidden="true"></i></a>
				<a href="" ng-show="todo.done" title="completed!"><i class="fa fa-check" aria-hidden="true"></i></a> 
					&nbsp; &nbsp; 
				<a href="" title="delete" ng-click="deleteToDo(todo.id)"><i class="fa fa-trash"	aria-hidden="true"></i></a></td>
			</tr>
		</tbody>

	</table>
</div>

 <div id="addPopup" class="modal fade">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">Add To-Do</h3>
            </div>
            <div class="modal-body">
                <form role="form" method="POST" ng-submit="addToDo(todo)">
                    <div class="form-group">
                        <label class="control-label">To-Do Name</label>
                        <div>
                            <input type="text" class="form-control input-lg" name="todoname" value="" required ng-model="todo.toDoName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Description</label>
                        <div>
                            <input type="text" class="form-control input-lg" name="description" ng-model="todo.description" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div>
                            <button type="submit" class="btn btn-success">Add</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
 