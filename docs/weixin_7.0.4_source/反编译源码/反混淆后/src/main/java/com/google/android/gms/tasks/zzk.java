package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzk<TResult> implements zzq<TResult> {
    private final Object mLock = new Object();
    private final Executor zzafk;
    @GuardedBy("mLock")
    private OnFailureListener zzafu;

    public zzk(Executor executor, OnFailureListener onFailureListener) {
        AppMethodBeat.m2504i(57396);
        this.zzafk = executor;
        this.zzafu = onFailureListener;
        AppMethodBeat.m2505o(57396);
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzafu = null;
        }
    }

    /* JADX WARNING: Missing block: B:12:0x001f, code skipped:
            r3.zzafk.execute(new com.google.android.gms.tasks.zzl(r3, r4));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onComplete(Task<TResult> task) {
        AppMethodBeat.m2504i(57397);
        if (!(task.isSuccessful() || task.isCanceled())) {
            synchronized (this.mLock) {
                try {
                    if (this.zzafu == null) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57397);
                }
            }
        }
        AppMethodBeat.m2505o(57397);
    }
}
