package com.hms.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "checkout")
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long checkoutId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "check_in_time", nullable = false)
    private Date checkInTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "check_out_time", nullable = false)
    private Date checkOutDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "reservation_start_date", nullable = false)
    private Date reservationStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "reservation_end_date", nullable = false)
    private Date reservationEndDate;

    @Column(name = "customer_name", nullable = false, length = 50)
    private String customerName;

    @Column(name = "room_number", nullable = false)
    private int roomNumber;

    public long getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(long checkoutId) {
        this.checkoutId = checkoutId;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
