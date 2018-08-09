package Siker.Olx;

import Siker.SearchProperties;

public class OlxSearchProperties extends SearchProperties {
    private final String urlFormat = "https://www.olx.pl/oferty/q-%s/?search[order]=%s&page=%s";
    private final String defaultSorting = "NEWEST";
    protected String sorting = OlxSorting.valueOf(defaultSorting).getSorting();


    public OlxSearchProperties() {
    }

    public OlxSearchProperties query(String query) {
        this.query = query;
        return this;
    }

    public OlxSearchProperties page(int page) {
        this.page = page;
        return this;
    }

    public OlxSearchProperties sorting(String sorting) {
        this.sorting = OlxSorting.valueOf(sorting).getSorting();
        return this;
    }

    public String getFormattedUrl() {
        return String.format(urlFormat, query, sorting, page);
    }

}
