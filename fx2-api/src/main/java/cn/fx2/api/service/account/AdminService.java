package cn.fx2.api.service.account;

import cn.fx2.common.utils.JsonResponseUtils;
import cn.fx2.database.form.account.AdminForm;

public interface AdminService {
    JsonResponseUtils login(String username,String password); //登录
    JsonResponseUtils list(int page); //账户列表
    JsonResponseUtils register(AdminForm adminForm); //账户注册
}
