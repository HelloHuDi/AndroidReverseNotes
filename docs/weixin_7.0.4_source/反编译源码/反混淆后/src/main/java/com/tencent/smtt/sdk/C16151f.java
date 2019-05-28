package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.JsVirtualMachine.C24258a;

/* renamed from: com.tencent.smtt.sdk.f */
class C16151f implements ValueCallback<String> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f3029a;
    /* renamed from: b */
    final /* synthetic */ C24258a f3030b;

    C16151f(C24258a c24258a, ValueCallback valueCallback) {
        this.f3030b = c24258a;
        this.f3029a = valueCallback;
    }

    /* renamed from: a */
    public void mo28971a(String str) {
        AppMethodBeat.m2504i(63959);
        this.f3029a.onReceiveValue(null);
        AppMethodBeat.m2505o(63959);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.m2504i(63960);
        mo28971a((String) obj);
        AppMethodBeat.m2505o(63960);
    }
}
