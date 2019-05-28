package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

final class zzcm implements DeathRecipient, zzcn {
    private final WeakReference<BasePendingResult<?>> zzmr;
    private final WeakReference<zzc> zzms;
    private final WeakReference<IBinder> zzmt;

    private zzcm(BasePendingResult<?> basePendingResult, zzc zzc, IBinder iBinder) {
        AppMethodBeat.m2504i(60897);
        this.zzms = new WeakReference(zzc);
        this.zzmr = new WeakReference(basePendingResult);
        this.zzmt = new WeakReference(iBinder);
        AppMethodBeat.m2505o(60897);
    }

    /* synthetic */ zzcm(BasePendingResult basePendingResult, zzc zzc, IBinder iBinder, zzcl zzcl) {
        this(basePendingResult, null, iBinder);
    }

    private final void zzcf() {
        AppMethodBeat.m2504i(60900);
        BasePendingResult basePendingResult = (BasePendingResult) this.zzmr.get();
        zzc zzc = (zzc) this.zzms.get();
        if (!(zzc == null || basePendingResult == null)) {
            zzc.remove(basePendingResult.zzo().intValue());
        }
        IBinder iBinder = (IBinder) this.zzmt.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
                AppMethodBeat.m2505o(60900);
                return;
            } catch (NoSuchElementException e) {
            }
        }
        AppMethodBeat.m2505o(60900);
    }

    public final void binderDied() {
        AppMethodBeat.m2504i(60899);
        zzcf();
        AppMethodBeat.m2505o(60899);
    }

    public final void zzc(BasePendingResult<?> basePendingResult) {
        AppMethodBeat.m2504i(60898);
        zzcf();
        AppMethodBeat.m2505o(60898);
    }
}
