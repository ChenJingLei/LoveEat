package app.models;

import javax.persistence.*;

/**
 * Created by HeZYSaaaaln on 2016/1/3.
 */
@Table(name = "OrderFormTable")
@Entity
public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自动添加

    @Column(name = "OFid", columnDefinition = "INT")
    private Long OFid;

    @Column(name = "Gid", columnDefinition = "INT")
    private Long Gid;

    @Column(name = "Did", columnDefinition = "INT")
    private Long Did;

    @Column(name = "OFnum", columnDefinition = "INT")
    private Long num;

    @Column(name = "OFaddress", columnDefinition = "INT")
    private Long address;

    public OrderForm() {
    }

    public OrderForm(Long gid, Long did, Long num, Long address) {
        Gid = gid;
        Did = did;
        this.num = num;
        this.address = address;
    }

    public Long getOFid() {
        return OFid;
    }

    public void setOFid(Long OFid) {
        this.OFid = OFid;
    }

    public Long getGid() {
        return Gid;
    }

    public void setGid(Long gid) {
        Gid = gid;
    }

    public Long getDid() {
        return Did;
    }

    public void setDid(Long did) {
        Did = did;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "address=" + address +
                ", num=" + num +
                ", Did=" + Did +
                ", Gid=" + Gid +
                ", OFid=" + OFid +
                '}';
    }
}
