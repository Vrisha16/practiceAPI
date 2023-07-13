package com.bestbuy.model;

public class StoresPojo {

    //private String id;
    private String name;
    private String type;
    private String adress;
    private  String city;
    private  String state;
    private  String zip;
    private String lat;
    private String ing;
    private String hours;
    private String createdAt;
    private String updatedAt;

   // public String getid(){return id;}
   // public void setid(String id){this.id=id;}
    public String getname(){return name;}
    public void setName(String name){this.name=name;}

    public String getType(){return type;}
    public void setType(String type){this.type=type;}
    public String getAdress(){return adress;}
    public void setadress(String adress){this.adress=adress;}
    public String getCity(){return city;}
    public void setCity(String city){this.city=city;}
    public String getState(){return state;}
    public void setState(String state){this.state=state;}
    public String getZip(){return zip;}
    public void setZip(String zip){this.zip=zip;}

    public String getLat(){return lat;}
    public void setLat(String lat){this.lat=lat;}

    public String getIng(){return ing;}
    public void setIng(String lat){this.ing=ing;}
    public String getHours(){return hours;}
    public void setHours(String hours){this.hours=hours;}

    public String getCreatedAt(){return createdAt;}
    public void setCreatedAt(String createdAt){this.createdAt=createdAt;}

    public String getUpdatedAt(){return updatedAt;}
    public void setUpdatedAt(String updatedAt){this.updatedAt=updatedAt;}

}
