import com.restapi.api.AuthApi;
import com.restapi.api.BookingApi;
import com.restapi.payloads.AuthLoginRequests;
import com.restapi.payloads.AuthLoginResponse;
import com.restapi.payloads.booking.Booking;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static io.restassured.RestAssured.given;

public class BookingTest {

    @Test
    public void postLogin() {
        AuthLoginResponse authLogin  = doLogin();
        Assert.assertEquals(authLogin.getToken().length(), 16);
    }

    @Test
    public void getAllBookings() {
        BookingApi bookingApi = new BookingApi();
        Response response = bookingApi.getAllBooking();
        // Get the body of the response
        System.out.println(response.getBody().prettyPrint());
        // Assert
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void getValidBooking() {
        BookingApi bookingApi = new BookingApi();
        Response response = bookingApi.getSpecificBooking(1);
        // Get the body of the response
        System.out.println(response.getBody().prettyPrint());
        // Valid book id assertion
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void getInvalidBooking(){
        BookingApi bookingApi = new BookingApi();
        Response response = bookingApi.getSpecificBooking(10);
        // Get the body of the response
        System.out.println(response.getBody().prettyPrint());
        response.getBody().prettyPrint();
        // Invalid book id assertion
        Assert.assertEquals(response.statusCode(), 500);
    }

    @Test
    public void createConflictBooking() {
        String token = "abc123";

        Date checkindate = new GregorianCalendar(2020,1 ,6).getTime();
        Date checkoutdate = new GregorianCalendar(2020,1,9).getTime();

        Booking bookingPayload = new Booking.BookingBuilder()
                .setRoomid(51)
                .setFirstname("Ali")
                .setLastname("Pala")
                .setDepositpaid(true)
                .setCheckin(checkindate)
                .setCheckout(checkoutdate)
                .setEmail("ali@alipala.com")
                .setPhone("01234123123")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(bookingPayload)
                .when()
                .post("https://automationintesting.online/booking/");

        Response bookingResponse = given()
                .contentType(ContentType.JSON)
                .body(bookingPayload)
                .when()
                .post("https://automationintesting.online/booking/");

        Assert.assertEquals(bookingResponse.statusCode(), 409);

    }

    private AuthLoginResponse doLogin() {
        AuthLoginRequests authPayload = new AuthLoginRequests("admin", "password");
        AuthApi authApi = new AuthApi();
        Response response = authApi.postLogin(authPayload);

        return response.as(AuthLoginResponse.class);
    }
}
