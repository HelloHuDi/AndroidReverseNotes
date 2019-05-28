package com.tencent.p177mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.protocal.protobuf.ard;
import com.tencent.p177mm.protocal.protobuf.are;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.q */
public enum C42382q {
    ;
    
    private static volatile long gZC;
    private static volatile are gZD;
    private static final Set<C19113b> gZE = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.q$a */
    enum C19112a {
        public static final C19112a gZL = null;
        public static final C19112a gZM = null;
        public static final C19112a gZN = null;
        private static final /* synthetic */ C19112a[] gZO = null;
        final int value;

        public static C19112a valueOf(String str) {
            AppMethodBeat.m2504i(129603);
            C19112a c19112a = (C19112a) Enum.valueOf(C19112a.class, str);
            AppMethodBeat.m2505o(129603);
            return c19112a;
        }

        public static C19112a[] values() {
            AppMethodBeat.m2504i(129602);
            C19112a[] c19112aArr = (C19112a[]) gZO.clone();
            AppMethodBeat.m2505o(129602);
            return c19112aArr;
        }

        static {
            AppMethodBeat.m2504i(129604);
            gZL = new C19112a("FORCE_OFF", 0, 0);
            gZM = new C19112a("FORCE_ON", 1, 1);
            gZN = new C19112a("DYNAMIC_THRESHOLD", 2, 2);
            gZO = new C19112a[]{gZL, gZM, gZN};
            AppMethodBeat.m2505o(129604);
        }

        private C19112a(String str, int i, int i2) {
            this.value = i2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.q$b */
    public interface C19113b {
        void axs();
    }

    static {
        gZE = Collections.newSetFromMap(new ConcurrentHashMap());
        AppMethodBeat.m2505o(129616);
    }

    /* renamed from: a */
    public static void m74992a(C19113b c19113b) {
        AppMethodBeat.m2504i(129607);
        gZE.add(c19113b);
        AppMethodBeat.m2505o(129607);
    }

    /* renamed from: b */
    public static void m74994b(C19113b c19113b) {
        AppMethodBeat.m2504i(129608);
        gZE.remove(c19113b);
        AppMethodBeat.m2505o(129608);
    }

    public static boolean axl() {
        return true;
    }

    public static boolean axm() {
        AppMethodBeat.m2504i(129609);
        switch (C42382q.axn()) {
            case gZL:
                AppMethodBeat.m2505o(129609);
                return false;
            case gZM:
                AppMethodBeat.m2505o(129609);
                return true;
            case gZN:
                if (C42382q.axo()) {
                    AppMethodBeat.m2505o(129609);
                    return true;
                } else if (gZD != null) {
                    if (gZD.jsN >= gZD.wuX) {
                        AppMethodBeat.m2505o(129609);
                        return true;
                    }
                    AppMethodBeat.m2505o(129609);
                    return false;
                }
                break;
        }
        AppMethodBeat.m2505o(129609);
        return false;
    }

    public static boolean refresh() {
        AppMethodBeat.m2504i(129610);
        gZD = null;
        gZC = 0;
        if (C19112a.gZL == C42382q.axn()) {
            AppMethodBeat.m2505o(129610);
            return false;
        }
        final PBool pBool = new PBool();
        final PBool pBool2 = new PBool();
        pBool.value = false;
        pBool2.value = false;
        C7564ap c7564ap = new C7564ap(Looper.getMainLooper(), new C5015a() {
            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(129598);
                if (pBool2.value) {
                    AppMethodBeat.m2505o(129598);
                } else {
                    pBool.value = true;
                    C42382q.m74993a(null);
                    AppMethodBeat.m2505o(129598);
                }
                return false;
            }
        }, false);
        long toMillis = TimeUnit.SECONDS.toMillis(20);
        c7564ap.mo16770ae(toMillis, toMillis);
        C26443d.agz().mo44207b((C42206a) C42677e.m75580bB(new C42206a() {
            private int gZI;

            /* renamed from: com.tencent.mm.plugin.appbrand.appusage.q$2$1 */
            class C267731 implements C1224a {
                C267731() {
                }

                /* renamed from: a */
                public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                    AppMethodBeat.m2504i(129599);
                    if (i == 0 && i2 == 0 && c7472b != null && c7472b.fsH.fsP != null && (c7472b.fsH.fsP instanceof are)) {
                        C42382q.m74993a((are) c7472b.fsH.fsP);
                    } else {
                        C4990ab.m7413e("MicroMsg.AppBrandNearbyLogic", "refresh() cgi return errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        C42382q.m74993a(null);
                    }
                    AppMethodBeat.m2505o(129599);
                    return 0;
                }
            }

            /* renamed from: a */
            public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                AppMethodBeat.m2504i(129600);
                C42677e.m75579at(this);
                C26443d.agz().mo44208c(this);
                int i2 = this.gZI + 1;
                this.gZI = i2;
                if (i2 > 1 || pBool.value) {
                    AppMethodBeat.m2505o(129600);
                    return false;
                }
                pBool2.value = true;
                if (z) {
                    boolean z2;
                    C1196a c1196a = new C1196a();
                    c1196a.fsI = 1056;
                    c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxaappnearby";
                    ard ard = new ard();
                    ard.wuQ = (double) f;
                    ard.wuR = (double) f2;
                    if (C42382q.axo()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    ard.wuT = z2;
                    c1196a.fsJ = ard;
                    c1196a.fsK = new are();
                    C1226w.m2655a(c1196a.acD(), new C267731(), true);
                    AppMethodBeat.m2505o(129600);
                    return false;
                }
                C42382q.m74993a(null);
                AppMethodBeat.m2505o(129600);
                return false;
            }
        }), false);
        AppMethodBeat.m2505o(129610);
        return true;
    }

    static C19112a axn() {
        int i = 0;
        AppMethodBeat.m2504i(129611);
        C19112a c19112a;
        if (C1720g.m3531RK()) {
            C5141c ll = C18624c.abi().mo17131ll("100215");
            if (ll.isValid()) {
                int i2 = C5046bo.getInt((String) ll.dru().get("isOpenNewNearEntry"), 0);
                C19112a[] values = C19112a.values();
                int length = values.length;
                while (i < length) {
                    c19112a = values[i];
                    if (c19112a.value == i2) {
                        AppMethodBeat.m2505o(129611);
                        return c19112a;
                    }
                    i++;
                }
            }
            c19112a = C19112a.gZL;
            AppMethodBeat.m2505o(129611);
            return c19112a;
        }
        c19112a = C19112a.gZL;
        AppMethodBeat.m2505o(129611);
        return c19112a;
    }

    static boolean axo() {
        AppMethodBeat.m2504i(129612);
        boolean z = C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_APP_BRAND_ENTRANCE_HAS_SEEN_NEARBY_SHOWCASE_BOOLEAN_SYNC, false);
        AppMethodBeat.m2505o(129612);
        return z;
    }

    static void axp() {
        AppMethodBeat.m2504i(129613);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_HAS_SEEN_NEARBY_SHOWCASE_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.m2505o(129613);
    }

    public static are axq() {
        return gZD;
    }

    public static boolean axr() {
        long j;
        AppMethodBeat.m2504i(129614);
        long anT = C5046bo.anT();
        if (!C1720g.m3531RK() || gZD == null) {
            j = 0;
        } else {
            j = gZC;
        }
        if (anT >= j) {
            AppMethodBeat.m2505o(129614);
            return true;
        }
        AppMethodBeat.m2505o(129614);
        return false;
    }

    public static void clearData() {
        gZD = null;
    }
}
