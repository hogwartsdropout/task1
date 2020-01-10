package com.example.controller;

import com.example.entity.Car;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "tesIF",
targetNamespace = "http://cxf.apache.org")
@SOAPBinding(style= SOAPBinding.Style.RPC, use= SOAPBinding.Use.LITERAL)
public interface TestSOAPInterface {
    @WebMethod(operationName = "getCarById")
    @RequestWrapper(className = "java.lang.String")
    @ResponseWrapper(className = "com.example.entity.Car")
    public Car getCarById(@WebParam(name="id") Long id);
}
