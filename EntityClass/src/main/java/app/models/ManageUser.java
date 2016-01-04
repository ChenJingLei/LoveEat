package app.models;



/**
 * Created by cjl20 on 2016/1/3.
 */

public class ManageUser {


    private String id;


    private String openid;

    private String name;

    private String phone;

    public ManageUser() {
    }

    public ManageUser(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public ManageUser(String openid, String name, String phone) {
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
        return "ManageUser{" +
                "id='" + id + '\'' +
                ", openid='" + openid + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
