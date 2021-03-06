package util;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.*;

public class TrimmerTest {
    public String str = "ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg ww000004.5kg";
    @Test
    public void trimApply() {
        assertEquals("4.50", Trimmer.trimWeight(str));
    }


//    @Test
    public void hexToString() throws IOException {
        byte[] byteArray = Files.readAllBytes(Path.of("out600_1.bin"));
        String hex = new String(byteArray);
        System.out.println(hex + "->" + hex.substring(6,11));
        assertEquals("2.10",Trimmer.hexToString(hex));
    }

   ///// @Test
    public void hex3000_3002() throws IOException {
        String hex =new String( Files.readAllBytes(Path.of("2_5246866811982449245.htm")));
        assertEquals("2.10",Trimmer.hexToString(hex));
    }

//    @Test
    public void parseWeight() throws IOException {
        var bytes = Files.readAllBytes(Path.of("outRS60_90.bin"));
        System.out.println(new String(bytes));
        assertEquals("90.00", Trimmer.trimApply(Trimmer.parseWeight(new String(bytes))));
    }

//    @Test
    public void parseWeight1900() throws IOException {
        var bytes = Files.readAllBytes(Path.of("out60RS_1900.bin"));
        System.out.println(new String(bytes));
        assertEquals("1900.00", Trimmer.trimApply(Trimmer.parseWeight(new String(bytes))));
    }

//    @Test
    public void parseWeight00() throws IOException {
        var bytes = Files.readAllBytes(Path.of("out60RS0.bin"));
        System.out.println(new String(bytes));
        assertEquals("0.00", Trimmer.trimApply(Trimmer.parseWeight(new String(bytes))));
    }

    @Test
    public void parse3002() throws IOException {
        var bytes = Files.readAllBytes(Path.of("out3002.text"));
        System.out.println(new String(bytes));
        assertEquals("18.00", Trimmer.trimApply(Trimmer.parse3002(new String(bytes))));
    }

    @Test
    public void parse3002__() throws IOException {
        String input = "0=8100000-=8100000-=8100000-=8100";
        assertEquals("-18.00", Trimmer.trimApply(Trimmer.parse3002(input)));
    }
}