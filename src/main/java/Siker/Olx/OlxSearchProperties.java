package Siker.Olx;

import Siker.SearchProperties;

public class OlxSearchProperties extends SearchProperties {
    public OlxSearchProperties() {
        urlFormat = "https://www.olx.pl/oferty/q-%s/?search[order]=%s&page=%s";
        sorting = "NEWEST";
        sorting = OlxSorting.valueOf( sorting ).getSorting();
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
