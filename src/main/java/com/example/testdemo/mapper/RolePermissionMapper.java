package com.example.testdemo.mapper;
import java.util.List;

import com.example.testdemo.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

 /**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@Mapper
public interface RolePermissionMapper {
    /**
     * delete by primary key
     * @param roleId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(@Param("roleId") String roleId, @Param("permissionId") String permissionId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(RolePermission record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(RolePermission record);

    List<RolePermission> findByRoleId(@Param("roleId")String roleId);


}