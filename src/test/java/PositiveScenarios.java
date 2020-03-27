import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.LinkedHashMap;

public class  PositiveScenarios {

    @Test
    public void programShouldHandleSameBigramOfDifferentCases() throws IOException {
        //This test is intended to verify that ProgramCode can handle same bigrams of different cases (upper/lower)properly.
        //inputData: "The quick brown fox and the brown FoX quick blue BROWN fox hare."

        String str = CustomUtilities.getTestData("src/test/TestData/validData2.txt");

        LinkedHashMap<String, Integer> actualHistogram = Histogram.getHistogram(str);

        Assert.assertTrue(actualHistogram.containsKey("brown fox"));
        Assert.assertTrue(actualHistogram.get("brown fox")==3);
    }

    @Test
    public void programShouldHandleBigramsBoardedByPunctationMarks() throws IOException {
        //This test is intended to verify that ProgramCode can handle same bigrams ignoring punctation marks they are scoped in.
        //inputData: "The quick - the quick - brown (the: quick) fox and the "quick" blue hare!"

        String str = CustomUtilities.getTestData("src/test/TestData/validData3.txt");

        LinkedHashMap<String, Integer> actualHistogram = Histogram.getHistogram(str);

        Assert.assertTrue(actualHistogram.containsKey("the quick"));
        Assert.assertTrue(actualHistogram.get("the quick")==4);
    }

    @Test
    public void programShouldHandleBigramsSeparatedByMultipleSpaces() throws IOException {
        //This test is intended to verify that ProgramCode can handle unformated (not autospaced) inputs,
        // for example: same bigrams separated by multiple spaces
        //inputData: "The     quick brown fox and the  quick blue hare."

        String str = CustomUtilities.getTestData("src/test/TestData/validData4.txt");

        LinkedHashMap<String, Integer> actualHistogram = Histogram.getHistogram(str);

        Assert.assertTrue(actualHistogram.containsKey("the quick"));
        Assert.assertTrue(actualHistogram.get("the quick")==2);
    }
}