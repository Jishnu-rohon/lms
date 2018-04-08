angular.module('app.services', [])

.factory('helper', [function(){
	return {
		fun1: function () {
			
			return 1;
		}
	}
}])


/*
===========================================================================
    MASTER DATA SERVICE
===========================================================================
*/
.service('MasterDataService',function(RestAPI,URL_Service,$q){
	this.fetchClientMasterData=function(){
		var q = $q.defer();
		RestAPI.GetAPI(URL_Service.get_clientMasterData())
		.then(
			function(rs){
				q.resolve(rs);
			},
			function(err){
				q.reject(err);
			}
		);
		return q.promise;
	}
})


/*
===========================================================================
    URL SERVICE
===========================================================================
*/
.service('URL_Service',function(RestAPI){
	this.urlObj={
		loginUrl:'login',
		menuUrl:'menu',
		clientMasterData:'master-data'
	};
	this.get_loginUrl=function(){
		return BASE_URL+this.urlObj.loginUrl;
	}
	this.get_menuUrl=function(){
		return BASE_URL+this.urlObj.menuUrl;
	}
	this.get_clientMasterData=function(){
		return BASE_URL+this.urlObj.clientMasterData;
	}
})



/*
===========================================================================
    LOGIN SERVICE
===========================================================================
*/
.service('LoginService',function(RestAPI,URL_Service,$q){
	this.loginObj={
		loginId:'',
		loginPass:''
	};
	this.validateUser=function(){
		var q = $q.defer();
		RestAPI.PostAPI(URL_Service.get_loginUrl(),this.loginObj)
		.then(
			function(rs){
				q.resolve(rs);
			},
			function(err){
				q.reject(err);
			}
		);
		return q.promise;
	}
})


/*
===========================================================================
    CLIENT SERVICE
===========================================================================
*/
.service('ClientService',function(RestAPI,URL_Service,$q){
	this.client={
		saluation:'',
		fName:'',
		mName:'',
		lName:'',
		religionSlno:'-1',
		genderSlno:'-1',
		dob:'',
		clientNatureSlno:'-1',
		clientDesc:'',
		clientPrecations:'',
		profession:{
			professionTypeSlno:'-1',
			designation:'',
			companyName:'',
			companyAddress:'',
			citySlno:'',
			countrySlno:'-1',
			companyPin:'',
			companyPhone:'',
			companyEmail:'',
			attachFile:''
		},
		contact:{
			pEmail:'',
			sEmail:'',
			pMobile:'',
			sMobile:'',
		},
		address:{
			presentAddress:{
				street:'',
				countrySlno:'-1',
				stateSlno:'-1',
				citySlno:'-1',
				pincode:''
			},
			indianAddress:{
				street:'',
				countrySlno:'',
				stateSlno:'',
				citySlno:'',
				pincode:''
			},
			overseasAddress:{
				street:'',
				countrySlno:'',
				stateSlno:'',
				citySlno:'',
				pincode:''
			}
		},
		kyc:{
			pan:'',
			passport:'',
			voterId:'',
			adhar:'',
			attachFile:''
		}
	};
})


.service('MenuService',function(RestAPI,URL_Service,$q,$cookies){
	this.getMenu=function(){
		var q = $q.defer();
		RestAPI.GetAPI(URL_Service.get_menuUrl())
		.then(
			function(rs){
				q.resolve(rs);
			},
			function(err){
				q.reject(err);
			}
		);
		return q.promise;
	}
})



/*
===========================================================================
    REST SERVICE
===========================================================================
*/
.service('RestAPI',function($q, $http, $loader,$cookies){
	'use strict';
	//Method for GET request
	this.GetAPI=function(url){
		console.log(url);
		var q = $q.defer();

		var headerObj={
			'Authorization': 'Bearer '+$cookies.get('token'),
			'Content-type': 'application/json'
		};
		
		Loader.start('doing-something');
		$http({
			method: 'GET',
			url: url,
			headers: headerObj
		})
		.then(
			function (rs) {		
				q.resolve(rs);
				Loader.stop('doing-something');	
			}, 
			function (err) {	
				q.reject(err);
				Loader.stop('doing-something');	
			}
		);
		return q.promise;


		//================= ( 2 ) ===========
		/* var config = {
			headers : {
				'Authorization': 'Bearer '+$cookies.get('token'),
				'Content-type': 'application/json'
			}
		}
		Loader.start('doing-something');
		$http.get(url, config)
		.then(
			function (rs) {
				q.resolve(rs);
			},
			function(err){
				q.reject(err);
			}
		);
		Loader.stop('doing-something');
		return q.promise; */
	},//GetAPI


	//Method for POST request
	this.PostAPI=function(url,reqObj){
		console.log(url);
		console.log(reqObj);
		var headerObj={
			Authorization: 'Bearer '+$cookies.get('token'),
			'Content-type': 'application/json'
		};
		Loader.start('doing-something');
		var q = $q.defer();
		$http({
			method: 'POST',
			url: url,
			data:reqObj,
			headers: headerObj,
		}).then(function (rs) {
			Loader.stop('doing-something');		
			q.resolve(rs);
		}, function (err) {	
			Loader.stop('doing-something');
			q.reject(err);
		});
		return q.promise;
	},

	//Method for PUT request
	this.PutAPI=function(url,data){
		var q = $q.defer();
		$http({
			method: 'PUT',
			url: url,
			headers: {
		    	'Content-type': 'application/json'
		 	},
		}).then(function (rs) {		
			q.resolve(rs);
		}, function (err) {	
			q.reject(err);
		});
		return q.promise;
	},

	//Method for DELETE request
	this.DeleteAPI=function(url,data){
		var q = $q.defer();
		$http({
			method: 'DELETE',
			url: url,
			headers: {
		    	'Content-type': 'application/json'
		 	},
		}).then(function (rs) {		
			q.resolve(rs);
		}, function (err) {	
			q.reject(err);
		});
		return q.promise;
	}

})


.service('SessionAPI',function($q,$http){
	var sessionUrl='script.php';
	this.getSessionObject=function(){
		var q = $q.defer();
		$http({
			method: 'POST',
			url: sessionUrl,
			headers: {
		    	'Content-type': 'application/json'
		 	},
		}).then(function (rs) {		
			q.resolve(rs);
		}, function (err) {	
			q.reject(err);
		});
		return q.promise;
	}
})
;