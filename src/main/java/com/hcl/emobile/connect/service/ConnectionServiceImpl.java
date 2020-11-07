package com.hcl.emobile.connect.service;

import com.hcl.emobile.connect.entity.Connection;
import com.hcl.emobile.connect.exception.NotFoundException;
import com.hcl.emobile.connect.model.ConnectionRequest;
import com.hcl.emobile.connect.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class ConnectionServiceImpl implements ConnectionService{
    @Autowired
    ConnectionRepository connectionRepository;
    public int applyConnection(ConnectionRequest connectionRequest) {
        Connection connection = new Connection(new Random().nextInt(), connectionRequest.getFirstName(),
                connectionRequest.getLastName(), connectionRequest.getEmail(), connectionRequest.getMobileNumber(),
                connectionRequest.getPlan(), connectionRequest.getSupportingDocType(), connectionRequest.getSupportingDocNumber(), "In Progress");
        Connection savedConnection = connectionRepository.save(connection);
        return savedConnection.getRequestId();
    }

    public String trackRequest(int requestId) {
        Optional<Connection> connection =  connectionRepository.findById(requestId);
        if(!connection.isPresent()) {
            throw new NotFoundException("Request Id is not present");
        }
        return connection.get().getStatus();
    }

    public List<Connection> listRequests() {
       List<Connection> connectionList = connectionRepository.findAll();
       List<Connection> requestList = connectionList.stream().filter(req ->
           req.getStatus().equals("In Progress")
       ).collect(Collectors.toList());
        return requestList;
    }

    public Connection viewRequestDetails(int requestId) {
        Optional<Connection> connection =  connectionRepository.findById(requestId);
        if(!connection.isPresent()) {
            throw new NotFoundException("Request Id is not present");
        }
        if (connection.get().getStatus().equals("In Progress")) {
            return connection.get();
        }
        throw new NotFoundException("The request in not in In progress status");
    }
}
