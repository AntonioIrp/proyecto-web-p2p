<%@ page contentType="text/xml"%><%@ page import="xmlista.*"%><% 
String dir=application.getRealPath("/");
String path=application.getContextPath();
String r; 
PlayList pl=new PlayList();
r=pl.GetList(dir,path);
System.out.println(r);
out.println(r);

System.out.println();
%>
