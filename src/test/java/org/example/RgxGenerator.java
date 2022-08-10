package org.example;

import com.github.curiousoddman.rgxgen.RgxGen;
import com.github.curiousoddman.rgxgen.iterators.StringIterator;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.Optional;

public class RgxGenerator {

    @Test
    public void test()
    {
        RgxGen rgxGen=new RgxGen("[A-Z]{5}\\d{12}");
        Optional<BigInteger> estimation = rgxGen.getUniqueEstimation();
        StringIterator uniqueStrings = rgxGen.iterateUnique();
        String s=rgxGen.generate();
        System.out.println(s);
        System.out.println(estimation);System.out.println(uniqueStrings);

    }
}
