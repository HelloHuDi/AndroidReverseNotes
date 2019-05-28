package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzm<TResult> implements zzq<TResult> {
    private final Object mLock = new Object();
    private final Executor zzafk;
    @GuardedBy("mLock")
    private OnSuccessListener<? super TResult> zzafw;

    public zzm(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        AppMethodBeat.m2504i(57399);
        this.zzafk = executor;
        this.zzafw = onSuccessListener;
        AppMethodBeat.m2505o(57399);
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzafw = null;
        }
    }

    /* JADX WARNING: Missing block: B:10:0x0019, code skipped:
            r3.zzafk.execute(new com.google.android.gms.tasks.zzn(r3, r4));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onComplete(Task<TResult> task) {
        AppMethodBeat.m2504i(57400);
        if (task.isSuccessful()) {
            synchronized (this.mLock) {
                try {
                    if (this.zzafw == null) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57400);
                }
            }
        }
        AppMethodBeat.m2505o(57400);
    }
}
