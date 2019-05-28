package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* renamed from: com.google.firebase.iid.ac */
final /* synthetic */ class C37304ac implements Runnable {
    private final TaskCompletionSource bvN;
    private final C32095ab bwJ;
    private final Bundle bwK;

    C37304ac(C32095ab c32095ab, Bundle bundle, TaskCompletionSource taskCompletionSource) {
        this.bwJ = c32095ab;
        this.bwK = bundle;
        this.bvN = taskCompletionSource;
    }

    public final void run() {
        AppMethodBeat.m2504i(108798);
        C32095ab c32095ab = this.bwJ;
        Bundle bundle = this.bwK;
        TaskCompletionSource taskCompletionSource = this.bvN;
        try {
            taskCompletionSource.setResult(c32095ab.bwH.mo43246f(bundle));
            AppMethodBeat.m2505o(108798);
        } catch (IOException e) {
            taskCompletionSource.setException(e);
            AppMethodBeat.m2505o(108798);
        }
    }
}
