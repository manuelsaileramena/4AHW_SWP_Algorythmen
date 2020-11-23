package models;

import java.util.Arrays;
import java.util.Random;

public class Binär_Suche_1 {

    public static void main(String[] args) {

        int[] numbers = new int[100];
        Arrays.sort(numbers);

        double links;
        double rechts;
        double mitte;
        double neueMitte;
        int anzahl = 0;

        Random zufall = new Random();

        double searchedNumber = zufall.nextDouble();

        public void sequentiellSearch(){
            for (int i = 0; i < numbers.length; i++) {
                if (numbers.equals(searchedNumber)) {
                    System.out.println("gesuchte Zahl gefunden: " + numbers[i]);
                }
            }
        }

        public void binaerSearch(){
            mitte = numbers.length / 2;

            if (mitte == searchedNumber) {
                System.out.println("Zahl gefunden: ");
            }
            if (mitte < neueMitte) {
                neueMitte = links / 2;
            }
            if (mitte > neueMitte) {
                neueMitte = rechts / 2;
            }
            if (neueMitte == searchedNumber) {
                System.out.println("gesuchte Zahl gefunden: " + neueMitte);
            }
            else{
                System.out.println("gesuchte Zahl konnte nicht gefunden werden: ");
            }
            anzahl++;
        }
    }
}