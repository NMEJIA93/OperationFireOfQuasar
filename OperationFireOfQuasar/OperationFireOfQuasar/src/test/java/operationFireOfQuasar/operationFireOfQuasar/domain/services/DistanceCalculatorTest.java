
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.operationFireOfQuasar.domain.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import operationFireOfQuasar.domain.models.Message;
import operationFireOfQuasar.domain.models.Point;
import operationFireOfQuasar.domain.models.Satellite;
import operationFireOfQuasar.domain.services.DistanceCalculator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author User
 */
public class DistanceCalculatorTest {

    @Test
    void testGetLocation_withValidInput() throws Exception {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(5, new ArrayList<>()));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(3, new ArrayList<>()));
        Satellite satellite3 = new Satellite("satellite3", new Point(0, 3), new Message(4, new ArrayList<>()));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);

        Point result = DistanceCalculator.getLocation(satellites);

        assertEquals(4, result.getxLocation(), 0.001, "X-coordinate is incorrect");
        assertEquals(3, result.getyLocation(), 0.001, "Y-coordinate is incorrect");
    }

    @Test
    void testGetLocation_withLessThanThreeSatellites() {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(5, new ArrayList<>()));
        Satellite satellite2 = new Satellite("satellite2", new Point(4, 0), new Message(3, new ArrayList<>()));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2);

        Exception exception = assertThrows(Exception.class, () -> DistanceCalculator.getLocation(satellites));
        assertEquals("At least 3 satellites are required to calculate the position.", exception.getMessage());
        assertEquals("At least 3 satellites are required to calculate the position.", exception.getMessage());
    }

    @Test
    void testGetLocation_withInvalidDistances() {
        Satellite satellite1 = new Satellite("satellite1", new Point(0, 0), new Message(1, new ArrayList<>()));
        Satellite satellite2 = new Satellite("satellite2", new Point(10, 0), new Message(1, new ArrayList<>()));
        Satellite satellite3 = new Satellite("satellite3", new Point(5, 5), new Message(10, new ArrayList<>()));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);

        Exception exception = assertThrows(Exception.class, () -> DistanceCalculator.getLocation(satellites));
        assertEquals("Two satellites cannot have the same distance from the emitter.", exception.getMessage());
    }
}