package zadanie7_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie7_5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        int liczba = 1;
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
            iloczyn *= liczba;
            System.out.println("Iloczyn: " + iloczyn);
            Collections.sort(lista, Collections.reverseOrder());
            System.out.println(lista.toString());

            if (iloczyn == 256) break;
            else if (iloczyn > 256) {
                iloczyn /= lista.get(lista.size()-1);
                lista.remove(lista.size()-1);
            }
        }
        System.out.println("Iloczyn jest równy 256. Do widzenia");
    }

}
