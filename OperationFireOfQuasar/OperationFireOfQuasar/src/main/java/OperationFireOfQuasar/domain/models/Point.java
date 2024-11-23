/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operationFireOfQuasar.domain.models;



/**
 *
 * @author Norbey
 */

public class Point {
    private double xLocation;
    private double yLocation;

    public Point(double xLocation, double yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public double getxLocation() {
        return xLocation;
    }

    public void setxLocation(double xLocation) {
        this.xLocation = xLocation;
    }

    public double getyLocation() {
        return yLocation;
    }

    public void setyLocation(double yLocation) {
        this.yLocation = yLocation;
    }
    
    
    
}
