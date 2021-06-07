package models;

import java.util.List;

public class Insertionsort implements ISortierung{

    private String name="Insertionsort";
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
        for (int i = 0; i < zahlen.size(); i++) {
            int key = zahlen.get(i);
            int j = i - 1;
            vergleiche.setZaehler((Long)vergleiche.getZaehler() + 1);
            while ((j > -1) && (zahlen.get(j) > key)) {
                zahlen.set(j + 1, zahlen.get(j));
                j--;
                vertauschungen.setZaehler((Long)vertauschungen.getZaehler() + 1);
            }
            zahlen.set(j + 1, key);

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
