package org.imooc.bean;

/**
 * SysGroupMenu 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-30 14:10:07
 * @version 1.0
 */
public class SysGroupMenu implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private int groupId;
	private int menuId;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setGroupId(int groupId){
		this.groupId = groupId;
	}
	public int getGroupId(){
		return this.groupId;
	}
	public void setMenuId(int menuId){
		this.menuId = menuId;
	}
	public int getMenuId(){
		return this.menuId;
	}

}