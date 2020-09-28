package cn.fx2.account.service.impl;

import cn.fx2.api.service.AccountService;
import cn.fx2.common.utils.JsonResponseUtils;
import cn.fx2.database.dao.account.AdminDao;
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(timeout = 5000,version = "1.0.0",interfaceClass = AccountService.class)
@org.springframework.stereotype.Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AdminDao adminDao;

    @Override
    public String accountHello() {
        return "account hello";
    }

    @Override
    public JsonResponseUtils getOne() {
        return JsonResponseUtils.success("成功",adminDao.getUsernameInfo("admin"));
    }
}
