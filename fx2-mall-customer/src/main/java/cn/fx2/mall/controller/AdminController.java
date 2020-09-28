package cn.fx2.mall.controller;

import cn.fx2.api.service.account.AdminService;
import cn.fx2.common.form.account.LoginForm;
import cn.fx2.common.utils.JsonResponseUtils;
import cn.fx2.common.utils.JsonUtils;
import cn.fx2.common.utils.StatusCodeUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Reference(version = "1.0.0",check = false)
    private AdminService adminService;

    @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
    public JsonResponseUtils login(@Validated LoginForm loginForm) throws BindException {
        System.out.println(JsonUtils.objectToJson(loginForm));
        try {
            return adminService.login(loginForm.getUsername(),loginForm.getPassword());
        } catch (Exception e) {
            return  JsonResponseUtils.error(StatusCodeUtils.SERVICE_NOT_AVAILABLE.getCode(),StatusCodeUtils.SERVICE_NOT_AVAILABLE.getMsg());
        }
    }
}
