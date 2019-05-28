package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final class ad implements Continuation<Bundle, String> {
    private final /* synthetic */ ab bwL;

    ad(ab abVar) {
        this.bwL = abVar;
    }

    public final /* synthetic */ Object then(Task task) {
        AppMethodBeat.i(108799);
        String h = this.bwL.h((Bundle) task.getResult(IOException.class));
        AppMethodBeat.o(108799);
        return h;
    }
}
