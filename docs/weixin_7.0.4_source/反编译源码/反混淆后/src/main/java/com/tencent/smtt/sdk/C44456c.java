package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;

/* renamed from: com.tencent.smtt.sdk.c */
class C44456c implements ValueCallback<IX5JsValue> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f17298a;
    /* renamed from: b */
    final /* synthetic */ JsContext f17299b;

    C44456c(JsContext jsContext, ValueCallback valueCallback) {
        this.f17299b = jsContext;
        this.f17298a = valueCallback;
    }

    /* renamed from: a */
    public void mo70630a(IX5JsValue iX5JsValue) {
        AppMethodBeat.m2504i(63909);
        this.f17298a.onReceiveValue(iX5JsValue == null ? null : new JsValue(this.f17299b, iX5JsValue));
        AppMethodBeat.m2505o(63909);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.m2504i(63910);
        mo70630a((IX5JsValue) obj);
        AppMethodBeat.m2505o(63910);
    }
}
