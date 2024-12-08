import org.code.theater.*;

public class TheaterRunner {
    public static void main(String[] args) {

        /*
         * Read steel coaster names from the file and store them in an array.
         * This will allow the program to access and display the names and speeds later.
         */
        String[] steelNamesArray = FileReader.toStringArray("steelNames.txt");
        String[] woodNamesArray = FileReader.toStringArray("woodNames.txt");
        double[] steelSpeedsArray = FileReader.toDoubleArray("steelSpeeds.txt");
        double[] woodSpeedsArray = FileReader.toDoubleArray("woodSpeeds.txt");
        String[] colorsArray = { "red", "blue", "black", "green", "purple" };

        /*
         * Create a new DataScene object with the data from the files and colors array.
         * This object will hold the coaster data and will be used to create and display scenes.
         */
        DataScene myDataScene = new DataScene(steelSpeedsArray, steelNamesArray, woodSpeedsArray, woodNamesArray, colorsArray);

        /*
         * Create the scenes by iterating through the coaster data.
         * This method processes the coaster information and generates a scene based on it.
         */
        myDataScene.createScene();  

        /*
         * Play the created scenes using the Theater class.
         * This will ensure the scenes are displayed to the user in a theater-like environment.
         */
        Theater.playScenes(myDataScene);  

    }
}
