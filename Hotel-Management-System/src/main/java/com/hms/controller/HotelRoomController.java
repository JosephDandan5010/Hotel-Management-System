package com.hms.controller;

import com.hms.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HotelRoomController {
    @Autowired
    private final HotelRoomService hotelService;

    public HotelRoomController(HotelRoomService hotelService) {
        this.hotelService = hotelService;
    }

//    @GetMapping
//    public List<HotelRoom> getHotelRooms() {
//        return hotelService.getAllHotelRooms();
//    }
}
