package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * @date 2020-12-1 - 13:19
 * Created by Salmon
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候，如果是null的对象，key也会消失
public class ServerResponse<T> implements Serializable {

    private int statue;
    private String msg;
    private T data;

    private ServerResponse(int statue){
        this.statue = statue;
    }

    private ServerResponse(int statue,T data){
        this.statue = statue;
        this.data = data;
    }

    private ServerResponse(int statue,String msg,T data){
        this.statue = statue;
        this.msg = msg;
        this.data = data;
    }

    public ServerResponse(int statue,String msg){
        this.statue = statue;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不再序列化
    public boolean isSuccess(){
        return this.statue == ResponseCode.Success.getCode();
    }

    public int getStatue() {
        return statue;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.Success.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.Success.getCode(),msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.Success.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.Success.getCode(),msg,data);
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }

}
