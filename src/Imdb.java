import java.util.ArrayList;
import java.util.List;

public class Imdb {

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

    // TODO: saveMoviesToFile



    }

    public void readMoviesFromFile(String fileName){

        // TODO readMoviesFromFile

    }

    public void removeMovie(String title){
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().equalsIgnoreCase(title)){
                movies.remove(i);
            }
        }
    }


}
