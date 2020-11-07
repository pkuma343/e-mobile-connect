package com.hcl.emobile.connect.service;

import com.hcl.emobile.connect.entity.Connection;
import com.hcl.emobile.connect.model.ConnectionRequest;
import com.hcl.emobile.connect.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.UUID;

@Component
public class ConnectionServiceImpl implements ConnectionService{
    @Autowired
    ConnectionRepository connectionRepository;
    public String applyConnection(ConnectionRequest connectionRequest) {
        Connection connection = new Connection(UUID.randomUUID(), connectionRequest.getFirstName(),
                connectionRequest.getLastName(), connectionRequest.getEmail(), connectionRequest.getMobileNumber(),
                connectionRequest.getPlan(), connectionRequest.getSupportingDocType(), connectionRequest.getSupportingDocNumber(), "In Progress");
        Connection savedConnection = connectionRepository.save(connection);
        return savedConnection.getRequestId().toString();
    }

    public String trackRequest(String requestId) {
        Option<Connection> connection =  connectionRepository.findById()
    }
}
