package cz.henrych.lunch.menu;

import org.jsoup.nodes.Document;

public class JidloJihu implements MenuSupplier {
    public static final String URL = "https://jidlojihu.cz/";

    @Override
    public String parse(final Document doc) {
        return "<a href=\"" + URL + "\">JI DLO JI HU</a><br/>";
    }

    @Override
    public String getName() {
        return "JI DLO JI HU";
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
