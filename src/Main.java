import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        File baconStrip = new File("src/REFERENCE.txt"), secondStrip = new File("src/bacon_strip5.txt");
        Scanner scanner = new Scanner(System.in);

        ActorsDB actorsDB;

        if (!baconStrip.exists() || !secondStrip.exists()) {
            final MovieDatabaseBuilder MDB = new MovieDatabaseBuilder();

            actorsDB = new ActorsDB(MDB.getMovieDB("src/movie_data"), MDB.getBaconNumberGraph());

            System.out.println("\nDatabases initialized, restart the program.");
        } else {

            String input = "";
            do {
                System.out.print("Enter an actor to bacon search, type \"x\" to exit: ");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("x") ||input.equals("daDBF")) break;
                //else System.out.println(ActorsDB.baconSearch(input) + "\n");
            } while (!input.equalsIgnoreCase("x") || !input.equals("daDBF"));

            if (input.equals("daDBF")) {
                for (int i = 0; i < 6; i++) {
                    File file = new File("src/bacon_strip" + i + ".txt");
                    file.deleteOnExit();
                }
            }
        }
    }
}

        //Disconnected from the target VM, address: '127.0.0.1:49252', transport: 'socket'