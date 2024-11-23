/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.domain.services;

import java.util.Arrays;
import java.util.List;
import operationFireOfQuasar.domain.models.Satellite;

/**
 *
 * @author Norbey
 */
public class MessageAdapter {
     public static void applyMessages(List<Satellite> satellites, String[][] messages) {
        if (satellites.size() != messages.length) {
            throw new IllegalArgumentException("El número de satélites no coincide con el número de distancias.");
        }

        for (int i = 0; i < satellites.size(); i++) {
            satellites.get(i).getMessage().setMessage(Arrays.asList(messages[i]));
        }
    }
}
