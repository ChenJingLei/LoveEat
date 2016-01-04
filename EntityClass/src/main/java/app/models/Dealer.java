package app.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by HeZYSaaaaln on 2016/1/3.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dealer {

    private String id;

    private String openid;

    private String name;

    private String phone;

    public Dealer() {
    }

    public Dealer(String name, String phone) {
        this.name = name;
        this.phone = phone;
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
