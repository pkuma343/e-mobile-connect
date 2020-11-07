package com.hcl.emobile.connect.service;

import com.hcl.emobile.connect.model.ConnectionRequest;

public interface ConnectionService {
    String applyConnection(ConnectionRequest connectionRequest);
    String trackRequest(String requestId);
}
