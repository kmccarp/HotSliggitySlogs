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
        if ($scope.datesAreBlank()) {
            SliggitySearchService.searchByName($scope.heroName).then(function(response) {
                $scope.sliggitySearchResponse = response.data;
                chartResults($scope.sliggitySearchResponse);
            });
        } else {
            SliggitySearchService.searchByNameAndDateRange($scope.heroName, $scope.beginningDate, $scope.endDate).then(function(response) {
                $scope.sliggitySearchResponse = response.data;
                chartResults($scope.sliggitySearchResponse);
            });
        }
    }

    function chartResults(response) {
        $scope.heroIcon = "https://d1i1jxrdh2kvwy.cloudfront.net/Images/Heroes/Portraits/" + $scope.sliggitySearchResponse.heroIcon + ".png";

        console.log($scope.sliggitySearchResponse);

        makeChart($scope.sliggitySearchResponse.wins, $scope.sliggitySearchResponse.matchesCount, $scope.sliggitySearchResponse.winLossRatio);
    }

    function makeChart(wins, matchesCount, winLossRatio) {
        d3.select(".chart")
          .style("width", winLossRatio + "%")
          .text(wins);
    }

    $scope.datesAreBlank = function () {
        if($scope.beginningDate == null || $scope.endDate == null || $scope.beginningDate == "" || $scope.endDate == "") {
            return true;
        } else {
            return false;
        }
    }

    $scope.testGenji = function() {
        $scope.heroName = "Genji";
        $scope.beginningDate = "2017-01-01";
        $scope.endDate = "2017-07-01";
        $scope.searchByName();
    }

    $scope.testValla = function() {
        $scope.heroName = "Valla";
        $scope.beginningDate = null;
        $scope.endDate = null;
        $scope.searchByName();
    }

    $scope.preseasonTest = function() {
        $scope.beginningDate = "2014-03-10";
        $scope.endDate = "2016-06-15";
        $scope.searchByName();
    }

    $scope.season12016Test = function() {
        $scope.beginningDate = "2016-06-15";
        $scope.endDate = "2016-09-14";
        $scope.searchByName();
    }

    $scope.season22016Test = function() {
        $scope.beginningDate = "2016-09-14";
        $scope.endDate = "2016-12-15";
        $scope.searchByName();
    }

    $scope.season32016Test = function() {
        $scope.beginningDate = "2016-12-15";
        $scope.endDate = "2017-03-15";
        $scope.searchByName();
    }

    $scope.season12017Test = function() {
        $scope.beginningDate = "2017-03-15";
        $scope.endDate = "2017-06-13";
        $scope.searchByName();
    }

}]);