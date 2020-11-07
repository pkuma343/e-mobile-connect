package com.hcl.emobile.connect.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class ConnectionRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String plan;
    private String supportingDocType;
    private String supportingDocNumber;
    private String status;

    public ConnectionRequest() {
    }

    public ConnectionRequest(String firstName, String lastName, String email, String mobileNumber, String plan, String supportingDocType, String supportingDocNumber, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.plan = plan;
        this.supportingDocType = supportingDocType;
        this.supportingDocNumber = supportingDocNumber;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getSupportingDocType() {
        return supportingDocType;
    }

    public void setSupportingDocType(String supportingDocType) {
        this.supportingDocType = supportingDocType;
    }

    public String getSupportingDocNumber() {
        return supportingDocNumber;
    }

    public void setSupportingDocNumber(String supportingDocNumber) {
        this.supportingDocNumber = supportingDocNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
