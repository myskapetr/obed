package cz.henrych.lunch.menu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Goodlunch implements MenuSupplier {
    public static final String URL = "https://www.facebook.com/theparkchodov/?locale=cs_CZ";

    @Override
    public String parse(final Document doc) {
        return "<a href=\"" + URL + "\">Goodlunch (Park FB)</a><br/>";
    }
    
    public static void main(String[] args) throws IOException {
        Goodlunch p = new Goodlunch();
        Document doc = Jsoup.connect(URL).get();
        System.out.println(p.parse(doc));
    }

    @Override
    public String getName() {
        return "Goodlunch";
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
