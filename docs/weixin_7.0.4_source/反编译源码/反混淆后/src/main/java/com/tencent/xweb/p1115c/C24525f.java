package com.tencent.xweb.p1115c;

import android.webkit.ValueCallback;
import com.tencent.xweb.C36586f;
import java.net.URL;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.xweb.c.f */
public interface C24525f {
    /* renamed from: a */
    void mo41188a(C36586f c36586f);

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
