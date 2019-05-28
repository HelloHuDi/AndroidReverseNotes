package com.tencent.mm.plugin.appbrand.h;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicInteger;

public class e {
    static final /* synthetic */ boolean $assertionsDisabled = (!e.class.desiredAssertionStatus());
    private final a ieY;
    private final AtomicInteger ieZ = new AtomicInteger(1);
    final SparseArray<d> ifa = new SparseArray();

    public interface a {
        l oT(int i);
    }

    static {
        AppMethodBeat.i(113940);
        AppMethodBeat.o(113940);
    }

    public e(a aVar) {
        AppMethodBeat.i(113937);
        this.ieY = aVar;
        AppMethodBeat.o(113937);
    }

    public static int aGX() {
        return 1;
    }

    public final g oO(int i) {
        g gVar;
        AppMethodBeat.i(113938);
        synchronized (this.ifa) {
            try {
                gVar = (g) this.ifa.get(i);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(113938);
            }
        }
        return gVar;
    }

    public final g aGV() {
        AppMethodBeat.i(113939);
        int incrementAndGet = this.ieZ.incrementAndGet();
        f fVar = new f(this.ieY.oT(incrementAndGet), incrementAndGet);
        synchronized (this.ifa) {
            try {
                this.ifa.put(incrementAndGet, fVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(113939);
            }
        }
        ab.i("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", Integer.valueOf(incrementAndGet));
        return fVar;
    }
}
