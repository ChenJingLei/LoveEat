package app.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by HeZYSaaaaln on 2016/1/3.
 */
@Table(name = "Dealer_Table")
@Entity
public class Dealer {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自动添加
    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")

    @Column(name = "Did", columnDefinition = "VARCHAR(32)",length = 32)
    private String id;

    @Column(name = "Dopenid", columnDefinition = "VARCHAR(100)", length = 100)
    private String openid;

    @Column(name = "Dname", columnDefinition = "VARCHAR(50)", length = 50)
    private String name;

    @Column(name = "Dphone", columnDefinition = "VARCHAR(11)", length = 11)
    private String phone;

    public Dealer() {
    }

    public Dealer(String openid, String name, String phone) {
        this.openid = openid;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
