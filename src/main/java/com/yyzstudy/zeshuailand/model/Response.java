package com.yyzstudy.zeshuailand.model;

public class Response {

    private int status;
    private String message;
    private Object data;



    public static Response ok(){
        return new Response(200,"ok",null);
    }
    public static Response ok(String message,Object data){
        return new Response(200,message,data);
    }



    public Response() {
    }

    public Response(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                '}';
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
