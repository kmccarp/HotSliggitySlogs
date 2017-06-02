sliggityApplication.controller('SliggityHomeController', ['$scope', '$http', 'SliggitySearchService', function($scope, $http, SliggitySearchService) {
    $scope.logId = '';
    $scope.sliggitySearchResponse = '';
    $scope.searchById = function() {
        SliggitySearchService.searchById($scope.logId).then(function(response) {
            $scope.sliggitySearchResponse = response.data;
            console.log($scope.sliggitySearchResponse);
        });
    };
}]);