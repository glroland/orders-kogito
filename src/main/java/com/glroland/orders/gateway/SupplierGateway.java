package com.glroland.orders.gateway;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.glroland.orders.dto.SupplierQuote;

@Path("/supplier")
@RegisterRestClient
public interface SupplierGateway {

    @POST
    @Path("/quote")
    SupplierQuote quoteProduct(SupplierQuote supplierQuote);

    @POST
    @Path("/tax")
    SupplierQuote calculateTax(SupplierQuote supplierQuote);

    @POST
    @Path("/shipCost")
    SupplierQuote calculateShipping(SupplierQuote supplierQuote);

    @POST
    @Path("/shipDate")
    SupplierQuote estimateShipDate(SupplierQuote supplierQuote);

    @POST
    @Path("/finalize")
    SupplierQuote finalizeQuote(SupplierQuote supplierQuote);

}
