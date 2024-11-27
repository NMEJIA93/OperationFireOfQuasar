/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OperationFireOfQuasar.infraestructure.input.request;

/**
 *
 * @author User
 */
public class SatellitePositionRequest {

    private String name;
    private PointRequest location;

    public SatellitePositionRequest(String name, PointRequest location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PointRequest getLocation() {
        return location;
    }

    public void setLocation(PointRequest location) {
        this.location = location;
    }

}
