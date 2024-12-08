import org.code.theater.*;

public class DataScene extends Scene {
    private double[] steelSpeeds;
    private double[] woodSpeeds;
    private String[] steelNames;
    private String[] woodNames;
    private String[] textColors;
    private double steelAverage;
    private double steelFastest;
    private double woodAverage;
    private double woodFastest;

    /*
     * Constructor for initializing the DataScene object with the data arrays.
     */
    public DataScene(double[] steelSpeeds, String[] steelNames, double[] woodSpeeds, String[] woodNames, String[] colors) {
        this.steelSpeeds = steelSpeeds;
        this.steelNames = steelNames;
        this.woodSpeeds = woodSpeeds;
        this.woodNames = woodNames;
        this.textColors = colors;
        getAverageAndFastest();  // Call method to calculate averages and fastest speeds
    }

    /*
     * Method to calculate the average and fastest speeds for steel and wood coasters.
     */
    private void getAverageAndFastest() {
        double total = 0;
        this.steelFastest = steelSpeeds[0];  // Initialize fastest steel coaster speed
        for (double steelSpeed : steelSpeeds) {
            if (this.steelFastest < steelSpeed) {
                this.steelFastest = steelSpeed;  // Update fastest speed if a new faster speed is found
            }
            total += steelSpeed;  // Sum the steel speeds
        }
        this.steelAverage = total / steelSpeeds.length;  // Calculate the average steel speed

        total = 0;
        this.woodFastest = woodSpeeds[0];  // Initialize fastest wood coaster speed
        for (double woodSpeed : woodSpeeds) {
            if (this.woodFastest < woodSpeed) {
                this.woodFastest = woodSpeed;  // Update fastest speed if a new faster speed is found
            }
            total += woodSpeed;  // Sum the wood speeds
        }
        this.woodAverage = total / woodSpeeds.length;  // Calculate the average wood speed
    }

    /*
     * Show the details for a specific steel coaster at the given index.
     */
    public void showSteelCoasterDetails(int index) {
        String message;
        setTextHeight(25);  // Set text height for the message
        if (steelSpeeds[index] == steelFastest) {
            message = "Fastest Steel Roller Coaster!!";  // Message for the fastest steel coaster
        } else if (steelSpeeds[index] > steelAverage || steelSpeeds[index] > woodFastest) {
            message = "Go go go!!!!!!!!";  // Message for above-average or faster than wood coasters
        } else {
            message = "Yeehaw";  // Message for normal-speed steel coasters
        }
        drawText(message, 20, 325);  // Display the message
        setTextHeight(18);  // Set text height for additional information
        drawText(steelNames[index], 20, 350);  // Display the steel coaster name
        drawText("Speed: " + steelSpeeds[index], 20, 375);  // Display the steel coaster speed
    }

    /*
     * Show the details for a specific wood coaster at the given index.
     */
    public void showWoodenCoasterDetails(int index) {
        String message;
        setTextHeight(25);  // Set text height for the message
        if (woodSpeeds[index] == woodFastest) {
            message = "Fastest Wooden Roller Coaster!!";  // Message for the fastest wood coaster
        } else if (woodSpeeds[index] > woodAverage || woodSpeeds[index] > steelFastest) {
            message = "Hands up!!";  // Message for above-average or faster than steel coasters
        } else {
            message = "Zoom";  // Message for normal-speed wood coasters
        }
        drawText(message, 20, 30);  // Display the message
        setTextHeight(18);  // Set text height for additional information
        drawText(woodNames[index], 20, 55);  // Display the wood coaster name
        drawText("Speed: " + woodSpeeds[index], 20, 80);  // Display the wood coaster speed
    }

    /*
     * Create the scene by iterating through both steel and wooden coasters.
     */
    public void createScene() {
        for (int i = 0; i < steelSpeeds.length; i++) {
            createSteelScene(i);  // Create steel coaster scene
            createWoodenScene(i);  // Create wood coaster scene
        }
    }

    /*
     * Create a scene for a specific wooden coaster at the given index.
     */
    public void createWoodenScene(int index) {
        drawImage("woodcoaster1.jpg", 0, 0, 550);  // Draw the image for the wood coaster scene
        setFillColor("brown");  // Set fill color for the wooden background
        drawRectangle(0, 0, 410, 100);  // Draw a rectangle for the background
        drawRectangle(0, 350, 410, 50);  // Draw a rectangle for the footer
        setTextColor(textColors[1]);  // Set text color for the message
        setTextHeight(34);  // Set text height for the title
        drawText("Wooden Rollercoaster", 40, 390);  // Display the title
        showWoodenCoasterDetails(index);  // Show details for the wood coaster
        playSound("Zoom.wav");  // Play the sound associated with the wooden coaster
        pause(2);  // Pause for 2 seconds
    }

    /*
     * Create a scene for a specific steel coaster at the given index.
     */
    public void createSteelScene(int index) {
        // Title box
        drawImage("yellowRollercoaster.jpg", 0, 0, 450);  // Draw the image for the steel coaster scene
        setFillColor("silver");  // Set fill color for the background
        drawRectangle(0, 0, 410, 50);  // Draw a rectangle for the title background
        // Info box
        drawRectangle(0, 300, 410, 110);  // Draw a rectangle for the info background
        // Title text
        setTextColor("black");  // Set text color for the title
        setTextHeight(34);  // Set text height for the title
        drawText("Steel Rollercoaster", 65, 40);  // Display the title
        showSteelCoasterDetails(index);  // Show details for the steel coaster
        playSound("steel.wav");  // Play the sound associated with the steel coaster
        pause(2);  // Pause for 2 seconds
    }
}
