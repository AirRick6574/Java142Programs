import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Weather {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Input file? ");
        String fileName = console.nextLine();

        ArrayList<Double> temperatures = new ArrayList<>();

        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            // Read all numeric tokens
            while (fileScanner.hasNext()) {
                if (fileScanner.hasNextDouble()) {
                    temperatures.add(fileScanner.nextDouble());
                } else {
                    // skip non-numeric tokens
                    fileScanner.next();
                }
            }
            fileScanner.close();

            // Print changes between neighboring days
            for (int i = 0; i < temperatures.size() - 1; i++) {
                double today = temperatures.get(i);
                double tomorrow = temperatures.get(i + 1);
                double change = tomorrow - today;
                System.out.printf("%.1f to %.1f, change = %.1f%n", today, tomorrow, change);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }

        console.close();
    }
}