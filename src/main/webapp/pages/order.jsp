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
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>			
<script type="text/javascript">
        var contexPath = "<%=request.getContextPath() %>";
</script>
</head>
<body style="background-image: url(../images/OnlineRestaurant.jpg); background-repeat: repeat; width:100%">
<a href="<%=request.getContextPath()%>/pages/main.jsp"><input type="button" value="Go to Home Page"/></a>
<h2>You have Ordered the below Beverages</h2>
<div id="">
<table id="mainTable" class="display" cellspacing="0" width="100%">
<thead>
        <tr>
            <th scope="col" align="left">OrderID</th>
            <th scope="col" align="left">ITEM_NAME</th>
            <th scope="col" align="left">STATUS</th>
        </tr>
    </thead>
    <tbody>
    </tbody> 
</table>
</div>
<SCRIPT language="javascript">
$.ajax({
	type: "GET",
	url: contexPath + "/restaurantCtrlr/bevorderstatus/",
	contentType: "application/json",
	dataType: "json",
	success: function(response){
		if(response !=null){
			$("#mainTable").find("tr:gt(0)").remove();
			var table1 = $("#mainTable");
			$.each(response, function(key,value) { 
				var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                   rowNew.children().eq(0).text(value['id']); 
                //   rowNew.children().eq(1).text(value['item_name']); 
                   rowNew.children().eq(2).text(value['item_name']); 
                   rowNew.children().eq(3).text(value['status']); 
                 //  rowNew.children().eq(4).text(value['total']); 
                   rowNew.appendTo(table1);	
			});
		}
		
	}
})
</SCRIPT>
</body>
</html>