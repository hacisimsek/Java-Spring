package com.springbootrabbitMQApplication.RabbitMQApplication.model;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {

    private String notificationId;
    private Date createdAt;
    private String message;
    private Boolean seen;

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", createdAt=" + createdAt +
                ", message='" + message + '\'' +
                ", seen=" + seen +
                '}';
    }
}
