package models;

public class Sortieralgorithmen {

    static int tauschZaehler1;
    static int tauschZaehler2;
    static int tauschZaehler3;
    static int tauschZaehler4;
    static int tauschZaehler5;
    static long durchschnitt;
    static long dauer1;
    static long dauer2;
    static long dauer3;
    static long dauer4;
    static long dauer5;

    public static void main(String[] args) {

        for (int j = 0; j <= 0; j++) {
            int[] zahlen = new int[1000];
            int range = 10;

            arrayBefüllen(zahlen, range);
            selectionsortUnstable(zahlen);
            arrayBefüllen(zahlen, range);
            selectionsortStable(zahlen);
            arrayBefüllen(zahlen, range);
            bubblesort(zahlen);
            arrayBefüllen(zahlen, range);
            insertionsort(zahlen);
            quickSort(zahlen, 0, zahlen.length-1);
        }
        System.out.println("Selectionsort Unstable:");
        System.out.println("Anzahl der Tauschoperationen:");
        System.out.println(tauschZaehler1);
        System.out.println("Dauer:");
        System.out.println(dauer1 + " Millisekunden");
        System.out.println("\n");

        System.out.println("Selectionsort Stable:");
        System.out.println("Anzahl der Tauschoperationen:");
        System.out.println(tauschZaehler2);
        System.out.println("Dauer:");
        System.out.println(dauer2 + " Millisekunden");
        System.out.println("\n");

        System.out.println("Bubblesort: ");
        System.out.println("Anzahl der Tauschoperationen:");
        System.out.println(tauschZaehler3);
        System.out.println("Dauer:");
        System.out.println(dauer3 + " Millisekunden");
        System.out.println("\n");

        System.out.println("Insertionsort: ");
        System.out.println("Anzahl der Tauschoperationen:");
        System.out.println(tauschZaehler4);
        System.out.println("Dauer:");
        System.out.println(dauer4 + " Millisekunden");
        System.out.println("\n");

        System.out.println("Quicksort: ");
        System.out.println("Anzahl der Tauschoperationen:");
        System.out.println(tauschZaehler5);
        System.out.println("Dauer:");
        System.out.println(dauer5 + " Millisekunden");
        System.out.println("\n");

        durchschnitt = (dauer1 + dauer2 + dauer3 + dauer4) / 4;
        System.out.println("Durchschnittszeit:");
        System.out.println(durchschnitt + " Millisekunden");
    }

    public static void arrayBefüllen(int zahlen[], int range) {
        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = (int) (Math.random() * range);
        }
    }

    public static int selectionsortUnstable(int zahlen[]) {
        long startZeit1 = System.nanoTime();
        tauschZaehler1 = 0;
        for (int i = 0; i < zahlen.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < zahlen.length; j++) {
                if (zahlen[j] < zahlen[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = zahlen[min_idx];
            zahlen[min_idx] = zahlen[i];
            zahlen[i] = temp;
            tauschZaehler1++;
        }
        long endZeit1 = System.nanoTime();
        dauer1 = (endZeit1 - startZeit1);
        //startZeit = 1 und endZeit = 2, dann wäre die Differenz -1, darum immer Minus Zahlen gehabt
        return tauschZaehler1;
    }

    public static int selectionsortStable(int zahlen[]) {
        long startZeit2 = System.nanoTime();
        tauschZaehler2 = 0;
        for (int i = 0; i < zahlen.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < zahlen.length; j++) {
                if (zahlen[min] > zahlen[j]) {
                    min = j;
                }
            }
            for (int n=min; n>i; n--){
                int zahlenTemp = zahlen[n];
                zahlen[n] = zahlen[n-1];
                zahlen[n-1] = zahlenTemp;
                tauschZaehler2++;
            }
        }
        long endZeit2 = System.nanoTime();
        dauer2 = (endZeit2 - startZeit2);
        return tauschZaehler2;
    }

    public static int bubblesort(int zahlen[]) {
        long startZeit3 = System.nanoTime();
        tauschZaehler3 = 0;
        for (int i = 0; i < zahlen.length - 1; i++) {
            for (int j = 0; j < zahlen.length - i - 1; j++) {
                if (zahlen[j] > zahlen[j + 1]) {
                    int temp = zahlen[j];
                    zahlen[j] = zahlen[j + 1];
                    zahlen[j + 1] = temp;
                    tauschZaehler3++;
                }
            }
        }
        long endZeit3 = System.nanoTime();
        dauer3 = (endZeit3 - startZeit3);
        return tauschZaehler3;
    }

    public static int insertionsort(int zahlen[]) {
        long startZeit4 = System.nanoTime();
        tauschZaehler4 = 0;
        for (int i = 0; i < zahlen.length; i++) {
            int key = zahlen[i];
            int j = i - 1;
            while ((j > -1) && (zahlen[j] > key)) {
                zahlen[j + 1] = zahlen[j];
                j--;
                tauschZaehler4++;
            }
            zahlen[j + 1] = key;
            tauschZaehler4++;
        }
        long endZeit4 = System.nanoTime();
        dauer4 = (endZeit4 - startZeit4);
        return tauschZaehler4;
    }

    static void swap(int zahlen[], int i, int j)
    {
        int temp= zahlen[i];
        zahlen[i] = zahlen[j];
        zahlen[j] = temp;
    }
    static int partition (int zahlen[], int low, int high)
    {
        int pivot = zahlen[high];
        int i = (low -1);
        for(int j = low; j<= high -1 ; j++)
        {
            if(zahlen[j] < pivot)
            {
                i++;
                swap(zahlen,i,j);
                tauschZaehler5++;
            }
        }
        swap(zahlen,i+1,high);
        return(i+1);
    }
    static void quickSort(int zahlen[], int low, int high)
    {
        long startZeit5 = System.nanoTime();
        if(low < high)
        {
            int pi = partition(zahlen, low ,high);
            quickSort(zahlen, low, pi-1);
            quickSort(zahlen, pi+1, high);
        }
        long endZeit5 = System.nanoTime();
        dauer5 = endZeit5 - startZeit5;
    }
}
