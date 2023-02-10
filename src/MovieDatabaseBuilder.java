import java.io.*;
import java.util.*;

public class MovieDatabaseBuilder {
    private  Hashtable<String, Hashtable<String, ArrayList<String>>> baconNumberGraph;
    private Hashtable<String, ArrayList<String>> actors;

    public Hashtable<String, ArrayList<String>> getMovieDB(String fileName) {

        Hashtable<String, ArrayList<String>> movies = new Hashtable();
        baconNumberGraph = new Hashtable<>();
        actors = new Hashtable<>();

        try {
            File movieData = new File(fileName);
            Scanner reader = new Scanner(movieData);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                if (line.indexOf("|") != -1) {
                    StringBuilder tempLine = new StringBuilder(line);
                    while (tempLine.indexOf("|") != -1) {
                        int index = tempLine.indexOf("|");
                        tempLine.setCharAt(index, ':');
                    }
                    line = tempLine.toString();
                }

                String[] data = line.split("---");

                if (data.length > 1) {
                    movies.put(data[0], new ArrayList(Arrays.asList(data[1].split(":"))));

                    String actorsList[] = data[1].split(":");

                    for (int i = 0; i < actorsList.length; i++) {
                        actors.computeIfAbsent(actorsList[i], k -> new ArrayList<>(Arrays.asList(data[0])));
                        if (!actors.get(actorsList[i]).contains(data[0])) actors.get(actorsList[i]).add(data[0]);
                        System.out.println(actors.get(actorsList[i]));
                    }

                    if (data[1].contains("Kevin Bacon")) {
                        if (baconNumberGraph.get("BaconGraph-0") == null) {
                            baconNumberGraph.put("BaconGraph-0", new Hashtable<String, ArrayList<String>>(
                                    Map.of(data[0], new ArrayList<String>(
                                            Arrays.asList(data[1].split(":"))
                                    ))
                            ));
                        } else if (baconNumberGraph.get("BaconGraph-0").get(data[0]) == null) {

                            baconNumberGraph.get("BaconGraph-0").put(data[0], new ArrayList<>(
                                    Arrays.asList(data[1].split(":"))
                            ));
                        }
                        System.out.println(baconNumberGraph);
                    }
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

    public Hashtable<String, Hashtable<String, ArrayList<String>>> getBaconNumberGraph() { return this.baconNumberGraph; }
    public Hashtable<String, ArrayList<String>> getActors() { return this.actors; }

}