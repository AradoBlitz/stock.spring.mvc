<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
  	<h1><fmt:message key="heading"></fmt:message></h1>
    <p><fmt:message key="greeting"><c:out value="${model.now}"></c:out></fmt:message>
    <h3>Products</h3>
    <c:forEach items="${model.products }" var="prod">
    	<c:out value="${prod.description }"></c:out><i>$<c:out value="${prod.price }"/></i><br><br>
    </c:forEach>
  </body>
</html>