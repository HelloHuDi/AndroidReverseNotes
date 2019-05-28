package com.google.android.gms.internal.stable;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzf extends ContentObserver {
    private final /* synthetic */ zzh zzagr;

    zzf(Handler handler, zzh zzh) {
        this.zzagr = zzh;
        super(null);
    }

    public final void onChange(boolean z) {
        AppMethodBeat.m2504i(90475);
        this.zzagr.zzagu.set(true);
        AppMethodBeat.m2505o(90475);
    }
}
