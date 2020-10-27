public class Main {

    public static void main(String[] args) {

        Imdb imdb = new Imdb();

        //imdb.addMovie(new Movie("First blood 1", 7.7, 1982));
        //imdb.addMovie(new Movie("Terminator 1", 8.0, 1984));
        //imdb.addMovie(new Movie("Fjern mig", 8.0, 1984));
        //imdb.addMovie(new Movie("First blood 1", 7.7, 1982));

        //imdb.showMovies();
        //System.out.println("Nu har vi fjernet en film:");
        //imdb.removeMovie("First blood 1");

        imdb.readMoviesFromFile("imdbfiles.txt");

        imdb.showMovies();
        //imdb.saveMoviesToFile("imdbfiles.txt");

    }
}
