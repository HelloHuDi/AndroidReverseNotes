package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zziy implements Runnable {
    private final /* synthetic */ ComponentName val$name;
    private final /* synthetic */ zziw zzapn;

    zziy(zziw zziw, ComponentName componentName) {
        this.zzapn = zziw;
        this.val$name = componentName;
    }

    public final void run() {
        AppMethodBeat.i(69343);
        zzii.zza(this.zzapn.zzape, this.val$name);
        AppMethodBeat.o(69343);
    }
}
