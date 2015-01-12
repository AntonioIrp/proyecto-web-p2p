package saxbean;

import java.io.*;
import java.sql.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;  
import javax.xml.parsers.SAXParser;


public class playlist2db extends DefaultHandler {
	String location;
	String title;
	String annotation;
	String info;
	String image;
	String identifier;
	   
	int pointer=0,c=0;
	    
	public playlist2db(){
	}

   public int parse(String xml) throws Exception {
	   SAXParserFactory spf =  SAXParserFactory.newInstance(); 
	   spf.setValidating(false);
	   SAXParser saxParser = spf.newSAXParser(); 
	   // create an XML reader
	   XMLReader reader = saxParser.getXMLReader();     
	   // set handler
	   reader.setContentHandler(this);
	   // call parse on an input source
	   ByteArrayInputStream xmldata=new ByteArrayInputStream(xml.getBytes());
	   reader.parse(new InputSource(xmldata));
	   return 1;
   }
   
   // receive notification of the beginning of an element 
   public void startElement (String uri, String nombre, String qName, Attributes atts) {
	   if (qName.equals("title")){
		   pointer=1;
	   }
	   else if (qName.equals("annotation")){
		   pointer=2;
	   }
	   else if (qName.equals("info")){
		   pointer=3;
	   }
	   else if (qName.equals("location")){
		   pointer=4;
	   }
	   else if (qName.equals("image")){
		   pointer=5;
	   }
	   else if (qName.equals("identifier")){
		   pointer=6;
	   }
   	}

   	// receive notification of the end of an element
   	public void endElement (String uri, String name, String qName) {
   		String sql="";
   		if (qName.equals("track")) {
   			c=c+1;
		   if (c==1){
			   sql="delete from aatt.p2pm where info='"+info+"';";;
			   enviarSQL(sql);
		   }
		   sql="INSERT INTO aatt.p2pm (title,annotation,info,location,image,identifier)values('"+title+"','"+annotation+"','"+info+"','"+location+"','"+image+"','"+identifier+"')";
		   enviarSQL(sql);
	   }
   		
   	}
   	
   	//realiza la conexi�n con la BBDD y envia la sentencia
   	public void enviarSQL(String sql){
   		Connection conn;
		Statement stm;
		   
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/aatt","root","");
			stm=conn.createStatement();
			stm.execute(sql);
			stm.close();
			conn.close();
			
		}catch(Exception e){
			System.out.println("Error: "+e); 
		}
   	}
   
   	// receive notification of character data
   	public void characters (char ch[], int start, int length) {
   		String value = new String( ch, start, length);
        if (pointer==1){
        	title=value;
            pointer=0;
        }
        else if (pointer==2){
        	annotation=value;
        	pointer=0;
        }
        else if (pointer==3){
            info=value;
        	pointer=0;
        }
        else if (pointer==4){
            location=value;
        	pointer=0;
        }
        else if (pointer==5){
            image=value;
        	pointer=0;
        }
        else if (pointer==6){
            identifier=value;
            pointer=0;
        }
   	}
}