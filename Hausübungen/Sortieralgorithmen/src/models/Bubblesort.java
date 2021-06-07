package models;

import java.util.List;

public class Bubblesort implements ISortierung {

    private String name="Bubblesort";
    private IZaehlen vertauschungen = new Zaehlen();
    private IZaehlen vergleiche = new Zaehlen();
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
        int temp;
        for (int i = 0; i < zahlen.size(); i++) {
            for (int j = 1; j < zahlen.size() - i; j++) {
                vergleiche.setZaehler((Long)vergleiche.getZaehler() + 1);
                if (zahlen.get(j - 1) > zahlen.get(j)) {
                    temp = zahlen.get(j -1);
                    zahlen.set(j - 1, zahlen.get(j));
                    zahlen.set(j, temp);
                    vertauschungen.setZaehler((Long)vertauschungen.getZaehler() + 1);
                }
            }
        }
        zeit.setZaehler(System.nanoTime() - (Long)zeit.getZaehler());
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
}
