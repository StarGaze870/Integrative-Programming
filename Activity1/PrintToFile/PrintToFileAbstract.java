package Activity1.PrintToFile;

import java.nio.file.Path;

public abstract class PrintToFileAbstract {

    abstract void createFile(Path FilePath);

    abstract void addHistory();

    abstract void viewHistory();
}
