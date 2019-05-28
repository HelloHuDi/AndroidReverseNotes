package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class TaskExecutors {
    public static final Executor MAIN_THREAD = new zza();
    static final Executor zzagd = new zzt();

    static final class zza implements Executor {
        private final Handler mHandler = new Handler(Looper.getMainLooper());

        public zza() {
            AppMethodBeat.i(57347);
            AppMethodBeat.o(57347);
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.i(57348);
            this.mHandler.post(runnable);
            AppMethodBeat.o(57348);
        }
    }

    static {
        AppMethodBeat.i(57349);
        AppMethodBeat.o(57349);
    }

    private TaskExecutors() {
    }
}
