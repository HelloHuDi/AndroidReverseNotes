package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class zzt implements Executor {
    zzt() {
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.m2504i(57412);
        runnable.run();
        AppMethodBeat.m2505o(57412);
    }
}
