<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/include_links.jsp"%>
<%@ page import="java.util.*"%>
<title>Eventoris | Confirmare</title>

<%@ include file="/WEB-INF/jsp/include_menu.jsp"%>

<div id="stick-menu">
	<div class="container clearfix">
		<div class="grid_12 margin-padding-clear">
			<nav id="index-nav">
				<ul class="navigation">
					<li data-slide="1">Home</li>
					<li data-slide="2">Ultimele Evenimente</li>
					<li data-slide="3">Top Evenimente</li>
					<!-- 					<li data-slide="4">Ultimele Noutăţi</li> -->
				</ul>
			</nav>
		</div>
	</div>
</div>
<section class="error-page">
	<div class="container clearfix">
		<div id="content" class="grid_12">
		<h1>${eventTitle}</h1>
			<div class="smile">
				<i class="icon-emo-surprised"></i>
			</div>
			<div class="message">
				<h2>Sigur doriţi să ştergeţi acest eveniment?</h2>
				<a href="#">Da</a> <br>
				<a href = "eventdetail.htm?event=${eventId}">Nu</a>
			</div>
		</div>
	</div>
</section>


<%@ include file="/WEB-INF/jsp/include_footer.jsp"%>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp"%>