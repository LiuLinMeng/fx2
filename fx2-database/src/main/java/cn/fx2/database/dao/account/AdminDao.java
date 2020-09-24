package cn.fx2.database.dao.account;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface AdminDao {
    Map<String,Object> getOne();
}
