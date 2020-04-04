package com.ph.grpcserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.GreeterGrpc;
import io.grpc.examples.Helloword;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

/**
 * @description:
 * @author: 杨利华
 * @date: 2020/3/24
 */
public class HelloWordServer {
    private int port = 8080;
    private Server server;

    /**
     * 启动服务
     * @throws IOException
     */
    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                //服务器关闭
                HelloWordServer.this.stop();
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    //阻塞 一直到退出程序
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


    public static void main(String[] args) throws IOException
            , InterruptedException {
        final HelloWordServer server = new HelloWordServer();
        server.start();
        server.blockUntilShutdown();
    }


    //实现 定义一个实现服务接口的类
    private class GreeterImpl extends GreeterGrpc.GreeterImplBase {
        public void sayHello(Helloword.HelloRequest req,
                             StreamObserver<Helloword.HelloReply> responseObserver) {
            //获取参数
            System.out.println("收到客户端信息:" + req.getName());
            //构造返回
            Helloword.HelloReply reply = Helloword.HelloReply.newBuilder()
                    .setMessage(("Hello: " + req.getName())).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}

