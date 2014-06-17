<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ include file="/WEB-INF/jsp/include_links.jsp"%>

<title>Eventoris | Detalii</title>

<jsp:include page="/WEB-INF/jsp/include_menu.jsp">
	<jsp:param name = "active" value ="event"/>
</jsp:include>
<section>
	<div class="container clearfix">
		<div id="content" class="grid_12">
			<div class="event-detail-wrapper">
				<%
					Map<String, Object> map = (Map<String, Object>) request
							.getAttribute("dataMap");

					if (map == null) {
				%>
				<div class="error-page">
					<div class="smile">
						<i class="icon-emo-unhappy"></i>
					</div>
					<div class="message">
						<h2>Ne cerem scuze, dar evenimentul cerut nu a fost gasit</h2>
					</div>
				</div>
				<%
					} else {
						eventoris.datatypes.EventInfo eventInfo = ((eventoris.datatypes.EventInfo) map
								.get("eventInfo"));
						String name = eventInfo.getTitle();
				%>
				<div class="left-column-eventdetail">
					<div class="block" id="information">
						<div class="block-header">
							<img alt="category"
								src="resources/img/categories/<%=eventInfo.getCategoryID()%>.png">

							<h1><%=name%></h1>
						</div>
						<div class="information-content">
							<p>
								<em>Categorie:</em> ${dataMap.categoryInfo.categoryName } <br>
								<br> <em>Descriere: </em><%=eventInfo.getDescription()%><br>
								<br>
								<%
									String tmp = eventInfo.getDateOfEvent();
										String year = tmp.substring(0, 4);
										String date = tmp.substring(8, 10);
										String month = tmp.substring(5, 7);
								%>
								<em>Data: </em>
								<%=date%>.<%=month%>.<%=year%><br> <br>
								<%
									String hour = tmp.substring(11, 13);
										String minutes = tmp.substring(14, 16);
								%>
								<em>Ora: </em>
								<%=hour%>:<%=minutes%><br>

								<c:if test="${dataMap.isLoggedInOwner}">
									<a href="delete.htm?eventid=<%=eventInfo.getEventID()%>" onClick="return confirm('Sigur doriţi să ştergeţi evenimentul cu titlul: <%=eventInfo.getTitle()%>?')">Şterge</a>
									<a href="addevent.htm?eventid=<%=eventInfo.getEventID()%>">Editeaza</a>
								</c:if>
								<br> <a href="#">Subscribe</a><br>


							</p>
						</div>
					</div>
					<div class="block" id="coming">
						<div class="block-header">
							<img alt="icon" src="resources/img/block icons/comming.jpg">
							<h1>Cine va veni?</h1>
						</div>
						<div class="participants-content">
							<%
								int participantsComing = (Integer) map.get("comingPartNumb");
									if (participantsComing > 0) {
							%>
							<div class="participants-wrap">
								<c:forEach items="${dataMap.comingUsers}" var="userInfo">

									<div class="participant">
										<img alt="profile picture" src="resources/img/avatars/0.jpg">
										<em>${userInfo.name } ${userInfo.familyName }</em>
									</div>

								</c:forEach>
							</div>
							<div class="see-all">
								<a href="#">Total toţi (<%=participantsComing%>)
								</a><br> <br>
							</div>
							<%
								} else {
							%><div class="be-first-message">
								<h2>Fii primul care se inscrie</h2>
							</div>
							<%
								}
							%>
							<c:choose>
								<c:when
									test="${pageContext.request.userPrincipal.name != null && !dataMap.userEventStatus.coming}">
									<div class="hai-button">

										<form:form modelAttribute="comeForSure" method="POST"
											action="comeforsure">
											<form:hidden path="eventid"
												value="<%=eventInfo.getEventID()%>" />
											<button type="submit">Hai!</button>
										</form:form>
									</div>
								</c:when>
								<c:when
									test="${pageContext.request.userPrincipal.name != null && dataMap.userEventStatus.coming}">
									<div class="hai-button">
										<form:form modelAttribute="comeForSure" method="POST"
												action="comeforsure">
												<form:hidden path="eventid"	value="<%=eventInfo.getEventID()%>" />
									  		<button type="submit">Totuşi nu</button>
									  	</form:form>
								  	</div>
								</c:when>

								<c:otherwise>Tre sa fii logat ca sa poti participa la eveniment</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>

				<div class="right-column-eventdetail">
					<div class="block" id="event-owner">
						<div class="block-header">
							<img alt="icon" src="resources/img/block icons/owner.jpg">
							<h1>Autorul evenimentului</h1>
						</div>
						<div class="owner-content">
							<div class="owner-picture">
								<img alt="profile picture" src="resources/img/avatars/0.jpg">
							</div>
							<div class="owner-name">
								<h2>${dataMap.ownerInfo.name }
									${dataMap.ownerInfo.familyName }</h2>
							</div>
						</div>
					</div>
					<div class="block" id="address">
						<div class="block-header">
							<img alt="icon" src="resources/img/block icons/address.jpg">
							<h1>Unde va avea loc?</h1>
						</div>
						<div class="address-content">
							<p>
								<em>Adresa: </em><%=eventInfo.getAddress()%></p>
						</div>
					</div>
					<div class="block" id="maybe-coming">
						<div class="block-header">
							<img alt="icon" src="resources/img/block icons/maybe.jpg">
							<h1>Cine posibil va veni?</h1>
						</div>
						<div class="participants-content">
							<%
								int participantsMaybe = (Integer) map.get("maybePartNumb");
									if (participantsMaybe > 0) {
							%>
							<div class="participants-wrap">
								<c:forEach items="${dataMap.maybeComingUsers}" var="userInfo">

									<div class="participant">
										<img alt="profile picture" src="resources/img/avatars/0.jpg">
										<em>${userInfo.name } ${userInfo.familyName }</em>
									</div>

								</c:forEach>
							</div>
							<div class="see-all">
								<a href="#">Total toţi (<%=participantsMaybe%>)
								</a><br> <br>
							</div>
							<%
								} else {
							%><div class="be-first-message">
								<h2>Fii primul care se inscrie</h2>
							</div>
							<%
								}
							%>
							<c:choose>
								<c:when
									test="${pageContext.request.userPrincipal.name != null && !dataMap.userEventStatus.maybeComing}">
									<div class="hai-button">
										<form:form modelAttribute="maybeComming" method="POST"
											action="maybe">
											<form:hidden path="eventid"
												value="<%=eventInfo.getEventID()%>" />
											<button type="submit">Hai!</button>
										</form:form>
									</div>
								</c:when>
								<c:when
									test="${pageContext.request.userPrincipal.name != null && dataMap.userEventStatus.maybeComing}">
								  		<div class="hai-button">
										<form:form modelAttribute="maybeComming" method="POST"
											action="maybe">
											<form:hidden path="eventid"
												value="<%=eventInfo.getEventID()%>" />
											<button type="submit">Totuşi nu</button>
										</form:form>
									</div>
																		
									
									</c:when>
								<c:otherwise>Tre sa fii logat ca sa poti participa la eveniment</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<div class="container clearfix">
		<div id="content" class="grid_12">
			<div class="comments-wrapper">
				<div class="block-header">
					<img alt="icon" src="resources/img/block icons/comments.jpg">
					<h1>Discuţii</h1>
				</div>
				<c:choose>
					<c:when test="${pageContext.request.userPrincipal.name != null}">
						<div class="send-comment-area">
							<form:form command="addcomment" modelAttribute="commentData"
								method="POST" action="addcomment">
								<form:textarea rows="4" cols="50" path="comments" />
								<form:hidden path="eventid" value="<%=eventInfo.getEventID()%>" />
								<button type="submit">Trimite</button>
							</form:form>
						</div>
					</c:when>
					<c:otherwise>Tre sa fii logat ca sa poti posta comentarii</c:otherwise>
				</c:choose>
				<div class="display-comments-area">
					<%
						if (map != null) {
					%>

					<c:forEach items="${dataMap.comments}" var="commentItem">
						<div class="comment-block">
							<div class="owner-picture">
								<img alt="icon" src="resources/img/avatars/0.jpg">
							</div>
							<div class="comment-info">
								<p>
									<em>${commentItem.ownerName} ${commentItem.ownerFamily}</em> -
									${commentItem.dateAdded}
								</p>
							</div>
							<div class="comment-text">
								<p>
									<c:out value="${commentItem.comment}" />
								</p>
							</div>
						</div>
					</c:forEach>
					<%
						}
					%>

				</div>
			</div>
		</div>
	</div>
	<%
		}
	%>
</section>
<%@ include file="/WEB-INF/jsp/include_footer.jsp"%>
<%@ include file="/WEB-INF/jsp/include_scripts.jsp"%>
