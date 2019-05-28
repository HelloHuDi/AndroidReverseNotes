package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.sdk.platformtools.al;
import java.util.List;

public final class a {

    /* renamed from: com.tencent.mm.aw.a$9 */
    public static class AnonymousClass9 implements Runnable {
        final /* synthetic */ List fJO;
        final /* synthetic */ boolean fJP = true;

        public AnonymousClass9(List list) {
            this.fJO = list;
        }

        public final void run() {
            AppMethodBeat.i(137240);
            kd kdVar = new kd();
            kdVar.cFz.action = 5;
            kdVar.cFz.cAV = this.fJO;
            kdVar.cFz.cFD = this.fJP;
            com.tencent.mm.sdk.b.a.xxA.m(kdVar);
            AppMethodBeat.o(137240);
        }
    }

    /* renamed from: com.tencent.mm.aw.a$7 */
    public static class AnonymousClass7 implements Runnable {
        final /* synthetic */ List fJM;
        final /* synthetic */ int fJN;

        public AnonymousClass7(List list, int i) {
            this.fJM = list;
            this.fJN = i;
        }

        public final void run() {
            AppMethodBeat.i(137238);
            kd kdVar = new kd();
            kdVar.cFz.action = 0;
            kdVar.cFz.cAV = this.fJM;
            kdVar.cFz.cFC = this.fJN;
            com.tencent.mm.sdk.b.a.xxA.m(kdVar);
            AppMethodBeat.o(137238);
        }
    }

    public static final void KX() {
        AppMethodBeat.i(137241);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(137232);
                kd kdVar = new kd();
                kdVar.cFz.action = 1;
                com.tencent.mm.sdk.b.a.xxA.m(kdVar);
                AppMethodBeat.o(137232);
            }
        });
        AppMethodBeat.o(137241);
    }

    public static final void KY() {
        AppMethodBeat.i(137242);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(137233);
                kd kdVar = new kd();
                kdVar.cFz.action = 2;
                com.tencent.mm.sdk.b.a.xxA.m(kdVar);
                AppMethodBeat.o(137233);
            }
        });
        AppMethodBeat.o(137242);
    }

    public static final void aic() {
        AppMethodBeat.i(137243);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(137234);
                kd kdVar = new kd();
                kdVar.cFz.action = -1;
                com.tencent.mm.sdk.b.a.xxA.m(kdVar);
                AppMethodBeat.o(137234);
            }
        });
        AppMethodBeat.o(137243);
    }

    public static final void aid() {
        AppMethodBeat.i(137244);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(137235);
                kd kdVar = new kd();
                kdVar.cFz.action = 11;
                com.tencent.mm.sdk.b.a.xxA.m(kdVar);
                AppMethodBeat.o(137235);
            }
        });
        AppMethodBeat.o(137244);
    }

    public static final void a(final e eVar) {
        AppMethodBeat.i(137245);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(137236);
                kd kdVar = new kd();
                kdVar.cFz.action = 6;
                kdVar.cFz.cFB = eVar;
                com.tencent.mm.sdk.b.a.xxA.m(kdVar);
                AppMethodBeat.o(137236);
            }
        });
        AppMethodBeat.o(137245);
    }

    public static boolean aie() {
        AppMethodBeat.i(137246);
        kd kdVar = new kd();
        kdVar.cFz.action = -3;
        com.tencent.mm.sdk.b.a.xxA.m(kdVar);
        boolean z = kdVar.cFA.csN;
        AppMethodBeat.o(137246);
        return z;
    }

    public static boolean aif() {
        AppMethodBeat.i(137247);
        kd kdVar = new kd();
        kdVar.cFz.action = 10;
        com.tencent.mm.sdk.b.a.xxA.m(kdVar);
        boolean z = kdVar.cFA.csN;
        AppMethodBeat.o(137247);
        return z;
    }

    public static boolean aig() {
        AppMethodBeat.i(137248);
        kd kdVar = new kd();
        kdVar.cFz.action = 9;
        com.tencent.mm.sdk.b.a.xxA.m(kdVar);
        boolean z = kdVar.cFA.csN;
        AppMethodBeat.o(137248);
        return z;
    }

    public static e aih() {
        AppMethodBeat.i(137249);
        kd kdVar = new kd();
        kdVar.cFz.action = -2;
        com.tencent.mm.sdk.b.a.xxA.m(kdVar);
        e eVar = kdVar.cFA.cFB;
        AppMethodBeat.o(137249);
        return eVar;
    }

    public static void b(final e eVar) {
        AppMethodBeat.i(137250);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(137237);
                kd kdVar = new kd();
                kdVar.cFz.action = 0;
                kdVar.cFz.cFB = eVar;
                com.tencent.mm.sdk.b.a.xxA.m(kdVar);
                AppMethodBeat.o(137237);
            }
        });
        AppMethodBeat.o(137250);
    }

    public static void c(final e eVar) {
        AppMethodBeat.i(137251);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(137239);
                kd kdVar = new kd();
                kdVar.cFz.action = 3;
                kdVar.cFz.cFB = eVar;
                com.tencent.mm.sdk.b.a.xxA.m(kdVar);
                AppMethodBeat.o(137239);
            }
        });
        AppMethodBeat.o(137251);
    }

    public static boolean d(e eVar) {
        if (eVar == null) {
            return false;
        }
        switch (eVar.fJS) {
            case 1:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean lP(int i) {
        AppMethodBeat.i(137252);
        kd kdVar = new kd();
        kdVar.cFz.action = 7;
        kdVar.cFz.position = i;
        com.tencent.mm.sdk.b.a.xxA.m(kdVar);
        boolean z = kdVar.cFA.csN;
        AppMethodBeat.o(137252);
        return z;
    }

    public static c aii() {
        AppMethodBeat.i(137253);
        kd kdVar = new kd();
        kdVar.cFz.action = 8;
        com.tencent.mm.sdk.b.a.xxA.m(kdVar);
        c cVar = kdVar.cFA.cFF;
        AppMethodBeat.o(137253);
        return cVar;
    }
}
