/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OperationFireOfQuasar.infraestructure.input.request;

import java.util.List;

/**
 *
 * @author Norbey
 */
public class SatelliteRequest {
    private List<MessageRequest> satellites;

    public List<MessageRequest> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<MessageRequest> satellites) {
        this.satellites = satellites;
    }
    
    
}
