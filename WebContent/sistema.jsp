<!doctype html>
<html ng-app="app">

<head>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.4/angular-route.js"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css"/>
 <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"  ></script>
 <script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>

    <ul>
      <li><a href="#/!">main</a></li>
      <li><a href="#!inclusao">inclusao</a></li>
      <li><a href="#!grid">grid</a></li>
    </ul>

<br/>
<div id="respostas">

      <div ng-view></div>


</div>
</body>

<script>

    var app = angular.module('app',["ngRoute"]);
    
     app.config(function ($routeProvider){
                          $routeProvider

    .when("/", {
         templateUrl : "main.html",
    })
    .when("/inclusao",{
        templateUrl : "inclusao.html",
        controller : "gravarctl"
    })
    .when("/grid",{
        templateUrl : "grid.html",
        controller : "gridctl"
     })
  });


  app.controller('gravarctl', function($scope, $http){
 
       $scope.model={idAluno:'', nome:'', email:''};


  $scope.cadastrar = function(){
 
  $http.get("http://localhost:8080/pr-webServ/json/aluno/incluir/"
       + $scope.model.nome + "/" + $scope.model.email
  ).then(function(msg){
         $scope.message = msg.data;
 }).catch(function(msg){
      $scope.message = msg.data;
 });
  
  $scope.model.idAluno ="";
  $scope.model.nome ="";
  $scope.model.email ="";

 }
});


app.controller('listarctl', function($scope, $http){
 
       
  $scope.listar = function(){
 
    $http.get("http://localhost:8080/pr-webServ/json/aluno/listar")
      .then(function(msg){
           $scope.message = msg.data;
   });
  
 }

});


</script>