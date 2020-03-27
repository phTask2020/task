package com.home.springbootgrpc.grpcserver;


import com.home.grpc.namelib.GreeterGrpc;
import com.home.grpc.namelib.NameService;
import com.home.grpc.usertestlib.Person;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @author: 邹玉玺
 * @date: 2020/3/23-23:37
 */
@Slf4j
@GrpcService(NameService.class)
public class GreeterServer extends GreeterGrpc.GreeterImplBase {
 @Override
   public void sayHello(NameService.HelloRequest request, StreamObserver<NameService.HelloReply> responseObserver){
     //设置欢迎语
     //数据从数据库取得，此处做一个demo
     String message=(request.getName()+",欢迎您的访问，GRPC服务器正常运行，客户端已接收").toString();
     
    final NameService.HelloReply.Builder builder =NameService.HelloReply.newBuilder().setMessage(message);
     responseObserver.onNext(builder.build());
     responseObserver.onCompleted();
     //将欢迎语打印在日志信息上
     Log log = LogFactory.getLog(getClass());
     log.info("Returning " + message);
 }
}
