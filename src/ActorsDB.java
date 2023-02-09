import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Arrays;

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
                                        finalWriter.write(data[0] + "---" + movies.get(data[0]));
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

    public static String baconSearch(String actor) throws IOException {
        Scanner reader = null; String returnString = "", toSearchFor = actor;

        for (int i = 5, bn = 0; i > -1; i--) {
            reader = new Scanner(new File("src/bacon_strip" + i + ".txt"));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split("---");
                String actors[] = data[1].split(":");

                if (Arrays.asList(actors).contains(toSearchFor)) {
                    bn++;
                    returnString += toSearchFor + " -> " + data[0] + "-> ";
                    if (Arrays.asList(actors).contains("Kevin Bacon"))
                        return returnString + " Kevin Bacon\nBacon number: " + bn;
                    else {
                        toSearchFor = actors[0];
                        returnString += data[0] + " ";
                    }
                }
            }
        }

        return "The actor \"" + actor + "\" cannot be found.";
    }


}
