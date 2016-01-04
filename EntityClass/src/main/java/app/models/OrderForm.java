package app.models;

/**
 * Created by HeZYSaaaaln on 2016/1/3.
 */

public class OrderForm {

    private Long ofid;

    private Long gid;

    private Long did;

    private Long num;

    private String address;

    private String datetime;

    public OrderForm() {
    }

    public OrderForm(Long gid, Long did, Long num, String address, String datetime) {
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
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