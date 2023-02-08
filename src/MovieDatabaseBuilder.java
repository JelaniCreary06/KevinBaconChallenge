import java.io.*;
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class MovieDatabaseBuilder {

    public static ArrayList<SimpleMovie> getMovieDB(String fileName) {

        ArrayList<SimpleMovie> movies = new ArrayList<SimpleMovie>();
        try {
            FileWriter writer = new FileWriter("src/bacon_strip.txt", true);
            File movieData = new File(fileName);
            Scanner reader = new Scanner(movieData);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split("---");
                if (data.length > 1) {
                    SimpleMovie s = new SimpleMovie(data[0], data[1]);
                    movies.add(s);

                    if (data[1].contains("Kevin Bacon")) writer.write(data[0]+"---"+data[1]+"\n");
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