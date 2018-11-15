package org.imooc.bean;

/**
 * SysParam 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-30 14:10:08
 * @version 1.0
 */
public class SysParam implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String paramKey;
	private java.util.Date paramValue;
	private String paramDesc;

	/** setter and getter method */
	public void setParamKey(String paramKey){
		this.paramKey = paramKey;
	}
	public String getParamKey(){
		return this.paramKey;
	}
	public void setParamValue(java.util.Date paramValue){
		this.paramValue = paramValue;
	}
	public java.util.Date getParamValue(){
		return this.paramValue;
	}
	public void setParamDesc(String paramDesc){
		this.paramDesc = paramDesc;
	}
	public String getParamDesc(){
		return this.paramDesc;
	}

}