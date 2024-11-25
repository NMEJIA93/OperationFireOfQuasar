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
 *
 * @author User
 */
public class MessageConstructorTest {

    @Test
    void testReconstructMessage_withCompleteMessage() {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(4, Arrays.asList("este", "", "", "mensaje", "")));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(4, Arrays.asList("", "es", "", "", "secreto")));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(4, Arrays.asList("", "", "un", "", "")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);

        String result = MessageConstructor.reconstructMessage(satellites);

        assertEquals("este es un mensaje secreto", result);
    }

    @Test
    void testReconstructMessage_withDuplicateWords() {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(4, Arrays.asList("este", "", "", "mensaje", "")));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(4, Arrays.asList("", "es", "", "", "secreto")));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(4, Arrays.asList("este", "", "un", "", "")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);

        String result = MessageConstructor.reconstructMessage(satellites);

        assertEquals("este es un mensaje secreto", result);
    }

    @Test
    void testReconstructMessage_withNullAndEmptyValues() {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(3, Arrays.asList("buenos", "", "")));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(3, Arrays.asList("", "días", null)));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2);

        String result = MessageConstructor.reconstructMessage(satellites);

        assertEquals("buenos días", result);
    }

    @Test
    void testReconstructMessage_withEmptySatelliteList() {
        // Arrange
        List<Satellite> satellites = Collections.emptyList();

        // Act
        String result = MessageConstructor.reconstructMessage(satellites);

        // Assert
        assertEquals("", result);
    }

    @Test
    void testReconstructMessage_withValidMessages() {
        // Caso 1: Mensajes válidos de satélites que tienen palabras completas y en orden
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(3, Arrays.asList("mensaje", "", "")));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(3, Arrays.asList("", "nuevo", "")));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(3, Arrays.asList("", "", "auxilio")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);

        String result = MessageConstructor.reconstructMessage(satellites);

        assertEquals("mensaje nuevo auxilio", result);
    }

    @Test
    void testReconstructMessage_withEmptyMessages() {
        // Caso 2: Mensajes vacíos de satélites
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(3, Arrays.asList("", "", "")));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(3, Arrays.asList("", "", "")));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(3, Arrays.asList("", "", "")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);

        String result = MessageConstructor.reconstructMessage(satellites);

        assertEquals("", result);
    }

    @Test
    void testReconstructMessage_withNullAndEmptyValues1() {
        // Caso 3: Mensajes con valores null y vacíos
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(3, Arrays.asList("nuevo", "", null)));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(3, Arrays.asList("", "mensaje", "")));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(3, Arrays.asList(null, null, "Auxilio")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);

        String result = MessageConstructor.reconstructMessage(satellites);

        assertEquals("nuevo mensaje Auxilio", result);
    }

    @Test
    void testReconstructMessage_withDifferentLengthMessages() {
        // Caso 4: Mensajes de satélites con diferentes longitudes
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(2, Arrays.asList("hola", "mundo")));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(3, Arrays.asList("", "mundo", "programador")));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(1, Arrays.asList("hola")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);

        String result = MessageConstructor.reconstructMessage(satellites);

        assertEquals("hola mundo programador", result);
    }

}
