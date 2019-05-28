package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzgj<V> extends FutureTask<V> implements Comparable<zzgj> {
    private final String zzaly;
    private final /* synthetic */ zzgg zzalz;
    private final long zzama = zzgg.zzalx.getAndIncrement();
    final boolean zzamb;

    zzgj(zzgg zzgg, Runnable runnable, boolean z, String str) {
        this.zzalz = zzgg;
        super(runnable, null);
        AppMethodBeat.m2504i(69056);
        Preconditions.checkNotNull(str);
        this.zzaly = str;
        this.zzamb = false;
        if (this.zzama == Long.MAX_VALUE) {
            zzgg.zzge().zzim().log("Tasks index overflow");
        }
        AppMethodBeat.m2505o(69056);
    }

    zzgj(zzgg zzgg, Callable<V> callable, boolean z, String str) {
        this.zzalz = zzgg;
        super(callable);
        AppMethodBeat.m2504i(69055);
        Preconditions.checkNotNull(str);
        this.zzaly = str;
        this.zzamb = z;
        if (this.zzama == Long.MAX_VALUE) {
            zzgg.zzge().zzim().log("Tasks index overflow");
        }
        AppMethodBeat.m2505o(69055);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.m2504i(69058);
        zzgj zzgj = (zzgj) obj;
        if (this.zzamb != zzgj.zzamb) {
            if (this.zzamb) {
                AppMethodBeat.m2505o(69058);
                return -1;
            }
            AppMethodBeat.m2505o(69058);
            return 1;
        } else if (this.zzama < zzgj.zzama) {
            AppMethodBeat.m2505o(69058);
            return -1;
        } else if (this.zzama > zzgj.zzama) {
            AppMethodBeat.m2505o(69058);
            return 1;
        } else {
            this.zzalz.zzge().zzin().zzg("Two tasks share the same index. index", Long.valueOf(this.zzama));
            AppMethodBeat.m2505o(69058);
            return 0;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void setException(Throwable th) {
        AppMethodBeat.m2504i(69057);
        this.zzalz.zzge().zzim().zzg(this.zzaly, th);
        if (th instanceof zzgh) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
        AppMethodBeat.m2505o(69057);
    }
}
