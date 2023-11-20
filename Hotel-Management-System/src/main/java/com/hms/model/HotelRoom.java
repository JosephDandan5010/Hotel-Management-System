package com.hms.model;
import jakarta.persistence.*;

@Entity
@Table(name = "hotelRoom")
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hotelRoomId;

    @Column(name = "building", nullable = false, length = 1)
    private String building;

    @Column(name = "room_number", nullable = false, length = 4)
    private String roomNumber;

    @Column(name = "bed_count", nullable = false)
    private int bedCount;

    @Column(name = "bathrooms", nullable = false)
    private int bathrooms;

    @Column(name = "security_deposit_amount", nullable = false)
    private Double securityDepositAmount;

    @Column(name = "room_type", nullable = false, length = 30)
    private String roomType;

    @Column(name = "room_description", length = 150)
    private String roomDescription;

    public long getHotelRoomId() {
        return hotelRoomId;
    }

    public void setHotelRoomId(long hotelRoomId) {
        this.hotelRoomId = hotelRoomId;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Double getSecurityDepositAmount() {
        return securityDepositAmount;
    }

    public void setSecurityDepositAmount(Double securityDepositAmount) {
        this.securityDepositAmount = securityDepositAmount;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String room_description) {
        this.roomDescription = room_description;
    }
}
