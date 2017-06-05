var sliggityApplication = angular.module('sliggityApplication', ['ngRoute']);

sliggityApplication.config(['$routeProvider',
  function ($routeProvider) {
        $routeProvider.
        when('/', {
            templateUrl: 'partials/home.html',
            controller: 'SliggityHomeController'
        }).when('/extras', {
            templateUrl: 'partials/extras.html',
            controller: 'SliggityExtrasController'
        }).otherwise({
            redirectTo: '/'
        });
}]);