<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- every relative link will be prepended by this path, given EL expression retruns context path of application -->
		<base href="${pageContext.request.contextPath}/"   />
		<link rel="stylesheet" type="text/css" href="res/css/formStyles.css" />
	</head>
	
	<body>
	<a href="sample">Link</a>
		<div class="formContainer">
			<form method="POST" action="binding">
				<div class="row">
					<div class="labelCol">
						<label for="name">First name</label>
					</div>
					<div class="fieldCol">
						<input type="text" id="name" name="firstName" placeholder="First name" >
					</div>
				</div>
				<div class="row">
					<div class="labelCol">
						<label for="surname">Surname</label>
					</div>
					<div class="fieldCol">
						<input type="text" id="surname" name="surname" placeholder="Surname" >
					</div>
				</div>
				<div class="row colored">
					<div class="labelCol">
						<label for="birthDate">Date of birth</label>
					</div>
					<div class="fieldCol">
						<input type="date" id="birthDate" name="birthDate" placeholder="Date of birth" >
					</div>
				</div>
				<div class="row">
					<div class="labelCol">
						<label for="startDate">Start of work</label>
					</div>
					<div class="fieldCol">
						<input type="text" id="startDate" name="startDate" placeholder="Start of wrok date" >
					</div>
				</div>
				
				<div class="row">
					<div class="labelCol">
						<!-- Integral value  -->
						<label for="xpPoints">Experiences</label>
					</div>
					<div class="fieldCol">
						<input type="text" id="xpPoints" name="xpPoints" placeholder="Experiences" >
					</div>
				</div>
				
				<div class="row">
					<div class="labelCol">
						<!-- decimal value  -->
						<label for="index">Index</label>
					</div>
					<div class="fieldCol">
						<input type="text" id="index" name="index" placeholder="Index" >
					</div>
				</div>
				
				
	
				<div class="row">
					<div class="labelCol">
						<label for="occupation">Occupation</label>
					</div>
					<div class="fieldCol">
						<select id="occupation" name="occupation">
							<option value="dev">Developer</option>
							<option value="maid" >Maid</option>
							<option value="acc" selected="selected">Accountant</option>
						</select>
					</div>
				</div>
				
				<div class="row">
					<div class="labelCol">
						Skills
					</div>
					<div class="fieldCol">
						<label for="chkRead">Read</label>
						<input type="checkbox" id="chkRead" name="skillRead" value="read">
						
							
						<label for="chkWrite">Write</label>
						<input type="checkbox" id="chkWrite" name="skillWrite" value="write">
						
						<label for="chkSing">Sing</label>
						<input type="checkbox" id="chkSing" name="skillSing" value="sing">
						
					</div>
				</div>
				
				<div class="row">
					<div class="labelCol">
						Sex
					</div>
					<div class="fieldCol">
						<label for="sexMale">Male</label>
						<input type="radio" id="sexMale" name="sex" value="male">
						
						<label for="sexFemale">Female</label>
						<input type="radio" id="sexFemale" name="sex" value="female">
						
						<label for="sexUnknown">Male</label>
						<input type="radio" id="sexUnknown" name="sex" value="unknown">
					</div>
				</div>
				<div class="submitRow">
					<input type="submit" value="Submit">
				</div>

				
			</form>
		</div>
		
		<h1>Provided object</h1>
		<!-- accessing Spring MVC model value from scripttlet -->
		<% if (request.getAttribute("infoData") != null) { %>
		
		<p>Real value set in FirstName property ${infoData.firstName} </p>
		
		<!-- model value by expression language: ${modelParam} -->
		<p>Value from Model named "infoData" is set inside controller.</p>
		<p>Expression language: "${infoData}" </p>
		<!-- With property editor registered in InitBinder spring:eval throws Conversion exception -->
		
		<!-- Bind works with property editor, only if target object is accessible as property of other object.
		If accessed directly from model, it doesn't work. (tmp is instance of WrapperObj class) -->
		<p>Spring Bind: <spring:bind path="tmp.infoData">${status.displayValue} </spring:bind> xx</p> 
		
		<!-- toString() -->
		<p>JSTL c:out:  <c:out value="${infoData}"></c:out></p>
		<!-- this will work with formatter registered in WebMvConfigurer -->
		<spring:eval expression="infoData"></spring:eval>
		
		
		<%} %>

	</body>
</html>