package com.smallho.netswitcher.interfaces;

/**
 * Created by small-ho on 2019-06-05 17:17
 * title：接口统一回调
 */
public interface ICallback {
    //  返回两种结果，成功或失败
    void onSuccess(String result);
    void onFailure(String e);
}
