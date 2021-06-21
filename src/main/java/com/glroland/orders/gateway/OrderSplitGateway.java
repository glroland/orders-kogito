package com.glroland.orders.gateway;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

import com.glroland.orders.dto.IncomingOrder;
import com.glroland.orders.dto.SupplierQuote;

@Path("/order")
@RegisterRestClient
public interface OrderSplitGateway {

    @POST
    @Path("/split")
    List<SupplierQuote> splitForSupplier(IncomingOrder order);

    @POST
    @Path("/join")
    boolean joinSupplierQuotes(IncomingOrder order, List supplierRequestsIn);
}
