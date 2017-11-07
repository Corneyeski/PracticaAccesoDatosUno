package Ejemplos.BufferVSsinBuffer;

import java.io.*;
import java.util.*;
import java.text.*;

public class EjemploBuffer {
   public static void main(String[] args) throws IOException{
      
      System.out.println("Procesando sin buffer...");      
      
      InputStream is = new FileInputStream("a.html");
      
      int dat;      
      long comienzoL = System.currentTimeMillis();
      
      while ( (dat=is.read())!=-1);
      
      long finL = System.currentTimeMillis();      
      is.close();
      long intervalo = finL - comienzoL;

      SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SS");
      dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
System.out.println("Sin buffer: "+ dateFormat.format(new Date(intervalo)));

	System.out.println("Procesando con buffer...");      

      is = new BufferedInputStream(new FileInputStream("a.html"));
      
      comienzoL = System.currentTimeMillis();
      
      while ( (dat=is.read())!=-1);      
       
      finL = System.currentTimeMillis();
 
      is.close();
 
      intervalo = finL - comienzoL;

      dateFormat = new SimpleDateFormat("HH:mm:ss:SS");
      dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

      System.out.println("Con buffer: "+  dateFormat.format(new Date(intervalo)));
    
   }

}
