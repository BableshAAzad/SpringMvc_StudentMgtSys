<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Social Media Profile</title>
</head>
<body>
<h2>Add New Social Media Profile</h2>
<form action="addNewProfile" method="post">
   <input type="number" name="studentId" value="<%=request.getAttribute("studentId")%>" readonly="true" /><br><br>
   <input type="number" name="profileId" placeholder="Enter profile Id" /><br><br>
   <input type="text" name="profileName" placeholder="Enter Profile Name" /><br><br>
   <input type="text" name="url" placeholder="enter profile url" /><br><br>
   <input type="submit" value="ADD Profile" />
</form>
</body>
</html>