<%@ page import= "java.net.*" %>
<%@ page import= "java.io.*" %>
<%@ page import= "xmlista.*" %>
<%@ page import= "saxbean.*"%>
<%@ page import = "java.util.*" %>




<%
String peticion = request.getParameter("nombre");
String titulo,anotacion,info,localizacion,imagen,identificador;
DAOBuscar busqueda = new DAOBuscar();

busqueda.getBusqueda(peticion);

String resultados = new String ();
resultados = busqueda.getList();

%>


<html>
<head>
<title>Listado de resultados</title>
</head>

<body bgcolor="#aaaee">
<h1 align="center">La busqueda ha finalizado:</h1>

<%=resultados %>


</body>
</html>
