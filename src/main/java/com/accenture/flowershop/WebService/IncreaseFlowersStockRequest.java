package com.accenture.flowershop.WebService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "http://www.flowershop.accenture.com/WebServices", name = "IncreseFlowersStockRequest")
public class IncreaseFlowersStockRequest {
    @XmlElement(namespace = "http://www.flowershop.accenture.com/WebServices", required = true)
    protected int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
