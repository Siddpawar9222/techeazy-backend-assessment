package com.example.techeazy.student_management_system.model;

import java.util.Date;

public class Response {

    private String message;
    private Object data;

    private Integer resultCode;

    private Date timestamp = new Date();

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", resultCode=" + resultCode +
                ", timestamp=" + timestamp +
                '}';
    }
}
