package com.example.demo.domain;

import java.util.Date;

public class Post {
    private Long postNumber;
    private Long stuId;
    private String departmentName;
    private String category;
    private Long trader;
    private Long price;
    private String itemName;
    private String itemDescription;
    private String tradingStatus;
    private Date registrationDate;

    public Long getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Long postNumber) {
        this.postNumber = postNumber;
    }

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getTrader() {
        return trader;
    }

    public void setTrader(Long trader) {
        this.trader = trader;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getTradingStatus() {
        return tradingStatus;
    }

    public void setTradingStatus(String tradingStatus) {
        this.tradingStatus = tradingStatus;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String toString() {
        return "Post{" +
                "postNumber=" + postNumber +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", tradingStatus='" + tradingStatus + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", category='" + category + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}