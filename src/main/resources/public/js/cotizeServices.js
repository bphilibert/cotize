var cotizeServices = cotizeModule.service('cotizeServices', []);

cotizeServices.factory('cotizeProjectService', ['$http', function ($http) {
    var serverBaseUrl = 'http://' + window.document.URL.split('/')[2] + '/api/';

    var service = {};
    service.createProject = function (project) {
        var query = serverBaseUrl + 'project';
        return $http.post(query, project);
    };
    service.loadProject = function (projectID) {
        var query = serverBaseUrl + 'project/' + projectID;
        return $http.get(query);
    };
    service.contribute = function (projectID, contribution) {
        var query = serverBaseUrl + 'project/' + projectID + '/contribute';
        return $http.post(query, contribution);
    };
    return service;
    }
]);