package app.models;

import javax.persistence.*;

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

    @Column(name = "Gid", columnDefinition = "INT")
    private Long gid;

    @Column(name = "Did", columnDefinition = "INT")
    private Long did;

    @Column(name = "OFnum", columnDefinition = "INT")
    private Long num;

    @Column(name = "OFaddress", columnDefinition = "INT")
    private String address;

    public OrderForm() {
    }

    public OrderForm(Long gid, Long did, Long num, String address) {
        this.gid = gid;
        this.did = did;
        this.num = num;
        this.address = address;
    }

    public Long getOfid() {
        return ofid;
    }

    public void setOfid(Long ofid) {
        this.ofid = ofid;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
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

    @Override
    public String toString() {
        return "OrderForm{" +
                "ofid=" + ofid +
                ", gid=" + gid +
                ", did=" + did +
                ", num=" + num +
                ", address='" + address + '\'' +
                '}';
    }
}