package com.hcl.emobile.connect.controller;

import com.hcl.emobile.connect.entity.Connection;
import com.hcl.emobile.connect.model.ConnectionRequest;
import com.hcl.emobile.connect.service.ConnectionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConnectionController {
    Logger logger = LoggerFactory.getLogger(ConnectionController.class);

    @Autowired
    ConnectionServiceImpl connectionServiceImpl;

    @PostMapping("/users/connections")
    public ResponseEntity<Object> applyConnection(@RequestBody ConnectionRequest connectionRequest) {
        int requestId = connectionServiceImpl.applyConnection(connectionRequest);
        return new ResponseEntity<>(requestId, HttpStatus.OK);
    }

    @GetMapping("/users/connections/{requestId}")
    public ResponseEntity<Object> trackRequest(@PathVariable int requestId) {
        String requestIdStatus = connectionServiceImpl.trackRequest(requestId);
        return new ResponseEntity<>(requestIdStatus, HttpStatus.OK);
    }

    @GetMapping("/admin/connections")
    public ResponseEntity<List<Connection>> trackRequest() {
        List<Connection> requests = connectionServiceImpl.listRequests();
        return new ResponseEntity<List<Connection>>(requests, HttpStatus.OK);
    }

    @GetMapping("/admin/connections/{requestId}")
    public ResponseEntity<Connection> viewRequestDetails(@PathVariable int requestId) {
        Connection request = connectionServiceImpl.viewRequestDetails(requestId);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

}
