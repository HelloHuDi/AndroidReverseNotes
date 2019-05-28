package com.tencent.mm.lib.riskscanner.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider;

public final class a {
    public static Bundle bN(Context context) {
        Bundle bundle = null;
        AppMethodBeat.i(114463);
        try {
            bundle = context.getContentResolver().call(RiskScannerReqBufferProvider.CONTENT_URI, "prepareReqBuffer", null, null);
            AppMethodBeat.o(114463);
        } catch (Throwable th) {
            AppMethodBeat.o(114463);
        }
        return bundle;
    }
}
