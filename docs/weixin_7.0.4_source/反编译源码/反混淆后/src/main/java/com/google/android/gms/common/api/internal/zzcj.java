package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzcj extends Handler {
    private final /* synthetic */ zzch zzml;

    public zzcj(zzch zzch, Looper looper) {
        this.zzml = zzch;
        super(looper);
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.m2504i(60890);
        switch (message.what) {
            case 0:
                PendingResult pendingResult = (PendingResult) message.obj;
                synchronized (this.zzml.zzfa) {
                    if (pendingResult == null) {
                        try {
                            zzch.zza(this.zzml.zzme, new Status(13, "Transform returned null"));
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(60890);
                        }
                    } else if (pendingResult instanceof zzbx) {
                        zzch.zza(this.zzml.zzme, ((zzbx) pendingResult).getStatus());
                    } else {
                        this.zzml.zzme.zza(pendingResult);
                    }
                }
                AppMethodBeat.m2505o(60890);
                return;
            case 1:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String str = "Runtime exception on the transformation worker thread: ";
                String valueOf = String.valueOf(runtimeException.getMessage());
                if (valueOf.length() != 0) {
                    str.concat(valueOf);
                } else {
                    valueOf = new String(str);
                }
                AppMethodBeat.m2505o(60890);
                throw runtimeException;
            default:
                new StringBuilder(70).append("TransformationResultHandler received unknown message type: ").append(message.what);
                AppMethodBeat.m2505o(60890);
                return;
        }
    }
}
