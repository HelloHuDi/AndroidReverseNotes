package com.tencent.luggage.bridge;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.luggage.bridge.r */
final class C8859r {
    private C45120n bOO;

    C8859r(C45120n c45120n) {
        this.bOO = c45120n;
    }

    @JavascriptInterface
    public final String send(String str, boolean z) {
        AppMethodBeat.m2504i(90746);
        String h = this.bOO.mo72930h(str, z);
        AppMethodBeat.m2505o(90746);
        return h;
    }
}
