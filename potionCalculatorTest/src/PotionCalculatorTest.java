import java.util.Arrays;
import java.util.List;

/*
    Test of CS 142 Assignment 1 by David Anderson.
    Version: 1/15/2023

    You may only use this program as a student at Tacoma Community College, CS 142 Summer 2025.

    Directions: Run this program from the same project source folder as your
    PotionCalculator.java file.
 */
public class PotionCalculatorTest {
    private enum Ingredient {
        MUSHROOM ("bagsOfMushroomPowder"),
        RADISH("cartonsOfRadishes"),
        ACORN("pouchesOfAcorns"),
        RUBY("containersOfRubyDust"),
        SAPPHIRE("containersOfSapphireDust"),
        MINT("bagsOfMint"),
        SOLVENT("bottlesOfSolvent");

        private final String method;

        Ingredient(String method) {
            this.method = method;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                "=======================================================================================\n"+
                        "Tester for CS 143 Assignment 1: Potion Calculator\n"+
                        "=======================================================================================\n"+
                        "* This tester checks your code for accuracy and provides feedback on inaccurate results.\n"+
                        "* Errors indicated by the tester should be fixed in your code. Re-run the tester after \n\t" +
                        "fixing them to check your code again.\n"+
                        "* If the tester finds no errors in your code, you should see a message at the bottom \n\t" +
                        "indicating that all tests passed.\n"+
                        "=======================================================================================\n"
        );

        int testSize = 10;
        int passed = 0;
        boolean problems = false;

        int[][] health = {
                {0, 1, 12, 24, 30, 45, 30, 30, 100, 200},   // MUSHROOM
                {0, 1, 12, 24, 48, 49, 100, 200, 300, 350}, // RADISH
                new int[10],                                // ACORN
                {0, 1, 12, 24, 72, 73, 100, 144, 145, 200}, // RUBY
                new int[10],                                // SAPPHIRE
                {0, 1, 12, 24, 30, 45, 30, 30, 100, 200},   // MINT
                {0, 1, 12, 24, 30, 50, 64, 96, 100, 200}    // SOLVENT
        };

        int[][] mana = {
                {0, 1, 8, 16, 20, 20, 45, 45, 100, 200},    // MUSHROOM
                new int[10],                                // RADISH
                {0, 1, 8, 16, 32, 64, 65, 96, 128, 129},    // ACORN
                new int[10],                                // RUBY
                {0, 1, 8, 16, 24, 25, 32, 40, 96, 100},     // SAPPHIRE
                {0, 1, 8, 16, 20, 20, 45, 45, 100, 200},    // MINT
                {0, 1, 8, 16, 20, 30, 32, 64, 100, 200}     // SOLVENT
        };

        int[][] expected = {
                {0, 1, 1, 2, 2, 3, 4, 4, 8, 16},            // MUSHROOM
                {0, 1, 1, 1, 1, 2, 3, 5, 7, 8},             // RADISH
                {0, 1, 1, 1, 1, 1, 2, 2, 2, 3},             // ACORN
                {0, 1, 1, 1, 2, 3, 3, 4, 5, 6},             // RUBY
                {0, 1, 1, 2, 2, 3, 3, 4, 8, 9},             // SAPPHIRE
                {0, 1, 2, 4, 5, 6, 8, 8, 19, 38},           // MINT
                {0, 1, 1, 1, 2, 2, 3, 4, 5, 9}              // SOLVENT
        };

        List<Ingredient> ingredients = Arrays.asList(Ingredient.values());
        for(int i = 0; i < ingredients.size(); i++){
            Ingredient ingredient = ingredients.get(i);
            passed = ingredientTest(ingredient, health[i], mana[i], expected[i]);
            problems = problems | methodProblems(ingredient, passed, testSize);
        }

        if(problems){
            System.out.println("\n=======================================================================================\n" +
                    "Some problems were found with your code. Please see the " +
                    "feedback above and run the test \n\tagain." +
                    "\n=======================================================================================\n");
        }
        else{
            System.out.println("\n=======================================================================================\n" +
                    "All tests passed. Fantastic!" +
                    "\n\tNote that the tester does not test the totalCost method. To test it, you could calculate\n" +
                            "\tthe cost of x number of health potion doses and y number of mana potion doses, then call your totalCost\n" +
                            "\tmethod in main to see if the expected result matches the actual result." +
                    "\n=======================================================================================\n");
        }

        System.out.println("=======================================================================================");
        System.out.println("* Please see the rubric on Canvas for a breakdown of how your grade will be calculated.");
        System.out.println("* Make sure your code has proper indentation and formatting.");
        System.out.println("* Be sure each method and class declaration has a correct Javadoc comment above it.");
        System.out.println("* Also do not forget to put a block comment at the top with your name and a description \n\tof the PotionCalculator class!");
        System.out.println("=======================================================================================");

    }

    private static int ingredientTest(Ingredient ingredient, int[] healthIn, int[] manaIn, int[] expectedOut) {
        System.out.println("Testing the " + ingredient.method + " method...");
        int res = 0;
        for(int i = 0; i < healthIn.length; i++){
            int hp = healthIn[i];
            int mp = manaIn[i];
            int expected = expectedOut[i];
            int actual = callForIngredient(ingredient, hp, mp);
            if(actual != expected){
                System.out.println("For numHealthPotionDoses = " + hp + ", and numManaPotionDoses = " + mp + ", I expected a result of " + expected + " but got " + actual);
            }
            else{
                res++;
            }
        }
        return res;
    }

    private static int callForIngredient(Ingredient ingredient, int healthPotions, int manaPotions){
        switch (ingredient){
            case MUSHROOM: return PotionCalculator.bagsOfMushroomPowder(healthPotions, manaPotions);
            case RADISH: return PotionCalculator.cartonsOfRadishes(healthPotions, manaPotions);
            case ACORN: return PotionCalculator.pouchesOfAcorns(healthPotions, manaPotions);
            case RUBY: return PotionCalculator.containersOfRubyDust(healthPotions, manaPotions);
            case SAPPHIRE: return PotionCalculator.containersOfSapphireDust(healthPotions, manaPotions);
            case MINT: return PotionCalculator.bagsOfMint(healthPotions, manaPotions);
            case SOLVENT: return PotionCalculator.bottlesOfSolvent(healthPotions, manaPotions);
            default: return 0;
        }
    }

    private static boolean methodProblems(Ingredient ingredient, int passed, int total){
        if(passed == total){
            System.out.println("All tests passed for the " + ingredient.method + " method!\n");
            return false;
        }
        else{
            System.out.println("Some tests for the " + ingredient.method + " method returned unexpected results.\n");
            return true;
        }
    }

}
