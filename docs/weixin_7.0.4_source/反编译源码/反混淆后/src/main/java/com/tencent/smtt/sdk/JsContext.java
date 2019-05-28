package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

public final class JsContext {
    /* renamed from: a */
    private final JsVirtualMachine f15114a;
    /* renamed from: b */
    private final IX5JsContext f15115b;
    /* renamed from: c */
    private ExceptionHandler f15116c;
    /* renamed from: d */
    private String f15117d;

    public interface ExceptionHandler {
        void handleException(JsContext jsContext, JsError jsError);
    }

    public JsContext(Context context) {
        this(new JsVirtualMachine(context));
        AppMethodBeat.m2504i(63913);
        AppMethodBeat.m2505o(63913);
    }

    public JsContext(JsVirtualMachine jsVirtualMachine) {
        AppMethodBeat.m2504i(63914);
        if (jsVirtualMachine == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The virtualMachine value can not be null");
            AppMethodBeat.m2505o(63914);
            throw illegalArgumentException;
        }
        this.f15114a = jsVirtualMachine;
        this.f15115b = this.f15114a.mo40330a();
        try {
            this.f15115b.setPerContextData(this);
            AppMethodBeat.m2505o(63914);
        } catch (AbstractMethodError e) {
            AppMethodBeat.m2505o(63914);
        }
    }

    public static JsContext current() {
        AppMethodBeat.m2504i(63926);
        JsContext jsContext = (JsContext) X5JsCore.m88580a();
        AppMethodBeat.m2505o(63926);
        return jsContext;
    }

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(63915);
        this.f15115b.addJavascriptInterface(obj, str);
        AppMethodBeat.m2505o(63915);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(63916);
        this.f15115b.destroy();
        AppMethodBeat.m2505o(63916);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(63917);
        evaluateJavascript(str, valueCallback, null);
        AppMethodBeat.m2505o(63917);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        AppMethodBeat.m2504i(63918);
        this.f15115b.evaluateJavascript(str, valueCallback, url);
        AppMethodBeat.m2505o(63918);
    }

    public final JsValue evaluateScript(String str) {
        AppMethodBeat.m2504i(63919);
        JsValue evaluateScript = evaluateScript(str, null);
        AppMethodBeat.m2505o(63919);
        return evaluateScript;
    }

    public final JsValue evaluateScript(String str, URL url) {
        AppMethodBeat.m2504i(63920);
        IX5JsValue evaluateScript = this.f15115b.evaluateScript(str, url);
        if (evaluateScript == null) {
            AppMethodBeat.m2505o(63920);
            return null;
        }
        JsValue jsValue = new JsValue(this, evaluateScript);
        AppMethodBeat.m2505o(63920);
        return jsValue;
    }

    public final void evaluateScriptAsync(String str, ValueCallback<JsValue> valueCallback, URL url) {
        AppMethodBeat.m2504i(63921);
        this.f15115b.evaluateScriptAsync(str, valueCallback == null ? null : new C44456c(this, valueCallback), url);
        AppMethodBeat.m2505o(63921);
    }

    public final ExceptionHandler exceptionHandler() {
        return this.f15116c;
    }

    public final String name() {
        return this.f15117d;
    }

    public final void removeJavascriptInterface(String str) {
        AppMethodBeat.m2504i(63922);
        this.f15115b.removeJavascriptInterface(str);
        AppMethodBeat.m2505o(63922);
    }

    public final void setExceptionHandler(ExceptionHandler exceptionHandler) {
        AppMethodBeat.m2504i(63923);
        this.f15116c = exceptionHandler;
        if (exceptionHandler == null) {
            this.f15115b.setExceptionHandler(null);
            AppMethodBeat.m2505o(63923);
            return;
        }
        this.f15115b.setExceptionHandler(new C24270d(this));
        AppMethodBeat.m2505o(63923);
    }

    public final void setName(String str) {
        AppMethodBeat.m2504i(63924);
        this.f15117d = str;
        this.f15115b.setName(str);
        AppMethodBeat.m2505o(63924);
    }

    public final void stealValueFromOtherCtx(String str, JsContext jsContext, String str2) {
        AppMethodBeat.m2504i(63925);
        this.f15115b.stealValueFromOtherCtx(str, jsContext.f15115b, str2);
        AppMethodBeat.m2505o(63925);
    }

    public final JsVirtualMachine virtualMachine() {
        return this.f15114a;
    }
}
