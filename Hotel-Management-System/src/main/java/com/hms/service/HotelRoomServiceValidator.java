package com.hms.service;

import com.hms.model.HotelRoomForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class HotelRoomServiceValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return HotelRoomForm.class.equals(clazz);
    }

    private static boolean isValidBuilding(String building) {
        // Check if the building is either "A" or "B" (case-insensitive)
        return "A".equalsIgnoreCase(building) || "B".equalsIgnoreCase(building);
    }

    @Override
    public void validate(Object target, Errors errors) {
        HotelRoomForm hotelRoomForm = (HotelRoomForm) target;

        // Validate Building
        if (hotelRoomForm.getBuilding() == null || !isValidBuilding(hotelRoomForm.getBuilding())) {
            errors.rejectValue("building", "error.building", "Invalid building");
        }

        // Validate Room Number
        if (!hotelRoomForm.getRoomNumber().matches("[AB][1-9]\\d{2}")) {
            errors.rejectValue("roomNumber", "error.roomNumber", "Invalid room number format");
        }

        // Validate Bed Count
        if (hotelRoomForm.getBedCount() == null || hotelRoomForm.getBedCount() <= 0) {
            errors.rejectValue("bedCount", "error.bedCount", "Bed count is required and must be a positive integer");
        }

        // Validate Bathrooms
        if (hotelRoomForm.getBathrooms() == null || hotelRoomForm.getBathrooms() <= 0) {
            errors.rejectValue("bathrooms", "error.bathrooms", "Bathroom count is required and must be a positive integer");
        }

        // Validate Security Deposit Amount
        if (hotelRoomForm.getSecurityDepositAmount() == null || hotelRoomForm.getSecurityDepositAmount() < 0) {
            errors.rejectValue("securityDepositAmount", "error.securityDepositAmount", "Security deposit amount is required and cannot be negative");
        }

        // Validate Room Type
        if (hotelRoomForm.getRoomType() == null || hotelRoomForm.getRoomType().trim().isEmpty()) {
            errors.rejectValue("roomType", "error.roomType", "Room type cannot be empty");
        } else {
            String lowerCaseRoomType = hotelRoomForm.getRoomType().trim().toLowerCase();
            if (!lowerCaseRoomType.equals("single") && !lowerCaseRoomType.equals("suite") && !lowerCaseRoomType.equals("king suite")) {
                errors.rejectValue("roomType", "error.roomType", "Invalid room type");
            }
        }

        // Validate Room Description
        if (hotelRoomForm.getRoomDescription() != null && hotelRoomForm.getRoomDescription().length() > 150) {
            errors.rejectValue("roomDescription", "error.roomDescription", "Room description cannot exceed 150 characters");
        }

        // Add more validation checks for other fields...

    }



//    public static void validateRoomNumber(String roomNumber) {
//        if (!isValidRoomNumber(roomNumber)) {
//            throw new IllegalArgumentException("Invalid room number");
//        }
//    }

//    private static boolean isValidRoomNumber(String roomNumber) {
//        // Check if the roomNumber follows the specified format (A101, B202, etc.)
//        if (!roomNumber.matches("[AB][1-9]\\d{2}")) {
//            throw new IllegalArgumentException("Invalid room number format. It should be in the format 'A101', 'B202', etc.");
//        }
//
//        return true;
//    }

//    public static void validateBuilding(String building) {
//        if (!isValidBuilding(building)) {
//            throw new IllegalArgumentException("Invalid building");
//        }
//    }

//    public static void validateBedCount(Integer bedCount) {
//        if (bedCount == null || bedCount <= 0) {
//            throw new IllegalArgumentException("Bed count is required and must be a positive integer");
//        }
//    }

//    public static void validateBathrooms(Integer bathrooms) {
//        if (bathrooms == null || bathrooms <= 0) {
//            throw new IllegalArgumentException("Bathroom count is required and must be a positive integer");
//        }
//    }


//    public static void validateSecurityDepositAmount(Double securityDepositAmount) {
//        if (securityDepositAmount == null) {
//            throw new IllegalArgumentException("Security deposit amount is required");
//        }
//
//        if (securityDepositAmount < 0) {
//            throw new IllegalArgumentException("Security deposit amount cannot be negative");
//        }
//    }


//    public static void validateRoomType(String roomType) {
//        if (roomType == null || roomType.trim().isEmpty()) {
//            throw new IllegalArgumentException("Room type cannot be empty");
//        }
//
//        String lowerCaseRoomType = roomType.trim().toLowerCase();
//
//        // Check if the room type is one of the valid options
//        if (!lowerCaseRoomType.equals("single") && !lowerCaseRoomType.equals("suite") && !lowerCaseRoomType.equals("king suite")) {
//            throw new IllegalArgumentException("Invalid room type");
//        }
//    }


//    public static void validateRoomDescription(String roomDescription) {
//        if (roomDescription != null && roomDescription.length() > 150) {
//            throw new IllegalArgumentException("Room description cannot exceed 150 characters");
//        }
//    }
}






//    @Transactional
//    public HotelRoom createHotelRoom(HotelRoom hotelRoom) {
//        // Validate input fields before creating the hotel room
//        HotelRoomValidator.validateRoomNumber(hotelRoom.getRoomNumber());
//        HotelRoomValidator.validateBuilding(hotelRoom.getBuilding());
//
//        // Your existing logic to create a hotel room
//        // ...
//
//        return hotelRoomRepository.save(hotelRoom);
//    }
//
//    @Transactional
//    public HotelRoom updateHotelRoom(long hotelRoomId, HotelRoom updatedRoom) {
//        // Validate input fields before updating the hotel room
//        HotelRoomValidator.validateRoomNumber(updatedRoom.getRoomNumber());
//        HotelRoomValidator.validateBuilding(updatedRoom.getBuilding());
//
//        // Your existing logic to update a hotel room
//        // ...
//
//        return hotelRoomRepository.save(existingRoom);
//    }
