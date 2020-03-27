import org.testng.annotations.Test;
import java.io.*;
import static org.testng.Assert.assertThrows;

public class NegativeScenarios {

    @Test
    public void programShouldThrowAnExceptionGettingInvalidInputData() throws IOException {
        //testData is empty file
        String str1 = CustomUtilities.getTestData("src/test/TestData/invalidData1.txt");
        assertThrows(() -> Histogram.getHistogram(str1));

        //testData contains symbols only: "{!?./}[+-=]_:)"
        String str2 = CustomUtilities.getTestData("src/test/TestData/invalidData2.txt");
        assertThrows(() -> Histogram.getHistogram(str2));

        //testData consist of a single word: "singleWord"
        String str3 = CustomUtilities.getTestData("src/test/TestData/invalidData3.txt");
        assertThrows(() -> Histogram.getHistogram(str3));
    }


}