import org.code.theater.*;
import java.util.Random;

/**
 * The DataScene class extends the Scene class to visualize roller coaster data.
 * It uses 1D arrays to store coaster names and speeds, calculates statistical data 
 * such as averages and maximum speeds, and generates visual scenes with detailed 
 * information about steel and wooden roller coasters.
 */
public class DataScene extends Scene {
    // Arrays to hold coaster data
    private double[] steelSpeeds;
    private double[] woodSpeeds;
    private String[] steelNames;
    private String[] woodNames;
    private String[] textColors;

    // Statistical variables for coaster speeds
    private double steelAverage;
    private double steelFastest;
    private double woodAverage;
    private double woodFastest;

    // Constants for image paths
    private static final String WOOD_IMAGE = "woodcoaster1.jpg";
    private static final String STEEL_IMAGE = "yellowRollercoaster.jpg";

    /**
     * Constructor for initializing the DataScene object with the given data arrays.
     */
    public DataScene(double[] steelSpeeds, String[] steelNames, double[] woodSpeeds, String[] woodNames, String[] colors) {
        this.steelSpeeds = steelSpeeds;
        this.steelNames = steelNames;
        this.woodSpeeds = woodSpeeds;
        this.woodNames = woodNames;
        this.textColors = colors;
        getAverageAndFastest(); // Compute averages and fastest speeds
    }

    /**
     * Calculates the average and fastest speeds for both steel and wooden coasters.
     */
    private void getAverageAndFastest() {
        steelFastest = findMax(steelSpeeds);
        steelAverage = findAverage(steelSpeeds);
        woodFastest = findMax(woodSpeeds);
        woodAverage = findAverage(woodSpeeds);
    }

    /**
     * Finds the maximum value in a given array.
     */
    private double findMax(double[] array) {
        double max = array[0];
        for (double value : array) {
            max = Math.max(max, value);
        }
        return max;
    }

    /**
     * Calculates the average value of the elements in an array.
     */
    private double findAverage(double[] array) {
        double total = 0;
        for (double value : array) {
            total += value;
        }
        return total / array.length;
    }

    /**
     * Displays details for a steel coaster, including its name, speed, and a 
     * message indicating its performance.
     */
    public void showSteelCoasterDetails(int index) {
        String message = getSteelMessage(index);
        drawCoasterDetails("Steel Rollercoaster", message, steelNames[index], steelSpeeds[index], STEEL_IMAGE, "silver");
    }

    /**
     * Displays details for a wooden coaster, including its name, speed, and a 
     * message indicating its performance.
     */
    public void showWoodenCoasterDetails(int index) {
        String message = getWoodMessage(index);
        drawCoasterDetails("Wooden Rollercoaster", message, woodNames[index], woodSpeeds[index], WOOD_IMAGE, "brown");
    }

    /**
     * Generates a message for a steel coaster based on its speed.
     */
    private String getSteelMessage(int index) {
        if (steelSpeeds[index] == steelFastest) {
            return "Fastest Steel Roller Coaster!!";
        } else if (steelSpeeds[index] > steelAverage || steelSpeeds[index] > woodFastest) {
            return "Go go go!!!!!!!!";
        } else {
            return "Yeehaw";
        }
    }

    /**
     * Generates a message for a wooden coaster based on its speed.
     */
    private String getWoodMessage(int index) {
        if (woodSpeeds[index] == woodFastest) {
            return "Fastest Wooden Roller Coaster!!";
        } else if (woodSpeeds[index] > woodAverage || woodSpeeds[index] > steelFastest) {
            return "Hands up!!";
        } else {
            return "Zoom";
        }
    }

    /**
     * Draws detailed information about a coaster, including its title, message, 
     * name, speed, and associated visual elements.
     */
    private void drawCoasterDetails(String title, String message, String name, double speed, String image, String color) {
        drawImage(image, 0, 0, 450);
        setFillColor(color);
        drawRectangle(0, 0, 410, 50);
        drawRectangle(0, 300, 410, 110);
        setTextColor("black");
        setTextHeight(34);
        drawText(title, 65, 40);
        setTextHeight(25);
        drawText(message, 20, 325);
        setTextHeight(18);
        drawText(name, 20, 350);
        drawText("Speed: " + Math.round(speed), 20, 375);
        playSound(speed > steelAverage ? "steel.wav" : "Zoom.wav");
        pause(2);
    }

    /**
     * Iterates through all coasters to create visual scenes for both steel and 
     * wooden roller coasters.
     */
    public void createScene() {
        for (int i = 0; i < steelSpeeds.length; i++) {
            createSteelScene(i);
            createWoodenScene(i);
        }
    }

    /**
     * Creates a scene for a specific wooden coaster.
     */
    public void createWoodenScene(int index) {
        drawCoasterDetails("Wooden Rollercoaster", getWoodMessage(index), woodNames[index], woodSpeeds[index], WOOD_IMAGE, "brown");
    }

    /**
     * Creates a scene for a specific steel coaster.
     */
    public void createSteelScene(int index) {
        drawCoasterDetails("Steel Rollercoaster", getSteelMessage(index), steelNames[index], steelSpeeds[index], STEEL_IMAGE, "silver");
    }
}