package org.imooc.controller.content;

import org.imooc.content.PageCodeEnum;
import org.imooc.dto.UserDto;
import org.imooc.service.GroupService;
import org.imooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @RequestMapping("/list")
    public String UserList(Model model){
        model.addAttribute("list",userService.getList());
        return "/content/userList";
    }

    @RequestMapping(value = "/modifyInit")
    public String modifyInit(@RequestParam("id") Long id,Model model){
        model.addAttribute("modifyObj",userService.getById(id));
        model.addAttribute("groups",groupService.getAll());
        System.out.println("所有的分类是："+groupService.getAll());
        return "/content/userModify";
    }

    /**
     * 修改用户
     */
    @RequestMapping(value = "/modify")
    public String modify(@PathVariable("id") Long id,UserDto userDto) {
        userService.modify(userDto);
        return "redirect:list" ;
    }


    @RequestMapping(value = "/toadd")
    public String toadd(Model model){
        model.addAttribute("groups",groupService.getAll());
        return "/content/userAdd";
    }

    @RequestMapping(value = "/add")
    public String add(Model model,UserDto userDto){
        if(userService.add(userDto)){
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_SUCCESS );
        }else {
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_FAIL );
        }
        return "redirect:list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable("id") Long id) {
        System.out.println("获取的ID值是："+id);
        return "redirect:/businesses";
    }




}
