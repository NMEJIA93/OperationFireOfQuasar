/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.operationFireOfQuasar.application;

import java.util.ArrayList;
import java.util.Arrays;
import operationFireOfQuasar.application.QuasarService;
import operationFireOfQuasar.domain.models.Message;
import operationFireOfQuasar.domain.models.Point;
import operationFireOfQuasar.domain.models.Satellite;
import operationFireOfQuasar.domain.services.DistanceCalculator;
import operationFireOfQuasar.domain.services.MessageConstructor;
import operationFireOfQuasar.infraestructure.output.SatelliteRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author User
 */
public class QuasarServiceUpdateSatelliteTest {
    
    @Mock
    private SatelliteRepository satelliteRepository;

    @InjectMocks
    private QuasarService quasarService;

    @BeforeEach
    public void setUp() {
        // Inicializa los mocks
        MockitoAnnotations.openMocks(this);

        // Crea un mock del repositorio en lugar de usar el repositorio real
        satelliteRepository = mock(SatelliteRepository.class);

        // Inicializa el servicio con el repositorio mockeado
        quasarService = new QuasarService(satelliteRepository);

        // Crear satélites de ejemplo
        Satellite kenobi = new Satellite("kenobi", new Point(-500, -200), new Message(0, new ArrayList<>()));
       

        // Configura el comportamiento mock del repositorio
        when(satelliteRepository.findAll()).thenReturn(Arrays.asList(kenobi));
    }

    @Test
    public void updateSatellite_Success() throws Exception {
        String satelliteName = "kenobi";
        Point newLocation = new Point(200, 300);
        Satellite existingSatellite = new Satellite(satelliteName, new Point(-500, -200), new Message(0, new ArrayList<>()));

        when(satelliteRepository.findByName(satelliteName)).thenReturn(java.util.Optional.of(existingSatellite));

        quasarService.updateSatellite(satelliteName, newLocation);

        assertNotNull(existingSatellite.getLocation());
        assertEquals(newLocation.getxLocation(), existingSatellite.getLocation().getxLocation());
        assertEquals(newLocation.getyLocation(), existingSatellite.getLocation().getyLocation());

  
        verify(satelliteRepository, times(1)).save(existingSatellite);
    }


    @Test
public void updateSatellite_SatelliteNotFound() {
    // Arrange
    String satelliteName = "nonExistingSatellite";
    Point newLocation = new Point(200, 300);

    // Simula que el repositorio no encuentra el satélite
    when(satelliteRepository.findByName(satelliteName)).thenReturn(java.util.Optional.empty());

    // Act & Assert
    Exception exception = assertThrows(Exception.class, () -> {
        quasarService.updateSatellite(satelliteName, newLocation);
    });

    assertEquals("Satellite not found: " + satelliteName, exception.getMessage());

}


}
