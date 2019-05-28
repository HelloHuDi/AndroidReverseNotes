package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

final class zzi<TResult> implements zzq<TResult> {
    private final Object mLock = new Object();
    private final Executor zzafk;
    @GuardedBy("mLock")
    private OnCompleteListener<TResult> zzafs;

    public zzi(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        AppMethodBeat.m2504i(57393);
        this.zzafk = executor;
        this.zzafs = onCompleteListener;
        AppMethodBeat.m2505o(57393);
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzafs = null;
        }
    }

    public final void onComplete(Task<TResult> task) {
        AppMethodBeat.m2504i(57394);
        synchronized (this.mLock) {
            try {
                if (this.zzafs == null) {
                } else {
                    this.zzafk.execute(new zzj(this, task));
                    AppMethodBeat.m2505o(57394);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57394);
            }
        }
    }
}
