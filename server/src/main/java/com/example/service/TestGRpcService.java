package com.example.service;

import com.example.grpc.TestServiceOuterClass;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class TestGRpcService extends com.example.grpc.TestServiceGrpc.TestServiceImplBase {
    @Override
    public void send(TestServiceOuterClass.TestRequest request,
                     StreamObserver<TestServiceOuterClass.TestResponse> responseObserver) {
        String name = request.getName();
        String greeting = "Hello, " + name;
        responseObserver.onNext(TestServiceOuterClass.TestResponse.newBuilder()
                .setGreeting(greeting)
                .build());
        responseObserver.onCompleted();
    }
}
