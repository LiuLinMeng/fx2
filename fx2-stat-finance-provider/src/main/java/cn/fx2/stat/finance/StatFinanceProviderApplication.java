package cn.fx2.stat.finance;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class StatFinanceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatFinanceProviderApplication.class, args);
    }
}
