package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzg<TResult> implements zzq<TResult> {
    private final Object mLock = new Object();
    private final Executor zzafk;
    @GuardedBy("mLock")
    private OnCanceledListener zzafq;

    public zzg(Executor executor, OnCanceledListener onCanceledListener) {
        AppMethodBeat.m2504i(57390);
        this.zzafk = executor;
        this.zzafq = onCanceledListener;
        AppMethodBeat.m2505o(57390);
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzafq = null;
        }
    }

    /* JADX WARNING: Missing block: B:10:0x0019, code skipped:
            r3.zzafk.execute(new com.google.android.gms.tasks.zzh(r3));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onComplete(Task task) {
        AppMethodBeat.m2504i(57391);
        if (task.isCanceled()) {
            synchronized (this.mLock) {
                try {
                    if (this.zzafq == null) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57391);
                }
            }
        }
        AppMethodBeat.m2505o(57391);
    }
}
