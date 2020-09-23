package cn.fx2.account.service.impl;

import cn.fx2.api.service.AccountService;
import com.alibaba.dubbo.config.annotation.Service;

@Service(timeout = 5000,version = "1.0.0",interfaceClass = AccountService.class)
public class AccountServiceImpl implements AccountService {

    @Override
    public String accountHello() {
        return "account hello";
    }
}
