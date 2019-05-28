package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;

/* renamed from: com.tencent.smtt.sdk.d */
class C24270d implements ValueCallback<IX5JsError> {
    /* renamed from: a */
    final /* synthetic */ JsContext f4522a;

    C24270d(JsContext jsContext) {
        this.f4522a = jsContext;
    }

    /* renamed from: a */
    public void mo40358a(IX5JsError iX5JsError) {
        AppMethodBeat.m2504i(63911);
        this.f4522a.f15116c.handleException(this.f4522a, new JsError(iX5JsError));
        AppMethodBeat.m2505o(63911);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.m2504i(63912);
        mo40358a((IX5JsError) obj);
        AppMethodBeat.m2505o(63912);
    }
}
