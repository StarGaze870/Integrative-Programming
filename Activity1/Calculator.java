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
        this.setInput(input);
    }

    public boolean isValid() {

        // TRY CATCH IN CASE OF UNSUCCESSFUL PARSING
        try {

            // SPLITTING INPUT FROM [-*/+] CHARACTERS
            String[] nums = getInput().split("[-*/+]");
            // SPLITTING INPUT FROM DIGIT CHARACTERS
            String[] symbolArray = getInput().split("[0-9\\.0-9]");

            // LOCAL VARIABLE FOR HOW MANY OPERATOR input HAS
            int symbolCount = 0;

            // FOR LOOP FOR GETTING OPERATOR
            for (int i = 0; i < symbolArray.length; ++i)

                // CHECK IF symbolArray IS AN OPERATOR
                if (Pattern.matches("[-+*/]", symbolArray[i])) {

                    setSymbol(symbolArray[i].charAt(0));
                    symbolCount += 1;
                }

            // CHECK IF VARIABLES IS VALID
            if (nums.length != 2 || symbolCount != 1 || !Pattern.matches("[-+*/]", String.valueOf(getSymbol()))) return false;

            else {

                // PARSING VARIABLES TO DOUBLES AND ASSIGNING TO x AND y
                setX(Double.parseDouble(nums[0]));
                setY(Double.parseDouble(nums[1]));
            }
        }

        // WILL RETURN FALSE IF AN EXCEPTION HAS OCCURRED
        catch (Exception e) { return false; }

        // WILL RETURN TRUE IF EVERYTHING IS SUCCESSFUL
        return true;
    }

    // PUBLIC FUNCTION FOR CALCULATING THE RESULT
    public double calculate() throws Exception{

        switch (getSymbol()) {

            // IF SYMBOL IS ADDITION
            case '+':
            return getX() + getY();

                        // IF SYMBOL IS SUBTRACTION
                        case '-':
                        return getX() - getY();

            // IF SYMBOL IS DIVISION
            case '/':
            // IF y == 0 WILL THROW AN EXCEPTION
            if (getY() == 0) throw new Exception("\nCannot divide by 0");
            return  getX() / getY();

                        // IF SYMBOL IS MULTIPLICATION
                        case '*':
                        return getX() * getY();

            // IF SYMBOL DOESN'T MATCH WILL RETURN 0
            default:
            return 0;
        }
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}

