<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
			href="<%=request.getContextPath()%>/css/restaurant.css" />
</head>
<body style="background-image: url(../images/main.jpg); background-repeat: repeat; width:100%">
<div style="height: 2px"></div>
<div class="headerRoundedBorder alignLeft">
<div class="headerText">Online Order</div>
</div>
<div style="height: 5px"></div>
<div class="snacksRoundedBorder">
<div><a class="snacksText" href="<%=request.getContextPath()%>/pages/snacks.jsp">SNACKS</a></div>
</div>
<div class="snacksRoundedBorder">
<div><a class="hotDrinksText" href="<%=request.getContextPath()%>/pages/hotDrinks.jsp">HOT DRINKS</a></div>
</div>
<div class="snacksRoundedBorder">
<div><a class="bevText" href="<%=request.getContextPath()%>/pages/beverage.jsp">BEVERAGES</a></div>
</div>
<div class="snacksRoundedBorder">
<div><a class="mainCourseText" href="<%=request.getContextPath()%>/pages/mainCourse.jsp">MAIN COURSE</a></div>
</div>
<div></div>
<div></div>
<div></div>
</body>
</html>