package com.example.testdemo.mapper;

import com.example.testdemo.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@Mapper
public interface PermissionMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Permission record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Permission record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Permission selectByPrimaryKey(String id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Permission record);

    @Select("SELECT code FROM t_permission WHERE id IN(\n" +
            "SELECT permission_id FROM t_role_permission WHERE role_id IN(\n" +
            "SELECT role_id FROM t_user_role WHERE user_id = #{id} \n" + ")\n" + ")")
    List<String> getAll(String id);

}