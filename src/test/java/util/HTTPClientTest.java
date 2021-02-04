package util;


import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class HTTPClientTest {
    String fn = "out.bin";
    String fn2 = "out.text";
    String url ="http://192.168.22.3:4567/get-weight?scaleId=4";
    @Test
    public void getGETResponcebinary() throws IOException, InterruptedException {
        var fos = new FileOutputStream(fn);
        fos.write(HTTPClient.getGETResponcebinary(url));
        fos.close();
    }

    @Test
    public void getGETResponcebinary2() throws IOException, InterruptedException {
        var fos = new FileOutputStream(fn2);
        fos.write(HTTPClient.getGETResponceString(url).getBytes());
        fos.close();
    }


}