package com.reuben.rpc.client;

import com.reuben.grpc.service.AccountGrpc;
import com.sun.javafx.binding.StringFormatter;
import com.reuben.grpc.entity.Account;
import com.reuben.grpc.entity.AccountResponse;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

/**
 * @program: grpc-demo
 * @description:
 * @author: reuben
 * @create: 2020-03-24 11:31
 **/
@Slf4j
public class AccountClient {

    private final AccountGrpc.AccountBlockingStub accountBlockingStub;

    private final BaseClient client;

    public AccountClient(BaseClient client) {
        this.client = client;
        this.accountBlockingStub = client.getAccountBlockingStub();
    }

    public void addAccount(String name, String sex, int age) {

        Account account = Account.getDefaultInstance().toBuilder()
                .setName(name)
                .setSex(sex)
                .setAge(age)
                .build();

        AccountResponse response = this.accountBlockingStub.addAccount(account);

        //System.out.println(StringFormatter.format("返回消息:%s\n状态:%d", response.getMsg(), response.getCode()).get());
        log.info(StringFormatter.format("返回消息:%s\n状态:%d", response.getMsg(), response.getCode()).get());

    }

    public void queryAccount(String name) {
        Account account = Account.getDefaultInstance().toBuilder()
                .setName(name).build();
        AccountResponse response = this.accountBlockingStub.getAccountByName(account);

        //System.out.println(StringFormatter.format("返回消息:%s\n状态:%d", response.getMsg(), response.getCode()).getValue());
        log.info(StringFormatter.format("返回消息:%s\n状态:%d", response.getMsg(), response.getCode()).getValue());
        //System.out.println("查询结果：");
        log.info("查询结果：");
        List<Account> list = response.getResultsList();
        for (Account acc : list) {
            log.info(StringFormatter.format("姓名:%s,性别:%s,年龄:%d", acc.getName(), acc.getSex(), acc.getAge()).get());
        }
    }
}
