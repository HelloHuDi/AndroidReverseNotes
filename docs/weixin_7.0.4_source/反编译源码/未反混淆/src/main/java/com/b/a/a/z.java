package com.b.a.a;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class z {
    private static z bIZ;
    private static final SparseArray<z> bJa = new SparseArray();
    private final ExecutorService bJb;
    private final Handler handler;

    static {
        AppMethodBeat.i(55674);
        AppMethodBeat.o(55674);
    }

    private z(Handler handler) {
        AppMethodBeat.i(55675);
        if (handler != null) {
            this.bJb = null;
        } else {
            this.bJb = Executors.newSingleThreadExecutor();
        }
        this.handler = handler;
        AppMethodBeat.o(55675);
    }

    static z b(Handler handler) {
        AppMethodBeat.i(55676);
        z zVar;
        if (handler != null) {
            int hashCode = handler.getLooper().hashCode();
            zVar = (z) bJa.get(hashCode);
            if (zVar == null) {
                zVar = new z(handler);
                bJa.put(hashCode, zVar);
            }
            AppMethodBeat.o(55676);
            return zVar;
        }
        if (bIZ == null) {
            bIZ = new z(null);
        }
        zVar = bIZ;
        AppMethodBeat.o(55676);
        return zVar;
    }

    /* Access modifiers changed, original: final */
    public final void execute(Runnable runnable) {
        AppMethodBeat.i(55677);
        if (this.handler != null) {
            this.handler.post(runnable);
            AppMethodBeat.o(55677);
            return;
        }
        this.bJb.execute(runnable);
        AppMethodBeat.o(55677);
    }
}
