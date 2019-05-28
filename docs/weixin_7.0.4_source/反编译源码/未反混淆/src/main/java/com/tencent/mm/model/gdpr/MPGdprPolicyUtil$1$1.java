package com.tencent.mm.model.gdpr;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.c.AnonymousClass1;

class MPGdprPolicyUtil$1$1 extends ResultReceiver {
    final /* synthetic */ AnonymousClass1 fos;

    MPGdprPolicyUtil$1$1(AnonymousClass1 anonymousClass1, Handler handler) {
        this.fos = anonymousClass1;
        super(handler);
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        AppMethodBeat.i(1488);
        r6.kL(i > 0 ? 0 : 1);
        AppMethodBeat.o(1488);
    }
}
