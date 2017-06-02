sliggityApplication.service('SliggitySearchService', ['$http', function ($http) {

    this.searchById = function (id) {
    	return $http.get("/matches/" + id);
    };
}]);