<%@ page import= "java.net.*" %>
<%@ page import= "java.io.*" %>
<%@ page import= "xmlista.*" %>
<%@ page import="saxbean.*"%>
 
<% 
int a;
String res="";
String lista = request.getParameter("lista"); 
playlist2db pr1 = new playlist2db(); 
a=pr1.parse(lista); 
if (a==1)	//sabe si se pudo almacenar bien en la bd o no
{
	res="Se insertaron correctamente los datos en la base de datos aatt.p2pm";
}
else
{
	res="Hubo un error al trabajar con la base de datos";
}
out.println(res);
%> 


