package cn.fx2.database.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface AdminDao {
    @Select("select * from fx2_admin")
    Map<String,Object> getOne();
}
