/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.operationFireOfQuasar.integracion;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import operationFireOfQuasar.domain.models.Message;
import operationFireOfQuasar.domain.models.Point;
import operationFireOfQuasar.domain.models.Satellite;
import operationFireOfQuasar.domain.services.DistanceAdapter;
import operationFireOfQuasar.domain.services.DistanceCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DistanceIntegrationTest {

    @Test
    public void testDistanceCalculationIntegration() throws Exception {

        Satellite satellite1 = new Satellite("Kenobi", new Point(-500, -200), new Message(0, Arrays.asList("", "este", "es", "un", "mensaje")));
        Satellite satellite2 = new Satellite("Skywalker", new Point(100, -100), new Message(0, Arrays.asList("este", "", "un", "mensaje")));
        Satellite satellite3 = new Satellite("Sato", new Point(500, 100), new Message(0, Arrays.asList("", "", "es", "", "mensaje")));

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2, satellite3);

     
        double[] distances = {485.32, 265.73, 600.52};
        DistanceAdapter.applyDistances(satellites, distances);


        Point location = DistanceCalculator.getLocation(satellites);

        
        assertNotNull(location);
        System.out.println("Posición calculada: (" + location.getxLocation() + ", " + location.getyLocation() + ")");
        assertEquals(-100, location.getxLocation(), 0.3); 
        assertEquals(75, location.getyLocation(), 0.3);
    }

}
