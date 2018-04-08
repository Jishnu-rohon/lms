//var BASE_URL="http://localhost:8089/";
//var BASE_URL="http://192.168.1.50:8088/lms/";
//var BASE_URL="http://localhost:8088/lms/";

//var BASE_URL="http://132.148.22.72:8080/lms/";

var BASE_URL="http://www.lms.referpartner.com/";


angular.module('app.controllers', ['ui.bootstrap'])

.controller('ctrlNav', function($scope, $rootScope){
	$scope.showAlert= function(){
		alert('Hi i am alert');
	}
	$scope.showChilds = function(menu, index){
        menu.active = !menu.active;
        updateMenu(index);
    };
	$rootScope.menulink=[
		{name:'Home', url:'#/home' , status: '1'},
		{name:'About Us', url:'#/about_us', status: '',
			subMenus:[
				{name:'Carear'},
				{name:'Portfolio'},
				{name:'Our Mision'}
			]
		},
		{name:'Gallery', url:'#/gallery', status: ''},
		{name:'Services', url:'#/services', status: ''},
		{name:'Contact Us', url:'#/contact_us', status: ''}
	];

	function updateMenu(index){
		for(var i=0;i<$rootScope.menulink.length;i++){
			if(i==index){
				$rootScope.menulink[i].status='1';
			}
			else{
				$rootScope.menulink[i].status='';
			}
		}
	}
})



/*
===========================================================================
    LOGIN CONTROLLER
===========================================================================
*/
.controller('ctrl_log_in', function($scope,$rootScope,LoginService,$location,$cookies) {
	$scope.init=function(){
		var status=$rootScope.operation.checkUserLoginStatus();
		if(!status){
			//$location.path('/login');
		}
		else{
			$location.path('/home');
			
		}
	}

	$scope.loginService=LoginService;
	$scope.doLogin=function(){
		$scope.loginService.validateUser()
		.then(
			function(rs){
				//console.log('**********************');
				//console.log(rs);
				if(rs.status==200){
					//alert(1);
					$rootScope.data.loginFlag=true;
					$cookies.put("token", rs.data.user.token);
					localStorage.setItem('menuList', JSON.stringify(rs.data.menu));
					$location.path('/home');
				}
				else{
					alert('Invalid Credential');
				}
			},
			function(err){
				console.log(err);
			}
		);
	}
})



/*
===========================================================================
    HOME CONTROLLER
===========================================================================
*/
.controller('ctrl_home', function($scope,$rootScope,$cookies,$location,MenuService) {
	
	$scope.init=function(){
		var status=$rootScope.operation.checkUserLoginStatus();
		if(!status){
			$location.path('/login');
		}
		else{
			
			//console.log('Bearer '+$cookies.get('token'));
		}
	}

	$scope.bnaner=[
		{
			imgUrl:'images/banner-img.jpg',
			heading:'Welcome to our web site',
			paragraph:'sorry, i don t understand  my englies is not very good',
			link:'Read More'
		},
		{
			imgUrl:'images/banner-img2.jpg',
			heading:'Welcome to our web site',
			paragraph:'sorry, i don t understand  my englies is not very good',
			link:'Read More'
		},
		{
			imgUrl:'images/banner-img3.jpg',
			heading:'Welcome to our web site',
			paragraph:'sorry, i don t understand  my englies is not very good',
			link:'Read More'
		}
	]

	$scope.fieldOne={
		name:'',
		email:'',
		phone:'',
		roll:''
	};

	$scope.about=[
		{
			imageUrl:'images/banner-img2.jpg',
			heading:'Aenean lectus ex',
			content:'Aenean lectus ex, pharetra et velit a, iaculis sodales nisl. Pellentesque fringilla faucibus risus vel viverra. Donec eleifend ex nec diam ornare, sit amet consectetur turpis hendrerit. Fusce vitae ante vehicula, gravida magna vel, mattis odio. Nunc in ipsum venenatis, lacinia arcu vitae, luctus ante. Nunc volutpat lacus mauris. '
		},
		{
			imageUrl:'images/banner-img.jpg',
			heading:'Proin a sapien vitae metus',
			content:'Proin a sapien vitae metus facilisis auctor eget eget sem. Aenean lectus ex, pharetra et velit a, iaculis sodales nisl. Pellentesque fringilla faucibus risus vel viverra. Donec eleifend ex nec diam ornare, sit amet consectetur turpis hendrerit. Fusce vitae ante vehicula, gravida magna vel, mattis odio.'
		},
		{
			imageUrl:'images/banner-img3.jpg',
			heading:'Mauris tincidunt dui arcu',
			content:'Mauris tincidunt dui arcu, accumsan auctor mauris porttitor ac. Proin a sapien vitae metus facilisis auctor eget eget sem. Aenean lectus ex, pharetra et velit a, iaculis sodales nisl. Pellentesque fringilla faucibus risus vel viverra. Donec eleifend ex nec diam ornare, sit amet consectetur turpis hendrerit. Fusce vitae ante vehicula, gravida magna vel, mattis odio. Nunc in ipsum venenatis, lacinia arcu vitae, luctus ante. Nunc volutpat lacus mauris. '
		}
	];

	$scope.function1=function(){
		$scope.menulink.splice(2,1);
	}

	$scope.formSubmit=function(){
		$rootScope.data.userName=$scope.fieldOne.name;
	}
})



/*
===========================================================================
    CREATE NEW CLIENT CONTROLLER
===========================================================================
*/
.controller('ctrl_creat_new_client', function($scope,$rootScope,$location,ClientService,MasterDataService,$filter) {
	
	/* Date Picker */
	$scope.open = function($event) {
		$event.preventDefault();
		$event.stopPropagation();
		$scope.opened = true;
	};
	$scope.dateOptions = {
		formatYear: 'yy',
		startingDay: 1
	};
	$scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate','yyyy-MM-dd'];
	$scope.format = $scope.formats[4];
	  
	  
	
	$scope.init=function(){
		var status=$rootScope.operation.checkUserLoginStatus();
		if(!status){
			$location.path('/login');
		}
		else{//Fetch Master Data
			MasterDataService.fetchClientMasterData()
			.then(
				function(res){
					$scope.masterData=res.data;
				},
				function(err){
					console.log(err);
				}
			);
		}
	}

	$scope.obj={
		copyIndianAddress: false,
		copyOverseasAddress: false
	};

	

	$scope.presentAddressStates=[];
	$scope.presentAddressCities=[];

	$scope.indianAddressStates=[];
	$scope.indianAddressCities=[];

	$scope.overseasAddressStates=[];
	$scope.overseasAddressCities=[];




	$scope.clientService=ClientService;

	$scope.dobChange=function(){
		$scope.clientService.client.dob=$filter('date')($scope.clientService.client.dob, 'yyyy-MM-dd');
	}

	$scope.updateCountry=function(type){
		if(type=='PA'){
			var countrySlno=$scope.clientService.client.address.presentAddress.countrySlno;
		}
		else if(type=='IA'){
			var countrySlno=$scope.clientService.client.address.indianAddress.countrySlno;
		}
		else if(type=='OA'){
			var countrySlno=$scope.clientService.client.address.overseasAddress.countrySlno;
		}

		$scope.clientService.getState(countrySlno)
		.then(
			function(rs){
				if(type=='PA'){
					$scope.presentAddressStates=rs.data;
				}
				if(type=='IA'){
					$scope.indianAddressStates=rs.data;
				}
				if(type=='OA'){
					$scope.overseasAddressStates=rs.data;
				}
			},
			function(err){
				console.log(err);
			}
		);
	}

	$scope.updateState=function(type){
		if(type=='PA'){
			var stateSlno=$scope.clientService.client.address.presentAddress.stateSlno;
		}
		else if(type=='IA'){
			var stateSlno=$scope.clientService.client.address.indianAddress.stateSlno;
		}
		else if(type=='OA'){
			var stateSlno=$scope.clientService.client.address.overseasAddress.stateSlno;
		}

		$scope.clientService.getCity(stateSlno)
		.then(
			function(rs){
				if(type=='PA'){
					$scope.presentAddressCities=rs.data;
				}
				else if(type=='IA'){
					$scope.indianAddressCities=rs.data;
				}
				else if(type=='OA'){
					$scope.overseasAddressCities=rs.data;
				}
			},
			function(err){
				console.log(err);
			}
		);
	}

	$scope.copyAddress=function(addressType){
		if(addressType=='IA'){
			if($scope.obj.copyIndianAddress==true){			
				$scope.clientService.client.address.indianAddress.street=$scope.clientService.client.address.presentAddress.street;
				$scope.clientService.client.address.indianAddress.countrySlno=$scope.clientService.client.address.presentAddress.countrySlno;
				$scope.clientService.client.address.indianAddress.stateSlno=$scope.clientService.client.address.presentAddress.stateSlno;
				$scope.clientService.client.address.indianAddress.citySlno=$scope.clientService.client.address.presentAddress.citySlno;
				$scope.clientService.client.address.indianAddress.pincode=$scope.clientService.client.address.presentAddress.pincode; 
				
			}
			else {
				$scope.clientService.client.address.indianAddress.street='';
				$scope.clientService.client.address.indianAddress.countrySlno='-1';
				$scope.clientService.client.address.indianAddress.stateSlno='-1';
				$scope.clientService.client.address.indianAddress.citySlno='-1';
				$scope.clientService.client.address.indianAddress.pincode=''; 
			}
		}
		else if(addressType=='OA'){
			if($scope.obj.copyIndianAddress==true){			
				$scope.clientService.client.address.overseasAddress.street=$scope.clientService.client.address.presentAddress.street;
				$scope.clientService.client.address.overseasAddress.countrySlno=$scope.clientService.client.address.presentAddress.countrySlno;
				$scope.clientService.client.address.overseasAddress.stateSlno=$scope.clientService.client.address.presentAddress.stateSlno;
				$scope.clientService.client.address.overseasAddress.citySlno=$scope.clientService.client.address.presentAddress.citySlno;
				$scope.clientService.client.address.overseasAddress.pincode=$scope.clientService.client.address.presentAddress.pincode; 
				
			}
			else {
				$scope.clientService.client.address.overseasAddress.street='';
				$scope.clientService.client.address.overseasAddress.countrySlno='-1';
				$scope.clientService.client.address.overseasAddress.stateSlno='-1';
				$scope.clientService.client.address.overseasAddress.citySlno='-1';
				$scope.clientService.client.address.overseasAddress.pincode=''; 
			}
		}
	}
	
	$scope.genderChange=function(){
		//console.log('Gender Changed!');
	}

	$scope.saveClient=function(){
		console.log($scope.clientService.client);
		$scope.clientService.saveClient()
		.then(
			function(rs){
				console.log(rs);
				if(rs.status==200){
					alert('Client Record Saved');
					$location.path('/view-clients');
				}
			},
			function(err){
				console.log(err);
			}
		);
	}
})


/*
===========================================================================
    CLIENT LIST CONTROLLER
===========================================================================
*/
.controller('ctrl_view_clients', function($scope,$rootScope,$location,ClientService,MasterDataService) {
	$scope.init=function(){
		console.log("init function called");
		var status=$rootScope.operation.checkUserLoginStatus();
		if(!status){
			$location.path('/login');
		}
		else{//Fetch Master Data
			ClientService.getAllClient()
			.then(
				function(rs){
					//console.log(rs);
					$scope.clientList=rs.data;
				},
				function(err){
					console.log(err);
				}
			);
		}
	}


	$scope.clientSearch='';




	$scope.viewClient=function(clientObj){
		$scope.selectedClient=clientObj;
		//console.log($scope.selectedClient);
	}

	$scope.setDeleteClientSlno=function(clientObj){
		//$scope.client=clientObj;
		console.log("client to delete = "+JSON.stringify(clientObj));

		$scope.deleteslno=clientObj.slno;

		console.log("client to delete slno = "+clientObj.slno);		
	}
	$scope.deleteClient=function(slno){
		//$scope.client=clientObj;
		
		console.log("client to delete slno = "+$scope.deleteslno);	

		var status=$rootScope.operation.checkUserLoginStatus();
		console.log("deleteClient = "+$scope.deleteslno);
		if(!status){
			$location.path('/login');
		}
		else{//Fetch Master Data
			ClientService.deleteClient($scope.deleteslno)

			.then(
				function(rs){
					console.log(rs);
					//$scope.clientList=rs.data;
					if(rs.status==200){
						console.log(rs);
						alert(rs.data.message);
						//$location.path('/view-clients');
						$scope.clientList=[];
						$scope.init();
					}
				},
				function(err){
					console.log(err);
				}
			);


		}	
	}
})


.controller('ctrl_deleted_clients', function($scope,$rootScope,$location,ClientService,MasterDataService) {
	$scope.init=function(){
		console.log("deleted init function called");
		var status=$rootScope.operation.checkUserLoginStatus();
		if(!status){
			$location.path('/login');
		}
		else{//Fetch Master Data
			ClientService.getAllDeletedClient()
			.then(
				function(rs){
					console.log(rs);
					$scope.clientList=rs.data;
				},
				function(err){
					console.log(err);
				}
			);
		}
	}

	$scope.clientSearch='';

	$scope.setRestoreClientSlno = function(clientObj) {
		console.log("client to restore = "+JSON.stringify(clientObj));
		$scope.restoreslno=clientObj.slno;
		console.log("client to restore slno = "+clientObj.slno);
	}
	$scope.restoreClient=function(){
		//$scope.client=clientObj;
		
		console.log("client to restore slno = "+$scope.restoreslno);	

		var status=$rootScope.operation.checkUserLoginStatus();
		console.log("restoreClient = "+$scope.restoreslno);
		if(!status){
			$location.path('/login');
		}
		else{//Fetch Master Data
			ClientService.restoreClient($scope.restoreslno)

			.then(
				function(rs){
					console.log(rs);
					//$scope.clientList=rs.data;
					if(rs.status==200){
						console.log(rs);
						alert(rs.data.message);
						//$location.path('/view-clients');
						$scope.clientList=[];
						$scope.init();
					}
				},
				function(err){
					console.log(err);
				}
			);


		}	
	}

})


/*
===========================================================================
    VIEW A CLIENT CONTROLLER
===========================================================================
*/
/* .controller('ctrl_view_client', function($scope,$rootScope,ClientService,$routeParams){
	var clientId=$routeParams.clientId;
	$scope.init=function(){
		var status=$rootScope.operation.checkUserLoginStatus();
		if(!status){
			$location.path('/login');
		}
		else{
			$scope.clientService=ClientService;
			$scope.clientService.getClient(clientId)
			.then(
				function(rs){
					console.log(rs);
					$scope.clientObj=rs.data;
				},
				function(err){
					console.log(err);
				}
			);
		}
	}
	
}) */



/*
===========================================================================
    EDIT A CLIENT CONTROLLER
===========================================================================
*/
.controller('ctrl_edit_client', function($scope,$location,MasterDataService,ClientService,$rootScope,$routeParams,$route){
	var clientId=$routeParams.clientId;

	/* Date Picker */
	$scope.open = function($event) {
		$event.preventDefault();
		$event.stopPropagation();
		$scope.opened = true;
	};
	$scope.dateOptions = {
		formatYear: 'yy',
		startingDay: 1
	};
	$scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate','yyyy-MM-dd'];
	$scope.format = $scope.formats[4];


	/*
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		INIT METHOD
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	*/
	$scope.init=function(){
		var status=$rootScope.operation.checkUserLoginStatus();
		if(!status){
			$location.path('/login');
		}
		else{
			$scope.clientService=ClientService;

			$scope.lclient = ClientService.client;

			MasterDataService.fetchClientMasterData()
			.then(
				function(res){
					$scope.masterData=res.data;

					//Fetch the client data
					$scope.clientService.getClient(clientId)
					.then(
						function(rs){
							$scope.clientService.saveObjToClient(rs.data);

							console.log("local client slno = "+$scope.lclient.slno);
							//$route.reload();
						},
						function(err){
							console.log(err);
						}
					);
				},
				function(err){
					console.log(err);
				}
			);

			
		}
	}


	$scope.updateCountry=function(type){
		if(type=='PA'){
			var countrySlno=$scope.clientService.client.address.presentAddress.countrySlno;
		}
		else if(type=='IA'){
			var countrySlno=$scope.clientService.client.address.indianAddress.countrySlno;
		}
		else if(type=='OA'){
			var countrySlno=$scope.clientService.client.address.overseasAddress.countrySlno;
		}

		$scope.clientService.getState(countrySlno)
		.then(
			function(rs){
				if(type=='PA'){
					$scope.presentAddressStates=rs.data;
				}
				if(type=='IA'){
					$scope.indianAddressStates=rs.data;
				}
				if(type=='OA'){
					$scope.overseasAddressStates=rs.data;
				}
			},
			function(err){
				console.log(err);
			}
		);
	}

	$scope.updateState=function(type){
		if(type=='PA'){
			var stateSlno=$scope.clientService.client.address.presentAddress.stateSlno;
		}
		else if(type=='IA'){
			var stateSlno=$scope.clientService.client.address.indianAddress.stateSlno;
		}
		else if(type=='OA'){
			var stateSlno=$scope.clientService.client.address.overseasAddress.stateSlno;
		}

		$scope.clientService.getCity(stateSlno)
		.then(
			function(rs){
				if(type=='PA'){
					$scope.presentAddressCities=rs.data;
				}
				else if(type=='IA'){
					$scope.indianAddressCities=rs.data;
				}
				else if(type=='OA'){
					$scope.overseasAddressCities=rs.data;
				}
			},
			function(err){
				console.log(err);
			}
		);
	}

	$scope.copyAddress=function(addressType){
		if(addressType=='IA'){
			if($scope.obj.copyIndianAddress==true){			
				$scope.clientService.client.address.indianAddress.street=$scope.clientService.client.address.presentAddress.street;
				$scope.clientService.client.address.indianAddress.countrySlno=$scope.clientService.client.address.presentAddress.countrySlno;
				$scope.clientService.client.address.indianAddress.stateSlno=$scope.clientService.client.address.presentAddress.stateSlno;
				$scope.clientService.client.address.indianAddress.citySlno=$scope.clientService.client.address.presentAddress.citySlno;
				$scope.clientService.client.address.indianAddress.pincode=$scope.clientService.client.address.presentAddress.pincode; 
				
			}
			else {
				$scope.clientService.client.address.indianAddress.street='';
				$scope.clientService.client.address.indianAddress.countrySlno='-1';
				$scope.clientService.client.address.indianAddress.stateSlno='-1';
				$scope.clientService.client.address.indianAddress.citySlno='-1';
				$scope.clientService.client.address.indianAddress.pincode=''; 
			}
		}
		else if(addressType=='OA'){
			if($scope.obj.copyIndianAddress==true){			
				$scope.clientService.client.address.overseasAddress.street=$scope.clientService.client.address.presentAddress.street;
				$scope.clientService.client.address.overseasAddress.countrySlno=$scope.clientService.client.address.presentAddress.countrySlno;
				$scope.clientService.client.address.overseasAddress.stateSlno=$scope.clientService.client.address.presentAddress.stateSlno;
				$scope.clientService.client.address.overseasAddress.citySlno=$scope.clientService.client.address.presentAddress.citySlno;
				$scope.clientService.client.address.overseasAddress.pincode=$scope.clientService.client.address.presentAddress.pincode; 
				
			}
			else {
				$scope.clientService.client.address.overseasAddress.street='';
				$scope.clientService.client.address.overseasAddress.countrySlno='-1';
				$scope.clientService.client.address.overseasAddress.stateSlno='-1';
				$scope.clientService.client.address.overseasAddress.citySlno='-1';
				$scope.clientService.client.address.overseasAddress.pincode=''; 
			}
		}
	}
	
	$scope.genderChange=function(){
		//console.log('Gender Changed!');
	}

	$scope.updateClient=function(){
		console.log($scope.clientService.client);
		$scope.clientService.updateClient()
		.then(
			function(rs){
				console.log(rs);
				if(rs.status==200){
					alert('Client Record Updated');
					$location.path('/view-clients');
				}
			},
			function(err){
				console.log(err);
			}
		);
	}



})














.controller('ctrl_menu', function($scope,$cookies,$location){


	$scope.logoutUser=function(){
		$cookies.remove("token");
		$location.path('/login');
	}
})



.controller('ctrlFooter', function($scope){
	$scope.text={name:'2017 copyright | All right researved.'}
})
							



.controller('ctrl_about_us', function($scope) {
	$scope.aboutUsBlock=[
		{
			img:'images/walle.jpg',
			heading:'welcome',
			paragraph:'sorry, i dont understand my englies is not very good sorry, i dont understand my englies is not very good sorry, i don t understand my englies is not very good',
			link:'click hear'
		}
	]
})

.controller('ctrl_gallery', function($scope) {
	$scope.bannerBlock=[
		{
			img:'images/inner-banner3.jpg',
			heading:'what do you do,',
			paragraph:'sorry, i dont understand my englies is not very good'
		}
	]
	$scope.heading={text:'our-gallery'};
	$scope.link={text:'read more'};
	$scope.imgBlock=[
		{
			img:'images/img-9.jpg',
			text:'sorry i don,t understand'
		},
		{
			img:'images/img-10.jpg',
			text:'sorry i don,t understand'
		},
		{
			img:'images/img-11.jpg',
			text:'sorry i don,t understand'
		},
		{
			img:'images/img-12.jpg',
			text:'sorry i don,t understand'
		},
		{
			img:'images/img-13.jpg',
			text:'sorry i don,t understand'
		},
		{
			img:'images/img-14.jpg',
			text:'sorry i don,t understand'
		},
		{
			img:'images/img-15.jpg',
			text:'sorry i don,t understand'
		},
		{
			img:'images/img-16.jpg',
			text:'sorry i don,t understand'
		},
		{
			img:'images/img-17.jpg',
			text:'sorry i don,t understand'
		},
		{
			img:'images/img-18.jpg',
			text:'sorry i don,t understand'
		}
	]
})

.controller('ctrl_services', function($scope) {
	$scope.heading={text:'services'}
	$scope.services=[
		{
		 imgUrl:'images/img-1.jpg',
		 heading2:'best of Home',
		 paragraph:'pillow poillow poillow sofa sofa shi ehi it,s the new gril comeing my home, i am elena so good to sec you elean',
		 link:'click haer',
		 url:'#/home'		 
		},
		{
		 imgUrl:'images/img-2.jpg',
		 heading2:'best of About Us',
		 paragraph:'pillow poillow poillow sofa sofa shi ehi it,s the new gril comeing my home, i am elena so good to sec you elean',
		 link:'click haer',
		 url:'#/about_us'		 
		},
		{
		 imgUrl:'images/img-3.jpg',
		 heading2:'best of Gallery',
		 paragraph:'pillow poillow poillow sofa sofa shi ehi it,s the new gril comeing my home, i am elena so good to sec you elean',
		 link:'click haer',
		 url:'#/gallery'		 
		},
		{
		 imgUrl:'images/img-4.jpg',
		 heading2:'best of services',
		 paragraph:'pillow poillow poillow sofa sofa shi ehi it,s the new gril comeing my home, i am elena so good to sec you elean',
		 link:'click haer',
		 url:'#/services'		 
		},
		{ 
		 imgUrl:'images/img-5.jpg',
		 heading2:'best of Contact Us',
		 paragraph:'pillow poillow poillow sofa sofa shi ehi it,s the new gril comeing my home, i am elena so good to sec you elean',
		 link:'click haer',
		 url:'#/contact_us'		 
		}
	]
})

.controller('ctrl_super_admin', function($scope) {

})

.controller('ctrl_contact_us', function($scope) {

})

.controller('ctrl_lead_creat', function($scope) {

})

.controller('ctrl_lead_view', function($scope) {

})

.controller('ctrl_mail', function($scope) {

})

.controller('ctrl_lead_bucket', function($scope) {

})

.controller('ctrl_converted_leads', function($scope) {

})

.controller('ctrl_to_do_view', function($scope) {

})
.controller('ctrl_creat_new_task', function($scope) {

})
.controller('ctrl_profile', function($scope) {

})
.controller('ctrl_statistics', function($scope) {

})
.controller('ctrl_mail_history', function($scope) {

})
.controller('ctrl_mass_sms', function($scope) {

})
.controller('ctrl_sms_history', function($scope) {

})
.controller('ctrl_product_creat', function($scope) {

})
.controller('ctrl_product_view', function($scope) {

})

.controller('ctrl_product_delete', function($scope) {

})
.controller('ctrl_user_creat', function($scope) {

})
.controller('ctrl_user_view', function($scope) {

})
.controller('ctrl_user_block', function($scope) {

})

.controller('ctrl_create_user', function($scope) {

})
.controller('ctrl_deactivate_account', function($scope) {

})
.controller('ctrl_set_sales_activity_target', function($scope) {

})
.controller('ctrl_sales_statistics', function($scope) {

})


















