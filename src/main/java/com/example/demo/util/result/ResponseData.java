package com.example.demo.util.result;

public class ResponseData extends Response {
    private Object data;

    public ResponseData(Object data) {
        this.data = data;
    }

    public ResponseData(ExceptionMsg msg) {
        super(msg);
    }

    public ResponseData(String code, String msg) {
        super(code, msg);
    }

    public ResponseData(String code, String msg, Object data) {
        super(code, msg);
        this.data = data;
    }

    public ResponseData(ExceptionMsg msg, Object data) {
        super(msg);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "data=" + data +
                "} " + super.toString();
    }
}

/*return new ResponseData(ExceptionMsg.SUCCESS,"你好");*/
