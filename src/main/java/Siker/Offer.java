package Siker;

public class Offer {
    private String title;
    private String price;
    private String link;
    private String thumbnail;
    private String site;

    public Offer(String title, String price, String link, String thumbnail, String site) {
        this.title = title;
        this.price = price;
        this.link = link;
        this.thumbnail = thumbnail;
        this.site = site;
    }

    public String toJSON() {
        return "{" +
                " \"title\": \"" + title + "\", " +
                " \"price\": \"" + price + "\", " +
                " \"img\": \"" + thumbnail + "\", " +
                " \"link\": \"" + link + "\", " +
                " \"site\": \"" + site + "\"" +
                "}";

    }
}
