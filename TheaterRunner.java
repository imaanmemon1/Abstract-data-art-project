import org.code.theater.*;
import java.util.Scanner;

public class TheaterRunner {
    public static void main(String[] args) {
       /**
         * Read data from files
        */
        // Reading the new data from different files
        String[] rollercoasterNames = FileReader.toStringArray("rollercoasterNames.txt");
        String[] amusementParkNames = FileReader.toStringArray("amusementParkNames.txt");
        String[] cities = FileReader.toStringArray("cities.txt");
        String[] countries = FileReader.toStringArray("countries.txt");

        // Example data for speeds (just placeholders, you can replace with your own data)
        double[] speeds = {75, 80, 85, 90, 95};

        // Example colors (can be random or fixed)
        String[] colorsArray = { "red", "blue", "green", "yellow", "purple" };

        /**
         * Create a DataScene object
        */
        DataScene myDataScene = new DataScene(speeds, rollercoasterNames, amusementParkNames, cities, countries, colorsArray);

        // User interaction to choose coaster type and index
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the index of the roller coaster (0 to " + (rollercoasterNames.length - 1) + "):");
        int index = scanner.nextInt();

        // Display chosen coaster's details
        myDataScene.showCoasterDetails(index);

        // Create and play scenes
        myDataScene.createScene();
        Theater.playScenes(myDataScene);

        scanner.close(); // Close the scanner to release resources
    }
}