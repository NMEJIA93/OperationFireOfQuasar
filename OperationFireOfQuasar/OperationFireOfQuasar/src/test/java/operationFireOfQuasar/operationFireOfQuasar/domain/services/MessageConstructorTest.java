/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.operationFireOfQuasar.domain.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import operationFireOfQuasar.domain.models.Message;
import operationFireOfQuasar.domain.models.Point;
import operationFireOfQuasar.domain.models.Satellite;
import operationFireOfQuasar.domain.services.MessageConstructor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Test class for MessageConstructor.
 * This class contains unit tests for the MessageConstructor service.
 * 
 * @autor User
 */
public class MessageConstructorTest {

    @Test
    void testReconstructMessage_withCompleteMessage() {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(4, Arrays.asList("this", "", "", "message", "")));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(4, Arrays.asList("", "is", "", "", "secret")));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(4, Arrays.asList("", "", "a", "", "")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);

        String result = MessageConstructor.reconstructMessage(satellites);

        assertEquals("this is a message secret", result);
    }

    @Test
    void testReconstructMessage_withDuplicateWords1() {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(4, Arrays.asList("", "this", "is", "a", "message", "")));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(4, Arrays.asList("this", "", "", "a", "message")));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(4, Arrays.asList("", "", "is", "", "message")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);

        String result = MessageConstructor.reconstructMessage(satellites);

        assertEquals("this is a message", result);
    }

    @Test
    void testReconstructMessage_withNullAndEmptyValues() {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(3, Arrays.asList("good", "", "")));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(3, Arrays.asList("", "morning", null)));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2);

        String result = MessageConstructor.reconstructMessage(satellites);

        assertEquals("good morning", result);
    }

    @Test
    void testReconstructMessage_withEmptySatelliteList() {
        List<Satellite> satellites = Collections.emptyList();
        String result = MessageConstructor.reconstructMessage(satellites);
        assertEquals("", result);
    }

    @Test
    void testReconstructMessage_withValidMessages() {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(3, Arrays.asList("message", "", "")));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(3, Arrays.asList("", "new", "")));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(3, Arrays.asList("", "", "help")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);
        String result = MessageConstructor.reconstructMessage(satellites);
        assertEquals("message new help", result);
    }

    @Test
    void testReconstructMessage_withEmptyMessages() {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(3, Arrays.asList("", "", "")));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(3, Arrays.asList("", "", "")));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(3, Arrays.asList("", "", "")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);
        String result = MessageConstructor.reconstructMessage(satellites);

        assertEquals("", result);
    }

    @Test
    void testReconstructMessage_withNullAndEmptyValues1() {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(3, Arrays.asList("new", "", null)));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(3, Arrays.asList("", "message", "")));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(3, Arrays.asList(null, null, "help")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);
        String result = MessageConstructor.reconstructMessage(satellites);

        assertEquals("new message help", result);
    }

    @Test
    void testReconstructMessage_withDifferentLengthMessages() {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(2, Arrays.asList("hello", "world")));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(3, Arrays.asList("", "world", "programmer")));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(1, Arrays.asList("hello")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);
        String result = MessageConstructor.reconstructMessage(satellites);
        assertEquals("hello world programmer", result);
    }
}
