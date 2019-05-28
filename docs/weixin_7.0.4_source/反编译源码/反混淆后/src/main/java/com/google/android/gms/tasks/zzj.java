package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj implements Runnable {
    private final /* synthetic */ Task zzafn;
    private final /* synthetic */ zzi zzaft;

    zzj(zzi zzi, Task task) {
        this.zzaft = zzi;
        this.zzafn = task;
    }

    public final void run() {
        AppMethodBeat.m2504i(57395);
        synchronized (this.zzaft.mLock) {
            try {
                if (this.zzaft.zzafs != null) {
                    this.zzaft.zzafs.onComplete(this.zzafn);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57395);
            }
        }
    }
}
