package app.models;

/**
 * Created by HeZYSaaaaln on 2016/1/7.
 */
public class GoodsStatus {
    //错误码
    private String msgCode;
    //结果
    private String result;
    //Goods类型
    private Goods goods;

    public GoodsStatus() {
    }

    public GoodsStatus(String msgCode, String result, Goods goods) {
        this.msgCode = msgCode;
        this.result = result;
        this.goods = goods;
    }
    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "GoodsStatus{" +
                "msgCode='" + msgCode + '\'' +
                ", result='" + result + '\'' +
                ", goods=" + goods +
                '}';
    }
}
