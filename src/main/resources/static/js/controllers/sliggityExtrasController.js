sliggityApplication.controller('SliggityExtrasController', ['$scope', '$http', 'SliggitySearchService', function($scope, $http, SliggitySearchService) {
    $scope.logId = '';
    $scope.sliggitySearchResponse = '';

    $scope.seasonSearchTypes = SliggitySearchService.getSeasonSearchTypes();
    $scope.seasonSearchRequest = {};
    $scope.seasonSearchRequest.type = $scope.seasonSearchTypes[0];

    $scope.searchById = function() {
        SliggitySearchService.searchById($scope.logId).then(function(response) {
            $scope.sliggitySearchResponse = response.data;
            console.log($scope.sliggitySearchResponse);
        });
    };
    $scope.searchBySeason = function() {
        SliggitySearchService.searchBySeason($scope.seasonSearchRequest.type.text).then(function(response) {
            $scope.sliggitySearchResponse = response.data;
            console.log($scope.sliggitySearchResponse);
        });
    };
}]);