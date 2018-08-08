package Siker;


public class Offer {
    private String title;
    private String price;
    private String link;
    private String thumbnail;
    private String site;


    public Offer title(String title) {
        this.setTitle(title);
        return this;
    }

    public Offer thumbnail(String thumbnail) {
        this.setThumbnail(thumbnail);
        return this;
    }

    public Offer link(String link) {
        this.setLink(link);
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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
