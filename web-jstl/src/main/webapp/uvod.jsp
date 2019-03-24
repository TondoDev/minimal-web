<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Enumeration" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<body>
	<h2>Hello World!</h2>

	<h3>My name ist ${fullname}</h3>
	
	<c:forEach begin="0" end="10" varStatus="loop">
    	<h2><c:out value="${fullname}"></c:out></h2>
	</c:forEach>
	
	<!-- expression language works only on web-app 2.3 and greater -->
	<h2>${fullname}</h2>
	<h2><%= request.getAttribute("fullname") %></h2>
	<pre>
<%
 
for (Enumeration<String> enumeration = request.getAttributeNames(); enumeration.hasMoreElements();) {
    String attributeName = enumeration.nextElement();
    Object attribute = request.getAttribute(attributeName);
    out.println(attributeName + " -> " + attribute.getClass().getName() + ":" + attribute.toString());
}
 
%>
</pre>

	<c:set var="newName" scope="session" value="${fullname} + 4"></c:set>
	<h2> Nove meno
	<c:out value="${newName}"></c:out>
	</h2>
</body>
</html>
