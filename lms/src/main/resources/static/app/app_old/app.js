angular.module('app', ['app.controllers', 'app.routes', 'app.services', 'app.directives', 'ngRoute','angular-ui-loader','ngCookies'])


/* .config(['$httpProvider', function ($httpProvider,$cookies) {
    $httpProvider.defaults.headers.common = { 
        'Authorization': 'Bearer 12345',
        'Accept': 'application/json;odata=verbose'
      };
}]) */


.run(function($rootScope,$http,$cookies) {
	$rootScope.data={
		userName:'',
		loginFlag:false,  //false=User not login, true=User is login now
		menuArray:[],
		generateMenuArray:function(){
			generateMenuArray();
		},
		checkUserLoginStatus:function(){
			checkUserLoginStatus();
		}
	};

	//$http.defaults.headers.common['Authorization'] = 'Basic 12345'; 
	function generateMenuArray(){
		if($rootScope.data.menuArray.length==0){
			$rootScope.data.menuArray=$cookies.get('menu');
		}
	}


	function checkUserLoginStatus(){

	}


	$rootScope.operation={
		checkUserLoginStatus:function(){
			if(typeof $cookies.get("token") === "undefined"){
				return false;
			}else{
				generateMenuArray();
				return true;
			}
		}
	};//operation obj end.
})



