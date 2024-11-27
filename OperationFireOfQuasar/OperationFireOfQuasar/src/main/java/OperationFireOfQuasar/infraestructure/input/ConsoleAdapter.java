/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.infraestructure.input;

import java.util.Arrays;
import java.util.Scanner;
import operationFireOfQuasar.application.QuasarService;
import operationFireOfQuasar.domain.models.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Norbey
 */
@Controller
public class ConsoleAdapter {

    private static Scanner reader = new Scanner(System.in);
    private final QuasarService quasarService;

    @Autowired
    public ConsoleAdapter(QuasarService quasarService) {
        this.quasarService = quasarService;
    }

    public void distanceController() {
        double[] distances = new double[3];
        distances[0] = getDistanceFromUser("Kenobi");
        distances[1] = getDistanceFromUser("Skywalker");
        distances[2] = getDistanceFromUser("Sato");
        try {
            Point origin = quasarService.getLocation(distances);
            System.out.println("The message originates from X: " + origin.getxLocation() + " and Y: " + origin.getyLocation());
        } catch (Exception e) {
            System.out.println("Unable to determine the origin.");
        }
    }

    public void messageController() {
        String[][] messages = new String[3][];
        messages[0] = getMessageFromUser("Kenobi");
        messages[1] = getMessageFromUser("Skywalker");
        messages[2] = getMessageFromUser("Sato");
        try {
            String message = quasarService.getMessage(messages);
            System.out.println("The message is: " + message);
        } catch (Exception e) {
            System.out.println("Unable to determine the message.");
        }
    }

    public void level1Controller() {
        String[][] messages = new String[3][];
        double[] distances = new double[3];

        messages[0] = getMessageFromUser("Kenobi");
        distances[0] = getDistanceFromUser("Kenobi");

        messages[1] = getMessageFromUser("Skywalker");
        distances[1] = getDistanceFromUser("Skywalker");

        messages[2] = getMessageFromUser("Sato");
        distances[2] = getDistanceFromUser("Sato");

        try {
            String message = quasarService.getMessage(messages);
            System.out.println("The message is: " + message);

            Point origin = quasarService.getLocation(distances);
            System.out.println("The coordinates of the message sender are X: " + origin.getxLocation() + " and Y: " + origin.getyLocation());
        } catch (Exception e) {
            System.out.println("Unable to determine the message.");
        }
    }

    private double getDistanceFromUser(String satelliteName) {
        System.out.println("Enter the distance to " + satelliteName);
        return Double.parseDouble(reader.nextLine());
    }

    private String[] getMessageFromUser(String satelliteName) {
        System.out.println("Enter the message from " + satelliteName + " separated by commas (if cut off, put two commas in a row)");
        return reader.nextLine().split(",");
    }

    public static Scanner getReader() {
        return reader;
    }

    public static void setReader(Scanner reader) {
        ConsoleAdapter.reader = reader;
    }

    public QuasarService getQuasarService() {
        return quasarService;
    }

}
