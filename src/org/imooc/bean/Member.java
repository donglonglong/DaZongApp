package org.imooc.bean;

/**
 * Member 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-30 14:10:07
 * @version 1.0
 */
public class Member implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private long phone;
	private String name;
	private String password;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setPhone(long phone){
		this.phone = phone;
	}
	public long getPhone(){
		return this.phone;
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

}