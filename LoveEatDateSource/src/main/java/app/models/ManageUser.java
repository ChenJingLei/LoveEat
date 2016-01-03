package app.models;

import javax.persistence.*;

/**
 * Created by cjl20 on 2016/1/3.
 */
@Table(name = "ManageUserTable")
@Entity
public class ManageUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自动添加
    @Column(name = "MUid", columnDefinition = "INT")
    private Long id;

    @Column(name = "MUopenid", columnDefinition = "VARCHAR(100)", length = 100)
    private String OpenId;

    @Column(name = "MUname", columnDefinition = "VARCHAR(50)", length = 50)
    private String name;

    @Column(name = "MUphone", columnDefinition = "VARCHAR(11)")
    private String phone;

    public ManageUser() {
    }

    public ManageUser(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public ManageUser(String openId, String name, String phone) {
        OpenId = openId;
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
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
        return "ManageUser{" +
                "id=" + id +
                ", OpenId='" + OpenId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
