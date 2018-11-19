package org.imooc.service;

import org.imooc.bean.User;
import org.imooc.dto.UserDto;

import java.util.List;

public interface UserService {

    /**
     * 校验用户名/密码是否正确
     * @param userDto 待校验dto对象
     * @return true：用户名/密码正确，如果正确，将dto对象里其他属性补齐
     *                false：用户名/密码错误
     */
    boolean validate(UserDto userDto);

    /***
     * 获取用户列表
     * @return
     */
    List<UserDto> getList();
    /**
     * 新增用户
     * @param userDto
     * @return
     */
    boolean add(UserDto userDto);

    /***
     * 修改用户
     * @param userDto
     * @return
     */
    boolean modify(UserDto userDto);

    /***
     * 删除用户
     * @param id
     * @return
     */
    boolean remove(Long id);


    /**
     * 通过ID获取用户
     * @param id
     * @return  用户对象
     */
    UserDto getById(Long id);




}

