package app.models;

/**
 * Created by cjl20 on 2016/1/3.
 */
public class IdentifyUserStatus {
    String msgCode;
    IdentifyUser result;

    public IdentifyUserStatus() {
    }


    public IdentifyUserStatus(String msgCode, IdentifyUser result) {
        this.msgCode = msgCode;
        this.result = result;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public IdentifyUser getResult() {
        return result;
    }

    public void setResult(IdentifyUser result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "IdentifyUserStatus{" +
                "msgCode='" + msgCode + '\'' +
                ", result=" + result +
                '}';
    }
}
