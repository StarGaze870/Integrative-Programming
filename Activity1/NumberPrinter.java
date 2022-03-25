package Activity1;

public class NumberPrinter extends NumberIdentifier implements NumbersAndSymbols {

    // VARIABLES
    private Calculator calc;
    private int[] indexes;
    private char[] identifier;
    private String input;


    // CONSTRUCTOR
    public NumberPrinter(String input) {

        // SETTING input STRING
        this.input = input;
        // CALLING 'saveIndexes' FUNCTION AND PASSING input VARIABLE
        saveIndexes(input);
    }

    // FROM 'NumberIdentifier.java'
    @Override
    public void saveIndexes(String input) {

        // INITIALIZING indexes AND identifier ARRAY
        indexes = new int[input.length()];
        identifier = new char[input.length()];

        // FOR LOOP for THE STRING input
        for (int i = 0; i < indexes.length; ++i){

            // BOOLEAN FOR IDENTIFYING OUR CHARACTER FROM STRING
            boolean found = false;

            // NUMBERS FOR LOOP
            for (int j = 0; j < NumberChars.length; ++j) {
                // IF CHARACTER FROM STRING IS A DIGIT
                if (input.charAt(i) == NumberChars[j]) {
                    // SAVING INDEXES
                    indexes[i] = j;
                    // SAVING IDENTIFIER
                    identifier[i] = Number;
                    // SETTING found to TRUE
                    found = true;
                    // BREAK FROM FOR LOOP
                    break;
                }
            }
            // SYMBOL FOR LOOP
            for (int j = 0; !found && j < SymbolChars.length; ++j) {
                // IF CHARACTER FROM STRING IS A SYMBOL
                if (input.charAt(i) == SymbolChars[j]) {
                    // SAVING INDEXES
                    indexes[i] = j;
                    // SAVING IDENTIFIER
                    identifier[i] = Symbol;
                    // BREAK FROM FOR LOOP
                    break;
                }
            }
        }
    }

    // FROM 'NumberIdentifier.java'
    @Override
    public void display() {

        println("");

        // FOR LOOP for DISPLAY
        for (int i = 0; i < displayHeight; ++i) {

            // FOR LOOP for INDEXES ARRAY
            for (int j = 0; j < indexes.length; ++j) {

                // PRINTING ROW IF IT IS A DIGIT
                if (identifier[j] == Number) print(NumbersArray[indexes[j]][i]);

                // PRINTING ROW IF IT IS A SYMBOL
                else if (identifier[j] == Symbol) print(SymbolsArray[indexes[j]][i]);
            }
            // NEW LINE FOR NEW ROW
            println("");
        }
    }

    // PUBLIC FUNCTION FOR CALCULATOR
    public void calculator() {

        // INITIALIZING calc
        calc = new Calculator(input);

        // CHECK IF input IS VALID FOR COMPUTATION
        if (calc.isValid()) {

            // TRY CATCH IN CASE OF ARITHMETIC ERROR
            try {

                // LOCAL VARIABLE FOR THE RESULT OF CALCULATION
                double res = calc.calculate();
                String str = String.valueOf(res);

                // IF RESULT IS WHOLE NUMBER IT WILL CONVERT TO INT
                if (res % 1 == 0) str = String.valueOf((int) res);

                // CALLING THE saveIndexes FUNCTION
                saveIndexes(str);
                println("\n\n--- Computed Successfully ---\n");
                // CALLING THE display FUNCTION
                display();
            }
            catch (Exception e) {

                // PRINTING THE ERROR MESSAGE
                print(e.getMessage());
            }
        }
        // IF input HAS NO OPERATOR
        else println("\n--- No valid operator found ---");
    }
}
