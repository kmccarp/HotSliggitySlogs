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

        function today() {
            var today = new Date();

            today = formatDate(today);

            return today;
        }

        function formatDate(date) {
            var yyyy = date.getFullYear();
            var mm = date.getMonth() + 1;
            var dd = date.getDate();

            if(dd < 10) {
                dd = '0' + dd;
            }

            if(mm < 10) {
                mm = '0' + mm;
            }

            return yyyy + '-' + mm + '-' + dd;
        }

        function subtractDays(dateToSubtractFrom, numberOfDaysToSubtract) {
            var newDate = new Date(dateToSubtractFrom);
            var dd = newDate.getDate();
            newDate.setDate(dd - numberOfDaysToSubtract);
            return formatDate(newDate);
        }
}]);