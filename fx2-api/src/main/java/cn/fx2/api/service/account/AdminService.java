package cn.fx2.api.service.account;

import cn.fx2.common.form.account.LoginForm;
import cn.fx2.common.utils.JsonResponseUtils;

public interface AdminService {
    JsonResponseUtils login(String username,String password); //登录
    JsonResponseUtils list(int page); //账户列表
    JsonResponseUtils register(LoginForm loginForm); //账户注册
}
