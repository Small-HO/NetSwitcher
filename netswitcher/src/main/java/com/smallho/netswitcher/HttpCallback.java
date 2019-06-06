package com.smallho.netswitcher;

import com.google.gson.Gson;
import com.smallho.netswitcher.interfaces.ICallback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by small-ho on 2019-06-05 17:22
 * title：通过反射返回json数据所有类型
 */
public abstract class HttpCallback<Result> implements ICallback {

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> clz = analysisClassInfo(this);
        Result objResult = (Result) gson.fromJson(result,clz);
        onSuccess(objResult);
    }

    private Class<?> analysisClassInfo(Object object) {
        Type type = object.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] params = parameterizedType.getActualTypeArguments();
            return (Class<?>) params[0];
        }else {
            return (Class<?>) type;
        }
    }

    public abstract void onSuccess(Result result);
}
