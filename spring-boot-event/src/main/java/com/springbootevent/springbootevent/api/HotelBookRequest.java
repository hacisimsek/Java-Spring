package com.springbootevent.springbootevent.api;

public class HotelBookRequest {
    private String hotelId;
    private String userId;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "HotelBookRequest{" +
                "hotelId='" + hotelId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

}
