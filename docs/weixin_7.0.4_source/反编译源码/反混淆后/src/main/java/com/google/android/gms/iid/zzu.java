package com.google.android.gms.iid;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzu implements Callback {
    private final zzt zzch;

    zzu(zzt zzt) {
        this.zzch = zzt;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.m2504i(57613);
        boolean zzd = this.zzch.zzd(message);
        AppMethodBeat.m2505o(57613);
        return zzd;
    }
}
