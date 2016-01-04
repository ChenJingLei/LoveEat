package app.models;

/**
 * Created by cjl20 on 2016/1/3.
 */
public class IdentifyUser {
    private String Openid;
    private String name;
    private String phone;
    private int identification;

    public IdentifyUser() {
    }

    public IdentifyUser(String openid, String name, String phone, int identification) {
        Openid = openid;
        this.name = name;
        this.phone = phone;
        this.identification = identification;
    }

    public String getOpenid() {
        return Openid;
    }

    public void setOpenid(String openid) {
        Openid = openid;
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

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }
}
