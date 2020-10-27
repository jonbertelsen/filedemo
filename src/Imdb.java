import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Imdb {

    private final String TITLE = "TITLE";
    private final String RATING = "RATING";
    private final String YEAR = "YEAR";
    private final String BEGIN = "BEGIN";
    private final String END = "END";

    private List<Movie> movies;
    private int counter = 0;

    public Imdb() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    // brugte iter til at lave en for-each skabelon
    public void showMovies(){
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + ", " + movie.getRating() + ", " + movie.getYear());
        }
    }

    public void saveMoviesToFile(String fileName){

    try (PrintWriter writer = new PrintWriter(new File(fileName))) {
        for (Movie movie : movies) {
            writer.println(BEGIN);
            writer.println(TITLE);
            writer.println(movie.getTitle());
            writer.println(RATING);
            writer.println(movie.getRating());
            writer.println(YEAR);
            writer.println(movie.getYear());
            writer.println(END);
        }
    } catch (FileNotFoundException e){
        e.printStackTrace();
    }

    }

    public void readMoviesFromFile(String fileName){
        String line = "";
        String token = "";
        Movie movie = null;

        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)){

            while(scanner.hasNext()){
                line = scanner.nextLine();
                switch(line){
                    case BEGIN:
                        movie = new Movie(); break;
                    case TITLE:
                        token = TITLE; break;
                    case RATING:
                        token = RATING; break;
                    case YEAR:
                        token = YEAR; break;
                    case END:
                        if (movie != null) {
                            movies.add(movie);
                        }
                        break;
                    default:
                        switch (token){
                            case TITLE:
                                movie.setTitle(line);
                                break;
                            case RATING:
                                try {
                                    movie.setRating(Double.parseDouble(line));
                                } catch (Exception e){
                                    System.out.println("Det er ikke en double i rating for: " + movie.getTitle());
                                }
                                break;
                            case YEAR:
                                movie.setYear(Integer.parseInt(line));
                                break;
                        }

                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void removeMovie(String title){
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().equalsIgnoreCase(title)){
                movies.remove(i);
            }
        }
    }


}
