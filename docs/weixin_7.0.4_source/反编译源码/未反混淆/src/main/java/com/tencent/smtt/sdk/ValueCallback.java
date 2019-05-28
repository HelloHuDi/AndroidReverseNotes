package com.tencent.smtt.sdk;

public interface ValueCallback<T> extends android.webkit.ValueCallback<T> {
    void onReceiveValue(T t);
}
