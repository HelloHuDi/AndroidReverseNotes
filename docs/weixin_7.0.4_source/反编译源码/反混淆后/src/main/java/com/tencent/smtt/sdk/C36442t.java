package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.t */
class C36442t implements ValueCallback<Uri[]> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f15177a;
    /* renamed from: b */
    final /* synthetic */ C40981q f15178b;

    C36442t(C40981q c40981q, ValueCallback valueCallback) {
        this.f15178b = c40981q;
        this.f15177a = valueCallback;
    }

    /* renamed from: a */
    public void mo57627a(Uri[] uriArr) {
        AppMethodBeat.m2504i(64083);
        this.f15177a.onReceiveValue(uriArr);
        AppMethodBeat.m2505o(64083);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.m2504i(64084);
        mo57627a((Uri[]) obj);
        AppMethodBeat.m2505o(64084);
    }
}
