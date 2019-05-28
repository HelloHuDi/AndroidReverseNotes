package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;

final class zzp implements Runnable {
    private final /* synthetic */ Task zzafn;
    private final /* synthetic */ zzo zzafz;

    zzp(zzo zzo, Task task) {
        this.zzafz = zzo;
        this.zzafn = task;
    }

    public final void run() {
        AppMethodBeat.i(57407);
        try {
            Task then = this.zzafz.zzafy.then(this.zzafn.getResult());
            if (then == null) {
                this.zzafz.onFailure(new NullPointerException("Continuation returned null"));
                AppMethodBeat.o(57407);
                return;
            }
            then.addOnSuccessListener(TaskExecutors.zzagd, this.zzafz);
            then.addOnFailureListener(TaskExecutors.zzagd, this.zzafz);
            then.addOnCanceledListener(TaskExecutors.zzagd, this.zzafz);
            AppMethodBeat.o(57407);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.zzafz.onFailure((Exception) e.getCause());
                AppMethodBeat.o(57407);
                return;
            }
            this.zzafz.onFailure(e);
            AppMethodBeat.o(57407);
        } catch (CancellationException e2) {
            this.zzafz.onCanceled();
            AppMethodBeat.o(57407);
        } catch (Exception e3) {
            this.zzafz.onFailure(e3);
            AppMethodBeat.o(57407);
        }
    }
}
