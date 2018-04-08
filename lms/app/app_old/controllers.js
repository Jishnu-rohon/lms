//var BASE_URL="http://localhost:8089/";
//var BASE_URL="http://192.168.1.50:8088/lms/";
var BASE_URL="http://localhost:8888/lms/";






angular.module('app.controllers', [])

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
		$rootScope.data.loginFlag=false;
		//IF THE USER LOGIN ALREADY, THEN REDEIRECT LKOGIN PAGE.
		if(typeof $cookies.get("token") === "undefined"){
			
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
				console.log(rs);
				if(rs.status==200){
					
					$rootScope.data.menuArray=rs.data.menu;

					$cookies.put("token", rs.data.user.token);
					$cookies.put("menu", $rootScope.data.menuArray);
					console.log($rootScope.data.menuArray);
					$rootScope.data.loginFlag=true;
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
		$rootScope.data.loginFlag=true;
		if(typeof $cookies.get("token") === "undefined"){
			$location.path('/login');
		}else{
			
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
.controller('ctrl_creat_new_client', function($scope,$rootScope,$location,ClientService,MasterDataService) {
	$scope.init=function(){
		var status=$rootScope.operation.checkUserLoginStatus();
		if(!status){
			$location.path('/login');
		}
		else{//Fetch Master Data
			MasterDataService.fetchClientMasterData()
			.then(
				function(res){
					console.log(res);
					$scope.masterData=res.data;
				},
				function(err){
					console.log(err);
				}
			);
		}
	}




	$scope.clientService=ClientService;

	$scope.updatePresentAddressCountry=function(){
		alert(1111);
	}

	$scope.updateIndianAddressCountry=function(){
		alert(22222);
	}
	
	$scope.genderChange=function(){
		console.log('Gender Changed!');
	}

	$scope.saveClient=function(){
		console.log($scope.clientService.client);
	}
})


.controller('ctrl_menu', function($scope,$cookies,$location){


	$scope.logoutUser=function(){
		$cookies.remove("token");
		$cookies.remove("menu");
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
.controller('ctrl_view_clients', function($scope) {

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
.controller('ctrl_deleted_clients', function($scope) {

})

















