package org.imooc.service;

import org.imooc.dto.MenuDto;
import org.imooc.dto.MenuForMoveDto;
import org.imooc.dto.MenuForZtreeDto;

import java.util.List;

public interface MenuService {
    /**
     * 获取菜单树列表
     * @return 菜单树列表
     */
    List<MenuForZtreeDto> getZtreeList();

    /**
     * 根据条件获取菜单列表
     * @return
     */
    List<MenuDto> getList(MenuDto menuDto);

    /***
     * 新增菜单
     * @param menuDto
     * @return true 新增成功；false :新增失败
     */
    boolean add(MenuDto menuDto);


    /**
     * 删除菜单
     * @param id
     * @return true 新增成功；false :新增失败
     */
    boolean remove(Long id);


    /**
     * 通过id获取菜单
     * @param id
     * @return 菜单dto对象
     */
    MenuDto getById(Long id);

    /**
     * 修改菜单
     * @param menuDto
     * @return true:修改成功;false:修改失败
     */
    boolean modify(MenuDto menuDto);

    /**
     * 菜单排序
     * @param menuForMoveDto
     * @return
     */
    boolean order(MenuForMoveDto menuForMoveDto);

}
