package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbf extends Handler {
    private final /* synthetic */ zzbd zzjh;

    zzbf(zzbd zzbd, Looper looper) {
        this.zzjh = zzbd;
        super(looper);
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.m2504i(60834);
        switch (message.what) {
            case 1:
                ((zzbe) message.obj).zzc(this.zzjh);
                AppMethodBeat.m2505o(60834);
                return;
            case 2:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                AppMethodBeat.m2505o(60834);
                throw runtimeException;
            default:
                new StringBuilder(31).append("Unknown message id: ").append(message.what);
                AppMethodBeat.m2505o(60834);
                return;
        }
    }
}
