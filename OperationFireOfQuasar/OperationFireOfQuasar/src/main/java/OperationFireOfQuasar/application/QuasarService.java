/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.application;

import OperationFireOfQuasar.shared.Const;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import operationFireOfQuasar.domain.models.Message;
import operationFireOfQuasar.domain.models.Point;
import operationFireOfQuasar.domain.models.Satellite;
import operationFireOfQuasar.domain.services.DistanceAdapter;
import operationFireOfQuasar.domain.services.DistanceCalculator;
import operationFireOfQuasar.domain.services.MessageAdapter;
import operationFireOfQuasar.domain.services.MessageConstructor;
import operationFireOfQuasar.infraestructure.output.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Norbey
 */
@Service
public class QuasarService {

    @Autowired
    private SatelliteRepository satelliteRepository;

    public QuasarService(SatelliteRepository satelliteRepository) {
        this.satelliteRepository = satelliteRepository;
        Satellite kenobi = new Satellite(Const.KENOBI, new Point(-500, -200), new Message(0, new ArrayList<String>()));
        Satellite skyWalker = new Satellite(Const.SKYWALKER, new Point(100, -100), new Message(0, new ArrayList<String>()));
        Satellite sato = new Satellite(Const.SATO, new Point(500, 100), new Message(0, new ArrayList<String>()));
        satelliteRepository.save(sato);
        satelliteRepository.save(skyWalker);
        satelliteRepository.save(kenobi);
    }

    public Point getLocation(double[] distances) throws Exception {
        List<Satellite> satellites = satelliteRepository.findAll();
        DistanceAdapter.applyDistances(satellites,distances);
        this.saveInfo(satellites);
        return getLocation();
    }

    public String getMessage(String[][] messages) {
        List<Satellite> satellites = satelliteRepository.findAll();
        MessageAdapter.applyMessages(satellites, messages);
        this.saveInfo(satellites);
        return getMessage();
    }

    public String getMessage() {
        List<Satellite> satellites = satelliteRepository.findAll();
        return MessageConstructor.reconstructMessage(satellites);
    }

    public Point getLocation() throws Exception {
        List<Satellite> satellites = satelliteRepository.findAll();
        return DistanceCalculator.getLocation(satellites);
    }

    public void saveInfo(List<Satellite> satellites) {
        for (Satellite satellite : satellites) {
            satelliteRepository.save(satellite);
        }
    }

    public SatelliteRepository getSatelliteRepository() {
        return satelliteRepository;
    }

    public void setSatelliteRepository(SatelliteRepository satelliteRepository) {
        this.satelliteRepository = satelliteRepository;
    }

    public void updateSatellite(String satelliteName, Point location) throws Exception {

        Satellite existingSatellite = satelliteRepository.findByName(satelliteName)
                .orElseThrow(() -> new Exception("Satellite not found: " + satelliteName));

        existingSatellite.setLocation(location);

        satelliteRepository.save(existingSatellite);
    }

}
