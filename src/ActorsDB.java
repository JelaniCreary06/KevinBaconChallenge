import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class ActorsDB {
    private Hashtable<String, String> movies;

    public ActorsDB(Hashtable<String, String> movies) throws IOException {
        this.movies = movies;

        File currentFile = null;
        FileWriter writer = null;

        for (int i = 1; i < 6; i++) {
            String pathName = "src/bacon_strip" + i + ".txt", toCheckPath = "src/bacon_strip" + (i-1) + ".txt";
            currentFile = new File(pathName);

            if (!currentFile.exists()) {
                writer = new FileWriter(pathName, true);

                try {
                    Scanner reader = new Scanner(new File(toCheckPath));
                    while (reader.hasNextLine()) {
                        String line = reader.nextLine();
                        String[] data = line.split("---");

                        String actors[] = data[1].split(":");

                        for (int j = 0; j < actors.length; j++) {
                            FileWriter finalWriter = writer;
                            int finalJ = j;

                            movies.forEach( (key, value) -> {
                                if (value.indexOf(actors[finalJ]) != -1) {
                                    try {
                                        finalWriter.write("" + actors[finalJ] + "---" + movies.get(data[0]));
                                        System.out.println(actors[finalJ] + "---" + movies.get(data[0]));
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });
                        }

                    }
                } catch (FileNotFoundException noFile) {
                    System.out.println(toCheckPath + " not found!");
                }
            }
        }
    }

    public static String baconSearch(String actor) {
        String returnString = "";
        int baconNumber = 0;

        for (int i = 5; i > -1; i--) {

        }

        return null;
    }


}
