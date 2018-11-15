package org.imooc.bean;

/**
 * Comment 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-30 14:10:07
 * @version 1.0
 */
public class Comment implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private int ordersId;
	private String comment;
	private int star;
	private java.util.Date createTime;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setOrdersId(int ordersId){
		this.ordersId = ordersId;
	}
	public int getOrdersId(){
		return this.ordersId;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
	public String getComment(){
		return this.comment;
	}
	public void setStar(int star){
		this.star = star;
	}
	public int getStar(){
		return this.star;
	}
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

}