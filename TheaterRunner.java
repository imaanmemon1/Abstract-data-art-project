import org.code.theater.*;
import java.util.Scanner;

public class TheaterRunner {
    public static void main(String[] args) {
       /**
         * Read data from files
        */
        String[] steelNamesArray = FileReader.toStringArray("steelNames.txt");
        String[] woodNamesArray = FileReader.toStringArray("woodNames.txt");
        double[] steelSpeedsArray = FileReader.toDoubleArray("steelSpeeds.txt");
        double[] woodSpeedsArray = FileReader.toDoubleArray("woodSpeeds.txt");
        String[] colorsArray = { "red", "blue", "black", "green", "purple" };

      /**
         * Create a DataScene object
        */

        DataScene myDataScene = new DataScene(steelSpeedsArray, steelNamesArray, woodSpeedsArray, woodNamesArray, colorsArray);

        // User interaction to choose coaster type and index
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a coaster type: 1 for Steel, 2 for Wooden");
        int coasterType = scanner.nextInt();
        System.out.println("Enter the index of the coaster (0 to " + (steelSpeedsArray.length - 1) + "):");
        int index = scanner.nextInt();

        // Display chosen coaster's details
        if (coasterType == 1) {
            myDataScene.showSteelCoasterDetails(index);
        } else if (coasterType == 2) {
            myDataScene.showWoodenCoasterDetails(index);
        } else {
            System.out.println("Invalid choice. Displaying all scenes.");
        }

        // Create and play scenes
        myDataScene.createScene();
        Theater.playScenes(myDataScene);

        scanner.close(); // Close the scanner to release resources
    }
}