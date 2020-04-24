package com.changw98.grpcdemo.server;


import com.changw98.grpcdemo.generate.MyRequest;
import com.changw98.grpcdemo.generate.MyResponse;
import com.changw98.grpcdemo.generate.MyServiceGrpc;
import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;


public class MyGrpcServer {
    private int port=5001;
    private Server server;




    private void start() throws IOException {
        server=ServerBuilder.forPort(port)
                .addService((BindableService)new MyGrpcImpl())
                .build()
                .start();
        System.out.println("------------------- 服务端服务已开启，等待客户端访问 -------------------");
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.out.println("shutting down gRPC server since JVM is shutting down");
                MyGrpcServer.this.stop();
                System.out.println("server shutdown");

            }
        });
    }
    private void stop()
    {
        if (server!=null)
            server.shutdown();
    }

    private void blockUntilShutdown()throws InterruptedException{
        if (server!=null)
            server.awaitTermination();
    }

    public static void main(String[] args)throws IOException,InterruptedException {
        final MyGrpcServer myGrpcServer=new MyGrpcServer();
        //启动服务
        myGrpcServer.start();

        //服务一直在线，不关闭
        myGrpcServer.blockUntilShutdown();

    }


    //定义一个实现服务接口的类
    private class MyGrpcImpl extends MyServiceGrpc.MyServiceImplBase{
        @Override
        public void sayHello(MyRequest myRequest, StreamObserver<MyResponse> responseObserver){
            //具体其他丰富的业务实现代码
            System.out.println("server"+myRequest.getName());
            MyResponse reply=MyResponse.newBuilder().setMessage(("响应消息："+myRequest.getName())).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}


