<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
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
Songs Modification 
</div>
<div class="card-body">
<form action="update.do" method="post">
<div hidden class="form-group">
<label class="control-label">ID Song :</label>
<input type="text" name="id" class="form-control"
value="${song.idSong}"/>
</div>
<div class="form-group">
<label class="control-label">Song's name:</label>
<input type="text" name="nom" class="form-control"
value="${song.nameSong}"/>
</div>
<div class="form-group">
<label class="control-label">Singer</label>
<input type="text" name="name" class="form-control" value="${song.nameSinger}"/>
</div>
<div>
<button type="submit" class="btn btn-primary">Modify</button>
</div>
</form> 
</div>
</div>
</div>
</body>
</html>