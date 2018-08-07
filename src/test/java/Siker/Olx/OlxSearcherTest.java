package Siker.Olx;

import Siker.Searcher;
import org.junit.Test;

public class OlxSearcherTest {
    @Test
    public void testSearchNotEmpty() {
        OlxSearcher olxSearcher = new OlxSearcher();
        olxSearcher.search(new OlxSearchProperties("kawa", "1", "PRICE_ASCENDING"));
    }
}