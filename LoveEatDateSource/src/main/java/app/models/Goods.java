package app.models;

import javax.persistence.*;
/**
 * Created by HeZYSaaaaln on 2016/1/3.
 */
@Table(name = "GoodsTable")
@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自动添加

    @Column(name = "Gid", columnDefinition = "INT")
    private Long id;

    @Column(name = "Gname", columnDefinition = "VARCHAR(100)", length = 100)
    private String name;

    @Column(name = "Gnum", columnDefinition = "VARCHAR(50)", length = 50)
    private String num;

    @Column(name = "Guprice", columnDefinition = "float")
    private String uprice;

    @Column(name = "Goplace", columnDefinition = "VARCHAR(100)",length = 100)
    private String oplace;

    @Column(name = "Gmdate", columnDefinition = "date")
    private String mdate;

    public Goods() {

    }

    public Goods(String name, String num, String uprice, String oplace, String mdate) {
        this.name = name;
        this.num = num;
        this.uprice = uprice;
        this.oplace = oplace;
        this.mdate = mdate;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
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

    @Override
    public String toString() {
        return "Goods{" +
                "mdate='" + mdate + '\'' +
                ", oplace='" + oplace + '\'' +
                ", uprice='" + uprice + '\'' +
                ", num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
