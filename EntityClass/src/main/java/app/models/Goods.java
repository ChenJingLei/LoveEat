package app.models;

import java.util.Date;

/**
 * Created by HeZYSaaaaln on 2016/1/3.
 */

public class Goods {

    private Long id;

    private String name;

    private Long num;

    private Float uprice;

    private String oplace;

    private Date mdate;

    private String category;

    private String barcode;

    public Goods() {

    }

    public Goods(String name, Long num, Float uprice, String oplace, Date mdate) {
        this.name = name;
        this.num = num;
        this.uprice = uprice;
        this.oplace = oplace;
        this.mdate = mdate;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Goods(String name, Long num, Float uprice, String oplace, Date mdate, String category, String barcode) {
        this.name = name;
        this.num = num;
        this.uprice = uprice;
        this.oplace = oplace;
        this.mdate = mdate;
        this.category = category;
        this.barcode = barcode;
    }

    public Goods(String name, Long num, Float uprice, String oplace, Date mdate, String category) {
        this.name = name;
        this.num = num;
        this.uprice = uprice;
        this.oplace = oplace;
        this.mdate = mdate;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Float getUprice() {
        return uprice;
    }

    public void setUprice(Float uprice) {
        this.uprice = uprice;
    }

    public String getOplace() {
        return oplace;
    }

    public void setOplace(String oplace) {
        this.oplace = oplace;
    }

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", uprice='" + uprice + '\'' +
                ", oplace='" + oplace + '\'' +
                ", mdate='" + mdate + '\'' +
                ", category='" + category + '\'' +
                ", barcode='" + barcode + '\'' +
                '}';
    }
}
