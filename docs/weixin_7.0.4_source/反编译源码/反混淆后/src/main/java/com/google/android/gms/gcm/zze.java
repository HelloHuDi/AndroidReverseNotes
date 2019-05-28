package com.google.android.gms.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zze implements ThreadFactory {
    private final AtomicInteger zzx = new AtomicInteger(1);

    zze(GcmTaskService gcmTaskService) {
        AppMethodBeat.m2504i(70027);
        AppMethodBeat.m2505o(70027);
    }

    public final Thread newThread(Runnable runnable) {
        AppMethodBeat.m2504i(70028);
        Thread thread = new Thread(runnable, "gcm-task#" + this.zzx.getAndIncrement());
        thread.setPriority(4);
        AppMethodBeat.m2505o(70028);
        return thread;
    }
}
