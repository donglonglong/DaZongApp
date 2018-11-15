package org.imooc.dao;

import org.imooc.bean.Group;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("/groupDao")
public interface GroupDao {
    List<Group> select();
}
