package com.smallho.netswitcher.interfaces;

import java.util.Map;

/**
 * Created by small-ho on 2019-06-05 17:19
 * title：代理接口（subject）
 */
public interface IHttpProcessor {
    //  网络进行访问时，需要url、参数、回调结果
    void post(String url, Map<String,Object> params,ICallback callback);
    void get(String url,Map<String,Object> params,ICallback callback);
}
