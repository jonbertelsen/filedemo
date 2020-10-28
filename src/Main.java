import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        Imdb imdb = new Imdb();
        imdb.readMoviesFromFile("imdbfiles.txt");
        boolean running = true;
        while (running) {
            showMenu();
            int choose = getInt("What do you wanna do? : ");
            switch (choose) {
                case 1:
                    showMovieList(imdb);
                    break;
                case 2:
                    addMovie(imdb);
                    break;
                case 3:
                    removeMovie(imdb);
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
        System.out.println("Goodbye");
    }
    private static void showMenu() {
        System.out.println(" ────────────────────────────────────────────────────────────────");
        System.out.println(" │ " + "[1] Movie list" + " │ " + "[2] Add movie" + " │ " + "[3] Remove movie" + " │ " + "[4] Exit" + " │ ");
        System.out.println(" ────────────────────────────────────────────────────────────────");
    }
    private static void showMovieList(Imdb imdb) {
        System.out.println("\n" + "Movie list :");
        imdb.showMovies();
        System.out.println("\n");
    }
    private static void addMovie(Imdb imdb) {
        String title = getString("Title : ");
        imdb.addMovie(new Movie(title, getDouble("Rating : "), getInt("release year : ")));
        System.out.println(title + " has been added");
        imdb.saveMoviesToFile("imdbfiles.txt");
    }
    private static void removeMovie(Imdb imdb) {
        String title = (getString("Which movie do you wish to remove? : "));
        imdb.removeMovie(title);
        System.out.println(title + " has been removed");
        imdb.saveMoviesToFile("imdbfiles.txt");
    }
    public static String getString(String s) {
        System.out.print(s);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static int getInt(String question) {
        int i;
        while (true) {
            try {
                String answer = getString(question);
                i = Integer.parseInt(answer);
                break;
            } catch (NumberFormatException e) {
                System.out.println("input ikke gyldigt");
            }
        }
        return i;
    }
    public static double getDouble(String question) {
        double i;
        while (true) {
            try {
                String answer = getString(question);
                i = Double.parseDouble(answer);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input ikke gyldigt");
            }
        }
        return i;
    }
}