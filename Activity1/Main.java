package Activity1;

// IMPORT FOR SCANNER
import java.util.*;
// IMPORT FOR THE REGULAR EXPRESSION
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){

        // PRINTING TIME : from 'TimePrinter.java'
        println("\nTime:");
        new TimePrinter();
        println("\n");

        // INTRODUCTION
        println("--- Welcome to 'Numbers Printer' ---");
        println("\nThis program accepts number from [0-9],");
        println("and Symbols :  [+, -, *, /, =, :]");
        println("this could also compute basic math e.g., 1+1, 2.37*2.69 ");
        println("but not with numbers that starts with negative");

        // CREATING SCANNER AND 'NumberPrinter' VARIABLE
        Scanner scanner = new Scanner(System.in);
        NumberPrinter num;

        /*  DO WHILE
         *  LOOPS UNTIL THE USER INPUTS 'q' or 'quit'
         *  EITHER UPPERCASE OR LOWERCASE
         */

        do {

            // INPUT MESSAGE
            print("\n\nEnter a Number: ");
            // RECEIVING INPUT : TRIMMING AND REMOVING ALL SPACES
            String input = scanner.nextLine().trim().replaceAll("\\s+","");

            // CHECK IF 'input' IS EITHER 'q' OR 'quit'
            if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {

                println("\n--- Closing Program ---");
                break;
            }

            // CHECK IF INPUT IS NOT VALID
            if (!isValid(input))
                println("\nINVALID INPUT :  '" + input + "'\n");

            // CHECK IF INPUT IS VALID
            else {

                // INITIALIZING num
                num = new NumberPrinter(input);
                // CALLING THE display() FUNCTION OF num
                num.display();
                // CALLING THE calculator() FUNCTION OF num
                num.calculator();
            }
        }
        // ONLY BREAKS IF USER INPUT 'q' OR 'quit'
        while (true);
    }

    // CHECKING IF INPUT HAS ONLY CHARACTERS OF DIGIT AND SYMBOLS : +, =, *, /, ., -
    private static boolean isValid(String input) { return Pattern.matches("[0-9:+=*/.-]+", input); }
    // PRINT FUNCTION NO NEWLINE
    private static void print(Object input) { System.out.print(input); }
    // PRINT FUNCTION WITH NEWLINE
    private static void println(Object input) { System.out.println(input); }
}
