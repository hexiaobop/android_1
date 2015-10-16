package com.example.adapter.yiyego.pojo;


public class Goods  {
	
	private int goods_id;         	//商品id
	private int number;				//库存
	private String name;			//商品名称
	private String imageurl;		//商品小图片	
	private int style_id;         	//商品类别    外键
	private String detailurl;       //详情页链接
	private  int  price;			//商品价格       类型待定
	private String 	selltotal;		//销量
	private String  introduce;      //商品介绍
	private String messagetotal;	//预留信息
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public int getStyle_id() {
		return style_id;
	}
	public void setStyle_id(int style_id) {
		this.style_id = style_id;
	}
	public String getDetailurl() {
		return detailurl;
	}
	public void setDetailurl(String detailurl) {
		this.detailurl = detailurl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSelltotal() {
		return selltotal;
	}
	public void setSelltotal(String selltotal) {
		this.selltotal = selltotal;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getMessagetotal() {
		return messagetotal;
	}
	public void setMessagetotal(String messagetotal) {
		this.messagetotal = messagetotal;
	}
	
	
	
	
	

}
