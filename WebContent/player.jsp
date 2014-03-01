<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import= "java.net.*" %>
<%@ page import= "java.io.*" %>
<%@ page import= "xmlista.*" %>

<html>
<% String peticion = request.getParameter("url"); %>
<head>
<title>Servicios y Aplicaciones Telematicas 11/12</title>
</head>
<body bgcolor="#aaaaee">
<center>
<h1>Reproductor de video</h1>

<video controls>
<source src="<%=peticion%>" type="video/mp4" codecs="video/mp4">

Videos de SSAATT.
</video>
 </center>

</body>
</html>
