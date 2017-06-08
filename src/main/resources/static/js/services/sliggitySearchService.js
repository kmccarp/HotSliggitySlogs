sliggityApplication.service('SliggitySearchService', ['$http', function ($http) {

    var seasonSearchTypes = [
        {
            value: '2017season1',
            text: '2017 Season 1'
        },
        {
            value: '2016season3',
            text: '2016 Season 3'
        },
        {
            value: '2016season2',
            text: '2016 Season 2'
        },
        {
            value: '2016season1',
            text: '2016 Season 1'
        },
        {
            value: 'Preseason',
            text: 'Preseason'
        }
    ];

    this.getSeasonSearchTypes = function () {
        return seasonSearchTypes;
    };

    this.searchById = function (id) {
    	return $http.get("/matches/" + id);
    };

    this.searchByName = function (heroName) {
        return $http.get("/matches/heroName", {
            params: {
                heroName: heroName
            }
        });
    };

    this.searchByNameAndDateRange = function (heroName, beginningDate, endDate) {
        return $http.get("/matches/heroName", {
            params: {
                heroName: heroName,
                beginningDate: beginningDate,
                endDate: endDate
            }
        });
    };

    this.searchBySeason = function (seasonSearchRequestType) {
        return $http.get("/matches/season/" + seasonSearchRequestType);
    };
}]);