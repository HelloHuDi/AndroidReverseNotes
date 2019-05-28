package com.tencent.p177mm.plugin.appbrand.p297h;

import android.webkit.ValueCallback;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.appbrand.h.i */
public interface C6747i extends C2169j {
    /* renamed from: a */
    void mo14967a(URL url, String str, ValueCallback<String> valueCallback);

    /* renamed from: a */
    void mo14968a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback);

    void addJavascriptInterface(Object obj, String str);

    /* renamed from: af */
    <T extends C2169j> T mo14970af(Class<T> cls);

    void destroy();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void setJsExceptionHandler(C33211h c33211h);
}
