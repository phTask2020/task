package com.reuben.rpc.service.geeter;


import io.grpc.stub.StreamObserver;

import lombok.extern.slf4j.Slf4j;
import com.reuben.grpc.entity.HelloReply;
import com.reuben.grpc.entity.HelloRequest;
import com.reuben.grpc.service.GreeterGrpc;

/**
 * @program: grpc-demo
 * @description:
 * @author: reuben
 * @create: 2020-03-24 11:31
 **/
@Slf4j
public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("hello" + request.getName()).build();
        //处理接收到的消息
        String message = reply.getMessage();
        log.info("服务端收到消息：" + message);
        //响应消息
        HelloReply hello_world = reply.toBuilder().setMessage("hello world").build();

        responseObserver.onNext(hello_world);
        responseObserver.onCompleted();

    }
}
