package com.reuben.rpc.client;

import io.grpc.StatusRuntimeException;
import com.reuben.grpc.entity.HelloReply;
import com.reuben.grpc.entity.HelloRequest;
import com.reuben.grpc.service.GreeterGrpc;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: grpc-demo
 * @description:
 * @author: reuben
 * @create: 2020-03-24 11:31
 **/
@Slf4j
public class GreeterClient {

    private final GreeterGrpc.GreeterBlockingStub blockingStub;


    public GreeterClient(BaseClient client) {
        blockingStub = client.getGreeterBlockingStub();
    }

    public void greet(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try {
            response = blockingStub.sayHello(request);
            String msg = response.getMessage();
            //接收到服务端返回的消息
            log.info("客户端收到消息:" + msg);
        } catch (StatusRuntimeException e) {
            return;
        }
    }
}
