package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final /* synthetic */ class ac implements Runnable {
    private final TaskCompletionSource bvN;
    private final ab bwJ;
    private final Bundle bwK;

    ac(ab abVar, Bundle bundle, TaskCompletionSource taskCompletionSource) {
        this.bwJ = abVar;
        this.bwK = bundle;
        this.bvN = taskCompletionSource;
    }

    public final void run() {
        AppMethodBeat.i(108798);
        ab abVar = this.bwJ;
        Bundle bundle = this.bwK;
        TaskCompletionSource taskCompletionSource = this.bvN;
        try {
            taskCompletionSource.setResult(abVar.bwH.f(bundle));
            AppMethodBeat.o(108798);
        } catch (IOException e) {
            taskCompletionSource.setException(e);
            AppMethodBeat.o(108798);
        }
    }
}
