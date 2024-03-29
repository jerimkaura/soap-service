package com.jerimkaura.soapservice.endpoints;

import com.jerimkaura.soapservice.requests.ClientByIdRequest;
import com.jerimkaura.soapservice.requests.ClientRequest;
import com.jerimkaura.soapservice.requests.ClientResponse;
import com.jerimkaura.soapservice.services.ClientService;
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
public class ClientEndpoint {
    private static final String NAMESPACE_URI = "http://requests.soapservice.jerimkaura.com";

    private final ClientService clientService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ClientRequest")
    @ResponsePayload
    public ClientResponse addClient(@RequestPayload ClientRequest clientRequest) {

        return clientService.addClient(clientRequest);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ClientByIdRequest")
    @ResponsePayload
    public ClientResponse addClient(@RequestPayload ClientByIdRequest clientRequest) {

        return clientService.getClientByIdRequest(clientRequest);
    }
}
