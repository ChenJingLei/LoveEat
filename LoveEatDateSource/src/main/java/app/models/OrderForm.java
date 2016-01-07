package app.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by HeZYSaaaaln on 2016/1/3.
 */
@Table(name = "Order_Form_Table")
@Entity

public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自动添加

    @Column(name = "OFid", columnDefinition = "INT")
    private Long ofid;

    @Column(name = "Gid", columnDefinition = "VARCHAR(32)",length = 32)
    private String gid;

    @Column(name = "Did", columnDefinition =  "VARCHAR(32)",length = 32)
    private String did;

    @Column(name = "OFnum", columnDefinition = "INT")
    private Long num;

    @Column(name = "OFaddress", columnDefinition = "VARCHAR(100)",length = 100)
    private String address;

    @Column(name = "OFdatetime", columnDefinition = "DATETIME")   //限还时间
    private Date datetime;

    public OrderForm() {
    }

    public OrderForm(String gid, String did, Long num, String address, Date datetime) {
        this.gid = gid;
        this.did = did;
        this.num = num;
        this.address = address;
        this.datetime = datetime;
    }

    public Long getOfid() {
        return ofid;
    }

    public void setOfid(Long ofid) {
        this.ofid = ofid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "ofid=" + ofid +
                ", gid=" + gid +
                ", did=" + did +
                ", num=" + num +
                ", address='" + address + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}