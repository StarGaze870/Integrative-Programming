package Activity1;

// IMPORT FOR DECIMAL FORMAT
import java.text.DecimalFormat;
// IMPORT FOR CALENDAR
import java.util.Calendar;

public class TimePrinter implements NumbersAndSymbols {

    // VARIABLES
    private Calendar cal;
    private NumberPrinter np;
    private DecimalFormat df = new DecimalFormat("###,#00");
    private String date;

    public TimePrinter() {

        // INITIALIZING cal
        cal = Calendar.getInstance();
        // CONSTRUCTING date STRING
        date = df.format(cal.get(Calendar.HOUR)) + ":" + df.format(cal.get(Calendar.MINUTE));
        // INITIALIZING np
        np = new NumberPrinter(date);
        // CALLING saveIndexes FUNCTION FROM np
        np.saveIndexes(date);
        // CALLING display FUNCTION FROM np
        np.display();
    }
}
