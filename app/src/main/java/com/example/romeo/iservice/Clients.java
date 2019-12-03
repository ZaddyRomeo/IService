package com.example.romeo.iservice;

public class Clients {
    String name;
    String service_number;
    String message;
    String contactno;
    String Date;


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "Name='" + name + '\'' +
                ", service_number='" + service_number + '\'' +
                ", message='" + message + '\'' +
                ", contactno='" + contactno + '\'' +
                ", date='" + Date + '\''+
                '}';
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getService_number() {
        return service_number;
    }

    public void setService_number(String service_number) {
        this.service_number = service_number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getDate() {return Date;}

    public void setDate(String date) {this.Date = date;}

    public Clients(String name, String service_number, String message, String contactno, String date) {
        this.name = name;
        this.service_number = service_number;
        this.message = message;
        this.contactno = contactno;
        this.Date = date;
    }
    public Clients (){
    }
}