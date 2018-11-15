package org.imooc.controller.content;

import org.imooc.bean.Dic;
import org.imooc.constant.DicTypeConst;
import org.imooc.dto.DicDto;
import org.imooc.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/dic")
public class DicController {

    @Autowired
    private DicService dicService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Dic> list = dicService.getListByType(DicTypeConst.CITY);
        model.addAttribute("lists",list );
       return "/content/dicList";
    }

    @RequestMapping(value = "/toadd",method = RequestMethod.GET)
    public String toadd(){
        return "/content/adCity";
    }

    @RequestMapping("/add")
    public String add(DicDto dicDto,Model model){
        dicService.addDic(dicDto);
        model.addAttribute("searchParam", dicDto);
        return "redirect:list";
    }

}
