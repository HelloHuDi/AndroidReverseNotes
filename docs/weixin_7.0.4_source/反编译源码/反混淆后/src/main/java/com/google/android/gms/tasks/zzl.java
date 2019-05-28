package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl implements Runnable {
    private final /* synthetic */ Task zzafn;
    private final /* synthetic */ zzk zzafv;

    zzl(zzk zzk, Task task) {
        this.zzafv = zzk;
        this.zzafn = task;
    }

    public final void run() {
        AppMethodBeat.m2504i(57398);
        synchronized (this.zzafv.mLock) {
            try {
                if (this.zzafv.zzafu != null) {
                    this.zzafv.zzafu.onFailure(this.zzafn.getException());
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57398);
            }
        }
    }
}
