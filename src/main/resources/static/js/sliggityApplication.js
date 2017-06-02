var sliggityApplication = angular.module('sliggityApplication', ['ngRoute']);

sliggityApplication.config(['$routeProvider',
  function ($routeProvider) {
        $routeProvider.
        when('/', {
            templateUrl: 'partials/home.html',
            controller: 'SliggityHomeController'
        }).otherwise({
            redirectTo: '/'
        });
}]);