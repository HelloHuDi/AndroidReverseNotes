package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.s */
class C36441s implements ValueCallback<Uri> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f15175a;
    /* renamed from: b */
    final /* synthetic */ C40981q f15176b;

    C36441s(C40981q c40981q, ValueCallback valueCallback) {
        this.f15176b = c40981q;
        this.f15175a = valueCallback;
    }

    /* renamed from: a */
    public void mo57626a(Uri uri) {
        AppMethodBeat.m2504i(64081);
        this.f15175a.onReceiveValue(new Uri[]{uri});
        AppMethodBeat.m2505o(64081);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.m2504i(64082);
        mo57626a((Uri) obj);
        AppMethodBeat.m2505o(64082);
    }
}
