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
        validateInput(satellites, messages);
        setMessages(satellites, messages);
    }

    private static void validateInput(List<Satellite> satellites, String[][] messages) {
        if (satellites.size() != messages.length) {
            throw new IllegalArgumentException("The number of satellites does not match the number of messages.");
        }
    }

    private static void setMessages(List<Satellite> satellites, String[][] messages) {
        for (int i = 0; i < satellites.size(); i++) {
            satellites.get(i).getMessage().setMessage(Arrays.asList(messages[i]));
        }
    }
}
