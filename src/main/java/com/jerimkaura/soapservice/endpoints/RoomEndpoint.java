package com.jerimkaura.soapservice.endpoints;

import com.jerimkaura.soapservice.requests.*;
import com.jerimkaura.soapservice.services.RoomService;
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
public class RoomEndpoint {

    private static final String NAMESPACE_URI = "http://requests.soapservice.jerimkaura.com";

    private final RoomService roomService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RoomRequest")
    @ResponsePayload
    public RoomResponse addRoom(@RequestPayload RoomRequest roomRequest) {

        return roomService.addRoom(roomRequest);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RoomByIdRequest")
    @ResponsePayload
    public RoomResponse addRoom(@RequestPayload RoomByIdRequest roomRequest) {

        return roomService.getRoomByIdRequest(roomRequest);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RoomsAvailableRequest")
    @ResponsePayload
    public RoomsAvailableResponse getRoomsAvailable(@RequestPayload RoomsAvailableRequest RoomsAvailableRequest) {

        return roomService.getRoomsAvailable(RoomsAvailableRequest);
    }
}
