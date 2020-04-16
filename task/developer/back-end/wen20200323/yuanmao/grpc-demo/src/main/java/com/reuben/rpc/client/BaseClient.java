package com.reuben.rpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.reuben.grpc.service.AccountGrpc;
import com.reuben.grpc.service.GreeterGrpc;

import java.util.concurrent.TimeUnit;

/**
 * @program: grpc-demo
 * @description:
 * @author: reuben
 * @create: 2020-03-24 11:31
 **/
public class BaseClient {

    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterBlockingStub greeterBlockingStub;
    private final AccountGrpc.AccountBlockingStub accountBlockingStub;

    private BaseClient(ManagedChannel channel) {
        this.channel = channel;
        this.greeterBlockingStub = GreeterGrpc.newBlockingStub(channel);
        this.accountBlockingStub = AccountGrpc.newBlockingStub(channel);
    }

    /**
     * 构造客户端与Greeter 服务端连接 {@code host:port}
     *
     * @param host 主机地址
     * @param port 端口
     */
    public BaseClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext(true)
                .build());
    }

    /**
     * 关闭函数
     *
     * @throws InterruptedException
     */
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public GreeterGrpc.GreeterBlockingStub getGreeterBlockingStub() {
        return greeterBlockingStub;
    }

    public AccountGrpc.AccountBlockingStub getAccountBlockingStub() {
        return accountBlockingStub;
    }
}