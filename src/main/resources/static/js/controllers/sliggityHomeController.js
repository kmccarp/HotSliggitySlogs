sliggityApplication.controller('SliggityHomeController', ['$scope', '$http', 'SliggitySearchService', function($scope, $http, SliggitySearchService) {
    $scope.sliggitySearchResponse = '';
    $scope.isByDate = 'false';
    $scope.isByDateChecked = 'true';
    $scope.beginningDate = '';
    $scope.endDate = '';

    $scope.seasonSearchTypes = SliggitySearchService.getSeasonSearchTypes();
    $scope.seasonSearchRequest = {};
    $scope.seasonSearchRequest.type = $scope.seasonSearchTypes[0];

    $scope.searchByName = function() {
        SliggitySearchService.searchByName($scope.heroName, $scope.beginningDate, $scope.endDate).then(function(response) {
            $scope.sliggitySearchResponse = response.data;
            console.log($scope.sliggitySearchResponse);
        });
    };
}]);