package com.example.gs.grpc

import com.example.grpc.OrderServiceGrpc
import org.springframework.beans.factory.annotation.Autowired

class OrderGrpcClient {
    @Autowired
    OrderServiceGrpc.OrderServiceBlockingStub stub;

}
