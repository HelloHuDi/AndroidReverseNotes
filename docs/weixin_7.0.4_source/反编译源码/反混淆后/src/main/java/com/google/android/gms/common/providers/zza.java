package com.google.android.gms.common.providers;

import com.google.android.gms.common.providers.PooledExecutorsProvider.PooledExecutorFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class zza implements PooledExecutorFactory {
    zza() {
    }

    public final ScheduledExecutorService newSingleThreadScheduledExecutor() {
        AppMethodBeat.m2504i(89934);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        AppMethodBeat.m2505o(89934);
        return newSingleThreadScheduledExecutor;
    }
}
