package zadanie7_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie7_4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        int liczba = 1;
        int suma = 0;

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
            System.out.println("Suma: " + suma);
            Collections.sort(lista);
            System.out.println(lista.toString());

            if (suma == 64) break;
            else if (suma > 64) {
                suma -= lista.get(lista.size()-1);
                lista.remove(lista.size()-1);
            }
        }
        System.out.println("Suma jest równa 64. Do widzenia");
    }

}
