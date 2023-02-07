import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");
        FileManager baconStrip;
        try {
            baconStrip = new FileManager("bacon_strip.txt");
            baconStrip.writeToFile("hello, hi");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(movies.get(0));
        System.out.print("Enter an actor to bacon search: ");
        String actor = scanner.nextLine();

        //Disconnected from the target VM, address: '127.0.0.1:49252', transport: 'socket'
    }

    public static String findConnection(String actor) {

        return null;
    }

    public static String findMovies(String actor, ArrayList<SimpleMovie> movies) {
        ArrayList<SimpleMovie> connectedMovies = new ArrayList();

        for (SimpleMovie movie : movies) {
            if (movie.getActors().indexOf(actor) != -1) connectedMovies.add(movie);
        }

        return null;
    }
}