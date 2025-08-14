import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class mostCommonGpt {
	public static String mostCommon(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        String mostCommonWord = null;
        String currentWord = null;
        int maxCount = 0;
        int currentCount = 0;

        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.equals(currentWord)) {
                currentCount++;
            } else {
                currentWord = word;
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostCommonWord = currentWord;
            }
        }

        scanner.close();
        return mostCommonWord;
    }
}
