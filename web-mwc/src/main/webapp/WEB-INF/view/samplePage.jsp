<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		<h1>Sample page</h1>
		
		<p>Expression to verify whether JSP works 2*5 = <% out.print(2*5); %></p>
		  
		<p> Servlet name: <% out.print(this.getServletName()); %> </p>
		<p> Servlet class name: <% out.print(this.getClass().getCanonicalName()); %> </p> 
		<!-- JSP implicit objects:  request parameter is mapped as param. This is example of EL. -->
		<p>You can enter a query parameter "attr". Current value is: "${param.attr}"<br />
		<!-- Scriptlet access to  -->
		Another way how to print request parameter (form and query): <%= request.getParameter("attr") %>!</p>
		
		<!-- accessing Spring MVC model value from scripttlet -->
		<% if (request.getAttribute("modelParam") != null) { %>
		
		<!-- model value by expression language: ${modelParam} -->
		<p>Value from Model named "modelParam" is set inside controller. Value: "${modelParam}" </p>
		
		<%} else { %>
			<p>Model attribute "modelParam" is missing! Access from <code>ViewController</code>
		using the mapping <code>/sp</code> can't populate this model attribute and in such case it will be empty.</p>
		<%} %>
		
		
		<!-- Param added by ModelInterceptor registered to /sample URL -->
		<% if (request.getAttribute("interceptorParam") != null) { %>
		<p>Value from Model named "interceptorParam" is set inside <code>ModelInterceptor.postHandle()</code>. Value: "${interceptorParam}" </p>
		<%} else { %>
		<p>View is rendered from different location than "/sample", where <code>ModelInterceptor</code> is registered.</p>
		<%} %>
		
	</body>
</html>