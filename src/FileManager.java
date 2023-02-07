import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class FileManager {
    private File file;
    private String fileName;
    public FileManager(String filename) throws IOException {
        this.fileName = filename;

        file = new File("src\\", fileName);
        file.setReadable(true);
        file.setWritable(true);

        file.createNewFile();
    }

    public void writeToFile(String strObj) {
        try {
            FileWriter fileWriter = new FileWriter(this.file);
            fileWriter.write(strObj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() { return this.fileName; }
}