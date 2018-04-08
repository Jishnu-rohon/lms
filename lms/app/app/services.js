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
		slno:'',
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
				countrySlno:'-1',
				stateSlno:'-1',
				citySlno:'-1',
				pincode:''
			},
			overseasAddress:{
				street:'',
				countrySlno:'-1',
				stateSlno:'-1',
				citySlno:'-1',
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



	this.saveClientObj={
		saluation:'',
		f_name:'',
		m_name:'',
		l_name:'',
		religion_slno:'',
		gender_slno:'',
		dob:'',
		client_nature_slno:'',
		clientProfessions:{
			professionTypeSlno:'',
			designation:'',
			companyName:'',
			companyAddress:'',
			citySlno:'',
			stateSlno:'',
			countrySlno:'',
			pin:'',
			officePhone:'',
			officeEmail:''
		},
		kycs:[],
		email1:'',
		email2:'',
		mobile1:'',
		mobile2:'',
		addresses:[]
	};

	this.saveClientAddressObj={
		addressTypeSlno:'',
		street:'',
		citySlno:'',
		stateSlno:'',
		countrySlno:'',
		pinSlno:''
	};

	this.saveClientKycObj={
		kycTypeSlno:'',
		identificationNumber:''
	};

	this.getState=function(countrySlno){
		var q = $q.defer();
		RestAPI.GetAPI(URL_Service.get_masterState(countrySlno))
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

	this.getCity=function(stateSlno){
		var q = $q.defer();
		RestAPI.GetAPI(URL_Service.get_masterCity(stateSlno))
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


	this.getAllClient=function(){
		var q = $q.defer();
		RestAPI.GetAPI(URL_Service.get_allClient())
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

	this.getAllDeletedClient=function(){
		var q = $q.defer();
		RestAPI.GetAPI(URL_Service.get_allDeletedClient())
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

	//TO FETCH A CLIENT INFORMATIONS
	this.getClient=function(clientId){
		var q = $q.defer();
		RestAPI.GetAPI(URL_Service.get_clientUrl(clientId))
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

	this.saveObjToClient=function(obj){
		console.log(obj);
		this.client.slno = obj.slno;
		this.client.saluation=obj.saluation;
		this.client.fName=obj.f_name;
		this.client.mName=obj.m_name;
		this.client.lName=obj.l_name;
		
		
		this.client.religionSlno=obj.religion_slno;

		//Gender
		if(obj.gender_slno != null){
			this.client.genderSlno=obj.gender.slno;
		}
		
		this.client.dob=obj.dob;

		//CLIENT NATURE
		if(obj.client_nature_slno != null){
			this.client.clientNatureSlno=obj.clientNature.slno;
		}
		
		this.client.clientDesc=obj.client_desc;
		this.client.clientPrecations=obj.client_restriction;
		
		//CLIENT PROFESSION
		if(obj.profession_slno != null){
			this.client.profession.professionTypeSlno=obj.clientProfessions.professionTypeSlno;
			this.client.profession.designation=obj.clientProfessions.designation;
			this.client.profession.companyName=obj.clientProfessions.companyName;
			this.client.profession.profession=obj.clientProfessions.clientProfessions;
			this.client.profession.citySlno=obj.clientProfessions.citySlno;
			this.client.profession.countrySlno=obj.clientProfessions.countrySlno;
			this.client.profession.companyPin=obj.clientProfessions.pin;
			this.client.profession.companyPhone=obj.clientProfessions.officePhone;
			this.client.profession.companyEmail=obj.clientProfessions.officeEmail;
		}
		
		
		
		
		
		this.client.contact.pEmail=obj.email1;
		this.client.contact.sEmail=obj.email2;
		this.client.contact.pMobile=obj.mobile1;
		this.client.contact.sMobile=obj.mobile2;
		
		
		for(var i=0;i<obj.addresses.length;i++){
			if(obj.addresses[i].addressTypeSlno==1){
				this.client.address.presentAddress.slno=obj.addresses[i].slno;
				this.client.address.presentAddress.street=obj.addresses[i].street;
				this.client.address.presentAddress.countrySlno=obj.addresses[i].countrySlno;
				this.client.address.presentAddress.stateSlno=obj.addresses[i].stateSlno;
				this.client.address.presentAddress.citySlno=obj.addresses[i].citySlno;
				this.client.address.presentAddress.pincode=obj.addresses[i].slno;
			}
			if(obj.addresses[i].addressTypeSlno==2){
				this.client.address.indianAddress.street=obj.addresses[i].street;
				this.client.address.indianAddress.countrySlno=obj.addresses[i].countrySlno;
				this.client.address.indianAddress.stateSlno=obj.addresses[i].stateSlno;
				this.client.address.indianAddress.citySlno=obj.addresses[i].citySlno;
				this.client.address.indianAddress.pincode=obj.addresses[i].saluation;
			}
			if(obj.addresses[i].addressTypeSlno==3){
				this.client.address.overseasAddress.street=obj.addresses[i].street;
				this.client.address.overseasAddress.countrySlno=obj.addresses[i].countrySlno;
				this.client.address.overseasAddress.stateSlno=obj.addresses[i].stateSlno;
				this.client.address.overseasAddress.citySlno=obj.addresses[i].citySlno;
				this.client.address.overseasAddress.pincode=obj.addresses[i].slno;
			}
		}
		
		
		for(var i=0;i<obj.kycs.length;i++){
			if(obj.kycs[i].kycTypeSlno==1){
				this.client.kyc.pan=obj.kycs[i].identificationNumber;
			}
			if(obj.kycs[i].kycTypeSlno==2){
				this.client.kyc.passport=obj.kycs[i].identificationNumber;
			}
			if(obj.kycs[i].kycTypeSlno==3){
				this.client.kyc.voterId=obj.kycs[i].identificationNumber;
			}
			if(obj.kycs[i].kycTypeSlno==4){
				this.client.kyc.adhar=obj.kycs[i].identificationNumber;
			}
		}
		console.log(this.client);
	}

	this.saveClient=function() {
		this.saveClientObj.saluation=this.client.saluation;
		this.saveClientObj.f_name=this.client.fName;
		this.saveClientObj.m_name=this.client.mName;
		this.saveClientObj.l_name=this.client.lName;

		this.saveClientObj.email1=this.client.contact.pEmail;
		this.saveClientObj.email2=this.client.contact.sEmail;
		this.saveClientObj.mobile1=this.client.contact.pMobile;
		this.saveClientObj.mobile2=this.client.contact.sMobile;

		//RELIGION
		if(this.client.religionSlno=="-1"){
			this.saveClientObj.religion_slno=null;
		}
		else{
			this.saveClientObj.religion_slno=this.client.religionSlno;
		}

		//GENDER
		if(this.client.genderSlno=="-1"){
			this.saveClientObj.gender_slno=null;
		}
		else{
			this.saveClientObj.gender_slno=this.client.genderSlno;
		}

		//DOB
		this.saveClientObj.dob=this.client.dob;

		//CLIENT NATURE
		if(this.client.clientNatureSlno=="-1"){
			this.saveClientObj.client_nature_slno=null;
		}
		else{
			this.saveClientObj.client_nature_slno=this.client.clientNatureSlno;
		}
		this.saveClientObj.client_desc=this.client.clientDesc;
		this.saveClientObj.client_restriction=this.client.clientPrecations;

		// *** PROFESSION ***
		//CLIENT PROFESSION TYPE
		if(this.client.profession.professionTypeSlno=="-1"){
			this.saveClientObj.clientProfessions.professionTypeSlno=null;
		}
		else{
			this.saveClientObj.clientProfessions.professionTypeSlno=this.client.profession.professionTypeSlno;
			this.saveClientObj.clientProfessions.designation=this.client.profession.designation;
			this.saveClientObj.clientProfessions.companyName=this.client.profession.companyName;
			this.saveClientObj.clientProfessions.companyAddress=this.client.profession.companyAddress;
			this.saveClientObj.clientProfessions.countrySlno=this.client.profession.countrySlno;
			this.saveClientObj.clientProfessions.pin=this.client.profession.companyPin;
			this.saveClientObj.clientProfessions.officePhone=this.client.profession.companyPhone;
			this.saveClientObj.clientProfessions.officeEmail=this.client.profession.companyEmail;
		}
		
		



		// *** KYC ***
		//PAN
		if(this.client.kyc.pan!=""){
			this.saveClientObj.kycs.push({
				kycTypeSlno:'1',
				identificationNumber:this.client.kyc.pan
			})
		}

		//PASSPORT
		if(this.client.kyc.passport!=""){
			this.saveClientObj.kycs.push({
				kycTypeSlno:'2',
				identificationNumber:this.client.kyc.passport
			})
		}

		//VOTER ID
		if(this.client.kyc.voterId!=""){
			this.saveClientObj.kycs.push({
				kycTypeSlno:'3',
				identificationNumber:this.client.kyc.voterId
			})
		}

		//ADHAR
		if(this.client.kyc.adhar!=""){
			this.saveClientObj.kycs.push({
				kycTypeSlno:'4',
				identificationNumber:this.client.kyc.adhar
			})
		}


		// *** ADDRESS ***
		//Present
		if(this.client.address.presentAddress.countrySlno!="-1"){
			this.saveClientObj.addresses.push({
				addressTypeSlno:'1',
				street:this.client.address.presentAddress.street,
				citySlno:this.client.address.presentAddress.citySlno,
				stateSlno:this.client.address.presentAddress.stateSlno,
				countrySlno:this.client.address.presentAddress.countrySlno,
				pinSlno:this.client.address.presentAddress.pincode
			});
		}

		//Indian
		if(this.client.address.indianAddress.countrySlno!="-1"){
			this.saveClientObj.addresses.push({
				addressTypeSlno:'2',
				street:this.client.address.indianAddress.street,
				citySlno:this.client.address.indianAddress.citySlno,
				stateSlno:this.client.address.indianAddress.stateSlno,
				countrySlno:this.client.address.indianAddress.countrySlno,
				pinSlno:this.client.address.indianAddress.pincode
			});
		}

		//overseas
		if(this.client.address.overseasAddress.countrySlno!="-1"){
			this.saveClientObj.addresses.push({
				addressTypeSlno:'3',
				street:this.client.address.overseasAddress.street,
				citySlno:this.client.address.overseasAddress.citySlno,
				stateSlno:this.client.address.overseasAddress.stateSlno,
				countrySlno:this.client.address.overseasAddress.countrySlno,
				pinSlno:this.client.address.overseasAddress.pincode
			});
		}
		//console.log(this.saveClientObj);
		var q = $q.defer();
		RestAPI.PostAPI(URL_Service.get_saveClient(),this.saveClientObj)
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


	this.updateClient=function() {
		this.saveClientObj.slno=this.client.slno;
		this.saveClientObj.saluation=this.client.saluation;
		this.saveClientObj.f_name=this.client.fName;
		this.saveClientObj.m_name=this.client.mName;
		this.saveClientObj.l_name=this.client.lName;

		this.saveClientObj.email1=this.client.contact.pEmail;
		this.saveClientObj.email2=this.client.contact.sEmail;
		this.saveClientObj.mobile1=this.client.contact.pMobile;
		this.saveClientObj.mobile2=this.client.contact.sMobile;

		//RELIGION
		if(this.client.religionSlno=="-1"){
			this.saveClientObj.religion_slno=null;
		}
		else{
			this.saveClientObj.religion_slno=this.client.religionSlno;
		}

		//GENDER
		if(this.client.genderSlno=="-1"){
			this.saveClientObj.gender_slno=null;
		}
		else{
			this.saveClientObj.gender_slno=this.client.genderSlno;
		}

		//DOB
		this.saveClientObj.dob=this.client.dob;

		//CLIENT NATURE
		if(this.client.clientNatureSlno=="-1"){
			this.saveClientObj.client_nature_slno=null;
		}
		else{
			this.saveClientObj.client_nature_slno=this.client.clientNatureSlno;
		}

		this.saveClientObj.client_desc=this.client.clientDesc;
		this.saveClientObj.client_restriction=this.client.clientPrecations;

		// *** PROFESSION ***
		//CLIENT PROFESSION TYPE
		if(this.client.profession.professionTypeSlno=="-1"){
			this.saveClientObj.clientProfessions.professionTypeSlno=null;
		}
		else{
			this.saveClientObj.clientProfessions.professionTypeSlno=this.client.profession.professionTypeSlno;
			this.saveClientObj.clientProfessions.designation=this.client.profession.designation;
			this.saveClientObj.clientProfessions.companyName=this.client.profession.companyName;
			this.saveClientObj.clientProfessions.companyAddress=this.client.profession.companyAddress;
			this.saveClientObj.clientProfessions.countrySlno=this.client.profession.countrySlno;
			this.saveClientObj.clientProfessions.pin=this.client.profession.companyPin;
			this.saveClientObj.clientProfessions.officePhone=this.client.profession.companyPhone;
			this.saveClientObj.clientProfessions.officeEmail=this.client.profession.companyEmail;
		}
		
		



		// *** KYC ***
		//PAN
		if(this.client.kyc.pan!=""){
			this.saveClientObj.kycs.push({
				kycTypeSlno:'1',
				identificationNumber:this.client.kyc.pan
			})
		}

		//PASSPORT
		if(this.client.kyc.passport!=""){
			this.saveClientObj.kycs.push({
				kycTypeSlno:'2',
				identificationNumber:this.client.kyc.passport
			})
		}

		//VOTER ID
		if(this.client.kyc.voterId!=""){
			this.saveClientObj.kycs.push({
				kycTypeSlno:'3',
				identificationNumber:this.client.kyc.voterId
			})
		}

		//ADHAR
		if(this.client.kyc.adhar!=""){
			this.saveClientObj.kycs.push({
				kycTypeSlno:'4',
				identificationNumber:this.client.kyc.adhar
			})
		}


		// *** ADDRESS ***
		//Present
		if(this.client.address.presentAddress.countrySlno!="-1"){
			this.saveClientObj.addresses.push({
				addressTypeSlno:'1',
				street:this.client.address.presentAddress.street,
				citySlno:this.client.address.presentAddress.citySlno,
				stateSlno:this.client.address.presentAddress.stateSlno,
				countrySlno:this.client.address.presentAddress.countrySlno,
				pinSlno:this.client.address.presentAddress.pincode
			});
		}

		//Indian
		if(this.client.address.indianAddress.countrySlno!="-1"){
			this.saveClientObj.addresses.push({
				addressTypeSlno:'2',
				street:this.client.address.indianAddress.street,
				citySlno:this.client.address.indianAddress.citySlno,
				stateSlno:this.client.address.indianAddress.stateSlno,
				countrySlno:this.client.address.indianAddress.countrySlno,
				pinSlno:this.client.address.indianAddress.pincode
			});
		}

		//overseas
		if(this.client.address.overseasAddress.countrySlno!="-1"){
			this.saveClientObj.addresses.push({
				addressTypeSlno:'3',
				street:this.client.address.overseasAddress.street,
				citySlno:this.client.address.overseasAddress.citySlno,
				stateSlno:this.client.address.overseasAddress.stateSlno,
				countrySlno:this.client.address.overseasAddress.countrySlno,
				pinSlno:this.client.address.overseasAddress.pincode
			});
		}
		//console.log(this.saveClientObj);
		var q = $q.defer();
		RestAPI.PutAPI(URL_Service.get_updateClient(),this.saveClientObj)
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


	this.deleteClient=function(slno) {
		var q = $q.defer();

		console.log("deleteClient = "+URL_Service.get_updateClient()+"/"+slno);

		RestAPI.DeleteAPI(URL_Service.get_updateClient()+"/"+slno)
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

	this.restoreClient=function(slno) {
		var q = $q.defer();

		RestAPI.PutAPI(URL_Service.get_updateClient()+"/"+slno+"/restore")
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
    URL SERVICE
===========================================================================
*/
.service('URL_Service',function(RestAPI){
	this.urlObj={
		loginUrl:'login',
		menuUrl:'menu',
		clientMasterData:'master-data',
		saveClient:'clients',
		getClients:'clients',
		updateClient:'clients'
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
	this.get_masterState=function(countrySlno){
		return BASE_URL+'countries/'+countrySlno+'/states';
	}
	this.get_masterCity=function(stateSlno){
		return BASE_URL+'states/'+stateSlno+'/cities';
	}
	this.get_saveClient=function(){
		return BASE_URL+this.urlObj.saveClient;
	}
	this.get_updateClient=function(){
		return BASE_URL+this.urlObj.updateClient;
	}
	this.get_allClient=function(){
		return BASE_URL+this.urlObj.getClients;
	}

	this.get_clientUrl=function(clientId){
		return BASE_URL+this.urlObj.getClients+'/'+clientId;
	}
	
	this.get_allDeletedClient=function(){
		return BASE_URL+this.urlObj.getClients+'/deleted';
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
		console.log('URL='+url+'   >METHOD=GET');
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
				console.log(rs);
				Loader.stop('doing-something');	
			}, 
			function (err) {	
				q.reject(err);
				console.log(err);
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
		console.log('URL='+url+'   >METHOD=POST :- ');
		console.log(reqObj);
		var headerObj={
			Authorization: 'Bearer '+$cookies.get('token'),
			'Content-type': 'application/json'
		};
		//console.log($cookies.get('token'));
		Loader.start('doing-something');
		var q = $q.defer();
		$http({
			method: 'POST',
			url: url,
			data:reqObj,
			headers: headerObj,
		}).then(function (rs) {
			Loader.stop('doing-something');
			console.log(rs);
			q.resolve(rs);
		}, function (err) {	
			Loader.stop('doing-something');
			console.log(rs);
			q.reject(err);
		});
		return q.promise;
	},

	//Method for PUT request
	this.PutAPI=function(url,reqObj){
		console.log('URL='+url+'   >METHOD=PUT :- ');
		console.log(reqObj);
		var headerObj={
			Authorization: 'Bearer '+$cookies.get('token'),
			'Content-type': 'application/json'
		};
		Loader.start('doing-something');
		var q = $q.defer();
		$http({
			method: 'PUT',
			url: url,
			data:reqObj,
			headers: headerObj,
		}).then(function (rs) {
			Loader.stop('doing-something');
			console.log(rs);
			q.resolve(rs);
		}, function (err) {	
			Loader.stop('doing-something');
			console.log(rs);
			q.reject(err);
		});
		return q.promise;
	},

	//Method for DELETE request
	this.DeleteAPI=function(url){
		Loader.start('doing-something');
		var q = $q.defer();
		var headerObj={
			Authorization: 'Bearer '+$cookies.get('token'),
			'Content-type': 'application/json'
		};
		$http({
			method: 'DELETE',
			url: url,
			headers: headerObj
		}).then(function (rs) {	
			Loader.stop('doing-something');	
			q.resolve(rs);
		}, function (err) {	
			Loader.stop('doing-something');	
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