package org.imooc.dao;

import org.imooc.bean.User;

import java.util.List;

public interface UserDao {

    /**
     * 根据条件查询用户列表
     * @param user
     * @return
     */
    List<User> select(User user);


    /***
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

    /***
     * 修改
     * @return 影响行数：如用户名将修改成与其他用户的用户名相同，影响行数为0，修改成功，影响行数为1
     */
    int update(User user);

    /***
     * 根据主键删除
     * @param id  主键
     * @return  影响行数
     */
    int delete(Long id);


}
