package models;

import java.util.Scanner;

public class Potenz_Rekursion {

    public static void main(String[] args) {

        int n;
        int a;
        int b;
        int y = 1;
        int x = 1;
        int i = y + x;
        int c;

        Potenz_Rekursion p = new Potenz_Rekursion();
        Scanner reader = new Scanner(System.in);

        System.out.println("Geben Sie bitte die gesuchte Zahl ein: ");
        n = reader.nextInt();

        System.out.println("Geben Sie bitte die gesuchte Zahl ein: ");
        a = reader.nextInt();

        System.out.println("Geben Sie bitte die gesuchte Zahl ein: ");
        b = reader.nextInt();

        System.out.println("Geben Sie bitte die gesuchte Zahl ein: ");
        c = reader.nextInt();

        p.potenzRekursion(n);
        p.Fibonacci_Rekursiv(a);
        p.Fibonacci_Interativ(b);
        p.Fibonacci_Endrekursiv(y, x, i, c);
        p.Fibonacci_Endrekursiv1(c);


    }

    public static int potenzRekursion(int n){
        if (n < 0){
            return 0;
        }
        return n * potenzRekursion(n - 1);
    }

    public int Fibonacci_Interativ(int n) {
        if(n <= 1) {
            return n;
        }
        int fib = 1;
        int prevFib = 1;

        for(int i=2; i<n; i++) {
            int temp = fib;
            fib+= prevFib;
            prevFib = temp;
        }
        return fib;
    }

    public int Fibonacci_Rekursiv(int n) {
        if(n <= 1) {
            return n;
        }
        return Fibonacci_Rekursiv(n-1) + Fibonacci_Rekursiv(n-2);
    }

    public static int Fibonacci_Endrekursiv(int x, int y, int i, int n) {
        if (i > n)
            return y;
        else
            return Fibonacci_Endrekursiv(y, x + y, i + 1, n);
    }
    public static int Fibonacci_Endrekursiv1(int n) {
        return Fibonacci_Endrekursiv(1, 1, 2, n);
    }

}
