package app.models;

/**
 * Created by HeZYSaaaaln on 2016/1/3.
 */

public class Goods {

    private Long id;

    private String name;

    private Long num;

    private String uprice;

    private String oplace;

    private String mdate;

    private String category;

    public Goods() {

    }

    public Goods(String name, Long num, String uprice, String oplace, String mdate) {
        this.name = name;
        this.num = num;
        this.uprice = uprice;
        this.oplace = oplace;
        this.mdate = mdate;
    }

    public Goods(Long id, String name, Long num, String uprice, String oplace, String mdate, String category) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.uprice = uprice;
        this.oplace = oplace;
        this.mdate = mdate;
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

    public String getUprice() {
        return uprice;
    }

    public void setUprice(String uprice) {
        this.uprice = uprice;
    }

    public String getOplace() {
        return oplace;
    }

    public void setOplace(String oplace) {
        this.oplace = oplace;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
                '}';
    }
}
