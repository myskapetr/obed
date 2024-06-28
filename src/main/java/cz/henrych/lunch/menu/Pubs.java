package cz.henrych.lunch.menu;

import org.jsoup.nodes.Document;

public enum Pubs {
    Spojovna(new Spojovna(), "spojovna.png"),
    Goodlunch(new Goodlunch(), "goodlunch.svg", false),
    Cube(new Cube(), "cube.png"),
    JidloJihu(new JidloJihu(), "dragon.png"),
    Fruitisimo(new Fruitisimo(), "fruitisimo.svg", false),
    NaRychte(new NaRychte(), "na-rychte2.svg"),
    Pepe(new Pepe(), "pepe.png"),
    Zatisi(new Zatisi(), "zatisi.png"),
    ;
    
    private MenuSupplier getMenu;
    private String icon;
    private boolean shouldConnect = true;
    
    public static String[] rightsStr;
    public static String[] leftsStr;
    
    static {
        Pubs[] r = new Pubs[] { Spojovna, Goodlunch, Fruitisimo, NaRychte };
        Pubs[] l = new Pubs[] { Cube, JidloJihu, Pepe, Zatisi };
        rightsStr = new String[r.length];
        leftsStr = new String[l.length];
        for (int i=0; i<r.length; i++) {
            rightsStr[i] = r[i].name();
        }
        for (int i=0; i<l.length; i++) {
            leftsStr[i] = l[i].name();
        }
    }
    
    Pubs(MenuSupplier getMenu, String icon) {
        this(getMenu, icon, true);
    }

    Pubs(MenuSupplier getMenu, String icon, boolean shouldConnect) {
        this.getMenu = getMenu;
        this.icon = icon;
        this.shouldConnect = shouldConnect;
    }
    
    public String getIcon() {
        return icon;
    }

    public String getName() {
        return getMenu.getName();
    }
    public String getUrl() {
        return getMenu.getUrl();
    }

    public String parse(Document doc) {
        return getMenu.parse(doc);
    }

    public boolean shouldConnect() {
        return shouldConnect;
    }
}
