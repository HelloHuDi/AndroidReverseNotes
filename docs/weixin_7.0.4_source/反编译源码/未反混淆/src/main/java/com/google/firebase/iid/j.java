package com.google.firebase.iid;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class j implements l {
    private final TaskCompletionSource bvK;

    j(TaskCompletionSource taskCompletionSource) {
        this.bvK = taskCompletionSource;
    }

    public final String zzp() {
        AppMethodBeat.i(108733);
        String a = i.a(this.bvK);
        AppMethodBeat.o(108733);
        return a;
    }
}
