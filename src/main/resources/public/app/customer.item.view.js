CustomerItemView = Backbone.View.extend({

	el : 'table',

	initialize : function(options) {
		
	
		this.model = options.model;
		this.render();

	},

	events : {

		'click button' : 'edit'
		
	},
	
	edit : function(e) {
		
		e.preventDefault();		
		alert('edit'+e.target.id);
	
	},
	
	
	render : function() {

		var compiled_template = _.template(this.html());
		var $el = $(this.el);
		var m = this.model.toJSON();
	    m['date'] = this.formatDate(new Date(m.created));
		
		$el.append(compiled_template(m));

	},

	html : function() {

		return '<tr class="info text-primary"><td id="<%=id%>-id"><%=id%> </td> '
				+ '<td id="<%=id%>-name"><%=name%> </td> '
				+ '<td id="<%=id%>-location"><%=location.street%> <%=location.city%>,<%=location.state%>  <%=location.zip%></td> '
				+ '<td id="<%=id%>-edit"><a href="#/edit/<%=id%>">Edit</a></td> '
				+ '</tr>';

	},

	formatDate : function(date) {

		var hours = date.getHours();
		var minutes = date.getMinutes();
		var ampm = hours >= 12 ? 'pm' : 'am';
		hours = hours % 12;
		hours = hours ? hours : 12; // the hour '0' should be '12'
		minutes = minutes < 10 ? '0' + minutes : minutes;
		var strTime = hours + ':' + minutes + ' ' + ampm;
		return date.getMonth() + 1 + "/" + date.getDate() + "/"
				+ date.getFullYear() + "  " + strTime;
	}

});
