package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzwt implements zzxb {
    private final zzws zzbnn;
    private final zzwp zzbno;

    zzwt(zzws zzws, zzwp zzwp) {
        this.zzbnn = zzws;
        this.zzbno = zzwp;
    }

    public final Object zzsc() {
        AppMethodBeat.m2504i(69761);
        String str = (String) this.zzbno.zzrt().get(this.zzbnn.zzbnh);
        AppMethodBeat.m2505o(69761);
        return str;
    }
}
