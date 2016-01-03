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
    private String Gname;

    @Column(name = "Gnum", columnDefinition = "VARCHAR(50)", length = 50)
    private String Gnum;

    @Column(name = "Guprice", columnDefinition = "float")
    private String Guprice;

    @Column(name = "Goplace", columnDefinition = "VARCHAR(100)",length = 100)
    private String Goplace;

    @Column(name = "GMdate", columnDefinition = "date")
    private String GMdate;

    public Goods(String gname, String gnum, String guprice, String goplace, String gmdate) {
        Gname = gname;
        Gnum = gnum;
        Guprice = guprice;
        Goplace = goplace;
        GMdate = gmdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGname() {
        return Gname;
    }

    public void setGname(String gname) {
        Gname = gname;
    }

    public String getGnum() {
        return Gnum;
    }

    public void setGnum(String gnum) {
        Gnum = gnum;
    }

    public String getGuprice() {
        return Guprice;
    }

    public void setGuprice(String guprice) {
        Guprice = guprice;
    }

    public String getGoplace() {
        return Goplace;
    }

    public void setGoplace(String goplace) {
        Goplace = goplace;
    }

    public String GMdate() {
        return GMdate;
    }

    public void setGmdate(String GMdate) {
        GMdate = GMdate;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", Gname='" + Gname + '\'' +
                ", Gnum='" + Gnum + '\'' +
                ", Guprice='" + Guprice + '\'' +
                ", Goplace='" + Goplace + '\'' +
                ", GMdate='" + GMdate + '\'' +
                '}';
    }
}
