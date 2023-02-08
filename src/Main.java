import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Hashtable<String, String> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");

        ActorsDB actorsDatabase = new ActorsDB(movies);

        System.out.println(movies.get(0));
        System.out.print("Enter an actor to bacon search: ");


        //Disconnected from the target VM, address: '127.0.0.1:49252', transport: 'socket'
    }
}