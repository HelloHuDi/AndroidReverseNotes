package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

final class zzjt implements zzfm {
    private final /* synthetic */ zzjr zzaqu;

    zzjt(zzjr zzjr) {
        this.zzaqu = zzjr;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        AppMethodBeat.m2504i(69487);
        this.zzaqu.zzb(str, i, th, bArr, map);
        AppMethodBeat.m2505o(69487);
    }
}
