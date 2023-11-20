package com.hms.model;
import lombok.Data;

@Data //generates getter & setter methods for class properties
public class HotelRoomForm {
    private Long id;  // This field will hold the ID, but it won't be generated in the form
    private String building;
    private String roomNumber;
    private Integer bedCount;
    private Integer bathrooms;
    private Double securityDepositAmount;
    private String roomType;
    private String roomDescription;
}
