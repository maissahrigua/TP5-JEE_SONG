<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
 <div class="card-header">
 Search songs
 </div>
 <div class="card-body">
 <form action="chercher.do" method="get">
 <label>Key word</label>
 <input type="text" name="motCle" value="${model.motCle}" />
 <button type="submit" class="btn btn-primary">Search</button>
 </form> 
 <table class="table table-striped">
 <tr>
 <th>ID</th><th>Song's name</th><th>Singer</th><th>Delete</th><th>Edit</th>
 </tr>
 <c:forEach items="${model.songs}" var="s">
 <tr>
 <td>${s.idSong}</td>
 <td>${s.nameSong}</td>
 <td>${s.nameSinger}</td>
 <td><a onclick="return confirm('Are u sure ?')"href="supprimer.do?id=${s.idSong}">Delete</a></td>
 <td><a href="editer.do?id=${s.idSong}">Edit</a></td>
 
 </tr>
 </c:forEach> 
 </table>
 </div>
</div>
</div>
</body>
</html>