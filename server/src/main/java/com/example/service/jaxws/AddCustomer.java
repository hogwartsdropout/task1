
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.3.4
 * Thu Jan 09 12:56:58 MSK 2020
 * Generated source version: 3.3.4
 */

@XmlRootElement(name = "addCustomer", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addCustomer", namespace = "http://service.example.com/")

public class AddCustomer {

    @XmlElement(name = "customer")
    private com.example.entity.Customer customer;

    public com.example.entity.Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(com.example.entity.Customer newCustomer)  {
        this.customer = newCustomer;
    }

}
