package cz.henrych.lunch.menu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Fruitisimo implements MenuSupplier {
    public static final String URL = "https://www.facebook.com/fruitisimobistrocafe?locale=cs_CZ";
    public static final String URL2 = "https://www.facebook.com/theparkchodov/?locale=cs_CZ";

    @Override
    public String parse(final Document doc) {
        return "<a href=\"" + URL + "\">Fruitisimo FB</a><br/>" +
            "<a href=\"" + URL2 + "\">(Park FB)</a><br/>";
    }
    
    public static void main(String[] args) throws IOException {
        Fruitisimo p = new Fruitisimo();
        Document doc = Jsoup.connect(URL).get();
        System.out.println(p.parse(doc));
    }

    @Override
    public String getName() {
        return "Fruitisimo";
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
