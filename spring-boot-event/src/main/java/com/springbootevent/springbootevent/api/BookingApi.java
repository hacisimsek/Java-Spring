package com.springbootevent.springbootevent.api;

import com.springbootevent.springbootevent.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookingApi {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public void bookHotel(@RequestBody HotelBookRequest hotelBookRequest) {
        reservationService.publishReservationEvent(hotelBookRequest);
        System.out.println("Kullanıcı rezervasyon yaptı" + hotelBookRequest);
    }
}
