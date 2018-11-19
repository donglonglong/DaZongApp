package org.imooc.controller.system;

import com.sun.org.apache.regexp.internal.RE;
import org.imooc.constant.SessionKeyConst;
import org.imooc.content.PageCodeEnum;
import org.imooc.dto.GroupDto;
import org.imooc.dto.UserDto;
import org.imooc.service.GroupService;
import org.imooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller("loginController")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private HttpSession session;

    /***
     * 登录页面
     * @return
     */
    @RequestMapping
    public String index(){
        return "/system/login";
    }

    /**
     * session 超时
     * @param model
     * @return
     */
    @RequestMapping("/sessionTimeout")
    public String sessionTimeout(Model model){
        model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.SESSION_TIMEOUT );
        return "/system/error";
    }

    /***
     *  没有权限访问
     * @param model
     * @return
     */
    @RequestMapping("/noAuth")
    public String noAuth(Model model){
        model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.NO_AUTH );
        session.invalidate();
        return "/system/error";
    }

    /***
     *验证用户名， 密码是否正确，验证通过跳转至后台管理首页，验证失败跳转至首页
     * @param userDto
     * @param attr
     * @return
     */
    @RequestMapping("/validate")
    public String validate(UserDto userDto, RedirectAttributes attr){
        if(userService.validate(userDto)){
            session.setAttribute(SessionKeyConst.USER_INFO,userDto);
            //TODO  用来判断权限
            return "redirect:/index";
        }
        attr.addFlashAttribute(PageCodeEnum.KEY,PageCodeEnum.LOGIN_FAIL);
        return "redirect:/login";
    }

}
