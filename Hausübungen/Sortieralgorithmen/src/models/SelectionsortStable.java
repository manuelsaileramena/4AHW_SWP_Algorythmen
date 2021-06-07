package models;

import java.util.List;

public class SelectionsortStable implements ISortierung {

    private String name="Selectionsort Stable";
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
        for (int i = 0; i < zahlen.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < zahlen.size(); j++) {
                vergleiche.setZaehler((Long) vergleiche.getZaehler() + 1);
                if (zahlen.get(min) > zahlen.get(j)) {
                    min = j;
                }
            }
            for (int n=min; n>i; n--){
                int zahlenTemp = zahlen.get(n);
                zahlen.set(n, zahlen.get(n - 1));
                zahlen.set(n - 1, zahlenTemp);
                vertauschungen.setZaehler((Long) vertauschungen.getZaehler() + 1);
            }
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
