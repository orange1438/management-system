package indi.orange1438.managementsystem.dto;

import java.io.Serializable;

/**
 * json对象容器
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/31 10:20
 */
public class BaseResult implements Serializable {


    // 请求唯一ID
    private String requestId;

    // 成功标记
    private boolean success;

    // 消息
    private String message;

    // 对象
    private Object resultObj;

    public BaseResult() {
        this.requestId = null;
        this.success = false;
        this.message = null;
        this.resultObj = null;
    }

    public BaseResult(boolean success, String message) {
        this.requestId = null;
        this.success = success;
        this.message = message;
        this.resultObj = null;
    }

    public BaseResult(boolean success, String message, Object resultObj) {
        this.requestId = null;
        this.success = success;
        this.message = message;
        this.resultObj = resultObj;
    }

    public BaseResult(String requestId, boolean success, String message, Object resultObj) {
        this.requestId = requestId;
        this.success = success;
        this.message = message;
        this.resultObj = resultObj;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResultObj() {
        return resultObj;
    }

    public void setResultObj(Object resultObj) {
        this.resultObj = resultObj;
    }
}
