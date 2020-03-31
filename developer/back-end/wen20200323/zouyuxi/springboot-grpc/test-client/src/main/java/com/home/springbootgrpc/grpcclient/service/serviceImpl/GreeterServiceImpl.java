package com.home.springbootgrpc.grpcclient.service.serviceImpl;


import com.home.grpc.namelib.GreeterGrpc;
import com.home.grpc.namelib.NameService;
import com.home.springbootgrpc.grpcclient.service.GreeterService;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;


/**
 * @author: 邹玉玺
 * @date: 2020/3/24-13:35
 */
@Service
public class GreeterServiceImpl implements GreeterService {
    //获取channel
    @GrpcClient("local-grpc-server")
    private Channel serverChannel;

    @Override
    public String sendMessage(String name) {
  //      System.out.println("进到impl");
        //连接通信
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub( serverChannel);
   //     System.out.println("通过stub");
        NameService.HelloReply resply = stub.sayHello(NameService.HelloRequest.newBuilder().setName(name).build());
  //      System.out.println(resply.getMessage()+"IMPL里面");
        return resply.getMessage();
    }
}
