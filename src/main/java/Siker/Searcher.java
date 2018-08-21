package Siker;

import java.io.IOException;
import java.util.List;

public interface Searcher {
    List<Offer> search( SearchProperties searchProperties ) throws IOException;
}
