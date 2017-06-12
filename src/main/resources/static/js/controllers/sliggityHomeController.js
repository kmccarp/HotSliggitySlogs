sliggityApplication.controller('SliggityHomeController', ['$scope', '$http', 'SliggitySearchService', 'SliggityDateService', function($scope, $http, SliggitySearchService, SliggityDateService) {
    $scope.sliggitySearchResponse = '';

    $scope.heroSearchTypes = SliggitySearchService.getHeroSearchTypes();
    $scope.heroSearchRequest = {};
    $scope.heroSearchRequest.type = $scope.heroSearchTypes[0];

    $scope.heroName = $scope.heroSearchRequest.type.text;

    $scope.modeSearchTypes = SliggitySearchService.getModeSearchTypes();
    $scope.modeSearchRequest = {};
    $scope.modeSearchRequest.type = $scope.modeSearchTypes[0];

    $scope.matchType = $scope.modeSearchRequest.type.text;

    $scope.dateSearchTypes = SliggityDateService.getDateSearchTypes();
    $scope.dateSearchRequest = {};
    $scope.dateSearchRequest.type = $scope.dateSearchTypes[0];

    $scope.beginningDate = $scope.dateSearchRequest.type.from;
    $scope.endDate = $scope.dateSearchRequest.type.to;

    $scope.updateHero = function() {
        $scope.heroName = $scope.heroSearchRequest.type.text;
        $scope.search();
    }

    $scope.updateMode = function() {
        $scope.matchType = $scope.modeSearchRequest.type.text;
        $scope.search();
    }

    $scope.updateDates = function() {
        $scope.beginningDate = $scope.dateSearchRequest.type.from;
        $scope.endDate = $scope.dateSearchRequest.type.to;
        $scope.search();
    }

    $scope.search = function() {
        $scope.heroName = $scope.heroSearchRequest.type.text;
        $scope.matchType = $scope.modeSearchRequest.type.text;
        SliggitySearchService.search($scope.heroName, $scope.beginningDate, $scope.endDate, $scope.matchType).then(function(response) {
            $scope.sliggitySearchResponse = response.data;
            chartResults($scope.sliggitySearchResponse);
        });
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
}]);