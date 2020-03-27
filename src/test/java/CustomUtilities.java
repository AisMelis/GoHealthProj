import java.io.*;

public class CustomUtilities {
    public static String getTestData(String pathName) throws IOException {
        File inputFile = new File(pathName);
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(inputFile));
        String inputString = br.readLine();

        return inputString;

    }
}

