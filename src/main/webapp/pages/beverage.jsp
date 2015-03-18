<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
			href="<%=request.getContextPath()%>/css/restaurant.css" />
<link rel="stylesheet"
			href="<%=request.getContextPath()%>/css/dataTable.css" />			
<script src="http://code.jquery.com/jquery-latest.min.js"></script>		
<script type="text/javascript">
        var contexPath = "<%=request.getContextPath() %>";
</script>

</head>
<body style="background-image: url(../images/background_10.jpg); background-repeat: repeat; width:100%">
<a href="<%=request.getContextPath()%>/pages/main.jsp"><input type="button" value="Go to Home Page"/></a>
<h2 style="color:green">Here are the Beverages</h2>
<div id="tablediv">
<form id="bevForm">
<table id="beverageTable" class="display" cellspacing="0" width="100%">
	<thead>
        <tr>
        	<th><input type="checkbox" id="selectall"/></th>
            <th scope="col" align="left">Item Name</th>
            <th scope="col" align="left">Price</th>
            <th scope="col" align="left">Tax</th>
            <th scope="col" align="left">Total</th>
        </tr>
	</thead>
</table>
<div style="height: 5px" align="left"></div>
<input  id="bevButton" class="buttonContainer" type="button" value="Order"/>
<a href="<%=request.getContextPath()%>/pages/order.jsp">
<input  id="bevButton" class="buttonContainer" type="button" value="Order Status"/></a>
</form>
</div>

<SCRIPT language="javascript">

  	$.ajax({
    		type: "GET",
    		url: contexPath + "/restaurantCtrlr/beverage/",
    		contentType: "application/json",
    		dataType: "json",
    		success: function(response){
    			if(response !=null){
    				$("#beverageTable").find("tr:gt(0)").remove();
    				var table1 = $("#beverageTable");
    				$.each(response, function(key,value) { 
    					var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
	                   //    rowNew.children().eq(0).text(value['id']);
	                   	   rowNew.children().eq(0).html('<input type="checkbox" name="case" class="case" />'); 
	                   	   
	                   	   rowNew.children().eq(1).html('<span class="itemName">'+value['item_name']+'</span>'); 
	                       rowNew.children().eq(2).text(value['price']); 
	                       rowNew.children().eq(3).text(value['tax']); 
	                       rowNew.children().eq(4).text(value['total']); 
	                       rowNew.appendTo(table1);	
    				});
    			}
    			
    		}
    	})
    	
    	$("#bevButton").click(function(event){
    		
    		
    	//	console.log('hello');
        //	alert("m inside")
        	
        	$.each($('.case'),function(){
        		
        		if(this.checked){
                	
                	if(arr.length==0){
                		arr[0]=$( this ).parent().parent().find('.itemName').text();
                		
                		
                	}else{
                		arr[length-1]=$( this ).parent().parent().find('.itemName').text();
                	}
            	}
            	console.log(arr);
        		
        	});
        	
        	
    		
    		
    	//	alert('clicked');
          $.post( 
        		  contexPath + "/restaurantCtrlr/bevOrder",
        		  {'beverages':arr.join(",")},
	             function(data) {
              //  $('#stage1').html(data);
              console.log("print data::::::::>>>>>",data);
             }
          );
         // var str = $("#bevForm").serialize();
        //  $("#stage2").text(str);
      });
  // });
    $("#selectall").click(function () {
          $('.case').attr('checked', this.checked);
    });
    var arr=[];
	console.log('hi');

    // if all checkbox are selected, check the selectall checkbox
    // and viceversa
    $(".case").click(function(){
    	
    	
    	
        if($(".case").length == $(".case:checked").length) {
            $("#selectall").attr("checked", "checked");
        } else {
            $("#selectall").removeAttr("checked");
        }
 
    });


</SCRIPT>
</body>
</html>