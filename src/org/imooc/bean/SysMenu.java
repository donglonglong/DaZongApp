package org.imooc.bean;

/**
 * SysMenu 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-30 14:10:07
 * @version 1.0
 */
public class SysMenu implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String url;
	private int parentId;
	private String orderNum;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public String getUrl(){
		return this.url;
	}
	public void setParentId(int parentId){
		this.parentId = parentId;
	}
	public int getParentId(){
		return this.parentId;
	}
	public void setOrderNum(String orderNum){
		this.orderNum = orderNum;
	}
	public String getOrderNum(){
		return this.orderNum;
	}

}