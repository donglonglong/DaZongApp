package org.imooc.controller.content;


import org.imooc.constant.DicTypeConst;
import org.imooc.content.PageCodeEnum;
import org.imooc.dto.BusinessDto;
import org.imooc.service.BusinessService;
import org.imooc.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/businesses")
public class BusinessController {

    @Value("${businessImage.savePath}")
    private String savePath;

    @Value("${businessImage.url}")
    private String url;


    @Autowired
    private BusinessService businessService;

    @Autowired
    private DicService dicService;
    /** 加载商户列表页面 */
    @RequestMapping(method = RequestMethod.GET)
    public String search(Model model, BusinessDto dto) {
        model.addAttribute("list", businessService.searchByPage(dto));
        model.addAttribute("searchParam", dto);
        return "/content/businessList";
    }
    /** 删除商户信息*/
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable("id") String id) {
        System.out.println("获取的ID值是："+id);
        return "redirect:/businesses";
    }


    /** 加载商户添加页面*/
    @RequestMapping(value = "/addPage",method = RequestMethod.GET)
    public String addPage(Model model){
        model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
        model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
        return "/content/businessAdd";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(BusinessDto dto, RedirectAttributes attr){
        if(businessService.add(dto)) {
            attr.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
            return "redirect:/businesses";
        } else {
            attr.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
            return "redirect:/businesses/addPage";
        }
    }

    @RequestMapping(value = "/{id}",method= RequestMethod.GET)
    public String modifyInit(Model model,@PathVariable("id")Long id){
        model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
        model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
        model.addAttribute("modifyObj", businessService.getById(id));
        return "/content/businessModify";
    }

//    @RequestMapping(value = "/{id}",method =RequestMethod.PUT)
//    public String  modify(@PathVariable("id")Long id,BusinessDto businessDto){
//        if(businessService.edit(businessDto)) {
////            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_SUCCESS);
//            return "redirect:/businesses";
//        } else {
////            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_FAIL);
//            return "redirect:/businesses/addPage";
//        }
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String modify(@PathVariable("id") Long id, BusinessDto dto,Model model) {
        model.addAttribute("modifyObj", dto);
        System.out.println("商家的Id是："+id);


        if( businessService.edit(dto)) {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_SUCCESS);
            return "redirect:/businesses";
        } else {
            model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.MODIFY_FAIL);
            return "redirect:/modifyInit";
        }
     }



    //soap和rest  协议
    //resuful == rest
    //分布式系统应用层解决方案
    //github的api
    //SOAP基于XML   REST 基于HTTP 方便快速应用
    // 创建，获取，删除，修改
    //REST API接口测试规范
    //HTTPS协议，确保交互信息的安全
}
