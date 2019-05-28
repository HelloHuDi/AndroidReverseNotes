package com.tencent.p177mm.lib.riskscanner.p1533a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.lib.riskscanner.RiskScannerReqBufferProvider;

/* renamed from: com.tencent.mm.lib.riskscanner.a.a */
public final class C37876a {
    /* renamed from: bN */
    public static Bundle m63921bN(Context context) {
        Bundle bundle = null;
        AppMethodBeat.m2504i(114463);
        try {
            bundle = context.getContentResolver().call(RiskScannerReqBufferProvider.CONTENT_URI, "prepareReqBuffer", null, null);
            AppMethodBeat.m2505o(114463);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(114463);
        }
        return bundle;
    }
}
