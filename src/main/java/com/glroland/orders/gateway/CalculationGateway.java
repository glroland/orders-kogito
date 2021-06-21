package com.glroland.orders.gateway;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.glroland.orders.dto.IncomingOrder;

@Path("/calculate")
@RegisterRestClient
public interface CalculationGateway {

    @POST
    IncomingOrder calculateTotal(IncomingOrder order);
}
