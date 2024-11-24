/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.infraestructure.output;

/**
 *
 * @author Norbey
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import operationFireOfQuasar.domain.models.Satellite;
import operationFireOfQuasar.domain.repositories.ISatelliteRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SatelliteRepository implements ISatelliteRepository {

    private final Map<String, Satellite> satelliteStorage = new HashMap<>();

    @Override
    public void save(Satellite satellite) {
        satelliteStorage.put(satellite.getName(), satellite);
        //System.out.println("se ha guardado el satelite " + satellite.getName());
    }

    @Override
    public Optional<Satellite> findByName(String name) {
        return Optional.ofNullable(satelliteStorage.get(name));
    }

    @Override
    public void deleteAll() {
        satelliteStorage.clear();
    }

    @Override
    public List<Satellite> findAll() {
        return new ArrayList<>(satelliteStorage.values());
    }
}
