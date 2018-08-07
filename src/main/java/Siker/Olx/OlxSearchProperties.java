package Siker.Olx;

import Siker.SearchProperties;

public class OlxSearchProperties extends SearchProperties {
    private final String urlFormat = "https://www.olx.pl/oferty/q-%s/?search[order]=%s&page=%s";
    private String sorting;

    public OlxSearchProperties(String query, String page, String sorting) {
        this.query = query;
        this.page = Integer.parseInt(page);
        this.sorting = OlxSorting.getSorting(sorting);
    }

    public String getFormattedUrl() {
        return String.format(urlFormat, query, page, sorting);
    }

}
