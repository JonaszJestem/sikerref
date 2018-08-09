package Siker;


public class Offer {
    private String title;
    private int price;
    private String link;
    private String thumbnail;
    private String site;


    public Offer title(String title) {
        this.title = title;
        return this;
    }

    public Offer thumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public Offer link(String link) {
        this.link = link;
        return this;
    }

    public Offer price(Integer price) {
        this.price = price;
        return this;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
