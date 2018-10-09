package lt.kaunascoding;

import lt.kaunascoding.crud.FileCRUD;

import java.util.Scanner;

public class MainFacade {

    public static void main(String[] args) {
        FileCRUD model = new FileCRUD(); // model nes pagal susitarima vadiname duomenis
        boolean arTesti = true;
        Scanner sc = new Scanner(System.in);
        while (arTesti) {
            showMeniu();
            int pasirintikimas = sc.nextInt();
            switch (pasirintikimas) {
                case 0:
                    arTesti = false;
                    break;
                case 1:
                    model.requestFileName();
                    break;
                case 2:
                    model.createFile();
                    break;
                case 3:
                    model.updateFile();
                    break;
                case 4:
                    model.readFile();
                    break;
                case 5:
                    model.deleteFile();
                    break;
            }
        }


    }

    static void showMeniu() {
        System.out.println("Iveskite pasirinkima");
        System.out.println("1- nurodyti failo varda");
        System.out.println("2- sukurti faila");
        System.out.println("3- papildyti faila tekstu");
        System.out.println("3- papildyti faila tekstu");
        System.out.println("4- parodyti failo turini");
        System.out.println("5- trinti faila");
        System.out.println("0- baigti darba");
    }
}

