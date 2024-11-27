/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package operationFireOfQuasar.domain.repositories;

import java.util.List;
import java.util.Optional;
import operationFireOfQuasar.domain.models.Satellite;

/**
 *
 * @author Norbey
 */
public interface ISatelliteRepository {
   
    void save(Satellite satellite);
    Optional<Satellite> findByName(String name);
    void deleteAll();
    List<Satellite>  findAll();
}


