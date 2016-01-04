package app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by cjl20 on 2016/1/3.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Manage_User_Table")
@Entity
public class ManageUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自动添加
//    @GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
//    @GeneratedValue(generator="idGenerator")
    @Column(name = "MUid", columnDefinition = "INT")
    private Long id;

    @Column(name = "MUopenid", columnDefinition = "VARCHAR(100)", length = 100)
    private String openid;

    @Column(name = "MUname", columnDefinition = "VARCHAR(50)", length = 50)
    private String name;

    @Column(name = "MUphone", columnDefinition = "VARCHAR(11)", length = 11)
    private String phone;

    public ManageUser() {
    }

    public ManageUser(String openid, String name, String phone) {
        this.openid = openid;
        this.name = name;
        this.phone = phone;
    }

    public ManageUser(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "ManageUser{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
