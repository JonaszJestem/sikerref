package SpringSiker.Controllers;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith( SpringRunner.class )
@WebMvcTest( AllegroController.class )
public class AllegroControllerTest
{
    @Autowired
    private MockMvc mvc;


    @Test
    public void controllerReturnsOkStatusCode() throws Exception
    {
        String query = RandomStringUtils.randomAlphabetic( 10 );

        mvc.perform( get( "/search/allegro?query=" + query )
                        .contentType( MediaType.APPLICATION_JSON ) ).andExpect( status().isOk() );
    }


    @Test
    public void controllerReturnsResults() throws Exception
    {
        String query = "kawa";

        mvc.perform( get( "/search/allegro?query=" + query )
                        .contentType( MediaType.APPLICATION_JSON ) ).andExpect( status().isOk() );
        mvc.perform( get( "/search/allegro?query=" + query )
                        .contentType( MediaType.APPLICATION_JSON ) )
                        .andExpect( content().contentType( MediaType.APPLICATION_JSON ) );
    }
}
