package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.ab */
class C46735ab implements ValueCallback<Uri[]> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f18004a;
    /* renamed from: b */
    final /* synthetic */ SystemWebChromeClient f18005b;

    C46735ab(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.f18005b = systemWebChromeClient;
        this.f18004a = valueCallback;
    }

    /* renamed from: a */
    public void mo75279a(Uri[] uriArr) {
        AppMethodBeat.m2504i(64154);
        this.f18004a.onReceiveValue(uriArr);
        AppMethodBeat.m2505o(64154);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.m2504i(64155);
        mo75279a((Uri[]) obj);
        AppMethodBeat.m2505o(64155);
    }
}
