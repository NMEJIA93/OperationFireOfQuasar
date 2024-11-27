/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OperationFireOfQuasar.infraestructure.input.request.response;

/**
 *
 * @author Norbey
 */
public class Position {
    private double x;
    private double y;

    Position(double xLocation, double yLocation) {
        this.x=xLocation;
        this.y=yLocation;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    
}
