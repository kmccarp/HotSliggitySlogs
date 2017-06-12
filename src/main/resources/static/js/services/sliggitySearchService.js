sliggityApplication.service('SliggitySearchService', ['$http', function ($http) {

    var heroSearchTypes = [
        { text: 'All Heroes'},
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

    var modeSearchTypes = [
        { text: 'All Modes'},
        { text: 'Quickmatch'},
        { text: 'Unranked Draft'},
        { text: 'Hero League'},
        { text: 'Team League'}
    ];

    this.getModeSearchTypes = function () {
        return modeSearchTypes;
    };

    var mapSearchTypes = [
        { text: 'All Maps'},
        { text: 'Battlefield of Eternity'},
        { text: "Blackheart's Bay"},
        { text: 'Braxis Holdout'},
        { text: 'Cursed Hollow'},
        { text: 'Dragon Shire'},
        { text: 'Garden of Terror'},
        { text: 'Hanamura'},
        { text: 'Haunted Mines'},
        { text: 'Infernal Shrines'},
        { text: 'Sky Temple'},
        { text: 'Tomb of the Spider Queen'},
        { text: 'Towers of Doom'}
    ];

    this.getMapSearchTypes = function () {
        return mapSearchTypes;
    };

    this.searchById = function (id) {
    	return $http.get("/matches/" + id);
    };

    this.search = function (heroName, beginningDate, endDate, matchType, mapName) {
        return $http.get("/matches", {
            params: {
                heroName: heroName,
                beginningDate: beginningDate,
                endDate: endDate,
                matchType: matchType,
                mapName: mapName
            }
        });
    };
}]);