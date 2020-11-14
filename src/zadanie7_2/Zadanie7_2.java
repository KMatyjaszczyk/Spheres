package zadanie7_2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie7_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        int liczba = 1;
        while (true) {
            System.out.print("Podaj liczbę różną od 0: ");
            try {
                liczba = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Nie podałeś liczby! Konczę program...");
                break;
            }
            if (liczba == 0) break;
            lista.add(liczba);
        }

        int suma = 0;
        int iloczyn = 1;
        for (int l : lista) {
            suma += l;
            iloczyn *= l;
        }

        System.out.println("Wprowadzono " + lista.size() + " liczb");
        System.out.println("Suma: " + suma);
        System.out.println("Iloczyn: " + iloczyn);

    }

}
