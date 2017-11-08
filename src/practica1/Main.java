package practica1;

import practica1.Entities.BugPackage;
import practica1.Entities.Maintainer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static final String maintainer = "packageMaintainer.txt";
    private static final String bugPackage = "rcBugPackage.txt";
    private static HashMap<Long, BugPackage> bugs = new HashMap<>();
    private static List<Maintainer> maintainers = new ArrayList<>();

    public static void main(String[] args) {


        String linea;
        String menu;
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(bugPackage));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while ((linea = bfr.readLine()) != null) {
                try {
                    BugPackage bug = new BugPackage(linea.split(";"));
                    bugs.put(bug.getId(), bug);
                } catch (Exception e) {
                    System.out.println("Linea no aceptada: " + linea);
                }
            }

            bfr = new BufferedReader(new FileReader(maintainer));
            while ((linea = bfr.readLine()) != null) {
                try {
                    maintainers.add(new Maintainer(linea.split(";")));
                } catch (Exception e) {
                    System.out.println("Linea no aceptada 2: " + linea);
                }
            }

            do {
                System.out.println("MENU PRINCIPAL DE LA PRACTICA");
                System.out.println("1 - Empezar ejercicio");
                System.out.println("0 - Salir");

                menu = reader.readLine();

                switch (menu) {
                    case "1":
                        String idS;
                        long id = 0;
                        do {
                            System.out.println("Introduce la ID del bug o escribe salir");
                            idS = reader.readLine();

                            try {
                                if (!idS.equalsIgnoreCase("salir")) {
                                    id = Long.parseLong(idS);
                                }
                            } catch (NumberFormatException nfe) {
                                System.out.println("Imposible parsear: " + nfe);
                                System.out.println("Introduce un numero valido");

                                idS = "";
                            }
                        } while (idS.equals(""));

                        mailWrite(id);
                        break;
                }
            } while (!menu.equals("0"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mailWrite(Long id) {

        if (bugs.containsKey(id)) {
            List<String> bugsNames = bugs.get(id).getName();
            List<Maintainer> maintainersFinal = new ArrayList<>();

            for (Maintainer m : maintainers) {
                if (m.equals(bugsNames)) {
                    maintainersFinal.add(m);
                }
            }
            if (!maintainersFinal.isEmpty()) {
                String[] data = getNamesAndEmails(maintainers);

                try {
                    Writer writer = new BufferedWriter(
                            new FileWriter("email.txt"));

                    String emailText = "From: owner@bugs.debian.org" +
                            System.lineSeparator() +
                            System.lineSeparator() +
                            "To: " + data[1] +
                            System.lineSeparator() +
                            System.lineSeparator() +
                            "Dear: " + data[0] +
                            System.lineSeparator() +
                            System.lineSeparator() +
                            "You have a new bug: " +
                            System.lineSeparator() +
                            System.lineSeparator() +
                            bugsNames.toString() + " - " + "RC bug number #" + id +
                            System.lineSeparator() +
                            System.lineSeparator() +
                            "Please, fix it as soon as possible." +
                            System.lineSeparator() +
                            System.lineSeparator() +
                            "Cheers.";

                    System.out.println(emailText);
                    writer.write(emailText);

                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else{
                System.out.println("Lo sentimos, este Package no tiene mantenimiento");
            }
        } else {
            System.out.println("Lo sentimos, esta ID no corresponde a ningun Package: " + id);
        }
    }

    private static String[] getNamesAndEmails(List<Maintainer> maintainers) {

        String[] data = new String[2];

        for (Maintainer m :
                maintainers) {
            data[0] += m.getName() + " ";
            data[1] += m.getEmail() + " ";
        }
        return data;
    }
}