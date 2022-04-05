package Activity1;

import java.util.regex.Pattern;

public class StringSeparator {

    // VARIABLES
    private String input;
    private double x;
    private double y;
    private char symbol;

    // CONSTRUCTOR
    StringSeparator(String input) {
        this.input = input;
    }

    public boolean separateStrings() {

        // TRY CATCH IN CASE OF UNSUCCESSFUL PARSING
        try {

            // SPLITTING INPUT FROM [-*/+] CHARACTERS
            String[] nums = getInput().split("[-*/+]");
            // SPLITTING INPUT FROM DIGIT CHARACTERS
            String[] symbolArray = getInput().split("[0-9.0-9]");

            // LOCAL VARIABLE FOR HOW MANY OPERATOR input HAS
            int symbolCount = 0;

            // FOR LOOP FOR GETTING OPERATOR
            for (String s : symbolArray)

                if (Pattern.matches("[-+*/]", s)) {

                    setSymbol(s.charAt(0));
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
