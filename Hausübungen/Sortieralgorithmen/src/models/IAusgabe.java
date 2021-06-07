package models;

public interface IAusgabe {

    public static void ausgabe(String... sortierungen){
        for(String sortierung:sortierungen){
            System.out.println(sortierung);
        }
    }

}
