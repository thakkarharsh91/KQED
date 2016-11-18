'use strict';
 
angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {	
    var self = this;
    self.user={username:'',email:'',subject:'',body:''};
    self.users=[];
 
    self.submit = submit;
    self.reset = reset; 
    function submit() {
    	 UserService.sendEmail(self.user)
         .then(
        		 function(d)
        		 {
        			 self.users.push(d);
        		 },
         function(errResponse){
             console.error('Error while creating User');
         }
     );
        reset();
    }
 
    function reset(){
        self.user={username:'',email:'',subject:'',body:''};
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);
