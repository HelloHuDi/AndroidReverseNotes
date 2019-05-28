package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.y */
class C46742y implements ValueCallback<String[]> {
    /* renamed from: a */
    final /* synthetic */ ValueCallback f18020a;
    /* renamed from: b */
    final /* synthetic */ SystemWebChromeClient f18021b;

    C46742y(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.f18021b = systemWebChromeClient;
        this.f18020a = valueCallback;
    }

    /* renamed from: a */
    public void mo75289a(String[] strArr) {
        AppMethodBeat.m2504i(64149);
        this.f18020a.onReceiveValue(strArr);
        AppMethodBeat.m2505o(64149);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        AppMethodBeat.m2504i(64150);
        mo75289a((String[]) obj);
        AppMethodBeat.m2505o(64150);
    }
}
