package com.restapi.payloads.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * This model class comes from https://github.com/mwinteringham/restful-booker-platform
 * @author Ali Pala mailto:ali.pala@ymail.com
 */

public class BookingDates {

    @JsonProperty
    private Date checkin;

    @JsonProperty
    private Date checkout;

    public BookingDates() {
    }

    public BookingDates(Date checkin, Date checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return "BookingDates{" +
                "checkin=" + sdf.format(checkin) +
                ", checkout=" + sdf.format(checkout) +
                '}';
    }
}
