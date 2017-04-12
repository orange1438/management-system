package indi.orange1438.managementsystem.dto;

import indi.orange1438.managementsystem.enums.CodeResultEnum;

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

    // 操作结果代码 对应enums.CodeResultEnum
    private int code;

    // 消息
    private String message;

    // 对象
    private Object resultObj;

    public BaseResult() {
        this.requestId = null;
        this.success = false;
        this.code = CodeResultEnum.FAIL.getValue();
        this.message = null;
        this.resultObj = null;
    }

    public BaseResult(boolean success, String message) {
        this.requestId = null;
        this.success = success;
        this.message = message;
        this.resultObj = null;

        if (this.success) {
            this.code = CodeResultEnum.SUCCESS.getValue();
        } else {
            this.code = CodeResultEnum.FAIL.getValue();
        }
    }

    public BaseResult(boolean success, String message, Object resultObj) {
        this.requestId = null;
        this.success = success;
        this.message = message;
        this.resultObj = resultObj;
        if (this.success) {
            this.code = CodeResultEnum.SUCCESS.getValue();
        } else {
            this.code = CodeResultEnum.FAIL.getValue();
        }
    }

    public BaseResult(String requestId, boolean success, String message, Object resultObj) {
        this.requestId = requestId;
        this.success = success;
        this.message = message;
        this.resultObj = resultObj;
        if (this.success) {
            this.code = CodeResultEnum.SUCCESS.getValue();
        } else {
            this.code = CodeResultEnum.FAIL.getValue();
        }
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
