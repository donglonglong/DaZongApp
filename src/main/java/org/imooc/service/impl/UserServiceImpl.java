package org.imooc.service.impl;

import org.imooc.bean.Ad;
import org.imooc.bean.User;
import org.imooc.dao.SysUserDao;
import org.imooc.dto.UserDto;
import org.imooc.service.UserService;
import org.imooc.util.CommonUtil;
import org.imooc.util.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("/userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserDao userDao;

    @Override
    public boolean validate(UserDto userDto) {
        return false;
    }

    @Override
    public boolean add(UserDto userDto) {
        User users = new User();
        users.setName(userDto.getName());
        users.setPassword(userDto.getPassword());
        users.setChName(userDto.getChName());
        users.setGroupId(userDto.getGroupId());
        System.out.println("添加的值是："+userDao.insert(users));
        return  userDao.insert(users)==1;
    }

    @Override
    public boolean modify(UserDto userDto) {
        User result = new User();
        System.out.println("userDto的值是："+userDto);
        BeanUtils.copyProperties(userDto, result);
        int updateCount = userDao.update(result);
        if(!CommonUtil.isEmpty(userDto.getPassword())){
            userDto.setPassword(MD5Util.getMD5(userDto.getPassword()));
        }
        return userDao.update(result)==1;
    }

    @Override
    public boolean remove(Long id) {
        return userDao.delete(id)==1;
    }

    @Override
    public UserDto getById(Long id) {
        UserDto userDto = new UserDto();
        User user = userDao.selectById(id);
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public List<User> getList() {
       List<User> users = userDao.select();
        return users;
    }
}
