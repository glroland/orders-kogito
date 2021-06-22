package com.glroland.orders.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.glroland.orders.dto.SupplierQuote;
import com.glroland.orders.util.Constants;
import com.glroland.orders.gateway.SupplierGateway;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class SupplierQuoteService {
    private static final Logger log = LoggerFactory.getLogger(SupplierQuoteService.class);

    @Inject
    @RestClient
    private SupplierGateway supplierGateway;

    public SupplierQuote quoteProduct(SupplierQuote supplierQuote)
    {
        return supplierGateway.quoteProduct(supplierQuote);
    }

    public SupplierQuote calculateTax(SupplierQuote supplierQuote)
    {
        return supplierGateway.calculateTax(supplierQuote);
    }

    public SupplierQuote calculateShipping(SupplierQuote supplierQuote)
    {
        return supplierGateway.calculateShipping(supplierQuote);
    }

    public SupplierQuote estimateShipDate(SupplierQuote supplierQuote)
    {
        return supplierGateway.estimateShipDate(supplierQuote);
    }

    public SupplierQuote finalizeQuote(SupplierQuote supplierQuote)
    {
        return supplierGateway.finalizeQuote(supplierQuote);
    }
}
