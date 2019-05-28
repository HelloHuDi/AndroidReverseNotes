package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* renamed from: com.google.firebase.iid.ad */
final class C45072ad implements Continuation<Bundle, String> {
    private final /* synthetic */ C32095ab bwL;

    C45072ad(C32095ab c32095ab) {
        this.bwL = c32095ab;
    }

    public final /* synthetic */ Object then(Task task) {
        AppMethodBeat.m2504i(108799);
        String h = this.bwL.mo52658h((Bundle) task.getResult(IOException.class));
        AppMethodBeat.m2505o(108799);
        return h;
    }
}
