package org.imooc.dao;

import org.imooc.bean.Dic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dicDao")
public interface DicDao {
    List<Dic> select(Dic dic);
    int insert(Dic dic);
}
