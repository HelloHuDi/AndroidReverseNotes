package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

public final class JsContext {
    private final JsVirtualMachine a;
    private final IX5JsContext b;
    private ExceptionHandler c;
    private String d;

    public interface ExceptionHandler {
        void handleException(JsContext jsContext, JsError jsError);
    }

    public JsContext(Context context) {
        this(new JsVirtualMachine(context));
        AppMethodBeat.i(63913);
        AppMethodBeat.o(63913);
    }

    public JsContext(JsVirtualMachine jsVirtualMachine) {
        AppMethodBeat.i(63914);
        if (jsVirtualMachine == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The virtualMachine value can not be null");
            AppMethodBeat.o(63914);
            throw illegalArgumentException;
        }
        this.a = jsVirtualMachine;
        this.b = this.a.a();
        try {
            this.b.setPerContextData(this);
            AppMethodBeat.o(63914);
        } catch (AbstractMethodError e) {
            AppMethodBeat.o(63914);
        }
    }

    public static JsContext current() {
        AppMethodBeat.i(63926);
        JsContext jsContext = (JsContext) X5JsCore.a();
        AppMethodBeat.o(63926);
        return jsContext;
    }

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(63915);
        this.b.addJavascriptInterface(obj, str);
        AppMethodBeat.o(63915);
    }

    public final void destroy() {
        AppMethodBeat.i(63916);
        this.b.destroy();
        AppMethodBeat.o(63916);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(63917);
        evaluateJavascript(str, valueCallback, null);
        AppMethodBeat.o(63917);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        AppMethodBeat.i(63918);
        this.b.evaluateJavascript(str, valueCallback, url);
        AppMethodBeat.o(63918);
    }

    public final JsValue evaluateScript(String str) {
        AppMethodBeat.i(63919);
        JsValue evaluateScript = evaluateScript(str, null);
        AppMethodBeat.o(63919);
        return evaluateScript;
    }

    public final JsValue evaluateScript(String str, URL url) {
        AppMethodBeat.i(63920);
        IX5JsValue evaluateScript = this.b.evaluateScript(str, url);
        if (evaluateScript == null) {
            AppMethodBeat.o(63920);
            return null;
        }
        JsValue jsValue = new JsValue(this, evaluateScript);
        AppMethodBeat.o(63920);
        return jsValue;
    }

    public final void evaluateScriptAsync(String str, ValueCallback<JsValue> valueCallback, URL url) {
        AppMethodBeat.i(63921);
        this.b.evaluateScriptAsync(str, valueCallback == null ? null : new c(this, valueCallback), url);
        AppMethodBeat.o(63921);
    }

    public final ExceptionHandler exceptionHandler() {
        return this.c;
    }

    public final String name() {
        return this.d;
    }

    public final void removeJavascriptInterface(String str) {
        AppMethodBeat.i(63922);
        this.b.removeJavascriptInterface(str);
        AppMethodBeat.o(63922);
    }

    public final void setExceptionHandler(ExceptionHandler exceptionHandler) {
        AppMethodBeat.i(63923);
        this.c = exceptionHandler;
        if (exceptionHandler == null) {
            this.b.setExceptionHandler(null);
            AppMethodBeat.o(63923);
            return;
        }
        this.b.setExceptionHandler(new d(this));
        AppMethodBeat.o(63923);
    }

    public final void setName(String str) {
        AppMethodBeat.i(63924);
        this.d = str;
        this.b.setName(str);
        AppMethodBeat.o(63924);
    }

    public final void stealValueFromOtherCtx(String str, JsContext jsContext, String str2) {
        AppMethodBeat.i(63925);
        this.b.stealValueFromOtherCtx(str, jsContext.b, str2);
        AppMethodBeat.o(63925);
    }

    public final JsVirtualMachine virtualMachine() {
        return this.a;
    }
}
