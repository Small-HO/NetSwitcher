package com.smallho.netswitcher.processor;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.smallho.netswitcher.interfaces.ICallback;
import com.smallho.netswitcher.interfaces.IHttpProcessor;

import java.util.Map;

/**
 * Created by small-ho on 2019-06-06 13:49
 * title：Volley框架 （RealSubject）
 */
public class VolleyProcessor implements IHttpProcessor {

    private static final String Tag = "VolleyProcessor.java";
    private static RequestQueue mRequestQueue = null;

    public VolleyProcessor(Context context) {mRequestQueue = Volley.newRequestQueue(context);}

    @Override
    public void post(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
        mRequestQueue.add(request);
    }

    @Override
    public void get(String url, Map<String, Object> params, final ICallback callback) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error.toString());
            }
        });
        mRequestQueue.add(request);
    }

}
