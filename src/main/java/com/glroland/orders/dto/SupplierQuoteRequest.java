package com.glroland.orders.dto;

import java.io.Serializable;
import java.util.Date;

public class SupplierQuoteRequest implements Serializable
{
    private Long orderNumber;
    private Integer lineNumber;
    private String supplierType;
    private String sku;
    private Integer quantity;
    private Double unitCost;
    private Double totalCost;
    private Double shipping;
    private String fulfillmentDate;
    private String paymentMethod;
    private String supplierId;
    private Date dateQuoted;

    private String status;
    private String fulfillmentPartner;
    private String fulfillmentOrderNumber;

    public Long getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
    public Integer getLineNumber() {
        return lineNumber;
    }
    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }
    public String getSupplierType() {
        return supplierType;
    }
    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getUnitCost() {
        return unitCost;
    }
    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }
    public Double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
    public Double getShipping() {
        return shipping;
    }
    public void setShipping(Double shipping) {
        this.shipping = shipping;
    }
    public String getFulfillmentDate() {
        return fulfillmentDate;
    }
    public void setFulfillmentDate(String fulfillmentDate) {
        this.fulfillmentDate = fulfillmentDate;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public String getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
    public Date getDateQuoted() {
        return dateQuoted;
    }
    public void setDateQuoted(Date dateQuoted) {
        this.dateQuoted = dateQuoted;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getFulfillmentPartner() {
        return fulfillmentPartner;
    }
    public void setFulfillmentPartner(String fulfillmentPartner) {
        this.fulfillmentPartner = fulfillmentPartner;
    }
    public String getFulfillmentOrderNumber() {
        return fulfillmentOrderNumber;
    }
    public void setFulfillmentOrderNumber(String fulfillmentOrderNumber) {
        this.fulfillmentOrderNumber = fulfillmentOrderNumber;
    }

}
