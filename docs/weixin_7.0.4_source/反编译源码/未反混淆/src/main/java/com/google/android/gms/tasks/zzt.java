package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class zzt implements Executor {
    zzt() {
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.i(57412);
        runnable.run();
        AppMethodBeat.o(57412);
    }
}
