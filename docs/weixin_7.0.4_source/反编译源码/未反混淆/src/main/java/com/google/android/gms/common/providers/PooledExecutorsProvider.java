package com.google.android.gms.common.providers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledExecutorService;

public class PooledExecutorsProvider {
    private static PooledExecutorFactory zzvs;

    public interface PooledExecutorFactory {
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    private PooledExecutorsProvider() {
    }

    public static PooledExecutorFactory createDefaultFactory() {
        AppMethodBeat.i(89933);
        zza zza = new zza();
        AppMethodBeat.o(89933);
        return zza;
    }

    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            AppMethodBeat.i(89932);
            if (zzvs == null) {
                zzvs = createDefaultFactory();
            }
            pooledExecutorFactory = zzvs;
            AppMethodBeat.o(89932);
        }
        return pooledExecutorFactory;
    }

    public static synchronized void setInstance(PooledExecutorFactory pooledExecutorFactory) {
        synchronized (PooledExecutorsProvider.class) {
            zzvs = pooledExecutorFactory;
        }
    }
}
