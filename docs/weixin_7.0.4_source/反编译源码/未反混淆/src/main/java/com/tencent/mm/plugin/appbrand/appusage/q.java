package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public enum q {
    ;
    
    private static volatile long gZC;
    private static volatile are gZD;
    private static final Set<b> gZE = null;

    enum a {
        public static final a gZL = null;
        public static final a gZM = null;
        public static final a gZN = null;
        private static final /* synthetic */ a[] gZO = null;
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(129603);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(129603);
            return aVar;
        }

        public static a[] values() {
            AppMethodBeat.i(129602);
            a[] aVarArr = (a[]) gZO.clone();
            AppMethodBeat.o(129602);
            return aVarArr;
        }

        static {
            AppMethodBeat.i(129604);
            gZL = new a("FORCE_OFF", 0, 0);
            gZM = new a("FORCE_ON", 1, 1);
            gZN = new a("DYNAMIC_THRESHOLD", 2, 2);
            gZO = new a[]{gZL, gZM, gZN};
            AppMethodBeat.o(129604);
        }

        private a(String str, int i, int i2) {
            this.value = i2;
        }
    }

    public interface b {
        void axs();
    }

    static {
        gZE = Collections.newSetFromMap(new ConcurrentHashMap());
        AppMethodBeat.o(129616);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(129607);
        gZE.add(bVar);
        AppMethodBeat.o(129607);
    }

    public static void b(b bVar) {
        AppMethodBeat.i(129608);
        gZE.remove(bVar);
        AppMethodBeat.o(129608);
    }

    public static boolean axl() {
        return true;
    }

    public static boolean axm() {
        AppMethodBeat.i(129609);
        switch (axn()) {
            case gZL:
                AppMethodBeat.o(129609);
                return false;
            case gZM:
                AppMethodBeat.o(129609);
                return true;
            case gZN:
                if (axo()) {
                    AppMethodBeat.o(129609);
                    return true;
                } else if (gZD != null) {
                    if (gZD.jsN >= gZD.wuX) {
                        AppMethodBeat.o(129609);
                        return true;
                    }
                    AppMethodBeat.o(129609);
                    return false;
                }
                break;
        }
        AppMethodBeat.o(129609);
        return false;
    }

    public static boolean refresh() {
        AppMethodBeat.i(129610);
        gZD = null;
        gZC = 0;
        if (a.gZL == axn()) {
            AppMethodBeat.o(129610);
            return false;
        }
        final PBool pBool = new PBool();
        final PBool pBool2 = new PBool();
        pBool.value = false;
        pBool2.value = false;
        ap apVar = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(129598);
                if (pBool2.value) {
                    AppMethodBeat.o(129598);
                } else {
                    pBool.value = true;
                    q.a(null);
                    AppMethodBeat.o(129598);
                }
                return false;
            }
        }, false);
        long toMillis = TimeUnit.SECONDS.toMillis(20);
        apVar.ae(toMillis, toMillis);
        d.agz().b((com.tencent.mm.modelgeo.b.a) e.bB(new com.tencent.mm.modelgeo.b.a() {
            private int gZI;

            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                AppMethodBeat.i(129600);
                e.at(this);
                d.agz().c(this);
                int i2 = this.gZI + 1;
                this.gZI = i2;
                if (i2 > 1 || pBool.value) {
                    AppMethodBeat.o(129600);
                    return false;
                }
                pBool2.value = true;
                if (z) {
                    boolean z2;
                    com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                    aVar.fsI = 1056;
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxaappnearby";
                    ard ard = new ard();
                    ard.wuQ = (double) f;
                    ard.wuR = (double) f2;
                    if (q.axo()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    ard.wuT = z2;
                    aVar.fsJ = ard;
                    aVar.fsK = new are();
                    w.a(aVar.acD(), new com.tencent.mm.ai.w.a() {
                        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                            AppMethodBeat.i(129599);
                            if (i == 0 && i2 == 0 && bVar != null && bVar.fsH.fsP != null && (bVar.fsH.fsP instanceof are)) {
                                q.a((are) bVar.fsH.fsP);
                            } else {
                                ab.e("MicroMsg.AppBrandNearbyLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                                q.a(null);
                            }
                            AppMethodBeat.o(129599);
                            return 0;
                        }
                    }, true);
                    AppMethodBeat.o(129600);
                    return false;
                }
                q.a(null);
                AppMethodBeat.o(129600);
                return false;
            }
        }), false);
        AppMethodBeat.o(129610);
        return true;
    }

    static a axn() {
        int i = 0;
        AppMethodBeat.i(129611);
        a aVar;
        if (g.RK()) {
            c ll = com.tencent.mm.model.c.c.abi().ll("100215");
            if (ll.isValid()) {
                int i2 = bo.getInt((String) ll.dru().get("isOpenNewNearEntry"), 0);
                a[] values = a.values();
                int length = values.length;
                while (i < length) {
                    aVar = values[i];
                    if (aVar.value == i2) {
                        AppMethodBeat.o(129611);
                        return aVar;
                    }
                    i++;
                }
            }
            aVar = a.gZL;
            AppMethodBeat.o(129611);
            return aVar;
        }
        aVar = a.gZL;
        AppMethodBeat.o(129611);
        return aVar;
    }

    static boolean axo() {
        AppMethodBeat.i(129612);
        boolean z = g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_HAS_SEEN_NEARBY_SHOWCASE_BOOLEAN_SYNC, false);
        AppMethodBeat.o(129612);
        return z;
    }

    static void axp() {
        AppMethodBeat.i(129613);
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_HAS_SEEN_NEARBY_SHOWCASE_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.o(129613);
    }

    public static are axq() {
        return gZD;
    }

    public static boolean axr() {
        long j;
        AppMethodBeat.i(129614);
        long anT = bo.anT();
        if (!g.RK() || gZD == null) {
            j = 0;
        } else {
            j = gZC;
        }
        if (anT >= j) {
            AppMethodBeat.o(129614);
            return true;
        }
        AppMethodBeat.o(129614);
        return false;
    }

    public static void clearData() {
        gZD = null;
    }
}
