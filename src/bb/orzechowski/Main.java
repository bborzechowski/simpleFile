package bb.orzechowski;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file;
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            printMenu();
            answer = scanner.nextLine();
            switch (answer) {
                case "1": {
                    System.out.println("podaj ścieżkę gdzie ma być utworzony folder np: C:\\");
                    String path = scanner.nextLine();
                    System.out.println("podaj nazwe folderu");
                    String name = scanner.nextLine();
                    file = new File(path + name);
                    file.mkdir();
                    break;
                }
                case "2": {
                    System.out.println("podaj ścieżkę gdzie ma być utworzony pliku np: C:\\folder");
                    String path = scanner.nextLine();
                    System.out.println("podaj nazwe pliku razem z rozszerzeniem np: plik.txt");
                    String name = scanner.nextLine();
                    file = new File(path + "\\" + name);
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "3": {
                    System.out.println("podaj ścieżkę  pliku np: C:\\");
                    String path = scanner.nextLine();
                    System.out.println("podaj nazwe pliku razem z rozszerzeniem np: plik.txt");
                    String name = scanner.nextLine();
                    file = new File(path + "\\" + name);
                    if (file.exists()) {
                        System.out.println("plik istnieje");
                    } else {
                        System.out.println("plik nie istnieje");
                    }
                    break;

                }
                case "4": {
                    System.out.println("podaj ścieżkę pliku np: C:\\plik.txt");
                    String path = scanner.nextLine();
                    file = new File(path);
                    List<String> tekst = null;
                    try {
                        tekst = Files.readAllLines(file.toPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tekst);
                    break;
                }
                case "5": {
                    System.out.println("podaj ścieżkę pliku i nazwe razem z rozszerzeniem np: C:\\plik.txt");
                    String path = scanner.nextLine();
                    file = new File(path);
                    System.out.println("wprowadz tekst");
                   String word = scanner.nextLine();
                    try {
                        Files.write(file.toPath(), (" " + word + "\r\n").getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                }
                case "6": {
                    System.out.println("podaj ścieżkę pliku i nazwe razem z rozszerzeniem np: C:\\plik.txt");
                    String path = scanner.nextLine();
                    file = new File(path);
                    System.out.println("podaj wyraz który chcesz zmienić");
                    String word = scanner.nextLine();
                    System.out.println("podaj nowy wyraz");
                    String newWord = scanner.nextLine();
                    List<String> lines = null;
                    try {
                        lines = Files.readAllLines(file.toPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    StringBuilder allText = new StringBuilder();
                    for(String line : lines){
                        allText.append(line.replace(word, newWord)).append("\r\n");
                    }
                    try {
                        Files.write(file.toPath(), allText.toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                }

            }
        }

            while (!answer.equals("7")) ;


        }
        private static void printMenu () {
            System.out.println("1 - Dodaj katalog");
            System.out.println("2 - Dodaj plik");
            System.out.println("3 - Sprawdz czy plik już istnieje");
            System.out.println("4 - Odczytaj zawartość pliku");
            System.out.println("5 - Dodaj tekst do pliku");
            System.out.println("6 - Zamień słowa na inne w pliku tekstowym");
            System.out.println("7 - Zakończ program");
        }


}
