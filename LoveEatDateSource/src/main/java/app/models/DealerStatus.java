package app.models;

/**
 * Created by HeZYSaaaaln on 2016/1/7.
 */
public class DealerStatus {
    //错误码
    private String msgCode;
    //结果
    private String result;
    //Dealer
    private Dealer dealer;

    public DealerStatus() {
    }

    public DealerStatus(String msgCode, String result, Dealer dealer) {
        this.msgCode = msgCode;
        this.result = result;
        this.dealer = dealer;
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

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    @Override
    public String toString() {
        return "DealerStatus{" +
                "msgCode='" + msgCode + '\'' +
                ", result='" + result + '\'' +
                ", dealer=" + dealer +
                '}';
    }
}
