package models;

import java.util.List;

public interface ISortierung {

    public String getName();

    public List<Integer> Sortierung(List<Integer> zahlen);

    public IZaehlen getVertauschungen();

    public IZaehlen getVergleiche();

    public IZaehlen getZeit();

}
