package org.imooc.dao;

import org.imooc.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("/sysUserDao")
public interface SysUserDao {
    /***
     * 根据查询条件查询用户列表
     * @param
     * @return
     */
    List<User> select();

    /**
     * 新增
     * @param user
     * @return
     */
    int insert(User user);

    /***
     * 根据主键获取用户实体
     * @param id
     * @return
     */
    User selectById(Long id);

    /**
     * 修改
     * @param
     * @return
     */
    int update(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Long id);

}
