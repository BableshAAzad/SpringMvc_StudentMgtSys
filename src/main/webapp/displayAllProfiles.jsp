<%@page import="com.mvc.entity.SocialProfile"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<SocialProfile> profileList = (List) request.getAttribute("profileList"); %>
<h1>Social Profile Dashboard</h1>
<table border="1" cellspacing="0" cellpadding="5px">
		<thead>
		<tr>
			<th>ProfileId</th>
			<th>ProfileName</th>
			<th>URL</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		</thead>
		<tbody>
		<%
		for (SocialProfile sp : profileList) {
		%>
		<tr>
			<td><%=sp.getProfileId()%></td>
			<td><%=sp.getProfileName()%></td>
			<td><%=sp.getUrl()%></td>
			<td><a href="updateProfile?studentId=<%=sp.getProfileId()%>">UPDATE</a></td>
			<td><a href="deleteProfile?studentId=<%=sp.getProfileId()%>">DELETE</a></td>
		</tr>
		<%
		}
		%>
		</tbody>
	</table>
	<h2>
		<a href="addNewProfile.jsp">Add New Profile</a>
	</h2>
	<h2>
		<a href="index.jsp">Home Page</a>
	</h2>

</body>
</html>