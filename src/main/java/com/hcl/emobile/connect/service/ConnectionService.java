package com.hcl.emobile.connect.service;

import com.hcl.emobile.connect.entity.Connection;
import com.hcl.emobile.connect.model.ConnectionRequest;

import java.util.List;

public interface ConnectionService {
    int applyConnection(ConnectionRequest connectionRequest);
    String trackRequest(int requestId);
    List<Connection> listRequests();
    Connection viewRequestDetails(int requestId);
}
