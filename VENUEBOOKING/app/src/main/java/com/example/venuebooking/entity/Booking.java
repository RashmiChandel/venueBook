package com.example.venuebooking.entity;

import java.io.Serializable;

public class Booking implements Serializable {
 private int Booking_id;
 private int User_id;
 private int Venue_id;
 private int Total_amount;
 private String Start_date;
 private String End_date;

 public Booking(){
 }

    public Booking(int booking_id, int user_id, int venue_id, int total_amount, String start_date, String end_date) {
        this.Booking_id = booking_id;
        this.User_id = user_id;
        this.Venue_id = venue_id;
       this.Total_amount = total_amount;
        this.Start_date = start_date;
        this.End_date = end_date;
    }

    public int getBooking_id() {
        return Booking_id;
    }

    public void setBooking_id(int booking_id) {
        Booking_id = booking_id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public int getVenue_id() {
        return Venue_id;
    }

    public void setVenue_id(int venue_id) {
        Venue_id = venue_id;
    }

    public int getTotal_amount() {
        return Total_amount;
    }

    public void setTotal_amount(int total_amount) {
        Total_amount = total_amount;
    }

    public String getStart_date() {
        return Start_date;
    }

    public void setStart_date(String start_date) {
        Start_date = start_date;
    }

    public String getEnd_date() {
        return End_date;
    }

    public void setEnd_date(String end_date) {
        End_date = end_date;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "Booking_id=" + Booking_id +
                ", User_id=" + User_id +
                ", Venue_id=" + Venue_id +
                ", Total_amount=" + Total_amount +
                ", Start_date='" + Start_date + '\'' +
                ", End_date='" + End_date + '\'' +
                '}';
    }
}
