package Activity1.PrintToFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Calendar;

public interface PrintToFileInterface {

    int RECORD_SIZE = 75;
    String DELIMITER = ",";

    default int RECORD_SIZE() {

        return RECORD_SIZE - System.getProperty("line.separator").length();
    }

    Path FilePath = Paths.get("History.txt").toAbsolutePath();

    default String currentDate() {

        DecimalFormat dateFormat = new DecimalFormat("###,#00");
        Calendar cal = Calendar.getInstance();

        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);;
        int year = cal.get(Calendar.YEAR);;

        return dateFormat.format(month) + "/" + dateFormat.format(day) + "/" + year + DELIMITER;
    }
}
