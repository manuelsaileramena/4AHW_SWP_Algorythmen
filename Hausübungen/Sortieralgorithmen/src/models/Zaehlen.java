package models;

public class Zaehlen implements IZaehlen{

    private Long zaehler = Long.valueOf(0);

    @Override
    public void setZaehler(Object zaehler) {
        if (zaehler.getClass() == Long.class) {
            this.zaehler = (Long)zaehler;
        }
    }

    @Override
    public Object getZaehler() {
        return zaehler;
    }
}
