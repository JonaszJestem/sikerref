package Siker.Olx;


enum OlxSorting {
    PRICE_ASCENDING("filter_float_price:asc"), PRICE_DESCENDING("filter_float_price:desc"), NEWEST("created_at:desc");

    private final String sorting;

    OlxSorting(String sorting) {
        this.sorting = sorting;
    }

    String getSorting() {
        return this.sorting;
    }
}
