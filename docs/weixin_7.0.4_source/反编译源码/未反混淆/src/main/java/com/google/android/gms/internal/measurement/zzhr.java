package com.google.android.gms.internal.measurement;

import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhr implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ ConditionalUserProperty zzaob;

    zzhr(zzhk zzhk, ConditionalUserProperty conditionalUserProperty) {
        this.zzanw = zzhk;
        this.zzaob = conditionalUserProperty;
    }

    public final void run() {
        AppMethodBeat.i(69223);
        zzhk.zza(this.zzanw, this.zzaob);
        AppMethodBeat.o(69223);
    }
}
