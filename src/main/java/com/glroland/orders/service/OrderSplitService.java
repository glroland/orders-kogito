package com.glroland.orders.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.glroland.orders.dto.IncomingOrder;
import com.glroland.orders.dto.IncomingOrderLine;
import com.glroland.orders.dto.SupplierQuoteRequest;
import com.glroland.orders.dto.SupplierQuoteRequestList;
import com.glroland.orders.util.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class OrderSplitService 
{
    private static final Logger log = LoggerFactory.getLogger(OrderSplitService.class);

    @Autowired
    private ProductService productService;

    public List splitForSupplier(IncomingOrder order) 
    {
        if (order == null)
        {
            String msg = "Inbound order is null";
            log.error(msg);
            throw new RuntimeException(msg);
        }

        ArrayList<SupplierQuoteRequest> requestList = new ArrayList<SupplierQuoteRequest>();

        if (order != null)
        {
            if (order.getOrderLines() != null)
            {
                for (IncomingOrderLine line : order.getOrderLines())
                {
                    String supplierType = productService.getSupplierTypeForProduct(line.getSku());
                    
                    SupplierQuoteRequest request = new SupplierQuoteRequest();
                    request.setOrderNumber(order.getOrderNumber());
                    request.setLineNumber(line.getLineNumber());
                    request.setSupplierType(supplierType);
                    request.setSku(line.getSku());
                    request.setQuantity(line.getQuantity());
                    request.setStatus(Constants.SupplierRequestStatus.NEW);

                    requestList.add(request);
                }
            }
        }

        return requestList;
    }
}
