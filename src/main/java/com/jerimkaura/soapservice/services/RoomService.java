package com.jerimkaura.soapservice.services;

import com.jerimkaura.soapservice.entities.RoomEntity;
import com.jerimkaura.soapservice.requests.*;
import com.jerimkaura.soapservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Morris.Okworo on 03/05/2023
 */
@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;

    public RoomResponse addRoom(RoomRequest roomRequest) {
        RoomEntity room = modelMapper.map(roomRequest.getRoom(), RoomEntity.class);
        RoomEntity savedRoom = roomRepository.save(room);
        RoomResponse response = new RoomResponse();
        ResponseStatus responseStatus = new ResponseStatus();
        if (savedRoom.getId() > 0) {
            responseStatus.setStatus("SUCCESS");
            responseStatus.setMessage("Room Saved Successfully");
            Room _room = modelMapper.map(savedRoom, Room.class);
            response.setRoom(_room);
            response.setResponseStatus(responseStatus);

        } else {
            responseStatus.setStatus("FAILED");
            responseStatus.setMessage("Room Not Saved!..");
            response.setResponseStatus(responseStatus);
        }
        return response;
    }

    public RoomResponse getRoomByIdRequest(RoomByIdRequest roomRequest) {
        RoomEntity room = roomRepository.findById(roomRequest.getRoomId()).get();
        RoomResponse response = new RoomResponse();
        response.setRoom(modelMapper.map(room, Room.class));
        return response;
    }

    public RoomsAvailableResponse getRoomsAvailable(RoomsAvailableRequest RoomsAvailableRequest) {
        List<RoomEntity> rooms = roomRepository.findByIsBooked(0);
        RoomsAvailableResponse response = new RoomsAvailableResponse();
        List<Room> _rooms = new ArrayList<>();
        for (RoomEntity room : rooms) {
            _rooms.add(modelMapper.map(room, Room.class));
        }
        response.getRoom().addAll(_rooms);

        return response;
    }


}
