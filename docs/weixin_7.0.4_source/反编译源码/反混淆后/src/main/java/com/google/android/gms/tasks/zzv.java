package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

final class zzv implements Runnable {
    private final /* synthetic */ Callable val$callable;
    private final /* synthetic */ zzu zzagj;

    zzv(zzu zzu, Callable callable) {
        this.zzagj = zzu;
        this.val$callable = callable;
    }

    public final void run() {
        AppMethodBeat.m2504i(57447);
        try {
            this.zzagj.setResult(this.val$callable.call());
            AppMethodBeat.m2505o(57447);
        } catch (Exception e) {
            this.zzagj.setException(e);
            AppMethodBeat.m2505o(57447);
        }
    }
}
