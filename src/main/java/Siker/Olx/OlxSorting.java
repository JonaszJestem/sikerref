package Siker.Olx;


class OlxSorting {

    static String getSorting(String sorting) {
        if(sorting.equalsIgnoreCase("PRICE_ASCENDING")) {
            return "filter_float_price:asc";
        }
        if(sorting.equalsIgnoreCase("PRICE_DESCENDING")) {
            return "filter_float_price:desc";
        }
        return "";
    }
}
