package com.glroland.orders.service;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.glroland.orders.dto.SupplierQuote;

@Component
public class SupplierQuoteService {
    private static final Logger log = LoggerFactory.getLogger(SupplierQuoteService.class);

    public void quoteProduct(SupplierQuote supplierQuote)
    {
        if (supplierQuote == null)
        {
            String msg = "Incoming supplierQuote is null.  Cannot quote product sale.";
            log.error(msg);
            throw new RuntimeException(msg);
        }
        if (supplierQuote.getQuantity() == null)
        {
            String msg = "Quantity for incoming supplier quote is null.  Cannot quote product sale.";
            log.error(msg);
            throw new RuntimeException(msg);
        }

        double costPerUnit = roundPennies(Math.random() * 100.0);
        supplierQuote.setUnitCost(costPerUnit);

        double subtotal = costPerUnit * supplierQuote.getQuantity();
        supplierQuote.setSubtotalCost(subtotal);
    }

    public void calculateTax(SupplierQuote supplierQuote)
    {
        if (supplierQuote == null)
        {
            String msg = "Incoming supplierQuote is null";
            log.error(msg);
            throw new RuntimeException(msg);
        }
        if (supplierQuote.getSubtotalCost() == null)
        {
            String msg = "Subtotal Cost for supplier quote is null.  Cannot calculate tax.";
            log.error(msg);
            throw new RuntimeException(msg);
        }

        double tax = supplierQuote.getSubtotalCost() * (double)0.06;
        supplierQuote.setTax(roundPennies(tax));
    }

    public void calculateShipping(SupplierQuote supplierQuote)
    {
        if (supplierQuote == null)
        {
            String msg = "Incoming supplierQuote is null";
            log.error(msg);
            throw new RuntimeException(msg);
        }
        if (supplierQuote.getQuantity() == null)
        {
            String msg = "Quantity for incoming supplier quote is null";
            log.error(msg);
            throw new RuntimeException(msg);
        }

        double shippingPerUnit = Math.random() * 15.0;
        int quantity = supplierQuote.getQuantity().intValue();
        double shipping = shippingPerUnit * (double)quantity;

        supplierQuote.setShipping(roundPennies(shipping));
    }

    private double roundPennies(double amount)
    {
        return Math.round(amount * 100.0) / 100.0;
    }
}
