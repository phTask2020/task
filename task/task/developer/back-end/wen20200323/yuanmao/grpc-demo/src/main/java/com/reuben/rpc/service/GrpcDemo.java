package com.reuben.rpc.service;

import com.reuben.rpc.service.account.AccountImpl;
import com.reuben.rpc.service.geeter.GreeterImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @program: grpc-demo
 * @description:
 * @author: reuben
 * @create: 2020-03-24 11:32
 **/
@Slf4j
public class GrpcDemo {

    private Server server;

    /**
     * 服务启动类
     * @param port 端口
     * @throws IOException
     */
    private void start(int port) throws IOException {
        server = ServerBuilder.forPort(port)
                //注册服务
                .addService(new GreeterImpl())
                .addService(new AccountImpl())
                .build()
                .start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.error("*** JVM 关闭,导致gRPC服务关闭!");
            GrpcDemo.this.stop();
            log.error("*** 服务关闭");
        }));
    }

    /**
     * RPC 服务关闭
     */
    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * 设置守护进程
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * RPC服务启动main函数
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final GrpcDemo server = new GrpcDemo();
        server.start(50051);
        server.blockUntilShutdown();
    }
}
