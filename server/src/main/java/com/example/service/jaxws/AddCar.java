
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

@XmlRootElement(name = "addCar", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addCar", namespace = "http://service.example.com/")

public class AddCar {

    @XmlElement(name = "car")
    private com.example.entity.Car car;

    public com.example.entity.Car getCar() {
        return this.car;
    }

    public void setCar(com.example.entity.Car newCar)  {
        this.car = newCar;
    }

}
