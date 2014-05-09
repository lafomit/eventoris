<%@ page import = "eventoris.dao.EventJDBCTemplate" %>
<%@ page import = "org.springframework.context.ApplicationContext" %>
<%@ page import = "org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import = "eventoris.datatypes.*" %>
<%@ page import = "java.util.List;" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>

<meta name="viewport" content="width=device-width, initial-scale = 1.0, user-scalable = no">
	<title>Eventoris | Home</title>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Noto+Sans:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Didact+Gothic&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="resources/css/grid.css" type="text/css" media="screen">
	<link rel="stylesheet" href="resources/css/fontello.css" type="text/css" media="screen">
	<link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen">
	<link rel="stylesheet" href="resources/css/main-nav.css" type="text/css" media="screen">
	
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.stellar.min.js"></script> 
	<script type="text/javascript" src="resources/js/waypoints.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="resources/js/scripts.js"></script>
	<script type="text/javascript" src="resources/js/jquery.sticky.js"></script>
	<script type="text/javascript" src="resources/js/modernizr.custom.js"></script>
</head>

<body>
	<header>
		<div class="main-navigation">
			<div class="container clearfix">
				<div class="grid_3 margin-padding-clear">
					<div class = "logo">
						<a href="#">
							<img src="resources/img/logo_03.png"/>
						</a>
					</div>
				</div>
				<div class="grid_4 margin-padding-clear">
					<nav id="menu" class="nav">					
						<ul>
							<li class = "active"><a href="#"><i class = "icon-home-outline"></i>Home</a></li>
							<li><a href="#"><i class = "icon-calendar-outlilne"></i>Evenimente</a></li>
							<li><a href="#"><i class = "icon-news"></i>Noutăţi</a></li>
						</ul>
					</nav>
				</div>
				<div class = "grid_4 margin-padding-clear">
				
				</div>
			</div>
		</div>
	</header>
	<div id="stick-menu">
		<div class="container clearfix">
			<div class="grid_12 margin-padding-clear">
			<nav>
				<ul class="navigation">
					<li data-slide="1">Home</li>
					<li data-slide="2">Ultimele Evenimente</li>
					<li data-slide="3">Top Evenimente</li>
					<li data-slide="4">Ultimele Noutati</li>
				</ul>
				</nav>
			</div>

		</div>
	</div>

	<div class="slide" id="slide1" data-slide="1" data-stellar-background-ratio="0.2">
		<div class="container clearfix">
			<div id="content" class="grid_6">
				<div class="intro-text">
					<h1>Hai cu noi</h1>
					<ul>
						<li>să ne distrăm</li>
						<li>să fim mai buni</li>
						<li>să fim prieteni</li>
					</ul>
					
					<button>Înregistrează-te</button>
				</div>
			</div>
			<div class="grid_6 omega">

			</div>

		</div>
	</div>



	<div class="slide" id="slide2" data-slide="2" data-stellar-background-ratio="0.2">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class="slide-title">
					<h1>Ultimele Evenimente</h1>
				</div>
			</div>
		</div>
		<div class="container clearfix">
			<div class="grid_6">
				<div class = "last-events">
					<p>
					<% 
					ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
					EventJDBCTemplate eventJdbcTemplate = (EventJDBCTemplate)context.getBean("eventJDBCTemplate");
					EventInfo event = new EventInfo();
					CategoryInfo category = new CategoryInfo();
					int categoryID;
					
					//-------------------SELELECT LAST 3 EVENTS---------------------//
				       int EVENTS_COUNT = 3;
				        List<EventInfo> events = eventJdbcTemplate.getLastEventsByDate(EVENTS_COUNT);
				        for(EventInfo record:events){
				        	System.out.println(record);
				        	out.println(record+"<br>");
				        	//-------------------SELECT CATEGORY BY ID---------------------//
				        	categoryID = record.getCategoryID();
				        	category = eventJdbcTemplate.getCategory(categoryID);
				        	System.out.println(category);
					        out.println(category+"<br> <br>");
				        }            
					%>
					</p>
				</div>
			</div>
		</div>
	</div>



	<div class="slide" id="slide3" data-slide="3" data-stellar-background-ratio="0.5">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class="slide-title">
					<h1>Top Evenimente</h1>
				</div>
			</div>
		</div>
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class = "top-events">
					<%
				        events = eventJdbcTemplate.getTopEvents(EVENTS_COUNT);
				        for(EventInfo record:events){
				        	System.out.println(record);
				        	out.println(record+"<br>");
				        	//-------------------SELECT CATEGORY BY ID---------------------//
				        	categoryID = record.getCategoryID();
				        	category = eventJdbcTemplate.getCategory(categoryID);
				        	System.out.println(category);
					        out.println(category+"<br> <br>");
				        }
			        %>
				</div>
			</div>
		</div>
	</div>



	<div class="slide" id="slide4" data-slide="4" data-stellar-background-ratio="0.2">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class="slide-title">
					<h1>Ultimele Noutăţi</h1>
				</div>
			</div>
		</div>
	</div>
	
	<footer style="height:200px; background-color:#2c3e50">
		<div class = "social-networks">
			<div class="container clearfix">
				<div class = "grid_3">
					<div class = "facebook"><a href="#">Facebook</a></div>
				</div>
				<div class = "grid_3">
					<div class = "google"><a href="#">Google+</a></div>
				</div>
				<div class = "grid_3">
					<div class = "odnoklassniki"><a href="#">Одноклассники</a></div>
				</div>
				<div class = "grid_3">
					<div class = "vkontakte"><a href="#">ВКонтакте</a></div>
				</div>
			</div>
		</div>
		<div class="copyright">
			<div class = "container clearfix">
				<div class="grid_12">
					<p>Copyright 2014</p>
				</div>
			</div>
		</div>
	</footer>
</body>

<!-- ============================SCRIPTS HERE BELOW THIS LINE=========================== -->
<script>
    $(window).load(function(){
      $("#stick-menu").sticky({ topSpacing: 0 });
    });
  </script>
  
  <script>
			//  The function to change the class
			var changeClass = function (r,className1,className2) {
				var regex = new RegExp("(?:^|\\s+)" + className1 + "(?:\\s+|$)");
				if( regex.test(r.className) ) {
					r.className = r.className.replace(regex,' '+className2+' ');
			    }
			    else{
					r.className = r.className.replace(new RegExp("(?:^|\\s+)" + className2 + "(?:\\s+|$)"),' '+className1+' ');
			    }
			    return r.className;
			};	

			//  Creating our button in JS for smaller screens
			var menuElements = document.getElementById('menu');
			menuElements.insertAdjacentHTML('afterBegin','<button type="button" id="menutoggle" class="navtoogle" aria-hidden="true"><i aria-hidden="true" class="icon-menu"> </i> Menu</button>');

			//  Toggle the class on click to show / hide the menu
			document.getElementById('menutoggle').onclick = function() {
				changeClass(this, 'navtoogle active', 'navtoogle');
			}

			// http://tympanus.net/codrops/2013/05/08/responsive-retina-ready-menu/comment-page-2/#comment-438918
			document.onclick = function(e) {
				var mobileButton = document.getElementById('menutoggle'),
					buttonStyle =  mobileButton.currentStyle ? mobileButton.currentStyle.display : getComputedStyle(mobileButton, null).display;

				if(buttonStyle === 'block' && e.target !== mobileButton && new RegExp(' ' + 'active' + ' ').test(' ' + mobileButton.className + ' ')) {
					changeClass(mobileButton, 'navtoogle active', 'navtoogle');
				}
			}
		</script>
</html>

<!-- 	==============================================================

<title>Eventoris | Home</title>
	<meta name="viewport" content="width=device-width, initial-scale = 1.0, user-scalable = no">
	<link rel="stylesheet" type="text/css" href="css/foundation.min.css">
</head>
<body>
<header></header>
<h2>Hello World!</h2>
<p>
-->
<%

/*System.out.println("START");
ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
System.out.println("APPCONTEXT" +context);
EventJDBCTemplate eventJdbcTemplate = (EventJDBCTemplate)context.getBean("eventJDBCTemplate");
EventInfo event = new EventInfo();

event = eventJdbcTemplate.getEvent(2);

out.print(event);*/
%>
<!-- 
</p>
<footer></footer>
</body>
</html>
-->