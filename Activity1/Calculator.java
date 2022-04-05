package Activity1;

public class Calculator extends StringSeparator implements NumbersAndSymbols {

    // CONSTRUCTOR
    Calculator(String input) {

        super(input);
        // SETTING input
        this.setInput(input);
    }

    // CHECK IF VALID
    public boolean isValid() {

        // FROM StringSeparator
        return separateStrings();
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
}

