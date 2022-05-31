<%@page import="com.axelor.studentdb.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.axelor.studentmain.Operations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert student</title>
</head>
<body>
<%
Operations ops= new Operations();
List<Subject> subs=ops.ListSub();
session.setAttribute("subbs", subs);

%>

    <form name="insertwalaform" id="form-1" action="insert">
	<h2> Insert Student Details:</h2><br><br>
	<label for="input-1">Id:</label>
		<br>
		<input id="input-1" name="id" placeholder="Text" type="text" />
		  <br> <br>
		  <label for="input-2">Name:</label><br>
		<input id="input-2" name="name" placeholder="Text" type="text" /> <br><br>
		<label for="input-3">book</label> <br>
		<input id="input-3" name="book" placeholder="Text" type="text" />
		<br> <br>
		<label for="sub"> Subject:</label>
		<select id="sub" name="subject" multiple="multiple">
				<c:forEach var="sub" items="${subbs}">
				<option value="${sub.getSubid()}">
				<c:out value="${sub.getSubname()}">
				</c:out>
				</option>
				</c:forEach>
		</select>
				<br><br>
				<label for="input-5">school:</label><br>
		<input id="input-5" name="school" placeholder="Text" type="text" /><br><br>
		<input type="submit" value="Create Student" id="button-1"/>
	</form>
</body>
</html>