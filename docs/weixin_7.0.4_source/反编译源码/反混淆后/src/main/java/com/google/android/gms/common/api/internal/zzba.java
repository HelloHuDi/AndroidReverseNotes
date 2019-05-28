package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzba extends Handler {
    private final /* synthetic */ zzav zzit;

    zzba(zzav zzav, Looper looper) {
        this.zzit = zzav;
        super(looper);
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.m2504i(60813);
        switch (message.what) {
            case 1:
                zzav.zzb(this.zzit);
                AppMethodBeat.m2505o(60813);
                return;
            case 2:
                zzav.zza(this.zzit);
                AppMethodBeat.m2505o(60813);
                return;
            default:
                new StringBuilder(31).append("Unknown message id: ").append(message.what);
                AppMethodBeat.m2505o(60813);
                return;
        }
    }
}
