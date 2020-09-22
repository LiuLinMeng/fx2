package cn.fx2.mall.controller;

import cn.fx2.api.service.HelloService;
import cn.fx2.api.service.StoreService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Reference
    private HelloService helloService;
    @Reference
    private StoreService storeService;

    @GetMapping("/sayHello")
    private String sayHello(){

        System.out.println("调用sayHello成功了..." + " name:");

        return helloService.sayHello();
    }

    @GetMapping("/storeHello")
    private String storeHello() {
        return storeService.list();
    }
}
