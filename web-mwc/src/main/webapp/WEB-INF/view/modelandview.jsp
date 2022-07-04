<%@ page import="java.util.Enumeration" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Model atributes</title>
	</head>
	
	<ul>
		<li>
			<a href="/web-mvc/mparam">From paramter</a>
			<p>Model passed to controller as a method parameter</p>
		</li>
		<li>
			<a href="/web-mvc/mret">Returned</a>
		</li>
		<li>
			<a href="/web-mvc/mcombi">Combination</a>
		</li>
		
		<li>
			<a href="/web-mvc/mempty">No model (no param, no retval model)</a>
		</li>
	</ul>
	<body>
		<h2>Session attributes in JSP way</h2>
		<table border="1">
			<tr>
				<td>Name</td><td>Value</td>
			</tr>
			
			<%
 for (Enumeration<String> enumeration = request.getAttributeNames(); enumeration.hasMoreElements();) {
    String attributeName = enumeration.nextElement();
    Object attribute = request.getAttribute(attributeName);
    String strVal = null;
    if (attribute != null) {
    	strVal = attribute.toString().split("\n")[0];
    }
    %>
    <tr>
    	<td><%= attributeName %></td>
    	<td><%= strVal %></td>
    </tr>
    
    <%
}

%>
		</table>


		<h2>Session attributes in JSTL way</h2>
		<table border="1">
			<tr>
				<td>Name</td><td>Value</td>
			</tr>
		<c:forEach var="ntry" items="${requestScope}">
		
			<c:if test="${fn:startsWith(ntry.key,'mavParam')}">
				<tr>
					<td><c:out value="${ntry.key}" /></td>
					<td><c:out value="${ntry.value}" /></td>
				</tr>
			</c:if>
   			
		</c:forEach>
		<!-- 
		I could pass variable calculated in scriptlet through "pageContext.setAttribute(name, value)".
		In JSTL then I would access it by  <c:out value="${resp}"/>.
		In JSTL are variables scoped (page, request, session).
		-->
		
			
		
		</table>
	</body>
</html>