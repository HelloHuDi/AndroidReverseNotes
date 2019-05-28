package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzf implements Runnable {
    private final /* synthetic */ Task zzafn;
    private final /* synthetic */ zze zzafp;

    zzf(zze zze, Task task) {
        this.zzafp = zze;
        this.zzafn = task;
    }

    public final void run() {
        AppMethodBeat.i(57389);
        try {
            Task task = (Task) this.zzafp.zzafl.then(this.zzafn);
            if (task == null) {
                this.zzafp.onFailure(new NullPointerException("Continuation returned null"));
                AppMethodBeat.o(57389);
                return;
            }
            task.addOnSuccessListener(TaskExecutors.zzagd, this.zzafp);
            task.addOnFailureListener(TaskExecutors.zzagd, this.zzafp);
            task.addOnCanceledListener(TaskExecutors.zzagd, this.zzafp);
            AppMethodBeat.o(57389);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.zzafp.zzafm.setException((Exception) e.getCause());
                AppMethodBeat.o(57389);
                return;
            }
            this.zzafp.zzafm.setException(e);
            AppMethodBeat.o(57389);
        } catch (Exception e2) {
            this.zzafp.zzafm.setException(e2);
            AppMethodBeat.o(57389);
        }
    }
}
