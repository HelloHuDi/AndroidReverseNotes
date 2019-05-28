package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd implements Runnable {
    private final /* synthetic */ Task zzafn;
    private final /* synthetic */ zzc zzafo;

    zzd(zzc zzc, Task task) {
        this.zzafo = zzc;
        this.zzafn = task;
    }

    public final void run() {
        AppMethodBeat.i(57383);
        if (this.zzafn.isCanceled()) {
            this.zzafo.zzafm.zzdp();
            AppMethodBeat.o(57383);
            return;
        }
        try {
            this.zzafo.zzafm.setResult(this.zzafo.zzafl.then(this.zzafn));
            AppMethodBeat.o(57383);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.zzafo.zzafm.setException((Exception) e.getCause());
                AppMethodBeat.o(57383);
                return;
            }
            this.zzafo.zzafm.setException(e);
            AppMethodBeat.o(57383);
        } catch (Exception e2) {
            this.zzafo.zzafm.setException(e2);
            AppMethodBeat.o(57383);
        }
    }
}
