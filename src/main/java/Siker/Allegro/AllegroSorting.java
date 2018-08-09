package Siker.Allegro;


enum AllegroSorting {
    PRICE_ASCENDING("p"), PRICE_DESCENDING("pd"), NEWEST("n");

    private final String sorting;

    AllegroSorting(String sorting) {
        this.sorting = sorting;
    }

    String getSorting() {
        return this.sorting;
    }
}
