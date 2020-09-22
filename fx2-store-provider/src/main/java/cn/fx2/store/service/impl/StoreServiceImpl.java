package cn.fx2.store.service.impl;

import cn.fx2.api.service.StoreService;
import com.alibaba.dubbo.config.annotation.Service;

@Service(timeout = 5000,version="1.0.0",interfaceClass = StoreService.class)
public class StoreServiceImpl implements StoreService {
    @Override
    public String list() {
        return "hello store";
    }
}
