/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.domain.services;

import java.util.List;
import operationFireOfQuasar.domain.models.Point;
import operationFireOfQuasar.domain.models.Satellite;

/**
 *
 * @author Norbey
 */
public class DistanceCalculator {

    public static Point getLocation(List<Satellite> satellites) throws Exception {
        if (satellites.size() < 3) {
            throw new Exception("Se requieren al menos 3 satélites para calcular la posición.");
        }

        Satellite s1 = satellites.get(0);
        Satellite s2 = satellites.get(1);
        Satellite s3 = satellites.get(2);

        double[] p1 = {s1.getLocation().getxLocation(), s1.getLocation().getyLocation()};
        double[] p2 = {s2.getLocation().getxLocation(), s2.getLocation().getyLocation()};
        double[] p3 = {s3.getLocation().getxLocation(), s3.getLocation().getyLocation()};

        double d1 = s1.getMessage().getDistance();
        double d2 = s2.getMessage().getDistance();
        double d3 = s3.getMessage().getDistance();

        double A = 2 * (p2[0] - p1[0]);
        double B = 2 * (p2[1] - p1[1]);
        double C = Math.pow(d1, 2) - Math.pow(d2, 2) - Math.pow(p1[0], 2) + Math.pow(p2[0], 2) - Math.pow(p1[1], 2) + Math.pow(p2[1], 2);
        double D = 2 * (p3[0] - p2[0]);
        double E = 2 * (p3[1] - p2[1]);
        double F = Math.pow(d2, 2) - Math.pow(d3, 2) - Math.pow(p2[0], 2) + Math.pow(p3[0], 2) - Math.pow(p2[1], 2) + Math.pow(p3[1], 2);

        double x = (C * E - F * B) / (E * A - B * D);
        double y = (C * D - A * F) / (B * D - A * E);

        return new Point(x, y);
    }
}


