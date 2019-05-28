package com.tencent.p177mm.plugin.appbrand.p297h;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C32488l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.appbrand.h.e */
public class C33208e {
    static final /* synthetic */ boolean $assertionsDisabled = (!C33208e.class.desiredAssertionStatus());
    private final C33209a ieY;
    private final AtomicInteger ieZ = new AtomicInteger(1);
    final SparseArray<C31294d> ifa = new SparseArray();

    /* renamed from: com.tencent.mm.plugin.appbrand.h.e$a */
    public interface C33209a {
        /* renamed from: oT */
        C32488l mo6005oT(int i);
    }

    static {
        AppMethodBeat.m2504i(113940);
        AppMethodBeat.m2505o(113940);
    }

    public C33208e(C33209a c33209a) {
        AppMethodBeat.m2504i(113937);
        this.ieY = c33209a;
        AppMethodBeat.m2505o(113937);
    }

    public static int aGX() {
        return 1;
    }

    /* renamed from: oO */
    public final C38235g mo53758oO(int i) {
        C38235g c38235g;
        AppMethodBeat.m2504i(113938);
        synchronized (this.ifa) {
            try {
                c38235g = (C38235g) this.ifa.get(i);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(113938);
            }
        }
        return c38235g;
    }

    public final C38235g aGV() {
        AppMethodBeat.m2504i(113939);
        int incrementAndGet = this.ieZ.incrementAndGet();
        C33210f c33210f = new C33210f(this.ieY.mo6005oT(incrementAndGet), incrementAndGet);
        synchronized (this.ifa) {
            try {
                this.ifa.put(incrementAndGet, c33210f);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(113939);
            }
        }
        C4990ab.m7417i("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", Integer.valueOf(incrementAndGet));
        return c33210f;
    }
}
