package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

final class zzr<TResult> {
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private Queue<zzq<TResult>> zzaga;
    @GuardedBy("mLock")
    private boolean zzagb;

    zzr() {
        AppMethodBeat.m2504i(57408);
        AppMethodBeat.m2505o(57408);
    }

    /* JADX WARNING: Missing block: B:12:0x001a, code skipped:
            r1 = r3.mLock;
     */
    /* JADX WARNING: Missing block: B:13:0x001c, code skipped:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:15:?, code skipped:
            r0 = (com.google.android.gms.tasks.zzq) r3.zzaga.poll();
     */
    /* JADX WARNING: Missing block: B:16:0x0025, code skipped:
            if (r0 != null) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:17:0x0027, code skipped:
            r3.zzagb = false;
     */
    /* JADX WARNING: Missing block: B:18:0x002a, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:25:0x0036, code skipped:
            r0.onComplete(r4);
     */
    /* JADX WARNING: Missing block: B:29:0x003c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(57410);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(Task<TResult> task) {
        AppMethodBeat.m2504i(57410);
        synchronized (this.mLock) {
            try {
                if (this.zzaga == null || this.zzagb) {
                } else {
                    this.zzagb = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57410);
            }
        }
    }

    public final void zza(zzq<TResult> zzq) {
        AppMethodBeat.m2504i(57409);
        synchronized (this.mLock) {
            try {
                if (this.zzaga == null) {
                    this.zzaga = new ArrayDeque();
                }
                this.zzaga.add(zzq);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57409);
            }
        }
    }
}
