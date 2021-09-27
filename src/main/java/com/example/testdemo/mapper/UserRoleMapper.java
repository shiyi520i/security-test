package com.example.testdemo.mapper;
import java.util.List;

import com.example.testdemo.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

 /**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@Mapper
public interface UserRoleMapper {
    /**
     * delete by primary key
     * @param userId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(UserRole record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserRole record);

    /**
     * select by primary key
     * @param userId primary key
     * @return object by primary key
     */
    UserRole selectByPrimaryKey(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserRole record);

    List<UserRole> findByUserId(@Param("userId")String userId);



}