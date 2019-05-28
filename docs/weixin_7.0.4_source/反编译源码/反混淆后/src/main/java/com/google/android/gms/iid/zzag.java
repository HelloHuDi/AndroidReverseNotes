package com.google.android.gms.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzag extends Handler {
    private final /* synthetic */ zzaf zzcx;

    zzag(zzaf zzaf, Looper looper) {
        this.zzcx = zzaf;
        super(looper);
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.m2504i(57547);
        this.zzcx.zze(message);
        AppMethodBeat.m2505o(57547);
    }
}
