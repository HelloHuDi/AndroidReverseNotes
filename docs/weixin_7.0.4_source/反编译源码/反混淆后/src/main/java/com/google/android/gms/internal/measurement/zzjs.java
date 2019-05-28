package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

final class zzjs implements zzfm {
    private final /* synthetic */ String zzaqt;
    private final /* synthetic */ zzjr zzaqu;

    zzjs(zzjr zzjr, String str) {
        this.zzaqu = zzjr;
        this.zzaqt = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        AppMethodBeat.m2504i(69486);
        this.zzaqu.zza(i, th, bArr, this.zzaqt);
        AppMethodBeat.m2505o(69486);
    }
}
