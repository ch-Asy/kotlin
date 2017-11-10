package com.ann.http.iml;

/**
 * Created by anliyuan on 2017/11/10.
 */

public interface SubscriberOnNextListener<T> {
    void onNext(T t);

    void onError();
}
