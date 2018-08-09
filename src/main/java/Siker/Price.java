package Siker;

public class Price {
    private int priceInCents;
    private String noDigits = "[^0-9]*";

    public Price(String price) {
        this.priceInCents = parsePrice(price);
    }

    private int parsePrice(String price) {
        if(price.matches(noDigits)) {
            return 0;
        }
        else if(price.contains(",")) {
            String[] splitPrice = price.split(",");
            splitPrice[0] = splitPrice[0].replaceAll(noDigits, "");
            int priceInCents = Integer.parseInt(splitPrice[0])*100;

            splitPrice[1] = splitPrice[1].replaceAll(noDigits, "");
            priceInCents += Integer.parseInt(splitPrice[1]);
            return priceInCents;
        }
        else {
            price = price.replaceAll(noDigits, "");
            return Integer.parseInt(price)*100;
        }
    }

    public int getValue() {
        return priceInCents;
    }

    public double getPrice() {
        return priceInCents/100.0;
    }
}
