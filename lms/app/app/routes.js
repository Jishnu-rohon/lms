angular.module('app.routes', ['ngRoute'])

.config(function($routeProvider) {
	$routeProvider
		.when('/home', {
			templateUrl: 'templates/home.html',
			controller: 'ctrl_home'
		})

		/*
		===========================================================================
			CREATE CLIENT
		===========================================================================
		*/
		.when('/create-new-client', {
			templateUrl: 'templates/creat-new-client.html',
			controller: 'ctrl_creat_new_client'
		})

		/*
		===========================================================================
			VIEW CLIENT LIST
		===========================================================================
		*/
		.when('/view-clients', {
			templateUrl: 'templates/view-clients.html',
			controller: 'ctrl_view_clients'
		})

		/*
		===========================================================================
			VIEW/EDIT CLIENT
		===========================================================================
		*/
		//view
		.when('/client/view/:clientId', {
			templateUrl: 'templates/view-client.html',
			controller: 'ctrl_view_client'
		})

		// edit
		.when('/client/edit/:clientId', {
			templateUrl: 'templates/edit-client.html',
			controller: 'ctrl_edit_client'
		})









		
		.when('/about_us', {
			templateUrl: 'templates/about.html',
			controller: 'ctrl_about_us'
		})
		.when('/gallery', {
			templateUrl: 'templates/gallery.html',
			controller: 'ctrl_gallery'
		})
		.when('/services', {
			templateUrl: 'templates/services.html',
			controller: 'ctrl_services'
		})
		.when('/contact_us', {
			templateUrl: 'templates/contact.html',
			controller: 'ctrl_contact_us'
		})

		.when('/super-admin', {
			templateUrl: 'templates/super-admin.html',
			controller: 'ctrl_super_admin'
		})

		.when('/lead-creat', {
			templateUrl: 'templates/lead-creat.html',
			controller: 'ctrl_lead_creat'
		})

		.when('/lead-view', {
			templateUrl: 'templates/lead-view.html',
			controller: 'ctrl_lead_view'
		})

		.when('/mail', {
			templateUrl: 'templates/mail.html',
			controller: 'ctrl_mail'
		})
		
		.when('/lead-bucket', {
			templateUrl: 'templates/lead-bucket.html',
			controller: 'ctrl_lead_bucket'
		})
		
		.when('/converted-leads', {
			templateUrl: 'templates/converted-leads.html',
			controller: 'ctrl_converted_leads'
		})

		.when('/log-in', {
			templateUrl: 'templates/log-in.html',
			controller: 'ctrl_log_in'
		})
		
		.when('/to-do-view', {
			templateUrl: 'templates/to-do-view.html',
			controller: 'ctrl_to_do_view'
		})

		.when('/creat-new-task', {
			templateUrl: 'templates/creat-new-task.html',
			controller: 'ctrl_creat_new_task'
		})
		.when('/profile', {
			templateUrl: 'templates/profile.html',
			controller: 'ctrl_profile'
		})

		.when('/statistics', {
			templateUrl: 'templates/statistics.html',
			controller: 'ctrl_statistics'
		})

		.when('/mail-history', {
			templateUrl: 'templates/mail-history.html',
			controller: 'ctrl_mail_history'
		})
		.when('/mass-sms', {
			templateUrl: 'templates/mass-sms.html',
			controller: 'ctrl_mass_sms'
		})

		.when('/sms-history', {
			templateUrl: 'templates/sms-history.html',
			controller: 'ctrl_sms_history'
		})
		.when('/product-creat', {
			templateUrl: 'templates/product-creat.html',
			controller: 'ctrl_product_creat'
		})
		.when('/product-view', {
			templateUrl: 'templates/product-view.html',
			controller: 'ctrl_product_view'
		})
		.when('/product-delete', {
			templateUrl: 'templates/product-delete.html',
			controller: 'ctrl_product_delete'
		})

		.when('/user-creat', {
			templateUrl: 'templates/user-creat.html',
			controller: 'ctrl_user_creat'
		})
		.when('/user-view', {
			templateUrl: 'templates/user-view.html',
			controller: 'ctrl_user_view'
		})
		.when('/user-block', {
			templateUrl: 'templates/user-block.html',
			controller: 'ctrl_user_block'
		})


		.when('/create-user', {
			templateUrl: 'templates/creat-user.html',
			controller: 'ctrl_create_user'
		})
		.when('/deactivate-account', {
			templateUrl: 'templates/deactivate-account.html',
			controller: 'ctrl_deactivate_account'
		})
		.when('/set-sales-activity-target', {
			templateUrl: 'templates/set-sales-activity-target.html',
			controller: 'ctrl_set_sales_activity_target'
		})
		.when('/sales-statistics', {
			templateUrl: 'templates/sales-statistics.html',
			controller: 'ctrl_sales_statistics'
		})
		.when('/deleted-clients', {
			templateUrl: 'templates/deleted-clients.html',
			controller: 'ctrl_deleted_clients'
		})

		.otherwise({
			redirectTo: '/log-in'
		});
});



