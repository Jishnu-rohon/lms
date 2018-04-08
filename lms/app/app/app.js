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

	function generateMenuArray(){
		$rootScope.data.menuArray=[];
		var menuArr=JSON.parse(localStorage.getItem("menuList"));
		$rootScope.data.menuArray=menuArr;
		//console.log(menuArr);
	}


	function checkUserLoginStatus(){

	}


	$rootScope.operation={
		checkUserLoginStatus:function(){
			if(typeof $cookies.get("token") === "undefined"){
				$rootScope.data.loginFlag=false;
				return false;
			}else{
				$rootScope.data.loginFlag=true;
				generateMenuArray();
				return true;
			}
		}
	};//operation obj end.
})



