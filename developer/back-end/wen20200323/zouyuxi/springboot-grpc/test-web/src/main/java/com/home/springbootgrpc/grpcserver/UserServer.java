package com.home.springbootgrpc.grpcserver;
import com.home.grpc.userlib.User;
import com.home.grpc.userlib.UserPublicGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @author: 邹玉玺
 * @date: 2020/3/24-22:12
 */
@Slf4j
@GrpcService(User.class)
public class UserServer extends UserPublicGrpc.UserPublicImplBase {
    @Override
    public void findUserMessageById(User.Request request, StreamObserver<User.Reply> responseObserver) {
        //client传入的Id
        int id = request.getId();
        //根据ID在数据库中查询对应的msg
//        String sql = "select message from user where id = ? "
//        System.out.println(jdbcTemplate);
//        List<User> list = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
//        System.out.println(list.get(0));
        String message=("ID:"+id+":姓名：蔡徐坤；特长：唱跳、rop").toString();
        final User.Reply.Builder builder = User.Reply.newBuilder().setMessage(message);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
        //打印日志信息
        Log log = LogFactory.getLog(getClass());
        log.info("Returning " + message);
    }
}
