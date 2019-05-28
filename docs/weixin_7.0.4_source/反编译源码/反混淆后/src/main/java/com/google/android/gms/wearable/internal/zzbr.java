package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzbr extends zzej {
    private final Object lock = new Object();
    @GuardedBy("lock")
    @Nullable
    private zzav zzcw;
    @GuardedBy("lock")
    @Nullable
    private zzbs zzda;

    public zzbr() {
        AppMethodBeat.m2504i(71102);
        AppMethodBeat.m2505o(71102);
    }

    public final void zza(int i, int i2) {
        zzbs zzbs;
        zzav zzav;
        AppMethodBeat.m2504i(71104);
        synchronized (this.lock) {
            try {
                zzbs = this.zzda;
                zzav = new zzav(i, i2);
                this.zzcw = zzav;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(71104);
                }
            }
        }
        if (zzbs != null) {
            zzbs.zzb(zzav);
        }
        AppMethodBeat.m2505o(71104);
    }

    public final void zza(zzbs zzbs) {
        zzav zzav;
        AppMethodBeat.m2504i(71103);
        synchronized (this.lock) {
            try {
                this.zzda = (zzbs) Preconditions.checkNotNull(zzbs);
                zzav = this.zzcw;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(71103);
                }
            }
        }
        if (zzav != null) {
            zzbs.zzb(zzav);
        }
        AppMethodBeat.m2505o(71103);
    }
}
