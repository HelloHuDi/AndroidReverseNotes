package com.tencent.mm.plugin.appbrand.h;

import android.webkit.ValueCallback;
import java.net.URL;

public interface i extends j {
    void a(URL url, String str, ValueCallback<String> valueCallback);

    void a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback);

    void addJavascriptInterface(Object obj, String str);

    <T extends j> T af(Class<T> cls);

    void destroy();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void setJsExceptionHandler(h hVar);
}
