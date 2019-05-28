package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfi {
    private final int priority;
    private final /* synthetic */ zzfg zzajc;
    private final boolean zzajd;
    private final boolean zzaje;

    zzfi(zzfg zzfg, int i, boolean z, boolean z2) {
        this.zzajc = zzfg;
        this.priority = i;
        this.zzajd = z;
        this.zzaje = z2;
    }

    public final void log(String str) {
        AppMethodBeat.i(68900);
        this.zzajc.zza(this.priority, this.zzajd, this.zzaje, str, null, null, null);
        AppMethodBeat.o(68900);
    }

    public final void zzd(String str, Object obj, Object obj2, Object obj3) {
        AppMethodBeat.i(68903);
        this.zzajc.zza(this.priority, this.zzajd, this.zzaje, str, obj, obj2, obj3);
        AppMethodBeat.o(68903);
    }

    public final void zze(String str, Object obj, Object obj2) {
        AppMethodBeat.i(68902);
        this.zzajc.zza(this.priority, this.zzajd, this.zzaje, str, obj, obj2, null);
        AppMethodBeat.o(68902);
    }

    public final void zzg(String str, Object obj) {
        AppMethodBeat.i(68901);
        this.zzajc.zza(this.priority, this.zzajd, this.zzaje, str, obj, null, null);
        AppMethodBeat.o(68901);
    }
}
