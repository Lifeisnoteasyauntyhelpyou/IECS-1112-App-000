package com.example.orderinssystem;

public class DataClass {

    private String dataTitle;
    private String dataMoney;
    private String dataNumber;
    //private String dataImage;

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataMoney() {
        return dataMoney;
    }

    public String getDataNumber() {
        return dataNumber;
    }

   // public String getDataImage() {
    //    return dataImage;
    //}

    public DataClass(String dataTitle, String dataMoney, String dataNumber) {
        this.dataTitle = dataTitle;
        this.dataMoney = dataMoney;
        this.dataNumber = dataNumber;
        //this.dataImage = dataImage;
    }

    public DataClass(){

    }
}
