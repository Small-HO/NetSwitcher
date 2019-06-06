package com.smallho.netswitcher;

import android.net.Uri;

import com.smallho.netswitcher.interfaces.ICallback;
import com.smallho.netswitcher.interfaces.IHttpProcessor;

import java.util.Map;
import java.util.Set;

/**
 * Created by small-ho on 2019-06-06 9:51
 * title：代理对象（proxy）
 */
public class HttpHelper implements IHttpProcessor {

    private static IHttpProcessor mIHttpProcessor = null;
    private static HttpHelper instance;
    private HttpHelper(){}

    public static HttpHelper getInstance() {
        synchronized (HttpHelper.class) {
            if (instance == null) {
                instance = new HttpHelper();
            }
        }
        return instance;
    }

    public static void init(IHttpProcessor httpProcessor) {
        mIHttpProcessor = httpProcessor;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallback callback) {
        String finalUrl = appendParams(url,params);
        mIHttpProcessor.post(finalUrl,params,callback);
    }

    @Override
    public void get(String url, Map<String, Object> params, ICallback callback) {
        String finalUrl = appendParams(url,params);
        mIHttpProcessor.get(finalUrl,params,callback);
    }

    /** 拼接字符串 */
    private String appendParams(String url, Map<String, Object> params) {
        if (url == null || params == null || params.isEmpty()) {
            return url;
        }
        Uri.Builder builder = Uri.parse(url).buildUpon();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            builder.appendQueryParameter(key, String.valueOf(params.get(key)));
        }
        return builder.build().toString();
    }
}
