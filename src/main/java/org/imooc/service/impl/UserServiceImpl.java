package org.imooc.service.impl;

import org.imooc.bean.User;
import org.imooc.dao.UserDao;
import org.imooc.dto.UserDto;
import org.imooc.service.UserService;
import org.imooc.util.CommonUtil;
import org.imooc.util.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("/userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /***
     * 判断用户登录是否成功
     * @param userDto 待校验dto对象
     * @return
     */
    @Override
    public boolean validate(UserDto userDto) {
        if(userDto !=null && !CommonUtil.isEmpty(userDto.getName()) && !CommonUtil.isEmpty(userDto.getPassword())){
            User user = new User();
            BeanUtils.copyProperties(userDto,user );
            List<User> list = userDao.select(user);
            if(list.size()==1){
                BeanUtils.copyProperties(list.get(0),userDto );
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * 新增用户
     * @param userDto
     * @return true:新增成功;false:因已存在相同用户名新增失败
     */
    @Override
    public boolean add(UserDto userDto) {
        User users = new User();
        users.setName(userDto.getName());
        users.setPassword(MD5Util.getMD5(userDto.getPassword()));
        users.setChName(userDto.getChName());
        users.setGroupId(userDto.getGroupId());
        System.out.println("添加的值是："+userDao.insert(users));
        return  userDao.insert(users)==1;
    }

    /**
     * 修改用户
     * @param userDto
     * @return true:修改成功;false:因已存在相同的用户名修改失败
     */
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

    /**
     * 通过id获取用户
     * @param id
     * @return 用户对象
     */
    @Override
    public UserDto getById(Long id) {
        UserDto userDto = new UserDto();
        User user = userDao.selectById(id);
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    /**
     * 获取用户列表
     * @return 用户列表
     */
    @Override
    public List<UserDto> getList() {
       List<UserDto> result = new ArrayList<>();
       List<User> userList = userDao.select(new User());
       for(User user:userList){
           UserDto  userDto = new UserDto();
           result.add(userDto);
           BeanUtils.copyProperties(user, userDto);
           userDto.setpId(0);
       }
       return result;
    }
}
