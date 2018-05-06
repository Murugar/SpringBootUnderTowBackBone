CustomerListView = Backbone.View
		.extend({

			el : 'div#customers',

			initialize : function(options) {

				$('#customers').empty();

				this.collection = options.collection;
				// NOTE: This would be called if server API involved
				var _this = this;
				if (options.fetch) {
					this.collection = new Customer.Collection();
					this.collection.fetch({
						url : '/customer/all',
						success : function(col, response, options) {
                           // _this.collection = col;
							_this.render();
				

						},
						error : function(co, response, options) {
							alert(response);
						}

					});

				} else {
					this.render();
				}
				$('#customers').unbind();

			},
		
			addRows : function() {

				this.collection.forEach(function(model) {

					// add item view, each row
					var itemView = new CustomerItemView({
						model : model
					});

				}, this);

			},

			render : function() {

				var compiled_template = _.template(this.html());
				var $el = $(this.el);
				$el.html(compiled_template());

				this.addRows();
				
				$('#panel-title').text('Customers');

			},
			

			// USING REQUIRE THIS WOULD CONTAINED IN AN HTML TEMPLATE
			html : function() {

				return '<table class="table"><tr class="success text-danger"><th>Id</th><th>Name</th><th>Address</th><th>Action</th></tr>';

			}

		});
