package com.example.administrator.mydairy;

/**
 * Created by Administrator on 2017/5/9.
 */

public class Bean {
    //"number varchar(40),zhijing varchar(40),bihou varchar(40)," +
    //            "changdu varchar(40),zhongliang varchar(40),shuliang varchar(40)," +
    //                    "pinzhong varchar(40),caizhi varchar(40),weizhi varchar(40),ruku varchar(40))"
    public Boolean Edit;
   public String number;
   public String zhijing;
   public String bihou;
   public String changdu;
   public String zhongliang;
   public String shuliang;
   public String pinzhong;
   public String caizhi;
   public String weizhi;
   public String ruku;
    public String jilu;

    public Bean(){

    }

    public Bean(String number,String zhijing,String bihou,String changdu,String zhongliang,String shuliang,String pinzhong,String caizhi,String weizhi,String ruku){
        this.number = number;
        this.zhijing = zhijing;
        this.bihou = bihou;
        this.changdu = changdu;
        this.zhongliang = zhongliang;
        this.shuliang = shuliang;
        this.pinzhong = pinzhong;
        this.caizhi = caizhi;
        this.weizhi = weizhi;
        this.ruku = ruku;

    }

    public Bean(String number,String zhijing,String bihou,String changdu,String zhongliang,String shuliang,String pinzhong,String caizhi,String weizhi,String ruku,String jilu){
        this.number = number;
        this.zhijing = zhijing;
        this.bihou = bihou;
        this.changdu = changdu;
        this.zhongliang = zhongliang;
        this.shuliang = shuliang;
        this.pinzhong = pinzhong;
        this.caizhi = caizhi;
        this.weizhi = weizhi;
        this.ruku = ruku;
        this.jilu = jilu;

    }

    public String getJilu() {
        return jilu;
    }

    public void setJilu(String jilu) {
        this.jilu = jilu;
    }

    public Boolean getEdit() {
        return Edit;
    }

    public void setEdit(Boolean edit) {
        Edit = edit;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZhijing() {
        return zhijing;
    }

    public void setZhijing(String zhijing) {
        this.zhijing = zhijing;
    }

    public String getBihou() {
        return bihou;
    }

    public void setBihou(String bihou) {
        this.bihou = bihou;
    }

    public String getChangdu() {
        return changdu;
    }

    public void setChangdu(String changdu) {
        this.changdu = changdu;
    }

    public String getZhongliang() {
        return zhongliang;
    }

    public void setZhongliang(String zhongliang) {
        this.zhongliang = zhongliang;
    }

    public String getShuliang() {
        return shuliang;
    }

    public void setShuliang(String shuliang) {
        this.shuliang = shuliang;
    }

    public String getPinzhong() {
        return pinzhong;
    }

    public void setPinzhong(String pinzhong) {
        this.pinzhong = pinzhong;
    }

    public String getCaizhi() {
        return caizhi;
    }

    public void setCaizhi(String caizhi) {
        this.caizhi = caizhi;
    }

    public String getWeizhi() {
        return weizhi;
    }

    public void setWeizhi(String weizhi) {
        this.weizhi = weizhi;
    }

    public String getRuku() {
        return ruku;
    }

    public void setRuku(String ruku) {
        this.ruku = ruku;
    }
}
