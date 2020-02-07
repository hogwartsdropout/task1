package com.example.gs.grpc

import com.example.grpc.OrderServiceGrpc
import com.example.grpc.OrderServiceOuterClass
import com.example.gs.model.Order
import org.lognet.springboot.grpc.GRpcService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class OrderGrpcClient {
    @Autowired
    OrderServiceGrpc.OrderServiceBlockingStub stub;
    //Remote call to save an order to the database from java server.
    //returns id of the record on success or zero otherwise.
    long save(Order order) {
        OrderServiceOuterClass.OrderSaveResponse response = stub
                .save(OrderServiceOuterClass.OrderSaveRequest.newBuilder()
                        .setClient(order.client)
                        .setCar(order.car)
                        .setColor(order.color)
                        .setStatus(OrderServiceOuterClass.OrderSaveRequest.OrderStatus.valueOf(order.status.ordinal()))
                        .build())
        println response.saveStatus //TODO: remove
        if (response.saveStatus == OrderServiceOuterClass.OrderSaveResponse.SaveStatus.SUCCESS) {
            return response.id
        } else return 0L
    }
}
