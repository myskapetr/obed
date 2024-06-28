package cz.henrych.lunch.menu;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Cube implements MenuSupplier {
    public static final String URL = "https://www.freshandtasty.cz/cz/firmy/cube-bistro/menu/obedy";

    @Override
    public String getName() {
        return "Cube bistro";
    }

    @Override
    public String getUrl() {
        return URL;
    }

    public String parse(Document doc) {
        StringBuilder out =  new StringBuilder();
        out.append("<a href=\"").append(URL).append("\">Cube bistro</a><br/>");

        for (Element sec : doc.select("div.meal__items:nth-child(2) > div")) {
            final Element type = sec.selectFirst("p.meal__item--first");
            final Element name = sec.selectFirst("div.meal__item--second > p");
            final Element price = sec.selectFirst("p.meal__item--third");
            final Element price2 = sec.selectFirst("p.meal__item--fourth");

            if (name != null && name.hasText()){
                out
                    .append("<small><i>")
                    .append(type.text())
                    .append("</small></i> ")
                    .append(" ")
                    .append(name.text())
                    .append(" ")
                    .append(price.text())
                    .append(" (<small>")
                    .append(price2.text())
                    .append("</small>)<br/>\n");
            }
        }

        out.append("<br/>");

        return out.toString();
    }
    
    public static void main(String[] args) throws IOException {
        Cube p = new Cube();
        Document doc = Jsoup.connect(URL).get();
        System.out.println(p.parse(doc));
    }
}
