package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.ah */
class C40972ah extends Handler {
    /* renamed from: a */
    final /* synthetic */ C36431ag f16290a;

    C40972ah(C36431ag c36431ag, Looper looper) {
        this.f16290a = c36431ag;
        super(looper);
    }

    public void handleMessage(Message message) {
        AppMethodBeat.m2504i(64255);
        if (message.what == 150) {
            C36431ag.m60062a(this.f16290a);
        }
        AppMethodBeat.m2505o(64255);
    }
}
