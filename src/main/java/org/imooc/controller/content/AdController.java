package org.imooc.controller.content;

import org.imooc.content.PageCodeEnum;
import org.imooc.dto.AdDto;
import org.imooc.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller()
@RequestMapping("/ad")
public class AdController {

    @Autowired
    private AdService adService;
    /** 进入默认页面 */
    @RequestMapping("/initList")
    public String init(Model model){
        AdDto adDto = new AdDto();
        model.addAttribute("list",adService.searchByPage(adDto));
        model.addAttribute("searchParam", adDto);
        return "/content/adList";
    }
    /** 进入添加页面 */
    @RequestMapping("/addInit")
    public String addInit(){
        return "/content/adAdd";
    }

    /** 提交添加按钮 */
    @RequestMapping("/add")
    public String add(AdDto adDto, Model model) {
        if (adService.add(adDto)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
        }
        return "/content/adAdd";
    }

    /** 删除广告列表 */
    @RequestMapping("/remove")
    public  String remove(@RequestParam("id")Long id,Model model){
        System.out.println("获取的id的值是："+id);
        if(adService.remove(id)) {
            System.out.println(id);
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_SUCCESS);
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.REMOVE_FAIL);
        }
        return "forward:/ad";
    }

    /** 查询广告列表 */
    @RequestMapping("/search")
    public String search(Model model, AdDto adDto) {
        model.addAttribute("list", adService.searchByPage(adDto));
        model.addAttribute("searchParam", adDto);
        return "/content/adList";
    }

    /** 进入修改页面 */
    @RequestMapping("/modifyInit")
    public String modifyInit(@RequestParam("id") long id,Model model){
        model.addAttribute("modifyObj", adService.getById(id));
        return "/content/adModify";
    }

    @RequestMapping("/modify")
    public String modify(Model model,AdDto adDto){
        model.addAttribute("modifyObj", adDto);
        if(adService.modify(adDto)){
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.MODIFY_SUCCESS );
        }else {
            model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.MODIFY_FAIL );
        }
        return "redirect:initList";
    }




}
