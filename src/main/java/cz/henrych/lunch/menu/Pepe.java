package cz.henrych.lunch.menu;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Pepe implements MenuSupplier {
    public static final String URL = "https://www.jidelnapepe.cz/";
            
    @Override
    public String parse(final Document doc) {
        StringBuilder out =  new StringBuilder();
        out.append("<a href=\"").append(URL).append("\">PePe</a><i>");

        for (Element h1 : doc.select("h1")) {
            if (h1.text().contains(" - ")) {
                out.append(h1.text());
            }
        }

        for (Element h2 : doc.select("h2")) {
            if (h2.text().contains(".")) {
                out.append(h2.text());
            }
        }
        out.append("</i><br/>");

        for (Element table : doc.select("table")) {
            for (Element jidlo : table.select("td.j_jidlo")) {
                out.append(jidlo.text()).append("<br/>");
            }
        }

        return out.toString();
    }

    @Override
    public String getName() {
        return "PePe";
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
