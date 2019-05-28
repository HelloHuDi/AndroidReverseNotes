package com.tencent.p177mm.model.gdpr;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.gdpr.C37918c.C379191;

/* renamed from: com.tencent.mm.model.gdpr.MPGdprPolicyUtil$1$1 */
class MPGdprPolicyUtil$1$1 extends ResultReceiver {
    final /* synthetic */ C379191 fos;

    MPGdprPolicyUtil$1$1(C379191 c379191, Handler handler) {
        this.fos = c379191;
        super(handler);
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        AppMethodBeat.m2504i(1488);
        r6.mo8219kL(i > 0 ? 0 : 1);
        AppMethodBeat.m2505o(1488);
    }
}
