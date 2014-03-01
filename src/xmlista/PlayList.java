package xmlista;

import java.io.*;
import java.net.*;

public class PlayList{
  File nombreD;
  File fi;
  public PlayList(){}

  public String GetList(String directorio, String dirpath){
	String res=new String("");
        String dirlocal=directorio+"shared/";
        nombreD=new File(dirlocal);
        if(nombreD.isDirectory()){
            try{
               String ip=InetAddress.getLocalHost().toString();
               ip=ip.substring(ip.indexOf("/")+1);
               String dir[]=nombreD.list();
               int longdir=dir.length;
               int i;
	       res  ="<?xml version='1.0'?>\r\n";
	       res+="<?xml-stylesheet href='playlist.xsl' type='text/xsl'?>\r\n";
               res+="<playList>\r\n"; 
               res+="<trackList>\r\n";
               for (i=0;i<longdir;i++){
                 if (dir[i].endsWith(".mp4")){
                   int idx_image=dir[i].lastIndexOf(".mp4");
                   String image=dir[i].substring(0,idx_image)+".jpg";
                   fi=new File(dirlocal+image);
                   if (fi.exists()!=true) image="default.jpg";
                   fi=new File(dirlocal+dir[i]);
                   MD5 md = new MD5();
                   
                   FileInputStream fis = new FileInputStream(dirlocal+dir[i]);
                   byte [] buff = new byte[8192];
    		       int nread;
                   nread=fis.read(buff, 0, 8192); // solo hash a los primeros 8KBytes
                   md.addInput(buff, nread);
                   fis.close();
                   byte [] fp = md.getMD();
                   String hash=md.bytes2hexStr(fp);
                   //String hash="000";
  	           res+="<track>\r\n";
                   res=res+"<title>"+dir[i]+"</title>\r\n";
                   res+="<annotation>Video descargado para uso educativo, sin animo de lucro.</annotation>\r\n";
                   res=res+"<info>http://"+ip+":8080"+dirpath+"</info>\r\n";
                   res=res+"<location>http://"+ip+":8080"+dirpath+"/shared/"+dir[i]+"</location>\r\n";
                   res=res+"<image>http://"+ip+":8080"+dirpath+"/shared/"+image+"</image>\r\n";
                   res=res+"<identifier>"+hash+"</identifier>\r\n";
                   res+="</track>\r\n";
                 }
				 if (dir[i].endsWith(".flv")){
                   int idx_image=dir[i].lastIndexOf(".flv");
                   String image=dir[i].substring(0,idx_image)+".jpg";
                   fi=new File(dirlocal+image);
                   if (fi.exists()!=true) image="default.jpg";
                   fi=new File(dirlocal+dir[i]);
                   MD5 md = new MD5();
                   
                   FileInputStream fis = new FileInputStream(dirlocal+dir[i]);
                   byte [] buff = new byte[8192];
    		       int nread;
                   nread=fis.read(buff, 0, 8192); // solo hash a los primeros 8KBytes
                   md.addInput(buff, nread);
                   fis.close();
                   byte [] fp = md.getMD();
                   String hash=md.bytes2hexStr(fp);
                   //String hash="000";
  	           res+="<track>\r\n";
                   res=res+"<title>"+dir[i]+"</title>\r\n";
                   res+="<annotation>Video descargado para uso educativo, sin animo de lucro.</annotation>\r\n";
                   res=res+"<info>http://"+ip+":8080"+dirpath+"</info>\r\n";
                   res=res+"<location>http://"+ip+":8080"+dirpath+"/shared/"+dir[i]+"</location>\r\n";
                   res=res+"<image>http://"+ip+":8080"+dirpath+"/shared/"+image+"</image>\r\n";
                   res=res+"<identifier>"+hash+"</identifier>\r\n";
                   res+="</track>\r\n";
                 }
               }
               res+="</trackList>\r\n";
               res+="</playList>\r\n";
            }catch (Exception e){System.out.println(e);};
        }
	return res;
   }
}    