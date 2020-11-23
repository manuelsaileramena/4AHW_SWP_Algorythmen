package models;

public class Suchmethoden {

    int[] numbers = new int[100];

    private double searchedNumber;
    private double links;
    private double rechts;
    private double mitte;
    private double neueMitte = 49;
    private int anzahl;


    public void sequentiellSearch(){
        for(int i=0; i < numbers.length; i++){
            if (numbers.equals(searchedNumber)){
                System.out.println(numbers[i]);
            }
        }
    }

    public void binärSearch(double links, double rechts){
        mitte = 100 / 2;

        if (neueMitte == searchedNumber){
            System.out.println("Zahl gefunden: ");
        }
        while (numbers.length <= 100) {
            if (mitte < neueMitte) {
                neueMitte = links / 2;
            }
            if (mitte > neueMitte) {
                neueMitte = rechts / 2;
            }
            if (neueMitte == searchedNumber){
                System.out.println("gesuchte Zahl gefunden: " + neueMitte);
            }
            anzahl++;
        }
    }

}
