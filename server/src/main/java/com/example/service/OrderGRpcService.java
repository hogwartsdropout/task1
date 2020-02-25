package com.example.service;

import com.example.entity.Order;
import com.example.grpc.OrderServiceGrpc;
import com.example.grpc.OrderServiceOuterClass;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class OrderGRpcService extends OrderServiceGrpc.OrderServiceImplBase {
    @Autowired
    CustomerService customerService;
    @Override
    public void get(OrderServiceOuterClass.OrderGetRequest request, StreamObserver<OrderServiceOuterClass.OrderGetResponse> responseObserver) {
        Long orderId = request.getId();
        //TODO: add response

    }

    @Override
    public void save(OrderServiceOuterClass.OrderSaveRequest request,
                     StreamObserver<OrderServiceOuterClass.OrderSaveResponse> responseObserver) {
        long client = request.getClient();
        long car = request.getCar();
        String color = request.getColor();
        Order.Status status = Order.Status.valueOf(request.getStatus().name());
        Order orderToSave = new Order(client,car,color,status);
        try {
            Order savedOrder = customerService.addOrder(orderToSave);
            OrderServiceOuterClass.OrderSaveResponse response =
                    OrderServiceOuterClass.OrderSaveResponse.newBuilder()
                            .setId(savedOrder.getId())
                            .setSaveStatus(OrderServiceOuterClass.OrderSaveResponse.SaveStatus.SUCCESS)
                            .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch (Exception e) {
            OrderServiceOuterClass.OrderSaveResponse response =
                    OrderServiceOuterClass.OrderSaveResponse.newBuilder()
                            .setSaveStatus(OrderServiceOuterClass.OrderSaveResponse.SaveStatus.FAIL)
                            .build();
            responseObserver.onError(e);
        }
    }
}
