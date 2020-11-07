package com.hcl.emobile.connect.repository;

import com.hcl.emobile.connect.entity.Connection;
import com.hcl.emobile.connect.model.ConnectionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, UUID> {
}
