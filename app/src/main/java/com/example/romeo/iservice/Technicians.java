package com.example.romeo.iservice;

public class Technicians {
    String technician;
    String fault;
    String address;
    String status;
    String reference;

    public String getTechnician() {
        return technician;
    }


    @Override
    public String toString() {
        return "Technicians{" +
                "Technician='" + technician + '\'' +
                ", fault='" + fault + '\'' +
                ", address='" + address + '\'' +
                ", reference='" + reference + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }

    public String getReference() { return reference; }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Technicians(String technician, String fault, String address, String status, String reference) {
        this.technician = technician;
        this.fault = fault;
        this.address = address;
        this.status = status;
        this.reference = reference;

    }

    public Technicians() {
    }
}
