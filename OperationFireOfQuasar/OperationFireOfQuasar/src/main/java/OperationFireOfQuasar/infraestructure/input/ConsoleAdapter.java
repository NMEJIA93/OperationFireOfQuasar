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
    @Autowired
    private QuasarService quasarService;

    public void distanceController() {
        double[] distances = new double[3];
        System.out.println("ingrese la distancia a Kenobi");
        distances[0] = Double.parseDouble(reader.nextLine());
        System.out.println("ingrese la distancia a Skywalker");
        distances[1] = Double.parseDouble(reader.nextLine());
        System.out.println("ingrese la distancia a Sato");
        distances[2] = Double.parseDouble(reader.nextLine());
        try {
            Point origin = quasarService.getLocation(distances);
            System.out.println("el mensaje tiene origen en X:" + origin.getxLocation() + " y Y:" + origin.getyLocation());
        } catch (Exception e) {
            System.out.println("no fue posible determinar el origen");
        }

    }

    public void messageController() {
        System.out.println("ingrese el mensaje de Kenobi separado por comas (en caso de ser cortado ponga dos comas seguidas");
        String messageKenobi = reader.nextLine();
        System.out.println("ingrese el mensaje de Skywalker separado por comas (en caso de ser cortado ponga dos comas seguidas");
        String messageSkywalker = reader.nextLine();
        System.out.println("ingrese el mensaje de Sato separado por comas (en caso de ser cortado ponga dos comas seguidas");
        String messageSato = reader.nextLine();
        String[][] messages = new String[3][];
        messages[0] = messageKenobi.split(",");
        messages[1] = messageSkywalker.split(",");
        messages[2] = messageSato.split(",");
        System.out.println(Arrays.toString(messages[0]));
        System.out.println(Arrays.toString(messages[1]));
        System.out.println(Arrays.toString(messages[2]));
        try {
            String message = quasarService.getMessage(messages);
            System.out.println("el mensaje es : " + message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (StackTraceElement st : e.getStackTrace()) {
                System.out.println(st.toString());
            }
            System.out.println("no fue posible determinar el mensaje");
        }

    }

     public void level1Controller() {

        System.out.println("ingrese el mensaje de Kenobi separado por comas (en caso de ser cortado ponga dos comas seguidas");
        String messageKenobi = reader.nextLine();
        System.out.println("ingrese la distancia a Kenobi");
        double distanceKenobi = Double.parseDouble(reader.nextLine());

        System.out.println("ingrese el mensaje de Skywalker separado por comas (en caso de ser cortado ponga dos comas seguidas");
        String messageSkywalker = reader.nextLine();
        System.out.println("ingrese la distancia a Skywalker");
        double distanceSkywalker = Double.parseDouble(reader.nextLine());

        System.out.println("ingrese el mensaje de Sato separado por comas (en caso de ser cortado ponga dos comas seguidas");
        String messageSato = reader.nextLine();
        System.out.println("ingrese la distancia a Sato");
        double distanceSato = Double.parseDouble(reader.nextLine());

        String[][] messages = new String[3][];
        double[] distances = new double[3];

        distances[0] = distanceKenobi;
        distances[1] = distanceSkywalker;
        distances[2] = distanceSato;

        messages[0] = messageKenobi.split(",");
        messages[1] = messageSkywalker.split(",");
        messages[2] = messageSato.split(",");
        /* System.out.println(Arrays.toString(messages[0]));
        System.out.println(Arrays.toString(messages[1]));
        System.out.println(Arrays.toString(messages[2]));
         */
        try {
            String message = quasarService.getMessage(messages);
            System.out.println("el mensaje es : " + message);

            Point origin = quasarService.getLocation(distances);
            System.out.println("Las Coordenadas del Emisor de mensaje son en X:" + origin.getxLocation() + " y Y:" + origin.getyLocation());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (StackTraceElement st : e.getStackTrace()) {
                System.out.println(st.toString());
            }
            System.out.println("no fue posible determinar el mensaje");
        }

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

    public void setQuasarService(QuasarService quasarService) {
        this.quasarService = quasarService;
    }

}
