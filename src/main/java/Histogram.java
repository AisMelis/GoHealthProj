import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Histogram {

    public static LinkedHashMap<String, Integer> getHistogram(String str) throws IOException {

        //declaring an LinkedHashMap object to store bigram and count values in key-value pair in preserved order
        LinkedHashMap<String, Integer> bigramCountMap = new LinkedHashMap<>();

        str = fixCaseAndPunctation(str);

        List<String> singleWordsArray = getWordsArrayFromInputString(str);

        if(singleWordsArray.size()<2)
            throw new IOException("Argument is not valid: " + str);

        for(int n = 0; n<singleWordsArray.size() - 1; n++){
            String bigram = singleWordsArray.get(n) + " " + singleWordsArray.get(n+1);
            int count = 0;
            for(int m = 0; m<singleWordsArray.size() - 1; m++){
                String wordsSequence = singleWordsArray.get(m) + " " + singleWordsArray.get(m+1);
                if (bigram.equals(wordsSequence)){
                    count++;
                }
            }

            /*
             * No need to verify if a bigram already exists in LinkedHashMap object,
             * as LinkedHashMap doesn't allow duplicate keys.
             * When adding a duplicate key, the old value pair will be simply replaced.
             */

            bigramCountMap.put(bigram, count);
        }

        return bigramCountMap;
    }

    public static String fixCaseAndPunctation(String str){

        //converting an input string to the same case and exclude punctation marks
        str = str.toLowerCase().replaceAll("[^a-z ]", "");
        return str;

        /*
        //other way to eliminate all punctation marks, if you want to see a logic of implementation
        String punctationMarks[] = {".", ",", ":", ";", "!", "?", "(", ")", "[", "]", "'", "-", "/", "\"" };
        for(int i = 0; i< punctationMarks.length; i++){
            str = str.replace(punctationMarks[i], "");
        }
        */
    }

    public static List<String> getWordsArrayFromInputString(String str){

        List<String> singleWordsAndEmptyStrings = Arrays.asList(str.split(" "));
        List<String> singleWords = new ArrayList<>();

        for(int i = 0; i<singleWordsAndEmptyStrings.size(); i++){
            String strElement = singleWordsAndEmptyStrings.get(i);
            if(!strElement.equals(""))
                singleWords.add(strElement);
        }

        return singleWords;
    }

    //keeping for debugging
    public static void printHistogram(LinkedHashMap<String, Integer> inputMapObject){
        inputMapObject.forEach((k, v) -> System.out.println("\"" + k + "\" " + v));
    }
}