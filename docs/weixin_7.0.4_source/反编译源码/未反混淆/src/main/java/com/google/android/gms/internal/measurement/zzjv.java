package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class zzjv implements zzek {
    private final /* synthetic */ zzjr zzaqu;
    zzkq zzaqv;
    List<Long> zzaqw;
    List<zzkn> zzaqx;
    private long zzaqy;

    private zzjv(zzjr zzjr) {
        this.zzaqu = zzjr;
    }

    /* synthetic */ zzjv(zzjr zzjr, zzjs zzjs) {
        this(zzjr);
    }

    private static long zza(zzkn zzkn) {
        AppMethodBeat.i(69491);
        long longValue = ((zzkn.zzatb.longValue() / 1000) / 60) / 60;
        AppMethodBeat.o(69491);
        return longValue;
    }

    public final boolean zza(long j, zzkn zzkn) {
        AppMethodBeat.i(69490);
        Preconditions.checkNotNull(zzkn);
        if (this.zzaqx == null) {
            this.zzaqx = new ArrayList();
        }
        if (this.zzaqw == null) {
            this.zzaqw = new ArrayList();
        }
        if (this.zzaqx.size() <= 0 || zza((zzkn) this.zzaqx.get(0)) == zza(zzkn)) {
            long zzvm = this.zzaqy + ((long) zzkn.zzvm());
            if (zzvm >= ((long) Math.max(0, ((Integer) zzew.zzagq.get()).intValue()))) {
                AppMethodBeat.o(69490);
                return false;
            }
            this.zzaqy = zzvm;
            this.zzaqx.add(zzkn);
            this.zzaqw.add(Long.valueOf(j));
            if (this.zzaqx.size() >= Math.max(1, ((Integer) zzew.zzagr.get()).intValue())) {
                AppMethodBeat.o(69490);
                return false;
            }
            AppMethodBeat.o(69490);
            return true;
        }
        AppMethodBeat.o(69490);
        return false;
    }

    public final void zzb(zzkq zzkq) {
        AppMethodBeat.i(69489);
        Preconditions.checkNotNull(zzkq);
        this.zzaqv = zzkq;
        AppMethodBeat.o(69489);
    }
}
