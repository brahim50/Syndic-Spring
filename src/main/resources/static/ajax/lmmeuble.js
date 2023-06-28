$(function() {
			fetchAllMeubles();
			function fetchAllMeubles(){
				var tableData = "";
                $.ajax({
                	type: "GET",
		        	url: "/lmmeubles",
                    success: function(response){
                    	console.log(response);
                    	response.forEach(function(item){
                    		tableData += '<tr>'+
                    		'<td>' + item.id + '<td>'+
                    		'<td>' + item.nom + '<td>'+
                    		'<td>' + item.numero + '<td>'+
                    		'<td>' + item.nbretage + '<td>'+
                    		'<td>' + item.address + '<td>'+
                    		'<td>' + item.ville + '<td>'+
                    		'<td>' +
                    		
                    		+ '<td>'+
                    		
                    		'</tr>';
                    	});
                    	$("#lmmeuble-table>tbody").html(tableData);
                    	
                    },
                    error: function(response){
		        		console.log(response);
		        	}

                });
            }
			$("#add_lmmeuble").submit(function(e) {
		        e.preventDefault();
		        $("#btn-add").text('Adding...');
		        var syndic = $('#syndic').val();
		        var nom = $('#nom').val();
		        var numero = $('#numero').val();
		        var nbretage = $('#nbretage').val();
		        var address = $('#address').val();
		        var ville = $('#ville').val();
		        $.ajax({
		        	 
		        	type: "POST",
		        	url: "/add",
		        	dataType: "json",
		        	data: {syndic:syndic ,nom: nom ,numero:numero ,nbretage:nbretage ,address:address, ville:ville},
		            cache: false,
		            success: function(response){
		            	Swal.fire(
		                        'Added!',
		                        'Appartement Added Successfully!',
		                        'success'
		                      )
		                      fetchAllMeubles();
		                     
		                        
		            	$('#add_lmmeuble')[0].reset();
		            	$("#btn-add").text('ADD');
		            	
		            	 
		            	 
                
               
              
		                
		               
		            },
		        	error: function(response){
		        		console.log(response);
		        	}
		            
		        });
		       
		    });
			
			
		});
		$('head').append('<link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600" rel="stylesheet" type="text/css">');

$('input').focus(function(event) {
  $(this).closest('.float-label-field').addClass('float').addClass('focus');
})

$('input').blur(function() {
  $(this).closest('.float-label-field').removeClass('focus');
  if (!$(this).val()) {
    $(this).closest('.float-label-field').removeClass('float');
  }
});