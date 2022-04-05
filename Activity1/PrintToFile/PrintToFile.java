package Activity1.PrintToFile;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

public class PrintToFile extends PrintToFileAbstract implements PrintToFileInterface{

    private String content;
    private static int position1;

    public PrintToFile() { createFile(FilePath); }

    public void setContent(String content) { this.content = content; }

    @Override
    public void createFile(Path FilePath) {

        try { FilePath.getFileSystem().provider().checkAccess(FilePath); }

        catch(Exception e) {

            try { new BufferedOutputStream(Files.newOutputStream(FilePath,CREATE)); }

            catch (Exception o) { System.err.println("Error in 'Create File' method A" + o.getMessage()); }
        }

        position1 = 0;
        try {

            InputStream input;
            BufferedReader reader;

            String x;

            input = new BufferedInputStream(Files.newInputStream(FilePath));
            reader = new BufferedReader(new InputStreamReader(input));

            x = reader.readLine();

            while(x != null) {

                position1 += RECORD_SIZE;
                x = reader.readLine();
            }

            input.close();
            reader.close();
        }
        catch(Exception e) { System.err.println("Error in 'Create File' method B" + e.getMessage()); }
    }

    @Override
    public void addHistory() {

        try {

            FileChannel fc = (FileChannel) Files.newByteChannel(FilePath, WRITE);

            StringBuffer contentBuilder = new StringBuffer(currentDate() + content);
            contentBuilder.setLength(RECORD_SIZE());
            content = contentBuilder + System.getProperty("line.separator");

            fc.position(position1);
            byte[] data = content.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(data);
            fc.write(buffer);

            position1 += RECORD_SIZE;
            fc.close();
        }
        catch (Exception e) { System.err.println("Add History" + e.getMessage()); }
    }

    @Override
    public void viewHistory() {

        System.out.println("\n--- Viewing History ---\n");
        int count = 0;
        try {

            InputStream input;
            BufferedReader reader;

            input = new BufferedInputStream(Files.newInputStream(FilePath));
            reader = new BufferedReader(new InputStreamReader(input));

            String x = reader.readLine();;

            do {

                count += 1;
                String[] z = x.trim().split(DELIMITER);
                System.out.println(count + ". " + z[0] + "  :  " +  z[1]);

                x = reader.readLine();;
            }
            while(x != null);

            input.close();
            reader.close();
        }
        catch(Exception e) { System.err.println("Error in 'viewHistory' method " + e.getMessage()); }
    }
}
