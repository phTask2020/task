package com.pc.grpcserver;


import com.JPA.grpc.lib.HelloReply;
import com.JPA.grpc.lib.HelloRequest;
import com.JPA.grpc.lib.SimpleGrpc;
import io.grpc.stub.StreamObserver;

import net.devh.springboot.autoconfigure.grpc.server.GrpcService;


@GrpcService(HelloReply.class)
public class GreeterService extends SimpleGrpc.SimpleImplBase{
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String message = "hello" +request.getName();
        final HelloReply.Builder repluBuilder = HelloReply.newBuilder().setMessagee(message);
        responseObserver.onNext(repluBuilder.build());
        responseObserver.onCompleted();
        System.out.println("return "+message);
    }
}
