package com.home.grpc.userlib;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * 定义服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.1)",
    comments = "Source: user.proto")
public final class UserPublicGrpc {

  private UserPublicGrpc() {}

  public static final String SERVICE_NAME = "userserver.UserPublic";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.home.grpc.userlib.User.Request,
      com.home.grpc.userlib.User.Reply> getFindUserMessageByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindUserMessageById",
      requestType = com.home.grpc.userlib.User.Request.class,
      responseType = com.home.grpc.userlib.User.Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.home.grpc.userlib.User.Request,
      com.home.grpc.userlib.User.Reply> getFindUserMessageByIdMethod() {
    io.grpc.MethodDescriptor<com.home.grpc.userlib.User.Request, com.home.grpc.userlib.User.Reply> getFindUserMessageByIdMethod;
    if ((getFindUserMessageByIdMethod = UserPublicGrpc.getFindUserMessageByIdMethod) == null) {
      synchronized (UserPublicGrpc.class) {
        if ((getFindUserMessageByIdMethod = UserPublicGrpc.getFindUserMessageByIdMethod) == null) {
          UserPublicGrpc.getFindUserMessageByIdMethod = getFindUserMessageByIdMethod = 
              io.grpc.MethodDescriptor.<com.home.grpc.userlib.User.Request, com.home.grpc.userlib.User.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "userserver.UserPublic", "FindUserMessageById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.home.grpc.userlib.User.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.home.grpc.userlib.User.Reply.getDefaultInstance()))
                  .setSchemaDescriptor(new UserPublicMethodDescriptorSupplier("FindUserMessageById"))
                  .build();
          }
        }
     }
     return getFindUserMessageByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserPublicStub newStub(io.grpc.Channel channel) {
    return new UserPublicStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserPublicBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserPublicBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserPublicFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserPublicFutureStub(channel);
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public static abstract class UserPublicImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 服务中的方法，用于根据ID获取user信息
     * </pre>
     */
    public void findUserMessageById(com.home.grpc.userlib.User.Request request,
        io.grpc.stub.StreamObserver<com.home.grpc.userlib.User.Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getFindUserMessageByIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindUserMessageByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.home.grpc.userlib.User.Request,
                com.home.grpc.userlib.User.Reply>(
                  this, METHODID_FIND_USER_MESSAGE_BY_ID)))
          .build();
    }
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class UserPublicStub extends io.grpc.stub.AbstractStub<UserPublicStub> {
    private UserPublicStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserPublicStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserPublicStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserPublicStub(channel, callOptions);
    }

    /**
     * <pre>
     * 服务中的方法，用于根据ID获取user信息
     * </pre>
     */
    public void findUserMessageById(com.home.grpc.userlib.User.Request request,
        io.grpc.stub.StreamObserver<com.home.grpc.userlib.User.Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindUserMessageByIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class UserPublicBlockingStub extends io.grpc.stub.AbstractStub<UserPublicBlockingStub> {
    private UserPublicBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserPublicBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserPublicBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserPublicBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 服务中的方法，用于根据ID获取user信息
     * </pre>
     */
    public com.home.grpc.userlib.User.Reply findUserMessageById(com.home.grpc.userlib.User.Request request) {
      return blockingUnaryCall(
          getChannel(), getFindUserMessageByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class UserPublicFutureStub extends io.grpc.stub.AbstractStub<UserPublicFutureStub> {
    private UserPublicFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserPublicFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserPublicFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserPublicFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 服务中的方法，用于根据ID获取user信息
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.home.grpc.userlib.User.Reply> findUserMessageById(
        com.home.grpc.userlib.User.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getFindUserMessageByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_USER_MESSAGE_BY_ID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserPublicImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserPublicImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_USER_MESSAGE_BY_ID:
          serviceImpl.findUserMessageById((com.home.grpc.userlib.User.Request) request,
              (io.grpc.stub.StreamObserver<com.home.grpc.userlib.User.Reply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserPublicBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserPublicBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.home.grpc.userlib.User.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserPublic");
    }
  }

  private static final class UserPublicFileDescriptorSupplier
      extends UserPublicBaseDescriptorSupplier {
    UserPublicFileDescriptorSupplier() {}
  }

  private static final class UserPublicMethodDescriptorSupplier
      extends UserPublicBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserPublicMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserPublicGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserPublicFileDescriptorSupplier())
              .addMethod(getFindUserMessageByIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
