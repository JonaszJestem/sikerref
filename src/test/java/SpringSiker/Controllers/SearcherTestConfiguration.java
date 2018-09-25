package SpringSiker.Controllers;

import Siker.SearchProperties;
import Siker.Searcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@Profile( "test" )
@Configuration
public class SearcherTestConfiguration
{
    @Bean
    @Primary
    public Searcher searcher() throws IOException
    {
        Searcher searcher = mock( Searcher.class );
        when( searcher.search( any( SearchProperties.class ) ) )
                        .thenReturn( Collections.emptyList() );

        return searcher;
    }
}
