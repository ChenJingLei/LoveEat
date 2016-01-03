package app.models;

/**
 * Created by cjl20 on 2016/1/3.
 */
public class AddUserStatus {

    //错误码
    private String msgCode;
    //结果
    private String result;

    public AddUserStatus(String msgCode, String result) {
        this.msgCode = msgCode;
        this.result = result;
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
}
