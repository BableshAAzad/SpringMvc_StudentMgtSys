<%@page import="com.mvc.entity.SocialProfile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Social Media Profile</title>
</head>
<body>
<h2>Update Social Media Profile</h2>
<% SocialProfile sp = (SocialProfile) request.getAttribute("sp"); %>
<form action="updateProfileData" method="post">
   <input type="number" name="studentId" value="<%=request.getAttribute("studentId")%>" readonly="true" /><br><br>
   <input type="number" name="profileId" value="<%=sp.getProfileId() %>" readonly="true" /><br><br>
   <input type="text" name="profileName" value="<%=sp.getProfileName() %>" placeholder="Enter Profile Name" /><br><br>
   <input type="text" name="url" value="<%=sp.getUrl() %>" placeholder="enter profile url" /><br><br>
   <input type="submit" value="Update Profile" />
</form>
</body>
</html>