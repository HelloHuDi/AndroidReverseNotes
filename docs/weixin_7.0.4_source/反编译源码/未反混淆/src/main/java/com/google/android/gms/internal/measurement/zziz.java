package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zziz implements Runnable {
    private final /* synthetic */ zziw zzapn;
    private final /* synthetic */ zzey zzapo;

    zziz(zziw zziw, zzey zzey) {
        this.zzapn = zziw;
        this.zzapo = zzey;
    }

    public final void run() {
        AppMethodBeat.i(69344);
        synchronized (this.zzapn) {
            try {
                this.zzapn.zzapk = false;
                if (!this.zzapn.zzape.isConnected()) {
                    this.zzapn.zzape.zzge().zzis().log("Connected to remote service");
                    this.zzapn.zzape.zza(this.zzapo);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(69344);
            }
        }
    }
}
