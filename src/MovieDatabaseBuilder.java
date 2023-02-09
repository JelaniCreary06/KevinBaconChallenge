import java.io.*;
import java.util.Hashtable;
import java.util.Scanner; // Import the Scanner class to read text files

public class MovieDatabaseBuilder {

    public static Hashtable<String, String> getMovieDB(String fileName) {

        Hashtable<String, String> movies = new Hashtable();
        try {
            File movieData = new File(fileName), baconStrip = new File("src/bacon_strip0.txt");
            boolean check = baconStrip.exists();

            FileWriter writer = new FileWriter("src/bacon_strip0.txt", true);
            Scanner reader = new Scanner(movieData);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split("---");
                if (data.length > 1) {
                    movies.put(data[0], data[1]);

                    if (!check && data[1].contains("Kevin Bacon")) writer.write(data[0]+"---"+data[1]+"\n");
                }

            }
        }
        catch (FileNotFoundException noFile) {
            System.out.println("File not found!");
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

}