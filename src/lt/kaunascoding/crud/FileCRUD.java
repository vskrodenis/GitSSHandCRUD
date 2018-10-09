package lt.kaunascoding.crud;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCRUD {
    public void createFile() {
        System.out.println("Iveskite failo pavadinima \u263B ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        System.out.println("Ivestas failo pavadinimas: " + fileName + "\u263B");
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("Toks failas egzistuoja \u263B");
        } else {
            System.out.println("Toks failas neegzistuoja \uD83D\uDE1E");
            System.out.println("Ar toki faila sukurti? y/N");
            String arSukurti = sc.nextLine();
            if (arSukurti.toLowerCase().equals("y")) {
                try {
                    file.createNewFile();
                    System.out.println("Failas sekmingai sukurtas \u263B");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Stmh wrong");
                }
            }
        }
    }

    public void updateFile() {
        System.out.println("Iveskite failo pavadinima");
        Scanner sc = new Scanner(System.in);
        String failoVardas = sc.nextLine();
        File file = new File(failoVardas);

        if (file.exists()) {
            System.out.println("Toks failas egzistuoja");
            System.out.println("Iveskite teksta ir spauskite enter");
            System.out.println("Ivedus zodi pabaiga, saugojimas bus baigtas");

            try {
                FileWriter writer = new FileWriter(file, true);
                String eilute;
                do {
                    eilute = sc.nextLine();

                    if (!eilute.toLowerCase().equals("pabaiga")) {
                        writer.write(eilute + "\n");
                    }

                } while (!eilute.toLowerCase().equals("pabaiga"));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public void readFile(){
        System.out.println("Iveskite failo pavaadinima");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        File file = new File(fileName);
        if (file.exists()){
            try {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNext()){
                    System.out.println(fileScanner.nextLine());
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteFile(){
        System.out.println("Iveskite failo pavadinima trinimui");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        File file = new File(fileName);
        if(file.exists()){
            System.out.println("Toks failas jau egzistuoja, ar tikrai norite ji trinti> y/N");
            String pasirinkimas = sc.nextLine();
            if(pasirinkimas.toLowerCase().equals("y")){
                file.delete();
                System.out.println("Failas sekmingai istrintas");
            }
        }
    }
}
