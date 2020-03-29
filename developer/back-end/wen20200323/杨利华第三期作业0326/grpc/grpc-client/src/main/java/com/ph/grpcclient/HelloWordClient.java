package com.ph.grpcclient;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.examples.GreeterGrpc;
import io.grpc.examples.Helloword;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 杨利华
 * @date: 2020/3/24
 */

public class HelloWordClient {

    private final ManagedChannel channel; //一个gRPC信道
    private final GreeterGrpc.GreeterBlockingStub blockingStub;//阻塞/同步 存根

    //初始化信道和存根
    public HelloWordClient(String host, int port){
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true));
    }

    //引导服务
    private HelloWordClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    //客户端方法
    public  void greet(String name){
        Helloword.HelloRequest request = Helloword.HelloRequest
                .newBuilder().setName(name).build();
        Helloword.HelloReply response;
        try {
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e) {
            System.out.println("RPC调用失败:"+e.getMessage());
            return;
        }
        System.out.println("服务器返回信息:"+response.getMessage());
    }

    public static void main(String[] args) throws InterruptedException {
        HelloWordClient client = new HelloWordClient("127.0.0.1",8080);
        try {
            for(int i=1;i<4;i++){
                client.greet("world:"+i);
            }
        }finally {
            client.shutdown();
        }
    }
}
