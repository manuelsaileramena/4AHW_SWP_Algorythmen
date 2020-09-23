package models;

import static java.lang.System.currentTimeMillis;

public class Binär_Suche_1 {

    private double _searchedNumber;
    long vorher;
    long nachher;

    public double getSearchedNumber(){
        return this._searchedNumber;
    }

    public void setSearchedNumber(double searchedNumber){
        if(searchedNumber > 0){
            this._searchedNumber = searchedNumber;
        }
    }

     int[] numbers;

    public void sequentiellSearch(double searchedNumber){
        vorher = System.currentTimeMillis();
        for(int i=0; i <= searchedNumber; i++){
            System.out.println(numbers[i]);
            System.out.println("Die Zahl ist kleiner als diese Zahl! ");
        }
    }

    public void binärSearch(){
        nachher = System.currentTimeMillis();
        System.out.println("Zeit benötigt: " + ((nachher - vorher)/1000) + "sec");
    }






}
