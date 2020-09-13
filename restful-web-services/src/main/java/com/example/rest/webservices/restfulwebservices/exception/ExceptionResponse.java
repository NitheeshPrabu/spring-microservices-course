package com.example.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date inTimeStamp) {
        this.timestamp = inTimeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String inMessage) {
        this.message = inMessage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String inDetails) {
        this.details = inDetails;
    }
}
