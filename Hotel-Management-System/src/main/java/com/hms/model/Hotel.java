package com.hms.model;


import jakarta.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hotelId;

    @Column(name = "hotel_name", nullable = false, length = 50)
    private String hotelName;

    @Column(name = "building", nullable = false, length = 1)
    private String building;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Column(name = "bed_count", nullable = false)
    private int bedCount;

    @Column(name = "bathrooms", nullable = false)
    private int bathrooms;

    @Column(name = "security_deposit_amount", nullable = false)
    private double securityDepositAmount;

    @Column(name = "room_type", nullable = false, length = 50)
    private String roomType;

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

    public double getSecurityDepositAmount() {
        return securityDepositAmount;
    }

    public void setSecurityDepositAmount(double securityDepositAmount) {
        this.securityDepositAmount = securityDepositAmount;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
