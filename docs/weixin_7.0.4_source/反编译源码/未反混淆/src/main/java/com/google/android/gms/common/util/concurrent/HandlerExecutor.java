package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public class HandlerExecutor implements Executor {
    private final Handler handler;

    public HandlerExecutor(Handler handler) {
        this(handler.getLooper());
        AppMethodBeat.i(90298);
        AppMethodBeat.o(90298);
    }

    public HandlerExecutor(Looper looper) {
        AppMethodBeat.i(90299);
        this.handler = new Handler(looper);
        AppMethodBeat.o(90299);
    }

    public void execute(Runnable runnable) {
        AppMethodBeat.i(90300);
        this.handler.post(runnable);
        AppMethodBeat.o(90300);
    }
}
