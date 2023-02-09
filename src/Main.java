import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        File baconStrip = new File("src/bacon_strip0.txt"), secondStrip = new File("src/bacon_strip5.txt");
        Scanner scanner = new Scanner(System.in);

        Hashtable<String, String> movies;
        ActorsDB actorsDB;

        if (!baconStrip.exists() || !secondStrip.exists()) {

            movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");
            actorsDB = new ActorsDB(movies);

            System.out.println("\nDatabases initialized, restart the program.");
        } else {

            String input = "";
            do {
                System.out.print("Enter an actor to bacon search, type \"x\" to exit: ");
                input = scanner.nextLine();
                System.out.println(ActorsDB.baconSearch(input) + "\n");
            } while (!input.equalsIgnoreCase("x"));
        }
    }
}

        //Disconnected from the target VM, address: '127.0.0.1:49252', transport: 'socket'