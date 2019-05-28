package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzwv implements zzxb {
    private final String zzbnp;
    private final boolean zzbnq = false;

    zzwv(String str, boolean z) {
        this.zzbnp = str;
    }

    public final Object zzsc() {
        AppMethodBeat.m2504i(69763);
        Boolean zze = Boolean.valueOf(zzwn.zza(zzws.zzqx.getContentResolver(), this.zzbnp, this.zzbnq));
        AppMethodBeat.m2505o(69763);
        return zze;
    }
}
