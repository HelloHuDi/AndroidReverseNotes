package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;

class c implements ValueCallback<IX5JsValue> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ JsContext b;

    c(JsContext jsContext, ValueCallback valueCallback) {
        this.b = jsContext;
        this.a = valueCallback;
    }

    public void a(IX5JsValue iX5JsValue) {
        AppMethodBeat.i(63909);
        this.a.onReceiveValue(iX5JsValue == null ? null : new JsValue(this.b, iX5JsValue));
        AppMethodBeat.o(63909);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.i(63910);
        a((IX5JsValue) obj);
        AppMethodBeat.o(63910);
    }
}
