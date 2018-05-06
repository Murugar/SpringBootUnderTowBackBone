CustomerAddView = Backbone.View.extend({

	el : 'div#customers',

	initialize : function(options) {
		
        this.model = new Customer();
        this.model.set('location',{});
        this.render();
		

	},

	events : {

		'click button#cancel' : 'cancel',
		'click button#save' : 'save',
		
	},
	
	cancel : function(e) {
		
		app_router.navigate('/#');
	
	},
	
	save : function(e) {
	
	    var name = $('#name').val();
	    var street = $('#street').val();
	    var city = $('#city').val();
	    var state = $('#state').val();
	    var zip = $('#zip').val();
	    this.model.get('location').street = street;
	    this.model.get('location').city = city;
	    this.model.get('location').state = state;
	    this.model.get('location').zip = zip;
	    this.model.save({name:name},{url: 'customer', 
	       success: function(model,response) { app_router.navigate('/#');   }});
	
	
	},
	
	
	
	
	render : function() {

		var compiled_template = _.template(this.html());
		var $el = $(this.el);
		var m = this.model.toJSON();		
		$el.html(compiled_template(m));

	},

	html : function() {

		return '<br/><h3 class="well text-center text-success">Add Customer</h3> <br/> <form>'		     
		      + '<div class="form-group">'
		      + '<label class="text-primary">Name:</label></br> <input id="name" type="text" value="<%=name%>"/>'
		      + '</div>'
		      + '<div class="form-group">'
		      + '<label class="text-primary">Street:</label></br> <input id="street" type="text" value="<%=location.street%>"/>'
		      + '</div>'
		      + '<div class="form-group">'
		      + '<label class="text-primary">City:</label> </br> <input id="city" type="text" value="<%=location.city%>"/>'
		      
		      + '</div>'
		       + '<div class="form-group">'
		      + '<label class="text-primary">State:</label> </br>  <input id="state" type="text" value="<%=location.state%>"/>'
		      + '</div>'
		      + '<div class="form-group">'
		      + '<label class="text-primary">Zip:</label> </br> <input id="zip" type="text" value="<%=location.zip%>"/>'
		      + '</div>'
		      
		      + '<div class="form-group">'
		      + '<button id="save" class="btn btn-primary">Save</button>&nbsp;&nbsp;<button id="cancel" class="btn btn-danger">Cancel</button>' 
		      + '</div> </form>';

    }

});
