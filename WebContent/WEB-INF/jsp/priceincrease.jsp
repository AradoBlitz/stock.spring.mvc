<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title><fmt:message key="title"/></title>
<style type="text/css">
	.error{color: red;}
</style>
</head>
<body>
<h1><fmt:message key="priceincrease.heading"></fmt:message></h1>
<form:form  method="post" commandName="priceIncrease">
	<table whidth="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td align="right" width="20%">Increase (%):</td>
			<td><form:input path="percentage"/></td>
			<td width="60%"><form:errors path="percentage" cssClass="error"></form:errors></td> 
		</tr>
	</table>
	<input type="submit" align="center" value="Execute" />
</form:form>

</body>
</html>