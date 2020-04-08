package com.home.springbootgrpc.grpcclient.service.serviceImpl;

import com.home.grpc.userlib.User;
import com.home.grpc.userlib.UserPublicGrpc;
import com.home.springbootgrpc.grpcclient.service.UserService;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author: 邹玉玺
 * @date: 2020/3/25-15:03
 */
@Service
public class UserServiceImpl implements UserService {
    //获取channel通信通道
    @GrpcClient("local-grpc-server")
    private Channel serverChannel;

    @Override
    public String queryMessageById(Integer id) {
        //连接通信
        UserPublicGrpc.UserPublicBlockingStub stub = UserPublicGrpc.newBlockingStub(serverChannel);
        User.Reply resoult = stub.findUserMessageById(User.Request.newBuilder().setId(id).build());
        return resoult.getMessage();
    }
}
