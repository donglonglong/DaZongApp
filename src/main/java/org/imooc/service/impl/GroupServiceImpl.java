package org.imooc.service.impl;

import org.imooc.bean.Group;
import org.imooc.dao.GroupDao;
import org.imooc.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("/groupService")
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> getAll() {
        List<Group> list = groupDao.select();

        return list;
    }
}
