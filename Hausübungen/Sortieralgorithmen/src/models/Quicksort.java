package models;

import java.util.List;

public class Quicksort implements ISortierung {

    private String name="Quicksort";
    private IZaehlen vergleiche = new Zaehlen();
    private IZaehlen vertauschungen = new Zaehlen();
    private IZaehlen zeit = new Zaehlen();

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Integer> Sortierung(List<Integer> zahlen) {
        zeit.setZaehler(System.nanoTime());
        vergleiche.setZaehler(0);
        vertauschungen.setZaehler(0);
        quickSort(zahlen, 0, zahlen.size() - 1);
        zeit.setZaehler(System.nanoTime() - (Long) zeit.getZaehler());
        return zahlen;
    }

    @Override
    public IZaehlen getVertauschungen() {
        return this.vertauschungen;
    }

    @Override
    public IZaehlen getVergleiche() {
        return this.vergleiche;
    }

    @Override
    public IZaehlen getZeit() {
        return this.zeit;
    }

    void swap(List<Integer> zahlen, int i, int j)
    {
        int temp= zahlen.get(i);
        zahlen.set(i, zahlen.get(j));
        zahlen.set(j, temp);
        vertauschungen.setZaehler((Long)vertauschungen.getZaehler() + 1);
    }

    int partition (List<Integer> zahlen, int low, int high)
    {
        int pivot = zahlen.get(high);
        int i = (low -1);
        for(int j = low; j<= high -1 ; j++)
        {
            vergleiche.setZaehler((Long)vergleiche.getZaehler() + 1);
            if(zahlen.get(j) < pivot)
            {
                i++;
                swap(zahlen,i,j);
            }
        }
        swap(zahlen,i+1,high);
        return(i+1);
    }

    void quickSort(List<Integer> zahlen, int low, int high)
    {
        if(low < high)
        {
            int pi = partition(zahlen, low ,high);
            quickSort(zahlen, low, pi-1);
            quickSort(zahlen, pi+1, high);
        }
    }

}
