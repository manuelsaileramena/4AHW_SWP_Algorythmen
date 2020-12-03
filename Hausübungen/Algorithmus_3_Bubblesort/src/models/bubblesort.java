package models;

public class bubblesort {

    static int[] zahlen = new int[100];
    static int zaehler = 0;

    public static void main(String[] args) {

        einfügen();
        ausgabe("Unsortiert");
        bubblesort();
        ausgabe("Sortiert");
        System.out.println("Schritte: " + zaehler);

    }

    public static void einfügen(){
        for (int i=0; i<zahlen.length; i++){
            zahlen[i] = (int)(Math.random()*101);
        }
    }

    public static void bubblesort() {
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

    public static void ausgabe(String betreff){
        System.out.println(betreff);
        for (int i=0; i<zahlen.length; i++){
            System.out.println(zahlen[i]);
        }
    }


}
