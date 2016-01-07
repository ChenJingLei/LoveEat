package app.models;

/**
 * Created by HeZYSaaaaln on 2016/1/7.
 */
public class OrderFormStatus {
    //错误码
    private String msgCode;
    //结果
    private String result;
    //Goods类型
    private OrderForm orderform;

    public OrderFormStatus() {
    }

    public OrderFormStatus(String msgCode, String result, OrderForm orderform) {
        this.msgCode = msgCode;
        this.result = result;
        this.orderform = orderform;
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

    public OrderForm getOrderform() {
        return orderform;
    }

    public void setOrderform(OrderForm orderform) {
        this.orderform = orderform;
    }

    @Override
    public String toString() {
        return "OrderFormStatus{" +
                "msgCode='" + msgCode + '\'' +
                ", result='" + result + '\'' +
                ", orderform=" + orderform +
                '}';
    }
}
