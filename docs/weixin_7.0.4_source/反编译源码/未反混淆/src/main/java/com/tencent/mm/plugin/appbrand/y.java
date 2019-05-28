package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class y {
    private static volatile boolean gQm = false;
    private static volatile boolean gQn = false;
    private static final Set<a> gQo = new HashSet();

    public interface a {
        void atR();

        void atS();
    }

    static {
        AppMethodBeat.i(129141);
        AppMethodBeat.o(129141);
    }

    public static boolean auw() {
        boolean z;
        synchronized (y.class) {
            z = gQn;
        }
        return z;
    }

    /* JADX WARNING: Missing block: B:10:0x0022, code skipped:
            if (r2 == false) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:11:0x0024, code skipped:
            r5.atR();
            com.tencent.matrix.trace.core.AppMethodBeat.o(129138);
     */
    /* JADX WARNING: Missing block: B:16:0x0031, code skipped:
            r0 = new com.tencent.mm.plugin.appbrand.y.AnonymousClass1();
            new com.tencent.mm.sdk.platformtools.al().aa(new com.tencent.mm.plugin.appbrand.y.AnonymousClass2());
            com.tencent.matrix.trace.core.AppMethodBeat.o(129138);
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(a aVar) {
        AppMethodBeat.i(129138);
        synchronized (y.class) {
            try {
                boolean z = gQm;
                boolean z2 = gQn;
                if (!z2) {
                    gQo.add(aVar);
                    gQm = true;
                    gQn = false;
                }
                if (z) {
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(129138);
            }
        }
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(129139);
        synchronized (y.class) {
            try {
                gQn = true;
                gQm = false;
                HashSet<a> hashSet = new HashSet(gQo);
                gQo.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(129139);
            }
        }
        for (a atR : hashSet) {
            atR.atR();
        }
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(129140);
        synchronized (y.class) {
            try {
                gQn = false;
                gQm = false;
                HashSet<a> hashSet = new HashSet(gQo);
                gQo.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(129140);
            }
        }
        for (a atS : hashSet) {
            atS.atS();
        }
    }
}
