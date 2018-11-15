package org.imooc.bean;

/**
 * SysUser 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-30 14:10:08
 * @version 1.0
 */
public class SysUser implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String password;
	private String chName;
	private int groupId;

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
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setChName(String chName){
		this.chName = chName;
	}
	public String getChName(){
		return this.chName;
	}
	public void setGroupId(int groupId){
		this.groupId = groupId;
	}
	public int getGroupId(){
		return this.groupId;
	}

}