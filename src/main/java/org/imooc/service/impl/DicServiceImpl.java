package org.imooc.service.impl;

import org.imooc.bean.Dic;
import org.imooc.constant.DicTypeConst;
import org.imooc.dao.DicDao;
import org.imooc.dto.DicDto;
import org.imooc.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("dicService")
public class DicServiceImpl implements DicService {
    @Autowired
    private DicDao dicDao;


    @Override
    public List<Dic> getListByType(String type) {
        Dic dic = new Dic();
        dic.setType(type);
        return dicDao.select(dic);
    }

    @Override
    public boolean addDic(DicDto dicDto) {
        Dic dic1 = new Dic();
        dic1.setType(DicTypeConst.CITY);
        dic1.setCode(dicDto.getName());
        dic1.setName(dicDto.getName());
        dic1.setWeight(dicDto.getWeight());
       int count = dicDao.insert(dic1);
       if(count==1){
           return true;
       }else {
           return false;
       }
    }
}
