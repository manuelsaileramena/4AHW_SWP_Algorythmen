package models;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException{
        alleSortierungen(0, 10, 10, 1000);
    }

    public static void alleSortierungen(int minRange, int maxRange, int rounds, int elements) throws ClassNotFoundException{
        IAusgabe.ausgabe(Berechnung.compare(minRange, maxRange, rounds, elements,
                new Bubblesort(),
                new Insertionsort(),
                new SelectionsortUnstable(),
                new SelectionsortStable(),
                new Quicksort()));
    }
}