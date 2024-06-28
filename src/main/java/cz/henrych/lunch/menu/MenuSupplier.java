package cz.henrych.lunch.menu;

import org.jsoup.nodes.Document;

public interface MenuSupplier {
    String getName();
    String getUrl();
    String parse(Document doc);
}
