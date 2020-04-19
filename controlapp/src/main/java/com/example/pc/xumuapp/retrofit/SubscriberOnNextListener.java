package com.example.pc.xumuapp.retrofit;

/**
 * Created by QZS
 */

public interface SubscriberOnNextListener<T> {
    void onNext(T t);
    void onError(Throwable e);

}
