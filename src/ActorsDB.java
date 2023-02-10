import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Arrays;

public class ActorsDB {
    private Hashtable<String, Hashtable<String, ArrayList<String>>> baconNumberGraph;
    private Hashtable<String, ArrayList<String>> actors;
    private Hashtable<String, ArrayList<String>> movies;


    public ActorsDB(Hashtable<String, ArrayList<String>> movies, Hashtable<String, Hashtable<String, ArrayList<String>>> baconNumberGraph, Hashtable<String, ArrayList<String>> actors) throws IOException {
        this.movies = movies;
        this.actors = actors;
        this.baconNumberGraph = baconNumberGraph;

        for (int i = 1; i < 6; i++) {
            String tableToCreate = "BaconGraph-" + i, tableToCheck = "BaconGraph-" + (i-1);

            baconNumberGraph.computeIfAbsent(tableToCreate, v -> new Hashtable<String, ArrayList<String>>());
            baconNumberGraph.get(tableToCheck).forEach( (movie, actorsList) -> {
                for (int j = 0; j < actorsList.size(); j++) {
                    for (String currentMovie : actors.get(actorsList.get(j))) {
                        baconNumberGraph.get(tableToCreate).put(currentMovie, movies.get(currentMovie));
                    }
                }
            });

            System.out.println(baconNumberGraph.get(tableToCreate));
            System.out.println(tableToCreate + " initialized.");
        }

        File currentFile = null;
        FileWriter writer = null;

        for (int i = 0; i < 6; i++) {
            String path = "src/bacon_graph-" + i + ".txt";
            writer = new FileWriter(path);

            writer.write(String.valueOf(baconNumberGraph.get("BaconGraph-" + i)));

            Scanner reader = new Scanner(new File(path));
            System.out.println(reader.nextLine().split("="));
        }
    }

}