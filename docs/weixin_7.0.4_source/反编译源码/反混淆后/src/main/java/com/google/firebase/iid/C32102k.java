package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.iid.k */
final /* synthetic */ class C32102k implements C37307l {
    private final C32100i bvL;
    private final C37307l bvM;
    private final TaskCompletionSource bvN;
    private final Pair bvO;

    C32102k(C32100i c32100i, C37307l c37307l, TaskCompletionSource taskCompletionSource, Pair pair) {
        this.bvL = c32100i;
        this.bvM = c37307l;
        this.bvN = taskCompletionSource;
        this.bvO = pair;
    }

    public final String zzp() {
        AppMethodBeat.m2504i(108734);
        String a = this.bvL.mo52669a(this.bvM, this.bvN, this.bvO);
        AppMethodBeat.m2505o(108734);
        return a;
    }
}
