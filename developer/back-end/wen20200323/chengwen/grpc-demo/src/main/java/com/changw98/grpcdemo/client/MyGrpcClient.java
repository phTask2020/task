package com.changw98.grpcdemo.client;

import com.changw98.grpcdemo.generate.MyRequest;
import com.changw98.grpcdemo.generate.MyResponse;
import com.changw98.grpcdemo.generate.MyServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;


/**
 * @Author: ChengWen
 * @Date: 2020/3/25
 * Time: 20:46
 * Description:
 */
public class MyGrpcClient {

    private final ManagedChannel channel;
    private final MyServiceGrpc.MyServiceBlockingStub blockingStub;


    public MyGrpcClient(String host,int port){
        channel=ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext(true)
                .build();
        blockingStub=MyServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException
    {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void greet(String name)
    {
        MyRequest myRequest=MyRequest.newBuilder().setName(name).build();
        MyResponse myResponse=blockingStub.sayHello(myRequest);
        System.out.println(myResponse.getMessage());
    }

    public static void main(String[] args)throws InterruptedException {
        MyGrpcClient myGrpcClient=new MyGrpcClient("127.0.0.1",5001);
        System.out.println("-------------------客户端开始访问请求-------------------");
        for (int i = 0; i < 100; i++) {
            myGrpcClient.greet("你若想生存，绝处也能缝生: " + i);
        }
    }

}
