sliggityApplication.service('SliggitySearchService', ['$http', function ($http) {

    var heroSearchTypes = [
        { text: 'Abathur'},
        { text: 'Alarak'},
        { text: "Anub'arak"},
        { text: 'Artanis'},
        { text: 'Arthas'},
        { text: 'Auriel'},
        { text: 'Azmodan'},
        { text: 'Brightwing'},
        { text: 'Cassia'},
        { text: 'Chen'},
        { text: 'Cho'},
        { text: 'Chromie'},
        { text: 'D.Va'},
        { text: 'Dehaka'},
        { text: 'Diablo'},
        { text: 'E.T.C.'},
        { text: 'Falstad'},
        { text: 'Gall'},
        { text: 'Gazlowe'},
        { text: 'Genji'},
        { text: 'Greymane'},
        { text: "Gul'dan"},
        { text: 'Illidan'},
        { text: 'Jaina'},
        { text: 'Johanna'},
        { text: "Kael'thas"},
        { text: 'Kerrigan'},
        { text: 'Kharazim'},
        { text: 'Leoric'},
        { text: 'Li Li'},
        { text: 'Li-Ming'},
        { text: 'Lt. Morales'},
        { text: 'Lúcio'},
        { text: 'Lunara'},
        { text: 'Malfurion'},
        { text: 'Malthael'},
        { text: 'Medivh'},
        { text: 'Muradin'},
        { text: 'Murky'},
        { text: 'Nazeebo'},
        { text: 'Nova'},
        { text: 'Probius'},
        { text: 'Ragnaros'},
        { text: 'Raynor'},
        { text: 'Rehgar'},
        { text: 'Rexxar '},
        { text: 'Samuro'},
        { text: 'Sgt. Hammer'},
        { text: 'Sonya'},
        { text: 'Stitches'},
        { text: 'Sylvanas'},
        { text: 'Tassadar'},
        { text: 'The Butcher'},
        { text: 'The Lost Vikings'},
        { text: 'Thrall'},
        { text: 'Tracer'},
        { text: 'Tychus'},
        { text: 'Tyrael'},
        { text: 'Tyrande'},
        { text: 'Uther'},
        { text: 'Valeera'},
        { text: 'Valla'},
        { text: 'Varian'},
        { text: 'Xul'},
        { text: 'Zagara'},
        { text: 'Zarya'},
        { text: 'Zeratul'},
        { text: "Zul'jin"}
    ];

    this.getHeroSearchTypes = function () {
        return heroSearchTypes;
    };

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