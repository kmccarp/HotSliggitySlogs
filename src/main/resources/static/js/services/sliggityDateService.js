sliggityApplication.service('SliggityDateService', ['$http', function ($http) {

    var dateSearchTypes = [
        { value: 'allDates', text: 'All Dates', from: '2014-03-10', to: '9999-12-31'},
        { value: 'alpha', text: 'Alpha', from: '2014-03-10', to: '2015-01-12'},
        { value: 'closedBeta', text: 'Closed Beta', from: '2015-01-13', to: '2015-05-18'},
        { value: 'openBeta', text: 'Open Beta', from: '2015-05-19', to: '2015-06-01'},
        { value: 'beta', text: 'Beta (Closed & Open)', from: '2015-01-13', to: '2015-06-01'},
        { value: 'preLaunch', text: 'Pre-Launch (Alpha & Beta)', from: '2014-03-10', to: '2015-06-01'},
        { value: 'heroes1', text: 'Heroes 1.0', from: '2015-06-02', to: '2017-04-24'},
        { value: 'heroes2', text: 'Heroes 2.0', from: '2017-04-25', to: '9999-12-31'},
        { value: 'preseason', text: 'Preseason', from: '2014-03-10', to: '2016-06-14'},
        { value: '2016season1', text: '2016 Season 1', from: '2016-06-15', to: '2016-09-13'},
        { value: '2016season2', text: '2016 Season 2', from: '2016-09-14', to: '2016-12-14'},
        { value: '2016season3', text: '2016 Season 3', from: '2016-12-15', to: '2017-03-14'},
        { value: '2017season1', text: '2017 Season 1', from: '2017-03-14', to: '2017-06-12'},
        { value: 'mapRotation1', text: 'Map Rotation #1', from: '2017-04-25', to: '2017-05-15'},
        { value: 'mapRotation2', text: 'Map Rotation #2', from: '2017-05-16', to: today()},
        { value: 'last7Days', text: 'Last 7 Days', from: subtractDays(new Date(), 7), to: today()}
    ];

    this.getDateSearchTypes = function () {
        return dateSearchTypes;
    };

    this.getCurrentDate = function () {
        return today();
    }

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

    this.subtractDates = function (dateToSubtractFrom, numberOfDaysToSubtract) {
        return subtractDays(dateToSubtractFrom, numberOfDaysToSubtract);
    }

    function subtractDays(dateToSubtractFrom, numberOfDaysToSubtract) {
        var newDate = new Date(dateToSubtractFrom);
        var dd = newDate.getDate();

        newDate.setDate(dd - numberOfDaysToSubtract);

        return formatDate(newDate);
    }
}]);