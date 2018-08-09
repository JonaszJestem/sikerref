package Siker.Allegro;

import Siker.SearchProperties;

public class AllegroSearchProperties extends SearchProperties {
    private final String urlFormat = "https://www.olx.pl/oferty/q-%s/?search[order]=%s&page=%s";
    private final String defaultSorting = "NEWEST";
    protected String sorting = AllegroSorting.valueOf(defaultSorting).getSorting();


    public AllegroSearchProperties() {
    }

    public AllegroSearchProperties query(String query) {
        this.query = query;
        return this;
    }

    public AllegroSearchProperties page(int page) {
        this.page = page;
        return this;
    }

    public AllegroSearchProperties sorting(String sorting) {
        this.sorting = AllegroSorting.valueOf(sorting).getSorting();
        return this;
    }

    public String getFormattedUrl() {
        return String.format(urlFormat, query, sorting, page);
    }

}
