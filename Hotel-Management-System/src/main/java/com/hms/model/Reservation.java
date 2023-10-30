package com.hms.model;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "check_in_time", nullable = false)
    private Date checkInTime;

    @Column(name = "customer_name",length = 50, nullable = false)
    private String customerName;

    @Column(name = "customer_age", nullable = false)
    private int customerAge;

    @Column(name = "drivers_license", length = 20, nullable = false)
    private String driversLicense;

    @ManyToOne HotelRoom hotelRoom;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_status", nullable = false)
    private RoomStatus roomStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = "reservation_start_date", nullable = false)
    private Date reservationStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "reservation_end_date", nullable = false)
    private Date reservationEndDate;

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }

    public HotelRoom getHotel() {
        return hotelRoom;
    }

    public void setHotel(HotelRoom hotel) {
        this.hotelRoom = hotel;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Date getReservationStartDate() {
        return reservationStartDate;
    }

    public void setReservationStartDate(Date reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    public Date getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationEndDate(Date reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }
}
