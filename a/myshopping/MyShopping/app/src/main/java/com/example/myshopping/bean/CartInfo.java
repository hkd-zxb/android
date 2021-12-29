package com.example.myshopping.bean;

//购物车信息
public class CartInfo {
    public int goods_id;
    public String name;
    public int pic;
    public String desc;
    public float price;

    public CartInfo() {
        name="";
        goods_id = 0;
        pic = 0;
        price=0;
        desc="";
    }
}
