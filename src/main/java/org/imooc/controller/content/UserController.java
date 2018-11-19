package org.imooc.controller.content;

import org.imooc.content.PageCodeEnum;
import org.imooc.dto.PageCodeDto;
import org.imooc.dto.UserDto;
import org.imooc.service.GroupService;
import org.imooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    /***
     * 获取用户列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getList(){
        return userService.getList();
    }

    /***
     * 新增用户
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public PageCodeDto add(UserDto userDto){
        PageCodeDto result;
        if(userService.add(userDto)){
            result = new PageCodeDto(PageCodeEnum.ADD_SUCCESS);
        }else {
            result = new PageCodeDto(PageCodeEnum.USERNAME_EXISTS);
        }
        return result;
    }


    /***
     * 根据主键获取用户Dto
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto getById(@PathVariable("id") Long id) {
        System.out.println("获取的ID值是："+id);
        return userService.getById(id);
    }

    /***
     * 修改用户
     */
    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public PageCodeDto modify(UserDto userDto) {
        PageCodeDto result;
        if(userService.modify(userDto)) {
            result = new PageCodeDto(PageCodeEnum.MODIFY_SUCCESS);
        } else {
            result = new PageCodeDto(PageCodeEnum.USERNAME_EXISTS);
        }
        return result;
    }

    /***
     * 删除用户
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public PageCodeDto  remove(@PathVariable("id")Long id){
        PageCodeDto result;
        if(userService.remove(id)){
            result =new PageCodeDto(PageCodeEnum.REMOVE_SUCCESS);
        }else {
            result = new PageCodeDto(PageCodeEnum.REMOVE_FAIL);
        }
        return  result;
    }

}
