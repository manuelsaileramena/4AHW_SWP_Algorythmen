package models;

public class Potenz_Rekursion {

    public static void main(String[] args) {
        hochFunktion(8, 7);
    }

    public static void hochFunktion(int zahl, int anzahl) {
        System.out.println("HochFunktion Iterativ: "+ potenz_iterativ(zahl, anzahl));
        System.out.println("HochFunktion Rekursiv: "+ potenz_rekursiv(zahl, anzahl));
    }

    public static int potenz_iterativ(int basis, int exponent) {
        int ergebnis=basis;
        while(exponent>1) {
            ergebnis=ergebnis*basis;
            exponent--;
        }
        return ergebnis;
    }

    public static int potenz_rekursiv(int basis, int exponent) {
        if(exponent>0) {
            return basis* potenz_rekursiv(basis, exponent-1);
        }else {
            return 1;
        }
    }

}


