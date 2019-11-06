import org.junit.Assert;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertTrue;

public class AppPropertyTest {
    @Test
    public void shouldFoundUrlToPropertyFile(){
        URL url = getClass().getClassLoader().getResource("app.properties");
        System.out.println("AppProperty : " + url.getPath());
        assertTrue( !url.getPath().isEmpty() );
    }

}
