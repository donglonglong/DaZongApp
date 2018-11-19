package org.imooc.service.impl;

import org.imooc.bean.Group;
import org.imooc.dao.GroupDao;
import org.imooc.dto.GroupDto;
import org.imooc.service.GroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("/groupService")
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;



    @Override
    public List<GroupDto> getList() {
        List<GroupDto> result = new ArrayList<>();
        List<Group> groupList = groupDao.select(new Group());
        for(Group group:groupList){
            GroupDto groupDto = new GroupDto();
            result.add(groupDto);
            BeanUtils.copyProperties(group,groupDto );
            groupDto.setpId(0);
        }
         return result;
    }

    @Override
    public boolean add(GroupDto groupDto) {
        Group group = new Group();
        BeanUtils.copyProperties(groupDto,group);
        return groupDao.insert(group)==1;
    }

    @Override
    public boolean modify(GroupDto groupDto) {
        Group group = new Group();
        BeanUtils.copyProperties(groupDto,group );
        return groupDao.update(group)==1;
    }

    @Override
    public boolean remove(Long id) {
        return  groupDao.delete(id)==1;
    }

    @Override
    public GroupDto getById(Long id) {

       Group group = groupDao.selectById(id);
       GroupDto groupDto = new GroupDto();
        BeanUtils.copyProperties(group,groupDto);
        return groupDto;
    }

    /**
     * 根据主键获取用户组(包括用户组对应可以访问的菜单和动作)
     * @param id
     * @return 用户组对象
     */
    @Override
    public GroupDto getByIdWithMenuAction(Long id) {
        return null;
    }

    /***
     * 为用户组分配可以访问的菜单
     * @param groupDto
     * @return
     */
    @Override
    public boolean assignMenu(GroupDto groupDto) {
        return false;
    }
}
