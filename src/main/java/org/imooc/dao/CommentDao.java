package org.imooc.dao;

import org.imooc.bean.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("commentDao")
public interface CommentDao {

    /**
     * 根据查询条件分页查询评论列表
     * @param comment  查询条件
     * @return  评论列表
     */
    List<Comment> selectByPage(Comment comment);


    /***
     * 新增
     * @param comment
     * @return
     */
    int insert(Comment comment);

}
