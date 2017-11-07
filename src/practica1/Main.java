package practica1;

import jdk.nashorn.internal.runtime.ParserException;
import practica1.Entities.BugPackage;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static final String maintainer = "packageMaintainer.txt";
    static final String bugPackage = "rcBugPackage.txt";

    public static void main(String[] args){

        List<BugPackage> bugs = new ArrayList<>();
        String linea = "";

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(bugPackage));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while( (linea = bfr.readLine()) != null){
                try{
                    bugs.add(new BugPackage(linea.split(";")));
                }catch (Exception e){
                    System.out.println("Linea no aceptada: " + linea);
                }
            }

            bfr = new BufferedReader(new FileReader(maintainer));
            while( (linea = bfr.readLine()) != null){
                try{
                    bugs.add(new BugPackage(linea.split(";")));
                }catch (Exception e){
                    System.out.println("Linea no aceptada: " + linea);
                }
            }


            String id;
            do {
                System.out.println("Introduce la ID del bug");
                id = reader.readLine();

                try{
                    Long.parseLong(id);
                }catch (NumberFormatException nfe){
                    System.out.println("Imposible parsear: " + nfe);
                    System.out.println("Introduce un numero valido");

                    id = "";
                }
            }while(id.equals(""));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
