package com.tencent.p177mm.plugin.appbrand;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p321l.C19550n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.y */
public class C42751y {
    private static volatile boolean gQm = false;
    private static volatile boolean gQn = false;
    private static final Set<C11068a> gQo = new HashSet();

    /* renamed from: com.tencent.mm.plugin.appbrand.y$a */
    public interface C11068a {
        void atR();

        void atS();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.y$1 */
    static class C386301 implements Runnable {
        C386301() {
        }

        public final void run() {
            AppMethodBeat.m2504i(129134);
            long anU = C5046bo.anU();
            new C19550n().init();
            C4990ab.m7411d("MicroMsg.AppBrandXWebPreloader", "x509 init cost %d", Long.valueOf(C5046bo.anU() - anU));
            C42751y.access$000();
            Looper.myLooper().quit();
            AppMethodBeat.m2505o(129134);
        }
    }

    static {
        AppMethodBeat.m2504i(129141);
        AppMethodBeat.m2505o(129141);
    }

    public static boolean auw() {
        boolean z;
        synchronized (C42751y.class) {
            z = gQn;
        }
        return z;
    }

    /* JADX WARNING: Missing block: B:10:0x0022, code skipped:
            if (r2 == false) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:11:0x0024, code skipped:
            r5.atR();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(129138);
     */
    /* JADX WARNING: Missing block: B:16:0x0031, code skipped:
            r0 = new com.tencent.p177mm.plugin.appbrand.C42751y.C386301();
            new com.tencent.p177mm.sdk.platformtools.C5004al().mo10302aa(new com.tencent.p177mm.plugin.appbrand.C42751y.C427522());
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(129138);
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m75787a(C11068a c11068a) {
        AppMethodBeat.m2504i(129138);
        synchronized (C42751y.class) {
            try {
                boolean z = gQm;
                boolean z2 = gQn;
                if (!z2) {
                    gQo.add(c11068a);
                    gQm = true;
                    gQn = false;
                }
                if (z) {
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(129138);
            }
        }
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.m2504i(129139);
        synchronized (C42751y.class) {
            try {
                gQn = true;
                gQm = false;
                HashSet<C11068a> hashSet = new HashSet(gQo);
                gQo.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(129139);
            }
        }
        for (C11068a atR : hashSet) {
            atR.atR();
        }
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.m2504i(129140);
        synchronized (C42751y.class) {
            try {
                gQn = false;
                gQm = false;
                HashSet<C11068a> hashSet = new HashSet(gQo);
                gQo.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(129140);
            }
        }
        for (C11068a atS : hashSet) {
            atS.atS();
        }
    }
}
