import org.junit.Assert;
import org.junit.Test;
import ru.s7.stuff.PathUtils;

import java.net.URL;

import static org.junit.Assert.assertTrue;

public class AppPropertyTest {
    @Test
    public void shouldFoundUrlToPropertyFile(){
        URL url = getClass().getClassLoader().getResource("app.properties");
        System.out.println("AppProperty : " + url.getPath());
        assertTrue( !url.getPath().isEmpty() );
    }

    @Test
    public void shouldGetJRXMLfileList(){

            String fullPath = "/Users/ruaiar2/prj/ews/";

            String[] files = new PathUtils().getFiles(fullPath , ".jrxml");

            for(String fileName : files){
                System.out.println("File: " + fileName);
            }


    }

}
