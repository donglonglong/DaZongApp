package org.imooc.service;

import org.imooc.bean.Page;
import org.imooc.dto.CommentForSubmitDto;
import org.imooc.dto.CommentListDto;

public interface CommentService {

    /**
     * 保存评论
     * @param commentForSubmitDto
     * @return
     */
    boolean add(CommentForSubmitDto commentForSubmitDto);

    /**
     * 安分页条件，根据商户ID获取商户下的评论列表dto
     * @param businessId
     * @param page
     * @return
     */
    CommentListDto getListByBusinessId(Long businessId, Page page);

}
