package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.aa */
class C40971aa implements ValueCallback<Uri> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f16288a;
    /* renamed from: b */
    final /* synthetic */ SystemWebChromeClient f16289b;

    C40971aa(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.f16289b = systemWebChromeClient;
        this.f16288a = valueCallback;
    }

    /* renamed from: a */
    public void mo64905a(Uri uri) {
        AppMethodBeat.m2504i(64152);
        this.f16288a.onReceiveValue(uri);
        AppMethodBeat.m2505o(64152);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.m2504i(64153);
        mo64905a((Uri) obj);
        AppMethodBeat.m2505o(64153);
    }
}
