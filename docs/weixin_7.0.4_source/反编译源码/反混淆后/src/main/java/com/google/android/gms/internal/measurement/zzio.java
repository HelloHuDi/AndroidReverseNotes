package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzio extends zzem {
    private final /* synthetic */ zzii zzape;

    zzio(zzii zzii, zzhi zzhi) {
        this.zzape = zzii;
        super(zzhi);
    }

    public final void run() {
        AppMethodBeat.m2504i(69327);
        this.zzape.zzge().zzip().log("Tasks have been queued for a long time");
        AppMethodBeat.m2505o(69327);
    }
}
