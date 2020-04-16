package com.reuben.rpc.service.account;

import com.sun.javafx.binding.StringFormatter;
import io.grpc.stub.StreamObserver;
import com.reuben.grpc.entity.Account;
import com.reuben.grpc.entity.AccountResponse;
import com.reuben.grpc.service.AccountGrpc;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: grpc-demo
 * @description:
 * @author: reuben
 * @create: 2020-03-24 11:31
 **/
@Slf4j
public class AccountImpl extends AccountGrpc.AccountImplBase {

    @Override
    public void addAccount(Account request, StreamObserver<AccountResponse> responseObserver) {
        //处理请求参数
        log.info(StringFormatter.format("新增用户:%s\n性别:%s\n年龄:%d岁", request.getName(), request.getSex(), request.getAge()).get());

        //处理响应参数
        AccountResponse response = AccountResponse.getDefaultInstance().toBuilder()
                .setCode(10000)
                .setMsg("success!").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAccountByName(Account request, StreamObserver<AccountResponse> responseObserver) {
        String name = request.getName();
        //处理请求参数
        log.info(StringFormatter.format("请求查询用户名:%s", name).get());

        //处理响应参数
        List<Account> list = new ArrayList<>();
        Account account1 = Account.getDefaultInstance().toBuilder()
                .setName("张三")
                .setAge(20)
                .setSex("男").build();
        list.add(account1);

        Account account2 = Account.getDefaultInstance().toBuilder()
                .setAge(30)
                .setSex("男")
                .setName("李四").build();
        list.add(account2);


        List<Account> results = new ArrayList<>();
        for (Account account : list) {
            if (account.getName().equals(name)){
                results.add(account);
            }
        }


        AccountResponse response = AccountResponse.getDefaultInstance().toBuilder()
                .setCode(10000)
                .setMsg("success!")
                .addAllResults(results)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
