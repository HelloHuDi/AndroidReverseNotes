package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {
    private final String name;
    private final int priority;
    private final ThreadFactory zzaau;

    public NamedThreadFactory(String str) {
        this(str, 0);
    }

    public NamedThreadFactory(String str, int i) {
        AppMethodBeat.i(90301);
        this.zzaau = Executors.defaultThreadFactory();
        this.name = (String) Preconditions.checkNotNull(str, "Name must not be null");
        this.priority = i;
        AppMethodBeat.o(90301);
    }

    public Thread newThread(Runnable runnable) {
        AppMethodBeat.i(90302);
        Thread newThread = this.zzaau.newThread(new zza(runnable, this.priority));
        newThread.setName(this.name);
        AppMethodBeat.o(90302);
        return newThread;
    }
}
