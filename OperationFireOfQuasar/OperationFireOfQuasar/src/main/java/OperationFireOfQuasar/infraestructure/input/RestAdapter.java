/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OperationFireOfQuasar.infraestructure.input;

import OperationFireOfQuasar.infraestructure.input.request.MessageRequest;
import OperationFireOfQuasar.infraestructure.input.request.SatelliteRequest;
import OperationFireOfQuasar.infraestructure.input.request.response.MessageResponse;
import OperationFireOfQuasar.shared.Const;
import operationFireOfQuasar.application.QuasarService;
import operationFireOfQuasar.domain.models.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Norbey
 */
@RestController()
@RequestMapping("/topsecret")
public class RestAdapter {

    @Autowired
    private QuasarService quasarService;

    @PostMapping("/")
    public ResponseEntity messageReconstruction(@RequestBody SatelliteRequest request) {

        if (request.getSatellites().size() != 3) {
            return new ResponseEntity("Invalid number of messages", HttpStatus.BAD_REQUEST);
        }
        try {
            String[][] messages = new String[3][];
            double[] distances = new double[3];
            for (MessageRequest mr : request.getSatellites()) {
                if (mr.getName().equalsIgnoreCase(Const.KENOBI)) {
                    distances[0] = mr.getDistance();
                    messages[0] = mr.getMessage();
                    continue;
                }
                if (mr.getName().equalsIgnoreCase(Const.SKYWALKER)) {
                    distances[1] = mr.getDistance();
                    messages[1] = mr.getMessage();
                    continue;
                }
                if (mr.getName().equalsIgnoreCase(Const.SATO)) {
                    distances[2] = mr.getDistance();
                    messages[2] = mr.getMessage();
                    continue;
                }
                return new ResponseEntity("Invalid name: " + mr.getName(), HttpStatus.BAD_REQUEST);
            }
            Point location = quasarService.getLocation(distances);
            String message = quasarService.getMessage(messages);
            MessageResponse response = new MessageResponse(location, message);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public QuasarService getQuasarService() {
        return quasarService;
    }

    public void setQuasarService(QuasarService quasarService) {
        this.quasarService = quasarService;
    }

}
