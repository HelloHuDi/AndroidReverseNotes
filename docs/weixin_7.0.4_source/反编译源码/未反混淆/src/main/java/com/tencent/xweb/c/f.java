package com.tencent.xweb.c;

import android.webkit.ValueCallback;
import java.net.URL;
import java.nio.ByteBuffer;

public interface f {
    void a(com.tencent.xweb.f fVar);

    void addJavascriptInterface(Object obj, String str);

    void cleanup();

    boolean dTW();

    boolean dUA();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url);

    ByteBuffer getNativeBuffer(int i);

    int getNativeBufferId();

    void init(int i);

    void pause();

    void resume();

    void setNativeBuffer(int i, ByteBuffer byteBuffer);
}
