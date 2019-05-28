package com.tencent.smtt.export.external.jscore.interfaces;

import android.webkit.ValueCallback;
import java.net.URL;

public interface IX5JsContext {
    void addJavascriptInterface(Object obj, String str);

    void destroy();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url);

    IX5JsValue evaluateScript(String str, URL url);

    void evaluateScriptAsync(String str, ValueCallback<IX5JsValue> valueCallback, URL url);

    void removeJavascriptInterface(String str);

    void setExceptionHandler(ValueCallback<IX5JsError> valueCallback);

    void setName(String str);

    void setPerContextData(Object obj);

    void stealValueFromOtherCtx(String str, IX5JsContext iX5JsContext, String str2);
}
