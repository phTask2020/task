package com.reuben.grpc.service;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 *定义rpc服务接口
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.6.1)",
    comments = "Source: entity/hello_account.proto")
public final class AccountGrpc {

  private AccountGrpc() {}

  public static final String SERVICE_NAME = "com.reuben.grpc.service.Account";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.reuben.grpc.entity.Account,
      com.reuben.grpc.entity.AccountResponse> METHOD_ADD_ACCOUNT =
      io.grpc.MethodDescriptor.<com.reuben.grpc.entity.Account, com.reuben.grpc.entity.AccountResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.reuben.grpc.service.Account", "addAccount"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.reuben.grpc.entity.Account.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.reuben.grpc.entity.AccountResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.reuben.grpc.entity.Account,
      com.reuben.grpc.entity.AccountResponse> METHOD_GET_ACCOUNT_BY_NAME =
      io.grpc.MethodDescriptor.<com.reuben.grpc.entity.Account, com.reuben.grpc.entity.AccountResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.reuben.grpc.service.Account", "getAccountByName"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.reuben.grpc.entity.Account.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.reuben.grpc.entity.AccountResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountStub newStub(io.grpc.Channel channel) {
    return new AccountStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AccountBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AccountFutureStub(channel);
  }

  /**
   * <pre>
   *定义rpc服务接口
   * </pre>
   */
  public static abstract class AccountImplBase implements io.grpc.BindableService {

    /**
     */
    public void addAccount(com.reuben.grpc.entity.Account request,
        io.grpc.stub.StreamObserver<com.reuben.grpc.entity.AccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_ACCOUNT, responseObserver);
    }

    /**
     */
    public void getAccountByName(com.reuben.grpc.entity.Account request,
        io.grpc.stub.StreamObserver<com.reuben.grpc.entity.AccountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ACCOUNT_BY_NAME, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD_ACCOUNT,
            asyncUnaryCall(
              new MethodHandlers<
                com.reuben.grpc.entity.Account,
                com.reuben.grpc.entity.AccountResponse>(
                  this, METHODID_ADD_ACCOUNT)))
          .addMethod(
            METHOD_GET_ACCOUNT_BY_NAME,
            asyncUnaryCall(
              new MethodHandlers<
                com.reuben.grpc.entity.Account,
                com.reuben.grpc.entity.AccountResponse>(
                  this, METHODID_GET_ACCOUNT_BY_NAME)))
          .build();
    }
  }

  /**
   * <pre>
   *定义rpc服务接口
   * </pre>
   */
  public static final class AccountStub extends io.grpc.stub.AbstractStub<AccountStub> {
    private AccountStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountStub(channel, callOptions);
    }

    /**
     */
    public void addAccount(com.reuben.grpc.entity.Account request,
        io.grpc.stub.StreamObserver<com.reuben.grpc.entity.AccountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_ACCOUNT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccountByName(com.reuben.grpc.entity.Account request,
        io.grpc.stub.StreamObserver<com.reuben.grpc.entity.AccountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ACCOUNT_BY_NAME, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *定义rpc服务接口
   * </pre>
   */
  public static final class AccountBlockingStub extends io.grpc.stub.AbstractStub<AccountBlockingStub> {
    private AccountBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.reuben.grpc.entity.AccountResponse addAccount(com.reuben.grpc.entity.Account request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_ACCOUNT, getCallOptions(), request);
    }

    /**
     */
    public com.reuben.grpc.entity.AccountResponse getAccountByName(com.reuben.grpc.entity.Account request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ACCOUNT_BY_NAME, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *定义rpc服务接口
   * </pre>
   */
  public static final class AccountFutureStub extends io.grpc.stub.AbstractStub<AccountFutureStub> {
    private AccountFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccountFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccountFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccountFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.reuben.grpc.entity.AccountResponse> addAccount(
        com.reuben.grpc.entity.Account request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_ACCOUNT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.reuben.grpc.entity.AccountResponse> getAccountByName(
        com.reuben.grpc.entity.Account request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ACCOUNT_BY_NAME, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_ACCOUNT = 0;
  private static final int METHODID_GET_ACCOUNT_BY_NAME = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccountImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccountImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_ACCOUNT:
          serviceImpl.addAccount((com.reuben.grpc.entity.Account) request,
              (io.grpc.stub.StreamObserver<com.reuben.grpc.entity.AccountResponse>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT_BY_NAME:
          serviceImpl.getAccountByName((com.reuben.grpc.entity.Account) request,
              (io.grpc.stub.StreamObserver<com.reuben.grpc.entity.AccountResponse>) responseObserver);
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

  private static final class AccountDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.reuben.grpc.service.ServiceProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AccountGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountDescriptorSupplier())
              .addMethod(METHOD_ADD_ACCOUNT)
              .addMethod(METHOD_GET_ACCOUNT_BY_NAME)
              .build();
        }
      }
    }
    return result;
  }
}
