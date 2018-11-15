package org.imooc.bean;

/**
 * SysAction 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-30 14:10:07
 * @version 1.0
 */
public class SysAction implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String url;
	private int menuId;
	private String method;

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
	public void setMenuId(int menuId){
		this.menuId = menuId;
	}
	public int getMenuId(){
		return this.menuId;
	}
	public void setMethod(String method){
		this.method = method;
	}
	public String getMethod(){
		return this.method;
	}

}