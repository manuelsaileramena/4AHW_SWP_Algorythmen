package models;

public class Fibonacci {

    public static void main(String[] args) {

        funktionsaufruf(8);
        fibonacci_rekursiv(20);

    }

    public static void funktionsaufruf(int zahl) {
        System.out.println("Fibonacci Iterativ: "+ fibonacci_interativ(zahl));
        System.out.println("Fibonacci Rekursiv: "+ fibonacci_endrekursiv(0, 1, zahl-1));
    }

    public static int fibonacci_interativ(int hilfszahl) {
        hilfszahl-=2;
        int x=1;
        int y=1;
        int ergebnis=0;
        while(hilfszahl>0) {
            ergebnis=x+y;
            y=x;
            x=ergebnis;
            hilfszahl--;
        }
        return ergebnis;
    }

    public static int fibonacci_rekursiv(int hilfszahl) {
        if (hilfszahl<=2) {
            return 1;
        }else {
            return fibonacci_rekursiv(hilfszahl-1)+ fibonacci_rekursiv(hilfszahl-2);
        }
    }

    public static int fibonacci_endrekursiv(int x0, int x1, int hilfszahl) {
        if (hilfszahl<0) {
            return 0;
        }
        if(hilfszahl==0) {
            return x1;
        }
        return fibonacci_endrekursiv(x1, x0+x1, hilfszahl-1);
    }

}
