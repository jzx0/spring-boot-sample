// 定义控制器View1Controller，并注入$rootScope、$scope和$http
actionApp.controller('View1Controller',
    ['$rootScope', '$scope', '$http', function ($rootScope, $scope, $http) {
    // 使用$scope.$on监听$viewContentLoaded事件，可以在页面内容加载完成后进行一些操作
    $scope.$on('$viewContentLoaded', function () {
        console.log('页面加载完成');
    });
    // 在scope内定义一个方法search，在页面上通过ng-click调用
    $scope.search = function () {
        // 通过$scope.personName获取页面定义的ng-model=“personName”的值
        var personName = $scope.personName;
        // 使用$http.get向服务端地址search发送get请求
        $http.get('search', {
            // 使用params增加请求参数
            params: {
                personName: personName
            }
        }).then(function (result) {
            $scope.person = result.data;
        })
    }
}]);

actionApp.controller('View2Controller', ['$rootScope', '$scope', function ($rootScope, $scope) {
    $scope.$on('$viewContentLoaded', function (event) {
        console.log('页面加载完成，event：' + event.toString());
    })
}]);