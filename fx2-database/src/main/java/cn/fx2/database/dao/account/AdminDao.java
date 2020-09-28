package cn.fx2.database.dao.account;

import cn.fx2.database.pojo.account.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminDao {
    Map<String,Object> getUsernameInfo(@Param("username") String username); //根据用户名查询账户信息(登录和其他使用)
    List<Map<String,Object>> getList(@Param("page") int page,@Param("pageSize") int pageSize); //查询账户列表
    int register(Admin admin); //账号注册
}
