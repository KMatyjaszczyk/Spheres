package zadanie7_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie7_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        int liczba = 1;
        int suma = 0;
        int iloczyn = 1;

        while (true) {
            System.out.print("Podaj liczbę: ");

            try {
                liczba = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Nie podałeś liczby! Konczę program...");
                break;
            }

            lista.add(liczba);
            suma += liczba;
            iloczyn *= liczba;

            if(suma > 250 || iloczyn > 3000000) break;
        }

        System.out.println("Wprowadzono " + lista.size() + " liczb");
        System.out.println("Suma: " + suma);
        System.out.println("Iloczyn: " + iloczyn);

        Collections.sort(lista, Collections.reverseOrder());

        for (int l: lista) {
            System.out.print(l + " ");
        }

    }

}
