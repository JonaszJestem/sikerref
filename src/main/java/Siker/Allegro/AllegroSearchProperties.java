package Siker.Allegro;

import Siker.SearchProperties;

public class AllegroSearchProperties extends SearchProperties {
    public AllegroSearchProperties() {
        urlFormat = "https://allegro.pl/listing?string=%s&order=%s&p=%s";
        sorting = "NEWEST";
        sorting = AllegroSorting.valueOf( sorting ).getSorting();
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
