package com.example.manav;

import java.io.Serializable;

public class listdata implements Serializable {
    private String name;   // name of the employee
    private  String email;  // email of the employee

    public listdata(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public listdata(String email, int ic_dialog_email) {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
//    private static String description;
//    private int imgId;
//    public listdata(String description, int imgId) {
//        this.description = description;
//        this.imgId = imgId;
//    }
//    public static String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public int getImgId() {
//        return imgId;
//    }
//    public void setImgId(int imgId) {
//        this.imgId = imgId;
//    }

