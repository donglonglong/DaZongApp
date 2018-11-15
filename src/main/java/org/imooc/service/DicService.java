package org.imooc.service;

import org.imooc.bean.Dic;
import org.imooc.dto.DicDto;

import java.util.List;

public interface DicService {
    List<Dic> getListByType(String type);
    boolean addDic(DicDto dicDto);
}
