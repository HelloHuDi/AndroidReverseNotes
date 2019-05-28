package com.p081b.p082a.p083a;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.b.a.a.z */
final class C37158z {
    private static C37158z bIZ;
    private static final SparseArray<C37158z> bJa = new SparseArray();
    private final ExecutorService bJb;
    private final Handler handler;

    static {
        AppMethodBeat.m2504i(55674);
        AppMethodBeat.m2505o(55674);
    }

    private C37158z(Handler handler) {
        AppMethodBeat.m2504i(55675);
        if (handler != null) {
            this.bJb = null;
        } else {
            this.bJb = Executors.newSingleThreadExecutor();
        }
        this.handler = handler;
        AppMethodBeat.m2505o(55675);
    }

    /* renamed from: b */
    static C37158z m62269b(Handler handler) {
        AppMethodBeat.m2504i(55676);
        C37158z c37158z;
        if (handler != null) {
            int hashCode = handler.getLooper().hashCode();
            c37158z = (C37158z) bJa.get(hashCode);
            if (c37158z == null) {
                c37158z = new C37158z(handler);
                bJa.put(hashCode, c37158z);
            }
            AppMethodBeat.m2505o(55676);
            return c37158z;
        }
        if (bIZ == null) {
            bIZ = new C37158z(null);
        }
        c37158z = bIZ;
        AppMethodBeat.m2505o(55676);
        return c37158z;
    }

    /* Access modifiers changed, original: final */
    public final void execute(Runnable runnable) {
        AppMethodBeat.m2504i(55677);
        if (this.handler != null) {
            this.handler.post(runnable);
            AppMethodBeat.m2505o(55677);
            return;
        }
        this.bJb.execute(runnable);
        AppMethodBeat.m2505o(55677);
    }
}
