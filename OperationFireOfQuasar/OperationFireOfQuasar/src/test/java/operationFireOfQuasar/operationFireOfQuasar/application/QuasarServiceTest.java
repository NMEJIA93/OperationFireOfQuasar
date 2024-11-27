package operationFireOfQuasar.operationFireOfQuasar.application;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import operationFireOfQuasar.domain.models.Message;
import operationFireOfQuasar.domain.models.Point;
import operationFireOfQuasar.domain.models.Satellite;
import operationFireOfQuasar.domain.services.DistanceAdapter;
import operationFireOfQuasar.domain.services.DistanceCalculator;
import operationFireOfQuasar.domain.services.MessageAdapter;
import operationFireOfQuasar.domain.services.MessageConstructor;
import operationFireOfQuasar.infraestructure.output.SatelliteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import operationFireOfQuasar.application.QuasarService;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;

/**
 *
 * @author NMEJIA
 */
public class QuasarServiceTest {

    @Mock
    private SatelliteRepository satelliteRepository;

    @InjectMocks
    private QuasarService quasarService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Satellite kenobi = new Satellite("kenobi", new Point(-500, -200), new Message(0, new ArrayList<>()));
        Satellite skywalker = new Satellite("skywalker", new Point(100, -100), new Message(0, new ArrayList<>()));
        Satellite sato = new Satellite("sato", new Point(500, 100), new Message(0, new ArrayList<>()));
        when(satelliteRepository.findAll()).thenReturn(Arrays.asList(kenobi, skywalker, sato));
    }

    @Test
    public void testGetLocation() throws Exception {
        double[] distances = {100.0, 115.5, 142.7};
        Point expectedLocation = new Point(-100, 75);

        try (MockedStatic<DistanceCalculator> mockedCalculator = mockStatic(DistanceCalculator.class)) {
            mockedCalculator.when(() -> DistanceCalculator.getLocation(anyList())).thenReturn(expectedLocation);

            Point location = quasarService.getLocation(distances);

            assertNotNull(location);
            assertEquals(expectedLocation.getxLocation(), location.getxLocation());
            assertEquals(expectedLocation.getyLocation(), location.getyLocation());

            verify(satelliteRepository, times(2)).findAll(); 
            verify(satelliteRepository, times(6)).save(any(Satellite.class)); 
        }
    }

    @Test
    public void testGetMessage() {
        String[][] messages = {
            {"este", "", "", "mensaje", ""},
            {"", "es", "", "", "secreto"},
            {"este", "", "un", "", ""}
        };
        String expectedMessage = "este es un mensaje secreto";

        try (MockedStatic<MessageConstructor> mockedConstructor = mockStatic(MessageConstructor.class)) {
            mockedConstructor.when(() -> MessageConstructor.reconstructMessage(anyList())).thenReturn(expectedMessage);

            String message = quasarService.getMessage(messages);

            assertNotNull(message);
            assertEquals(expectedMessage, message);

            verify(satelliteRepository, times(2)).findAll(); 
            verify(satelliteRepository, times(6)).save(any(Satellite.class)); 
        }
    }

    @Test
    public void testGetMessageWithoutArguments() {
        String expectedMessage = "este es un mensaje secreto";

        try (MockedStatic<MessageConstructor> mockedConstructor = mockStatic(MessageConstructor.class)) {
            mockedConstructor.when(() -> MessageConstructor.reconstructMessage(anyList())).thenReturn(expectedMessage);

            String message = quasarService.getMessage();

            assertNotNull(message);
            assertEquals(expectedMessage, message);

            verify(satelliteRepository, times(1)).findAll();
        }
    }

    @Test
    public void testGetLocationWithoutArguments() throws Exception {
        Point expectedLocation = new Point(-100, 75);

        try (MockedStatic<DistanceCalculator> mockedCalculator = mockStatic(DistanceCalculator.class)) {
            mockedCalculator.when(() -> DistanceCalculator.getLocation(anyList())).thenReturn(expectedLocation);

            Point location = quasarService.getLocation();

            assertNotNull(location);
            assertEquals(expectedLocation.getxLocation(), location.getxLocation());
            assertEquals(expectedLocation.getyLocation(), location.getyLocation());

            verify(satelliteRepository, times(1)).findAll();
        }
    }
}

