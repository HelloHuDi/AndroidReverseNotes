package com.google.firebase.iid;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.iid.ak */
final /* synthetic */ class C25585ak implements Callback {
    private final C17707aj bwX;

    C25585ak(C17707aj c17707aj) {
        this.bwX = c17707aj;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.m2504i(108830);
        boolean f = this.bwX.mo32789f(message);
        AppMethodBeat.m2505o(108830);
        return f;
    }
}
