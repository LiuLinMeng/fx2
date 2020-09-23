package cn.fx2.common.utils.log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//定义公共log
public class Fx2Log {
    Logger log;


    public Fx2Log(Class<?> clazz) {
        log = LoggerFactory.getLogger(clazz);
    }


    public void info(Object msg) {
        log.info("{}",msg);
    }

    public void debug(String msg) {
        log.debug(msg);
    }

    public void warn(String msg) {
        log.warn(msg);
    }

    public void error(Object msg) {
        log.error("异常日志 {}",msg);
    }
}
