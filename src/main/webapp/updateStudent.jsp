<%@page import="com.mvc.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body>
<h1>Update Student</h1>
<% Student s = (Student) request.getAttribute("student"); %>
<form action="saveUpdatedStudent" method="post">
  <input type="number" value="<%= s.getStudentId() %>" name="studentId" placeholder="Student Id" readonly="true" /><br><br>
  <input type="text" value="<%= s.getStudentName() %>" name="studentName" placeholder="Student Name" /><br><br>
  <input type="email" value="<%= s.getStudentEmail() %>" name="studentEmail" placeholder="Student Email" /><br><br>
  <input type="text" value="<%= s.getStudentPassword() %>" name="studentPassword" placeholder="Student Password" /><br><br>
  <input type="submit" value="Update Student" />
</form>
</body>
</html>