package com.jerimkaura.soapservice.endpoints;

import com.jerimkaura.soapservice.requests.RoomConfirmationRequest;
import com.jerimkaura.soapservice.requests.BookingRequest;
import com.jerimkaura.soapservice.requests.BookingResponse;
import com.jerimkaura.soapservice.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author Morris.Okworo on 03/05/2023
 */
@Endpoint
@RequiredArgsConstructor
public class BookingEndpoint {

    private static final String NAMESPACE_URI = "http://requests.soapservice.jerimkaura.com";

    private final BookingService bookingService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "BookingRequest")
    @ResponsePayload
    public BookingResponse addBooking(@RequestPayload BookingRequest bookingRequest) {

        return bookingService.addBooking(bookingRequest);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RoomConfirmationRequest")
    @ResponsePayload
    public BookingResponse addBooking(@RequestPayload RoomConfirmationRequest request) {

        return bookingService.getClientBookings(request);
    }
}
