package cn.fx2.account.service.impl;

import cn.fx2.api.service.account.AdminService;
import cn.fx2.common.form.account.LoginForm;
import cn.fx2.common.utils.JsonResponseUtils;
import cn.fx2.common.utils.Md5Utils;
import cn.fx2.common.utils.StatusCodeUtils;
import cn.fx2.common.utils.code.AdminCodeUtils;
import cn.fx2.common.utils.log.Fx2Log;
import cn.fx2.database.dao.account.AdminDao;
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service(timeout = 5000,version = "1.0.0",interfaceClass = AdminService.class)
@org.springframework.stereotype.Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;
    private static final Fx2Log log = new Fx2Log(AdminServiceImpl.class);

    @Override
    public JsonResponseUtils login(String username, String password) {
        Map<String, Object> usernameInfo = adminDao.getUsernameInfo(username);
        if(usernameInfo == null || usernameInfo.isEmpty()) {
            return JsonResponseUtils.error(StatusCodeUtils.SELECT_FAIL.getCode(),"用户不存在");
        }
        if(!usernameInfo.get("password").toString().equals(Md5Utils.getMD5(password))) {
            return JsonResponseUtils.error(AdminCodeUtils.PASSWORD_ERROR.getAdminCode(),AdminCodeUtils.PASSWORD_ERROR.getAdminMsg());
        }
        Map<String,Object> map = new HashMap<>();
        map.put("id",usernameInfo.get("id"));
        map.put("username",usernameInfo.get("username"));
        map.put("token",usernameInfo.get("token"));
        return JsonResponseUtils.success("登录成功,正在跳转中....",map);
    }

    @Override
    public JsonResponseUtils list(int page) {
        return null;
    }

    @Override
    public JsonResponseUtils register(LoginForm loginForm) {
        return null;
    }
}
