package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn implements Runnable {
    private final /* synthetic */ Task zzafn;
    private final /* synthetic */ zzm zzafx;

    zzn(zzm zzm, Task task) {
        this.zzafx = zzm;
        this.zzafn = task;
    }

    public final void run() {
        AppMethodBeat.m2504i(57401);
        synchronized (this.zzafx.mLock) {
            try {
                if (this.zzafx.zzafw != null) {
                    this.zzafx.zzafw.onSuccess(this.zzafn.getResult());
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57401);
            }
        }
    }
}
