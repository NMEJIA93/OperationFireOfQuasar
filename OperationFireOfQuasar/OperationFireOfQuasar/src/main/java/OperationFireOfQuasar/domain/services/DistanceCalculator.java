/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.domain.services;

import java.util.List;
import operationFireOfQuasar.domain.models.Point;
import operationFireOfQuasar.domain.models.Satellite;

/**
 * Service for calculating distances and locations.
 * This service provides methods to calculate the location of a point based on distances from known points.
 * 
 * @autor Norbey
 */
public class DistanceCalculator {

    public static Point getLocation(List<Satellite> satellites) throws Exception {
        validateSatellites(satellites);

        Satellite sKenobi = satellites.get(0);
        Satellite sSkywalker = satellites.get(1);
        Satellite sSato = satellites.get(2);

        double[] kenobiCoordinates = getCoordinates(sKenobi);
        double[] skywalkerCoordinates = getCoordinates(sSkywalker);
        double[] satoCoordinates = getCoordinates(sSato);

        double distanceToKenobi = sKenobi.getMessage().getDistance();
        double distanceToSkywalker = sSkywalker.getMessage().getDistance();
        double distanceToSato = sSato.getMessage().getDistance();

        validateDistances(distanceToKenobi, distanceToSkywalker, distanceToSato);

        return calculateLocation(kenobiCoordinates, skywalkerCoordinates, satoCoordinates, distanceToKenobi, distanceToSkywalker, distanceToSato);
    }

    private static void validateSatellites(List<Satellite> satellites) throws Exception {
        if (satellites.size() < 3) {
            throw new Exception("At least 3 satellites are required to calculate the position.");
        }
    }

    private static double[] getCoordinates(Satellite satellite) {
        return new double[]{satellite.getLocation().getxLocation(), satellite.getLocation().getyLocation()};
    }

    private static void validateDistances(double distanceToKenobi, double distanceToSkywalker, double distanceToSato) throws Exception {
        if (distanceToKenobi == distanceToSkywalker || distanceToKenobi == distanceToSato || distanceToSkywalker == distanceToSato) {
            throw new Exception("Two satellites cannot have the same distance from the emitter.");
        }
    }

    private static Point calculateLocation(double[] kenobiCoordinates, double[] skywalkerCoordinates, double[] satoCoordinates, double distanceToKenobi, double distanceToSkywalker, double distanceToSato) {
        double deltaXKenobiSkywalker = 2 * (skywalkerCoordinates[0] - kenobiCoordinates[0]);
        double deltaYKenobiSkywalker = 2 * (skywalkerCoordinates[1] - kenobiCoordinates[1]);
        double constantKenobiSkywalker = Math.pow(distanceToKenobi, 2) - Math.pow(distanceToSkywalker, 2) - Math.pow(kenobiCoordinates[0], 2) + Math.pow(skywalkerCoordinates[0], 2) - Math.pow(kenobiCoordinates[1], 2) + Math.pow(skywalkerCoordinates[1], 2);

        double deltaXSkywalkerSato = 2 * (satoCoordinates[0] - skywalkerCoordinates[0]);
        double deltaYSkywalkerSato = 2 * (satoCoordinates[1] - skywalkerCoordinates[1]);
        double constantSkywalkerSato = Math.pow(distanceToSkywalker, 2) - Math.pow(distanceToSato, 2) - Math.pow(skywalkerCoordinates[0], 2) + Math.pow(satoCoordinates[0], 2) - Math.pow(skywalkerCoordinates[1], 2) + Math.pow(satoCoordinates[1], 2);

        double x = (constantKenobiSkywalker * deltaYSkywalkerSato - constantSkywalkerSato * deltaYKenobiSkywalker) / (deltaYSkywalkerSato * deltaXKenobiSkywalker - deltaYKenobiSkywalker * deltaXSkywalkerSato);
        double y = (constantKenobiSkywalker * deltaXSkywalkerSato - deltaXKenobiSkywalker * constantSkywalkerSato) / (deltaYKenobiSkywalker * deltaXSkywalkerSato - deltaXKenobiSkywalker * deltaYSkywalkerSato);

        return new Point(x, y);
    }
}