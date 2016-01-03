package app.models;

/**
 * Created by cjl20 on 2016/1/3.
 */
public class IdentifyUserStatus {
    String msgCode;
    Object result;

    public IdentifyUserStatus() {
    }

    public IdentifyUserStatus(String msgCode, Object result) {
        this.msgCode = msgCode;
        this.result = result;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
