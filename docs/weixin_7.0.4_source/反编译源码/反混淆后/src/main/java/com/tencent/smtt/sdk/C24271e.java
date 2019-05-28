package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.JsVirtualMachine.C24258a;

/* renamed from: com.tencent.smtt.sdk.e */
class C24271e implements ValueCallback<String> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f4523a;
    /* renamed from: b */
    final /* synthetic */ C24258a f4524b;

    C24271e(C24258a c24258a, ValueCallback valueCallback) {
        this.f4524b = c24258a;
        this.f4523a = valueCallback;
    }

    /* renamed from: a */
    public void mo40360a(String str) {
        AppMethodBeat.m2504i(63957);
        this.f4523a.onReceiveValue(str);
        AppMethodBeat.m2505o(63957);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.m2504i(63958);
        mo40360a((String) obj);
        AppMethodBeat.m2505o(63958);
    }
}
