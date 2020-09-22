package cn.fx2.store.service.impl;

import cn.fx2.api.service.StoreService;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class StoreServiceImpl implements StoreService {
    @Override
    public String list() {
        return "hello store";
    }
}
