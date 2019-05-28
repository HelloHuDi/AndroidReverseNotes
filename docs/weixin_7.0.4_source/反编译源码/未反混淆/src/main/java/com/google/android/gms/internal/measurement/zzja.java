package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzja implements Runnable {
    private final /* synthetic */ zziw zzapn;

    zzja(zziw zziw) {
        this.zzapn = zziw;
    }

    public final void run() {
        AppMethodBeat.i(69345);
        zzii.zza(this.zzapn.zzape, new ComponentName(this.zzapn.zzape.getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
        AppMethodBeat.o(69345);
    }
}
