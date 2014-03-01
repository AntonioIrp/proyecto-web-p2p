package saxbean;

import java.sql.*;
import java.util.*;

public class DAOBuscar{
	public DAOBuscar(){}
	Vector v=new Vector();
	
	/*
	 * Realiza la busqueda
	 */
	public Vector getBusqueda(String peticion){
		String sql="select * from aatt.p2pm where title like '%"+peticion+"%'";
		Connection conn;
		Statement stm;
		ResultSet rs;
		int i=0;
		if (peticion.equals("")!=true){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/aatt","root","samba1234");
			stm=conn.createStatement();
			rs=stm.executeQuery(sql);		
			while(rs.next()){
				v.add(rs.getString("title"));
				v.add(rs.getString("annotation"));
				v.add(rs.getString("info"));
				v.add(rs.getString("location"));
				v.add(rs.getString("image"));
				v.add(rs.getString("identifier"));				
			}
			rs.close();			
			stm.close();
			conn.close();
		}catch(Exception e){}
		}
		return v;
	}

	/*
	 * Devuelve el resultado en forma de tabla
	 */
	public String getList(){
		String title,annotation,info,location,image,identifier;
		String cad="<table>";
		int i=v.size()/6;
		for (int iter=0;iter<i;iter++){
			title=(String)v.get(iter*6);
			annotation=(String)v.get(iter*6+1);
			info=(String)v.get(iter*6+2);
			location=(String)v.get(iter*6+3);
			image=(String)v.get(iter*6+4);
			identifier=(String)v.get(iter*6+5);
			cad+="<tr>"+
			"<td>"+
			"<a href='player.jsp?url="+location+"' target=_blank>"+
			"<img src='"+image+"' border='0' width='130' heigth='97'/>"+
			"</a>"+
			"</td>"+
			"<td valign='top'>"+
			"<b>Titulo: </b>"+title+"<br/>"+
			"<b>Id: </b>"+identifier+"<br/>"+
			"<a href='"+location+"'>Descarga video</a><br/>"+
			annotation+"<br/>"+
			"<a href='playlist.jsp' target=_blank>Lista completa</a><br/>"+
			"</td>"+
			"</tr>"+
			"<tr><td colspan='2'><hr width='480' align='center' size='1'/></td></tr>";
		}
		cad+="</table>";
		return cad;	
	}
}

			
			
