package com.hms.controller;

import com.hms.model.HotelRoom;
import com.hms.model.HotelRoomForm;
import com.hms.service.HotelRoomService;
import com.hms.service.HotelRoomServiceValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/hotel-rooms")
public class HotelRoomController {
    @Autowired
    private final HotelRoomService hotelRoomService;

    @Autowired
    private HotelRoomServiceValidator hotelRoomServiceValidator;

    @InitBinder("hotelRoomForm")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(hotelRoomServiceValidator);
    }

    public HotelRoomController(HotelRoomService hotelRoomService) {
        this.hotelRoomService = hotelRoomService;
    }

    @GetMapping("/list")
    public String listHotelRooms(Model model) {
        //retrieves a list of hotel rooms from your service
        List<HotelRoom> hotelRooms = hotelRoomService.getAllHotelRooms();

        //adds the list to the model for rendering
        model.addAttribute("hotelRooms", hotelRooms);

        //returns the HTML template to display the list
        return "hotelRoom/list_hotel_rooms";
    }

    @GetMapping("/details/{id}")
    public String showDetailedHotelRoom(@PathVariable Long id, Model model) {
        HotelRoom detailedHotelRoom = hotelRoomService.getHotelRoomById(id);
        model.addAttribute("hotelRoom", detailedHotelRoom);
        return "hotelRoom/hotel_room_details";
    }


    @GetMapping("/create")
    public String createHotelRoomForm(Model model) {
        //adds an empty HotelRoomForm to the model for creating a new room
        model.addAttribute("hotelRoomForm", new HotelRoomForm());

        //returns the HTML template for creating a new hotel room
        return "hotelRoom/create_hotel_room";
    }

    @PostMapping("/create")
    public String createHotelRoom(@ModelAttribute HotelRoomForm hotelRoomForm, BindingResult result) {
        // Manually validate the form input
        hotelRoomServiceValidator.validate(hotelRoomForm, result);

        // Validates the form input
        if (result.hasErrors()) {
            return "hotelRoom/create_hotel_room";
        }

        //creates a new HotelRoom object
        HotelRoom hotelRoom = new HotelRoom();
        //copies properties from the form to the HotelRoom object
        BeanUtils.copyProperties(hotelRoomForm, hotelRoom);
        //calls the service method to create and save the new HotelRoom
        hotelRoomService.createHotelRoom(hotelRoom);

        //redirects to the list of hotel rooms
        return "redirect:/hotel-rooms/list";
    }

    //method to show the form for updating a hotel room
    @GetMapping("/update/{id}")
    public String updateHotelRoomForm(@PathVariable Long id, Model model) {
        //retrieves the hotel room with the given ID from your service
        HotelRoom hotelRoom = hotelRoomService.getHotelRoomById(id);

        //adds the hotel room to the model
        model.addAttribute("hotelRoom", hotelRoom);

        //adds an empty HotelRoomForm to the model (for the form submission)
        model.addAttribute("hotelRoomForm", convertToHotelRoomForm(hotelRoom));

        //returns the HTML template for updating the hotel room
        return "hotelRoom/update_hotel_room";
    }

    //method to handle the submission of the updated hotel room
    @PostMapping("/update/{id}")
    public String updateHotelRoom(@PathVariable Long id, @ModelAttribute("hotelRoomForm") HotelRoomForm hotelRoomForm, BindingResult result, Model model) {

        // Validate the HotelRoomForm using your custom validator
        hotelRoomServiceValidator.validate(hotelRoomForm, result);

        if (result.hasErrors()) {
            // If there are validation errors, return to the update form with error messages
            model.addAttribute("hotelRoom", hotelRoomService.getHotelRoomById(id));
            return "hotelRoom/update_hotel_room";
        }

        hotelRoomService.updateHotelRoom(id, convertToHotelRoom(hotelRoomForm));

        //redirects to the list of hotel rooms after updating
        return "redirect:/hotel-rooms/list";
    }

    private HotelRoom convertToHotelRoom(HotelRoomForm hotelRoomForm) {
        HotelRoom hotelRoom = new HotelRoom();
        hotelRoom.setBuilding(hotelRoomForm.getBuilding());
        hotelRoom.setRoomNumber(hotelRoomForm.getRoomNumber());
        hotelRoom.setBedCount(hotelRoomForm.getBedCount());
        hotelRoom.setBathrooms(hotelRoomForm.getBathrooms());
        hotelRoom.setSecurityDepositAmount(hotelRoomForm.getSecurityDepositAmount());
        hotelRoom.setRoomType(hotelRoomForm.getRoomType());
        hotelRoom.setRoomDescription(hotelRoomForm.getRoomDescription());
        return hotelRoom;
    }

    private HotelRoomForm convertToHotelRoomForm(HotelRoom hotelRoom) {
        HotelRoomForm hotelRoomForm = new HotelRoomForm();
        hotelRoomForm.setBuilding(hotelRoom.getBuilding());
        hotelRoomForm.setRoomNumber(hotelRoom.getRoomNumber());
        hotelRoomForm.setBedCount(hotelRoom.getBedCount());
        hotelRoomForm.setBathrooms(hotelRoom.getBathrooms());
        hotelRoomForm.setSecurityDepositAmount(hotelRoom.getSecurityDepositAmount());
        hotelRoomForm.setRoomType(hotelRoom.getRoomType());
        hotelRoomForm.setRoomDescription(hotelRoom.getRoomDescription());
        return hotelRoomForm;
    }

    @PostMapping("/delete/{id}")
    public String deleteHotelRoom(@PathVariable Long id) {
        // Call a service method to delete the hotel room
        hotelRoomService.deleteHotelRoom(id);

        // Redirect to the list of hotel rooms after deleting
        return "redirect:/hotel-rooms/list";
    }



//    @GetMapping("/test-delete-hotel-room/{roomId}")
//    public ResponseEntity<String> testDeleteHotelRoom(@PathVariable Long roomId) {
//        hotelRoomService.deleteHotelRoom(roomId);
//        return ResponseEntity.ok("Hotel room with ID " + roomId + " deleted for testing");
//    }

    //    @PostMapping("/test-create-hotel-room")
//    public ResponseEntity<String> testCreateHotelRoom() {
//        String building = "A";
//        String roomNumber = "A213";
//        int bedCount = 2;
//        int bathrooms = 1;
//        Double securityDepositAmount = 100.0;
//        String roomType = "Suite";
//        String roomDescription = "Great View of a parking lot!";
//
//        HotelRoom createdRoom = hotelRoomService.createHotelRoom(building, roomNumber, bedCount, bathrooms, securityDepositAmount, roomType, roomDescription);
//
//        System.out.println("I AM HERE");
//        return ResponseEntity.ok("Hotel room created with ID: " + createdRoom.getHotelRoomId());
//    }

//    // Method to manually test updating a hotel room
//    @PutMapping("/test-update-hotel-room/{roomId}")
//    public ResponseEntity<String> testUpdateHotelRoom(@PathVariable Long roomId) {
//        String building = "B";
//        String roomNumber = "B314";
//        int bedCount = 3;
//        int bathrooms = 2;
//        Double securityDepositAmount = 150.0;
//        String roomType = "King Suite";
//        String roomDescription = "No view sadly";
//
//        //creates an updated HotelRoom  object with new values
//        HotelRoom updatedRoom = new HotelRoom();
//        updatedRoom.setBuilding(building);
//        updatedRoom.setRoomNumber(roomNumber);
//        updatedRoom.setBedCount(bedCount);
//        updatedRoom.setBathrooms(bathrooms);
//        updatedRoom.setSecurityDepositAmount(securityDepositAmount);
//        updatedRoom.setRoomType(roomType);
//        updatedRoom.setRoomDescription(roomDescription);
//
//        //calls the service method to update the hotel room
//        HotelRoom result = hotelRoomService.updateHotelRoom(roomId, updatedRoom);
//
//        if (result != null) {
//            System.out.println("Hotel room with ID " + roomId + " updated");
//            return ResponseEntity.ok("Hotel room with ID " + roomId + " updated");
//        } else {
//            System.out.println("Hotel room not found with ID: " + roomId);
//            return ResponseEntity.notFound().build();
//        }
//    }

}
