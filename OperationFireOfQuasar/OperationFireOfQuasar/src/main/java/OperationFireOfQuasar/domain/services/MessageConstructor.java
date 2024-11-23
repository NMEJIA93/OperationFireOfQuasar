/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.domain.services;

import java.util.ArrayList;
import java.util.List;
import operationFireOfQuasar.domain.models.Satellite;

/**
 *
 * @author Norbey
 */
public class MessageConstructor {

    public static String reconstructMessage(List<Satellite> satellites) {
        List<String> reconstructedMessage = new ArrayList<String>();
        List<String> addedWords = new ArrayList<>();

        for (Satellite satellite : satellites) {
            List<String> message = satellite.getMessage().getMessage();
            for (String word : message) {
                if (word != null && !word.equals("") && !addedWords.contains(word)) {
                    reconstructedMessage.add(word);
                    addedWords.add(word);
                }
            }
        }

        return String.join(" ", reconstructedMessage);
    }

}
