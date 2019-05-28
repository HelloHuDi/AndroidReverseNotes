package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class k implements l {
    private final i bvL;
    private final l bvM;
    private final TaskCompletionSource bvN;
    private final Pair bvO;

    k(i iVar, l lVar, TaskCompletionSource taskCompletionSource, Pair pair) {
        this.bvL = iVar;
        this.bvM = lVar;
        this.bvN = taskCompletionSource;
        this.bvO = pair;
    }

    public final String zzp() {
        AppMethodBeat.i(108734);
        String a = this.bvL.a(this.bvM, this.bvN, this.bvO);
        AppMethodBeat.o(108734);
        return a;
    }
}
