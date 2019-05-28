package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public class HandlerExecutor implements Executor {
    private final Handler handler;

    public HandlerExecutor(Handler handler) {
        this(handler.getLooper());
        AppMethodBeat.m2504i(90298);
        AppMethodBeat.m2505o(90298);
    }

    public HandlerExecutor(Looper looper) {
        AppMethodBeat.m2504i(90299);
        this.handler = new Handler(looper);
        AppMethodBeat.m2505o(90299);
    }

    public void execute(Runnable runnable) {
        AppMethodBeat.m2504i(90300);
        this.handler.post(runnable);
        AppMethodBeat.m2505o(90300);
    }
}
