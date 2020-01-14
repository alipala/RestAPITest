package com.restapi.payloads.booking;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/***
 * This model class comes from https://github.com/mwinteringham/restful-booker-platform
 * @author Ali Pala mailto:ali.pala@ymail.com
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Booking {

    @JsonProperty
    private int bookingid;

    @JsonProperty
    private int roomid;

    @JsonProperty
    private String firstname;

    @JsonProperty
    private String lastname;

    @JsonProperty
    private boolean depositpaid;

    @JsonProperty(value = "bookingdates")
    private BookingDates bookingDates;

    @JsonProperty
    private String email;

    @JsonProperty
    private String phone;

    public Booking(int bookingid, int roomid, String firstname, String lastname, boolean depositpaid, BookingDates bookingDates) {
        this.bookingid = bookingid;
        this.roomid = roomid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.depositpaid = depositpaid;
        this.bookingDates = bookingDates;
    }

    public Booking(int bookingid, int roomid, String firstname, String lastname, boolean depositpaid, BookingDates bookingDates, String email, String phone) {
        this.bookingid = bookingid;
        this.roomid = roomid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.depositpaid = depositpaid;
        this.bookingDates = bookingDates;
        this.email = email;
        this.phone = phone;
    }

    public Booking(ResultSet result) throws SQLException {
        this.bookingid = result.getInt("bookingid");
        this.roomid = result.getInt("roomid");
        this.firstname = result.getString("firstname");
        this.lastname = result.getString("lastname");
        this.depositpaid = result.getBoolean("depositpaid");
        this.bookingDates = new BookingDates(result.getDate("checkin"), result.getDate("checkout"));
    }

    public Booking() {
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public BookingDates getBookingDates() {
        return bookingDates;
    }

    public int getRoomid() {
        return roomid;
    }

    public int getBookingid() {
        return bookingid;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "roomid=" + roomid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", depositpaid=" + depositpaid +
                ", bookingDates=" + bookingDates +
                '}';
    }


    public static class BookingBuilder {

        private int bookingid;
        private int roomid;
        private String firstname;
        private String lastname;
        private boolean depositpaid;
        private Date checkin;
        private Date checkout;
        private String email;
        private String phone;

        public BookingBuilder setBookingid(int bookingid){
            this.bookingid = bookingid;

            return this;
        }

        public BookingBuilder setRoomid(int roomid){
            this.roomid = roomid;

            return this;
        }

        public BookingBuilder setFirstname(String firstname) {
            this.firstname = firstname;

            return this;
        }

        public BookingBuilder setLastname(String lastname) {
            this.lastname = lastname;

            return this;
        }

        public BookingBuilder setDepositpaid(boolean depositpaid) {
            this.depositpaid = depositpaid;

            return this;
        }

        public BookingBuilder setCheckin(Date checkin) {
            this.checkin = checkin;

            return this;
        }

        public BookingBuilder setCheckout(Date checkout) {
            this.checkout = checkout;

            return this;
        }

        public BookingBuilder setEmail(String email) {
            this.email = email;

            return this;
        }

        public BookingBuilder setPhone(String phone) {
            this.phone = phone;

            return this;
        }

        public Booking build(){
            BookingDates bookingDates = new BookingDates(checkin, checkout);

            if(email == null && phone == null){
                return new Booking(bookingid, roomid, firstname, lastname, depositpaid, bookingDates);
            } else {
                return new Booking(bookingid, roomid, firstname, lastname, depositpaid, bookingDates, email, phone);
            }
        }
    }
}
