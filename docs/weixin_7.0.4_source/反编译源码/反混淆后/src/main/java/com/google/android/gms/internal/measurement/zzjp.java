package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

class zzjp extends zzhg implements zzec {
    protected final zzjr zzajp;

    zzjp(zzjr zzjr) {
        super(zzjr.zzla());
        AppMethodBeat.m2504i(69428);
        Preconditions.checkNotNull(zzjr);
        this.zzajp = zzjr;
        AppMethodBeat.m2505o(69428);
    }

    public zzeb zziw() {
        AppMethodBeat.m2504i(69430);
        zzeb zziw = this.zzajp.zziw();
        AppMethodBeat.m2505o(69430);
        return zziw;
    }

    public zzei zzix() {
        AppMethodBeat.m2504i(69429);
        zzei zzix = this.zzajp.zzix();
        AppMethodBeat.m2505o(69429);
        return zzix;
    }
}
