
public class SPACENEEDLE2 {
    public static final int SIZE = 4;

    public static void main(String[] args) {
        drawNeedle();
        drawTopHalf();
        drawBowl();
        drawBaseNeedle();
        drawBody();
        drawBase();
    }

    // Top vertical needle
    public static void drawNeedle() {
        for (int i = 0; i < SIZE; i++) {
            printSpaces(SIZE * 3);
            System.out.println("||");
        }
    }

    // The widening top cone
    public static void drawTopHalf() {
        for (int line = 1; line <= SIZE; line++) {
            printSpaces((SIZE * 3) - (3 * line));
            System.out.print("__/");
            printRepeated(":", 3 * (line - 1));
            System.out.print("||");
            printRepeated(":", 3 * (line - 1));
            System.out.println("\\__");
        }

        System.out.print("|");
        printRepeated("\"", SIZE * 6);
        System.out.println("|");
    }

    // The lower cone (shrinking part)
    public static void drawBowl() {
        for (int line = 0; line < SIZE; line++) {
            printSpaces(2 * line);
            System.out.print("\\_");
            for (int i = 0; i < (SIZE * 3 - line); i++) {
                System.out.print("/\\");
            }
            System.out.println("_/");
        }
    }

    // Middle repeating vertical needle
    public static void drawBaseNeedle() {
        drawNeedle(); // Reuse the top needle
    }

    // The long vertical body
    public static void drawBody() {
        for (int i = 0; i < SIZE * SIZE; i++) {
            printSpaces(SIZE * 2);
            System.out.println("|%%||%%|");
        }
    }

    // Base repetition of top half
    public static void drawBase() {
        drawTopHalf();
    }

    // Helper method to print n spaces
    public static void printSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    // Helper method to print a character/string multiple times
    public static void printRepeated(String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
    }
}