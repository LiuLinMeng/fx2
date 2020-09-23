package cn.fx2.order.service.impl;

import cn.fx2.api.service.HelloService;
import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0",timeout = 5000,interfaceClass = HelloService.class)
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        return "hello";
    }
}
