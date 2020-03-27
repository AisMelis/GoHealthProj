import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BasicAcceptanceTest {

    @Test
    public void histogramShouldContainAllBigramsWithCorrectCounts() throws IOException {
        //Basic Happy Path Scenario Test
        //inputData: "The quick brown fox and the quick blue hare."

        String str = CustomUtilities.getTestData("src/test/TestData/validData1.txt");

        LinkedHashMap<String, Integer> actualHistogram = Histogram.getHistogram(str);

        String[] expectedBigrams = {"the quick", "quick brown", "brown fox", "fox and", "and the", "quick blue", "blue hare"};
        int[] expectedCountValues = {2, 1, 1, 1, 1, 1, 1};

        Assert.assertTrue(actualHistogram.size()==expectedBigrams.length &&
                                    expectedBigrams.length==expectedCountValues.length); //to avoid bugs in testing scripts

        for(int i = 0; i<expectedBigrams.length; i++){
            Assert.assertTrue(actualHistogram.containsKey(expectedBigrams[i]));
            Assert.assertTrue(actualHistogram.get(expectedBigrams[i])==expectedCountValues[i]);
        }
    }

    @Test
    public void caseAndPunctationMarksShouldBeIgnored(){
        String inputStr1 = "ab[rac-a'dab)ra";
        String inputStr2 = "([{Random STRing}])";
        String inputStr3 = "***interesting //task:)";

        String expectedOutput1 = "abracadabra";
        String expectedOutput2 = "random string";
        String expectedOutput3 = "interesting task";

        String actualOutput1 = Histogram.fixCaseAndPunctation(inputStr1);
        String actualOutput2 = Histogram.fixCaseAndPunctation(inputStr2);
        String actualOutput3 = Histogram.fixCaseAndPunctation(inputStr3);

        Assert.assertEquals(actualOutput1, expectedOutput1);
        Assert.assertEquals(actualOutput2, expectedOutput2);
        Assert.assertEquals(actualOutput3, expectedOutput3);
    }

    @Test
    public void notAutoSpacedStringShouldBeValid(){
        String input = " multiple   spaces  ";

        List<String> expectedOutput=new ArrayList<String>(){{add("multiple"); add("spaces");}};
        List<String> actualOutput = Histogram.getWordsArrayFromInputString(input);

        Assert.assertTrue(expectedOutput.size() == 2);
        Assert.assertFalse(actualOutput.contains(""));
        Assert.assertEquals(actualOutput, expectedOutput);
    }
}