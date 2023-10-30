package com.hms.service;

import com.hms.model.HotelRoom;
import com.hms.repository.HotelRoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelRoomService {

    private final HotelRoomRepository hotelRoomRepository;

    @Autowired
    public HotelRoomService(HotelRoomRepository hotelRoomRepository) {
        this.hotelRoomRepository = hotelRoomRepository;
    }

//    public List<Hotel> getAllHotelRooms() {
//
////        List<Hotel> hotelRoomList = new ArrayList<>();
////        hotelRepository.findAll().forEach(hotelRoom -> hotelRoomList.add(hotelRoom));
//        return hotelRoomRepository.findAll();
//    }

    //creates and saves a new HotelRoom instance to the database.
    public HotelRoom createHotelRoom(String building, String roomNumber, int bedCount, int bathrooms, Double securityDepositAmount, String roomType) {
        HotelRoom newRoom = new HotelRoom();
        newRoom.setBuilding(building);
        newRoom.setRoomNumber(roomNumber);
        newRoom.setBedCount(bedCount);
        newRoom.setBathrooms(bathrooms);
        newRoom.setSecurityDepositAmount(securityDepositAmount);
        newRoom.setRoomType(roomType);

        //saves the newRoom record and returns the newly saved instance to the hotelRoomRepository
        return hotelRoomRepository.save(newRoom);
    }

    //updates an existing HotelRoom instance based on the hotelRoomId
    public HotelRoom updateHotelRoom(long hotelRoomId, HotelRoom updatedRoom) {
        //retrieves the existing hotel from the database by its unique hotelRoomId
        Optional<HotelRoom> roomOptional = hotelRoomRepository.findById(hotelRoomId);

        //check to see if the specified hotelRoomId exists in the database
        if (roomOptional.isPresent()) {
            //if the room exists extracts the instance from the Optional
            HotelRoom existingRoom = roomOptional.get();

            //updates properties of the existing hotel room from the updatedRoom
            existingRoom.setBuilding(updatedRoom.getBuilding());
            existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
            existingRoom.setBedCount(updatedRoom.getBedCount());
            existingRoom.setBathrooms(updatedRoom.getBathrooms());
            existingRoom.setSecurityDepositAmount(updatedRoom.getSecurityDepositAmount());
            existingRoom.setRoomType(updatedRoom.getRoomType());

            return hotelRoomRepository.save(existingRoom);
        } else {
            //Handles the case where the room with the specified hotelRoomId does not exist
            //Might change this to a 404 redirect later
            throw new EntityNotFoundException("Hotel Room not found with ID: " + hotelRoomId);
        }
    }

    //deletes an existing instance of a hotel room by its hotelRoomId
    public void deleteHotelRoom(long hotelRoomId) {
        //uses the hotelRoomRepo to find the hotel room by its unique ID.
        Optional<HotelRoom> roomOptional = hotelRoomRepository.findById(hotelRoomId);

        //check to see if the specified hotelRoomId exists in the database
        if (roomOptional.isPresent()) {
            //if the room exists delete it
            hotelRoomRepository.delete(roomOptional.get());
        } else {
            throw new EntityNotFoundException("Hotel Room not found with ID: " + hotelRoomId);
        }
    }
    
}