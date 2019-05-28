package com.google.firebase.iid;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.iid.j */
final /* synthetic */ class C32101j implements C37307l {
    private final TaskCompletionSource bvK;

    C32101j(TaskCompletionSource taskCompletionSource) {
        this.bvK = taskCompletionSource;
    }

    public final String zzp() {
        AppMethodBeat.m2504i(108733);
        String a = C32100i.m52232a(this.bvK);
        AppMethodBeat.m2505o(108733);
        return a;
    }
}
