package org.imooc.bean;

/**
 * Orders 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-30 14:10:07
 * @version 1.0
 */
public class Orders implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private int businessId;
	private int memberId;
	private int num;
	private int commentState;
	private String price;
	private java.util.Date createTime;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setBusinessId(int businessId){
		this.businessId = businessId;
	}
	public int getBusinessId(){
		return this.businessId;
	}
	public void setMemberId(int memberId){
		this.memberId = memberId;
	}
	public int getMemberId(){
		return this.memberId;
	}
	public void setNum(int num){
		this.num = num;
	}
	public int getNum(){
		return this.num;
	}
	public void setCommentState(int commentState){
		this.commentState = commentState;
	}
	public int getCommentState(){
		return this.commentState;
	}
	public void setPrice(String price){
		this.price = price;
	}
	public String getPrice(){
		return this.price;
	}
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

}