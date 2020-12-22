package models;

import java.util.Random;

public class Insertionsort {

    private static int[] datenstruktur=new int[100];
    static int[] zahlen = new int[100];
    static int zaehler = 0;

    public static void main(String[] args) {

        einfügen();
        ausgabe("Unsortiert");
        long startZeit1 = System.nanoTime();
        insertionsortAbsteigend();
        long endZeit1 = System.nanoTime();
        long dauer1 = (endZeit1 - startZeit1);
        System.out.println();
        ausgabe("Absteigend Sortiert");
        System.out.println("Schritte: " + zaehler);
        System.out.println("Benötigte Zeit: " + dauer1/1000 + " Millisekunden");

        long startZeit2 = System.nanoTime();
        insertionnsortAufsteigend();
        long endZeit2 = System.nanoTime();
        long dauer2 = (endZeit2 - startZeit2);
        System.out.println();
        ausgabe("Aufsteigend Sortiert");
        System.out.println("Schritte: " + zaehler);
        System.out.println("Benötigte Zeit: " + dauer2/1000 + " Millisekunden");

        long startZeit3 = System.nanoTime();
        insertionsortZufaellig();
        long endZeit3 = System.nanoTime();
        long dauer3 = (endZeit3 - startZeit3);
        System.out.println();
        ausgabe("Zufällig Sortiert");
        System.out.println("Schritte: " + zaehler);
        System.out.println("Benötigte Zeit: " + dauer3/1000 + " Millisekunden");

    }

    public static void einfügen(){
        for (int i=0; i<zahlen.length; i++){
            zahlen[i] = (int)(Math.random()*101);
        }
    }

    public static void insertionsortAbsteigend() {
        int temp;
        for(int i=1; i<zahlen.length; i++) {
            for(int j=0; j<zahlen.length-i; j++) {
                if(zahlen[j]<zahlen[j+1]) {
                    zaehler++;
                    temp=zahlen[j];
                    zahlen[j]=zahlen[j+1];
                    zahlen[j+1]=temp;
                }
            }
        }
    }

    public static void insertionnsortAufsteigend() {
        int temp;
        for(int i=1; i<zahlen.length; i++) {
            for(int j=0; j<zahlen.length-i; j++) {
                if(zahlen[j]>zahlen[j+1]) {
                    zaehler++;
                    temp=zahlen[j];
                    zahlen[j]=zahlen[j+1];
                    zahlen[j+1]=temp;
                }
            }
        }
    }

    public static void insertionsortZufaellig() {
        int[] zufall=new int[100];
        int laenge=zufall.length-1;
        for(int i=0; i<zufall.length; i++) {
            zufall[i]=i+1;
        }
        for (int j = 0; j < zufall.length; j++) {
            int zahl=(int)(Math.random()*laenge);
            datenstruktur[j]=zufall[zahl];
            int p=zufall[laenge];
            zufall[laenge]=zufall[zahl];
            zufall[zahl]=p;
            laenge--;
        }
    }


    public static void ausgabe(String betreff){
        System.out.println(betreff);
        for (int i=0; i<zahlen.length; i++){
            System.out.println(zahlen[i]);
        }
    }

}
