/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.domain.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import operationFireOfQuasar.domain.models.Satellite;

/**
 *
 * @author Norbey
 */
public class MessageConstructor {

    public static String reconstructMessage(List<Satellite> satellites) {
        if (satellites.isEmpty()) {
            return "";
        }

        int maxMessageLength = getMaxMessageLength(satellites);
        String[] reconstructedMessage = new String[maxMessageLength];
        List<String> addedWords = new ArrayList<>();

        fillReconstructedMessage(satellites, reconstructedMessage, addedWords);
        fillEmptySlots(reconstructedMessage);

        return String.join(" ", reconstructedMessage).trim();
    }

    private static int getMaxMessageLength(List<Satellite> satellites) {
        int maxMessageLength = 0;
        for (Satellite satellite : satellites) {
            List<String> message = satellite.getMessage().getMessage();
            maxMessageLength = Math.max(maxMessageLength, message.size());
        }
        return maxMessageLength;
    }

    private static void fillReconstructedMessage(List<Satellite> satellites, String[] reconstructedMessage, List<String> addedWords) {
        for (Satellite satellite : satellites) {
            List<String> message = satellite.getMessage().getMessage();
            for (int i = 0; i < message.size(); i++) {
                String word = message.get(i);
                if (word != null && !word.isEmpty() && reconstructedMessage[i] == null && !addedWords.contains(word)) {
                    reconstructedMessage[i] = word;
                    addedWords.add(word);
                }
            }
        }
    }

    private static void fillEmptySlots(String[] reconstructedMessage) {
        for (int i = 0; i < reconstructedMessage.length; i++) {
            if (reconstructedMessage[i] == null) {
                reconstructedMessage[i] = "";
            }
        }
    }
}
