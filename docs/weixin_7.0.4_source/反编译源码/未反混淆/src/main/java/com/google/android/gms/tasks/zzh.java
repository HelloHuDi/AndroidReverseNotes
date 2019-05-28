package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzh implements Runnable {
    private final /* synthetic */ zzg zzafr;

    zzh(zzg zzg) {
        this.zzafr = zzg;
    }

    public final void run() {
        AppMethodBeat.i(57392);
        synchronized (this.zzafr.mLock) {
            try {
                if (this.zzafr.zzafq != null) {
                    this.zzafr.zzafq.onCanceled();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57392);
            }
        }
    }
}
