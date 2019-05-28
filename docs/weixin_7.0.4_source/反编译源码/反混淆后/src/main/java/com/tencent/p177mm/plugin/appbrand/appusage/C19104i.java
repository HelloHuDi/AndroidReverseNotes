package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p230g.p231a.C45360qp;
import com.tencent.p177mm.p230g.p231a.C45360qp.C26223b;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.C26776r.C19114a;
import com.tencent.p177mm.plugin.appbrand.appusage.C26776r.C19117c;
import com.tencent.p177mm.plugin.appbrand.appusage.C26776r.C19117c.C191151;
import com.tencent.p177mm.plugin.appbrand.appusage.C26776r.C26777e;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandGuideUI.C38522a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.i */
public enum C19104i {
    ;
    
    public static final C4884c<C45360qp> gZa = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.i$1 */
    static class C191051 extends C4884c<C45360qp> {
        C191051() {
            AppMethodBeat.m2504i(129532);
            this.xxI = C45360qp.class.getName().hashCode();
            AppMethodBeat.m2505o(129532);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(129533);
            C45360qp c45360qp = (C45360qp) c4883b;
            c45360qp.cMI.cMK = C19104i.axb();
            if (c45360qp.cMH.cMJ) {
                C26223b c26223b = c45360qp.cMI;
                c45360qp.cMI.cML = false;
                c26223b.cMM = false;
                if (!C19104i.axd()) {
                    switch (C191062.gZc[C26776r.axu().ordinal()]) {
                        case 1:
                            c45360qp.cMI.cMM = true;
                            break;
                        case 2:
                            c45360qp.cMI.cML = true;
                            break;
                    }
                }
                c45360qp.cMI.cMM = true;
                if (c45360qp.cMI.cML || c45360qp.cMI.cMM) {
                    C26776r.axw();
                }
                C19117c c19117c = C26776r.gZP;
                C42382q.axl();
                if (C1720g.m3531RK() && C1226w.adF()) {
                    long anT = C5046bo.anT();
                    long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_END_TIME_SECOND_LONG, Long.valueOf(0))).longValue();
                    long longValue2 = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_FREQUENCY_SECOND_LONG, Long.valueOf(Long.MAX_VALUE))).longValue() + ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_LAST_TIME_SECOND_LONG, Long.valueOf(0))).longValue();
                    if (longValue2 > 0 && anT < longValue && anT >= longValue2) {
                        C4990ab.m7410d("MicroMsg.AppBrandPushNewOrRedDotLogic", "doReport");
                        C26443d.agz().mo44207b((C42206a) C42677e.m75580bB(new C191151()), true);
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_LAST_TIME_SECOND_LONG, Long.valueOf(anT));
                    }
                }
            }
            AppMethodBeat.m2505o(129533);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.i$2 */
    static /* synthetic */ class C191062 {
        static final /* synthetic */ int[] gZc = null;

        static {
            AppMethodBeat.m2504i(129534);
            gZc = new int[C19114a.values().length];
            try {
                gZc[C19114a.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gZc[C19114a.REDDOT.ordinal()] = 2;
                AppMethodBeat.m2505o(129534);
            } catch (NoSuchFieldError e2) {
                AppMethodBeat.m2505o(129534);
            }
        }
    }

    static {
        gZa = new C191051();
        AppMethodBeat.m2505o(129546);
    }

    public static boolean axb() {
        AppMethodBeat.m2504i(129537);
        if (!C1720g.m3531RK()) {
            AppMethodBeat.m2505o(129537);
            return false;
        } else if (C26373g.m41964Nu().getInt("WeAppForbiddenSwitch", 0) == 1) {
            C4990ab.m7416i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
            AppMethodBeat.m2505o(129537);
            return false;
        } else if (C19104i.axg() || C26776r.axt()) {
            AppMethodBeat.m2505o(129537);
            return true;
        } else {
            AppMethodBeat.m2505o(129537);
            return false;
        }
    }

    public static void axc() {
        AppMethodBeat.m2504i(129538);
        if (C1720g.m3531RK()) {
            if (C19104i.axd()) {
                C26777e c26777e = C26777e.hab;
                C26777e.m42611a("", 0, 2, 1);
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, Boolean.FALSE);
            AppMethodBeat.m2505o(129538);
            return;
        }
        AppMethodBeat.m2505o(129538);
    }

    static boolean axd() {
        AppMethodBeat.m2504i(129539);
        if (C1720g.m3531RK()) {
            boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, Boolean.FALSE)).booleanValue();
            AppMethodBeat.m2505o(129539);
            return booleanValue;
        }
        AppMethodBeat.m2505o(129539);
        return false;
    }

    /* renamed from: nx */
    static void m29720nx(int i) {
        boolean z = true;
        AppMethodBeat.m2504i(129540);
        if (C1720g.m3531RK()) {
            C7580z Ry = C1720g.m3536RP().mo5239Ry();
            C19104i.m29719g((i & 2) > 0, "");
            C5127a c5127a = C5127a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_FAVORITE_BOOLEAN;
            if ((i & 1) <= 0) {
                z = false;
            }
            Ry.set(c5127a, Boolean.valueOf(z));
            AppMethodBeat.m2505o(129540);
            return;
        }
        AppMethodBeat.m2505o(129540);
    }

    /* renamed from: g */
    private static void m29719g(boolean z, String str) {
        AppMethodBeat.m2504i(129541);
        if (C1720g.m3531RK()) {
            Object obj;
            Boolean bool = (Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN, null);
            if (bool == null || bool.booleanValue() || !z) {
                obj = null;
            } else {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, Boolean.TRUE);
                C26777e c26777e = C26777e.hab;
                C26777e.axD();
                obj = 1;
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN, Boolean.valueOf(z));
            if (obj != null) {
                C38522a auN = C42340f.auN();
                if (auN != null) {
                    auN.mo61249DV(str);
                }
            }
            AppMethodBeat.m2505o(129541);
            return;
        }
        AppMethodBeat.m2505o(129541);
    }

    /* renamed from: yt */
    static void m29721yt(String str) {
        AppMethodBeat.m2504i(129542);
        C19104i.m29719g(true, str);
        AppMethodBeat.m2505o(129542);
    }

    public static boolean axe() {
        AppMethodBeat.m2504i(129543);
        if (C1720g.m3531RK()) {
            boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN, Boolean.FALSE)).booleanValue();
            AppMethodBeat.m2505o(129543);
            return booleanValue;
        }
        AppMethodBeat.m2505o(129543);
        return false;
    }

    public static boolean axf() {
        AppMethodBeat.m2504i(129544);
        C26783t.axG();
        if (C1720g.m3531RK()) {
            boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_FAVORITE_BOOLEAN, Boolean.FALSE)).booleanValue();
            AppMethodBeat.m2505o(129544);
            return booleanValue;
        }
        AppMethodBeat.m2505o(129544);
        return false;
    }

    public static boolean axg() {
        AppMethodBeat.m2504i(129545);
        if (C19104i.axf() || C19104i.axe()) {
            AppMethodBeat.m2505o(129545);
            return true;
        }
        AppMethodBeat.m2505o(129545);
        return false;
    }
}
