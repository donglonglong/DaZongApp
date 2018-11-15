package org.imooc.bean;

/**
 * Dic 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-30 14:10:07
 * @version 1.0
 */
public class Dic implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String type;
	private String code;
	private String name;
	private int weight;

	/** setter and getter method */
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}
	public void setCode(String code){
		this.code = code;
	}
	public String getCode(){
		return this.code;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setWeight(int weight){
		this.weight = weight;
	}
	public int getWeight(){
		return this.weight;
	}

}