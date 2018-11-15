package org.imooc.bean;

/**
 * Business 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-30 14:10:07
 * @version 1.0
 */
public class Business implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String imgFileName;
	private String title;
	private String subtitle;
	private String price;
	private int distance;
	private int number;
	private String desc;
	private String city;
	private String category;
	private int starTotalNum;
	private int commentTotalNum;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setImgFileName(String imgFileName){
		this.imgFileName = imgFileName;
	}
	public String getImgFileName(){
		return this.imgFileName;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setSubtitle(String subtitle){
		this.subtitle = subtitle;
	}
	public String getSubtitle(){
		return this.subtitle;
	}
	public void setPrice(String price){
		this.price = price;
	}
	public String getPrice(){
		return this.price;
	}
	public void setDistance(int distance){
		this.distance = distance;
	}
	public int getDistance(){
		return this.distance;
	}
	public void setNumber(int number){
		this.number = number;
	}
	public int getNumber(){
		return this.number;
	}
	public void setDesc(String desc){
		this.desc = desc;
	}
	public String getDesc(){
		return this.desc;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return this.city;
	}
	public void setCategory(String category){
		this.category = category;
	}
	public String getCategory(){
		return this.category;
	}
	public void setStarTotalNum(int starTotalNum){
		this.starTotalNum = starTotalNum;
	}
	public int getStarTotalNum(){
		return this.starTotalNum;
	}
	public void setCommentTotalNum(int commentTotalNum){
		this.commentTotalNum = commentTotalNum;
	}
	public int getCommentTotalNum(){
		return this.commentTotalNum;
	}

}