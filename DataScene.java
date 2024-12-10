import org.code.theater.*;

/**
 * The DataScene class extends the Scene class to visualize roller coaster data.
 * It uses 1D arrays to store coaster names, amusement park names, cities, countries, 
 * and calculates statistical data such as average speeds.
 */
public class DataScene extends Scene {
    // Arrays to hold coaster data
    private double[] speeds;
    private String[] rollercoasterNames;
    private String[] amusementParkNames;
    private String[] cities;
    private String[] countries;
    private String[] textColors;

    // Statistical variables for coaster speeds
    private double averageSpeed;
    private double fastestSpeed;

    // Constants for image paths (you can customize these)
    private static final String COASTER_IMAGE = "coasterImage.jpg";

    /**
     * Constructor for initializing the DataScene object with the given data arrays.
     */
    public DataScene(double[] speeds, String[] rollercoasterNames, String[] amusementParkNames, String[] cities, String[] countries, String[] colors) {
        this.speeds = speeds;
        this.rollercoasterNames = rollercoasterNames;
        this.amusementParkNames = amusementParkNames;
        this.cities = cities;
        this.countries = countries;
        this.textColors = colors;
        calculateStatistics(); // Compute averages and fastest speeds
    }

    /**
     * Calculates the average and fastest speeds for the coasters.
     */
    private void calculateStatistics() {
        fastestSpeed = findMax(speeds);
        averageSpeed = findAverage(speeds);
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
     * Displays details for a roller coaster, including its name, speed, amusement park, city, and country.
     */
    public void showCoasterDetails(int index) {
        String message = getMessage(index);
        drawCoasterDetails("Roller Coaster", message, rollercoasterNames[index], speeds[index], amusementParkNames[index], cities[index], countries[index], COASTER_IMAGE, "silver");
    }

    /**
     * Generates a message for the roller coaster based on its speed.
     */
    private String getMessage(int index) {
        if (speeds[index] == fastestSpeed) {
            return "Fastest Roller Coaster!!";
        } else if (speeds[index] > averageSpeed) {
            return "Amazing Speed!!";
        } else {
            return "Great Ride!";
        }
    }

    /**
     * Draws detailed information about a coaster, including its title, message, 
     * name, speed, and associated visual elements.
     */
    private void drawCoasterDetails(String title, String message, String name, double speed, String parkName, String city, String country, String image, String color) {
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
        drawText("Park: " + parkName, 20, 400);
        drawText("City: " + city, 20, 425);
        drawText("Country: " + country, 20, 450);
        playSound(speed > averageSpeed ? "fast.wav" : "slow.wav");
        pause(2);
    }

    /**
     * Iterates through all coasters to create visual scenes.
     */
    public void createScene() {
        for (int i = 0; i < speeds.length; i++) {
            createCoasterScene(i);
        }
    }

    /**
     * Creates a scene for a specific roller coaster.
     */
    public void createCoasterScene(int index) {
        drawCoasterDetails("Roller Coaster", getMessage(index), rollercoasterNames[index], speeds[index], amusementParkNames[index], cities[index], countries[index], COASTER_IMAGE, "silver");
    }
}