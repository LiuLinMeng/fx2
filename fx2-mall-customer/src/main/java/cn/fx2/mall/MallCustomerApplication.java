package cn.fx2.mall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class MallCustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallCustomerApplication.class, args);
    }
}
