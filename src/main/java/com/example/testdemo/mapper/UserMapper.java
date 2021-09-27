package com.example.testdemo.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.example.testdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

 /**
  *${description}
  * @author     ：ShiYI
  * @date       ：Created in 2021/9/27
  */
@Mapper
public interface UserMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(User record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(User record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    User selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(User record);

    List<User> findByUsername(@Param("username")String username);


}