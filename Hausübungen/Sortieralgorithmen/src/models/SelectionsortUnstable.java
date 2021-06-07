package models;

import java.util.List;

public class SelectionsortUnstable implements ISortierung {

    private String name="Selectionsort Unstable";
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
            int min_idx = i;
            for (int j = i + 1; j < zahlen.size(); j++) {
                vergleiche.setZaehler((Long) vergleiche.getZaehler() + 1);
                if (zahlen.get(j) < zahlen.get(min_idx)) {
                    min_idx = j;
                }
            }
            int temp = zahlen.get(min_idx);
            zahlen.set(min_idx, zahlen.get(i));
            zahlen.set(i, temp);
            vertauschungen.setZaehler((Long) vertauschungen.getZaehler() + 1);
        }
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
}
