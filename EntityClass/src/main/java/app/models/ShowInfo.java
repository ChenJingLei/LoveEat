package app.models;

import java.util.List;

/**
 * Created by HeZYSaaaaln on 2016/1/5.
 */
public class ShowInfo {
    List list;
    private String msgCode;
    private String result;

    public ShowInfo() {
    }

    public ShowInfo(String result, String msgCode) {
        this.result = result;
        this.msgCode = msgCode;
    }

    public ShowInfo(List list, String msgCode, String result) {
        this.list = list;
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

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public ShowInfo(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ShowInfo{" +
                "list=" + list +
                ", msgCode='" + msgCode + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
