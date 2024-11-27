/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OperationFireOfQuasar.infraestructure.input.request.response;

import operationFireOfQuasar.domain.models.Point;

/**
 *
 * @author Norbey
 */
public class MessageResponse {
    private Position position;
    private String message;

    public MessageResponse(Point location, String message) {
        this.position= new Position(location.getxLocation(),location.getyLocation());
        this.message=message;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
