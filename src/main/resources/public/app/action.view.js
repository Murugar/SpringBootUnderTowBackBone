ActionView = Backbone.View
		.extend({

			el : 'form#actions',

			initialize : function(options) {

				this.services = options.services;
				$('form#actions').empty();
				
			},
			
			events : {

				'click button#add' : 'add'
				
				
			},
			
			
			add : function(e) {
				
				app_router.navigate('#/add');
				
			},
			
	
			render : function() {

				var compiled_template = _.template(this.html());
				var $el = $(this.el);
				$el.html(compiled_template());

			},

			// USING REQUIRE THIS WOULD CONTAINED IN AN HTML TEMPLATE
			html : function() {

						
				 var html = '<div class="form-group">'; 	    
				    
			    	html += 
					'<span>&nbsp;&nbsp;</span>' +
					'</div>' +
					'<div class="form-group">' +
					' <button id="add" class="btn btn-success btn-lg" type="button">Add</button>' 
					
			    	
			    	return html;
			}		 	
			

		});
