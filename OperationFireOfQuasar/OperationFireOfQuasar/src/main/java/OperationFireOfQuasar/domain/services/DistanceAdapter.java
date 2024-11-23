/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.domain.services;

import java.util.List;
import operationFireOfQuasar.domain.models.Satellite;

/**
 *
 * @author Norbey
 */
public class DistanceAdapter {
    public static void applyDistances(List<Satellite> satellites, double[] distances) {
        if (satellites.size() != distances.length) {
            throw new IllegalArgumentException("El número de satélites no coincide con el número de distancias.");
        }

        for (int i = 0; i < satellites.size(); i++) {
            satellites.get(i).getMessage().setDistance(distances[i]);
        }
    }
}
