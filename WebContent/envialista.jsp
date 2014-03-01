
<%@ page language="java" contentType="text/html"%>

<%@ page import= "java.net.*" %>
<%@ page import= "java.io.*" %>
<%@ page import= "xmlista.*" %>

<%
String encoded, cad, texto="";

String dir=application.getRealPath("/");
String path=application.getContextPath();


PlayList pl=new PlayList();
String lista=pl.GetList(dir,path);
//se codifica la informacion y se prepara el mensaje
String encoded_lista = URLEncoder.encode(lista, "UTF-8"); //se codifican solo los parametros o sea la lista
String url_datos="lista=" + encoded_lista; //el parametro lista no se codifica es una etiqueta de la cual se va a leer informacion si se codifica ¿como se reconoce?

try
{
URL url = new URL("http://localhost:8080/p2p/list2db.jsp");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");
conn.setDoOutput(true);
DataOutputStream o= new DataOutputStream(conn.getOutputStream());
o.writeBytes(url_datos); //prepara un POST con parametros lista=@@@@@@@@
o.flush ();
o.close();

BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
while ( (cad = reader.readLine()) != null)
{
    texto += cad;
}
}

catch (Exception ex) 
{
	ex.printStackTrace();
}
//out.println(xml);
%>

<html>
<head>
<title>Servicios y Aplicaciones Telematicas 11/12</title>
</head>

<body bgcolor="#aaaaee">

<h1>se ha enviado la lista de elementos a la base de datos aatt.p2pm</h1>
<h1><%=texto%> </h1>


</body>
</html>