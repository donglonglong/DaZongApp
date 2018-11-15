package org.imooc.service;

 import org.imooc.bean.Business;
 import org.imooc.dto.BusinessDto;
 import org.imooc.dto.BusinessListDto;

 import java.util.List;

public interface BusinessService {


    List<BusinessDto> searchByPage(BusinessDto businessDto);

    public BusinessDto getById(Long id);

    boolean add(BusinessDto businessDto);

    boolean edit(BusinessDto businessDto);

    BusinessListDto searchByPageForApi(BusinessDto businessDto);


}
