package Activity1;

// IMPORT FOR THE REGULAR EXPRESSION
import java.util.regex.Pattern;

public class Calculator implements  NumbersAndSymbols {

    // VARIABLES
    private String input;
    private double x;
    private double y;
    private char symbol;

    // CONSTRUCTOR
    Calculator(String input) {

        // SETTING input
        this.input = input;
    }

    public boolean isValid() {

        // TRY CATCH IN CASE OF UNSUCCESSFUL PARSING
        try {

            // SPLITTING INPUT FROM [-*/+] CHARACTERS
            String[] nums = input.split("[-*/+]");
            // SPLITTING INPUT FROM DIGIT CHARACTERS
            String[] symbolArray = input.split("[0-9\\.0-9]");

            // LOCAL VARIABLE FOR HOW MANY OPERATOR input HAS
            int symbolCount = 0;

            // FOR LOOP FOR GETTING OPERATOR
            for (int i = 0; i < symbolArray.length; ++i)

                // CHECK IF symbolArray IS AN OPERATOR
                if (Pattern.matches("[-+*/]", symbolArray[i])) {

                    symbol = symbolArray[i].charAt(0);
                    symbolCount += 1;
                }

            // CHECK IF VARIABLES IS VALID
            if (nums.length != 2 || symbolCount != 1 || !Pattern.matches("[-+*/]", String.valueOf(symbol))) return false;

            else {

                // PARSING VARIABLES TO DOUBLES AND ASSIGNING TO x AND y
                x = Double.parseDouble(nums[0]);
                y = Double.parseDouble(nums[1]);
            }
        }

        // WILL RETURN FALSE IF AN EXCEPTION HAS OCCURRED
        catch (Exception e) { return false; }

        // WILL RETURN TRUE IF EVERYTHING IS SUCCESSFUL
        return true;
    }

    // PUBLIC FUNCTION FOR CALCULATING THE RESULT
    public double calculate() throws Exception{

        switch (symbol) {

            // IF SYMBOL IS ADDITION
            case '+':
            return x + y;

                        // IF SYMBOL IS SUBTRACTION
                        case '-':
                        return x - y;

            // IF SYMBOL IS DIVISION
            case '/':
            // IF y == 0 WILL THROW AN EXCEPTION
            if (y == 0) throw new Exception("\nCannot divide by 0");
            return  x / y;

                        // IF SYMBOL IS MULTIPLICATION
                        case '*':
                        return x * y;

            // IF SYMBOL DOESN'T MATCH WILL RETURN 0
            default:
            return 0;
        }
    }
}

