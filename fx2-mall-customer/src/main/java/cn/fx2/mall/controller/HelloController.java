package cn.fx2.mall.controller;

import cn.fx2.api.service.AccountService;
import cn.fx2.api.service.HelloService;
import cn.fx2.api.service.StoreService;
import cn.fx2.common.utils.log.Fx2Log;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Reference(version = "1.0.0",check = false)
    private HelloService helloService;
    @Reference(version = "1.0.0",check = false)
    private StoreService storeService;
    @Reference(version = "1.0.0",check = false)
    private AccountService accountService;
    private static final Fx2Log log = new Fx2Log(HelloController.class);

    @GetMapping("/sayHello")
    private String sayHello(){
        return helloService.sayHello();
    }

    @GetMapping("/storeHello")
    private String storeHello() {
        try {
            return storeService.list();
        } catch (Exception e) {
            return "错误了";
        }
    }

    @GetMapping("/accountHello")
    private String accountHello() {
        log.info("调用了accountHello");
        return accountService.accountHello();
    }
}
