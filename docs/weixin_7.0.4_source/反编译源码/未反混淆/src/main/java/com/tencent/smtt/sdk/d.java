package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

class d implements ValueCallback<IX5JsError> {
    final /* synthetic */ JsContext a;

    d(JsContext jsContext) {
        this.a = jsContext;
    }

    public void a(IX5JsError iX5JsError) {
        AppMethodBeat.i(63911);
        this.a.c.handleException(this.a, new JsError(iX5JsError));
        AppMethodBeat.o(63911);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.i(63912);
        a((IX5JsError) obj);
        AppMethodBeat.o(63912);
    }
}
