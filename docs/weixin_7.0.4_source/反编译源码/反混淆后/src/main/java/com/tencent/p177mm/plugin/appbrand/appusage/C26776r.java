package com.tencent.p177mm.plugin.appbrand.appusage;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.appusage.C42382q.C19112a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.clq;
import com.tencent.p177mm.protocal.protobuf.clr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.r */
public final class C26776r {
    public static final C19117c gZP = new C19117c();

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.r$a */
    public enum C19114a {
        NONE(0),
        REDDOT(1),
        NEW(2);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(129619);
        }

        private C19114a(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.r$c */
    public static final class C19117c {

        /* renamed from: com.tencent.mm.plugin.appbrand.appusage.r$c$1 */
        class C191151 implements C42206a {
            int count = 0;

            C191151() {
            }

            /* renamed from: a */
            public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                AppMethodBeat.m2504i(129627);
                C42677e.m75579at(this);
                C26443d.agz().mo44208c(this);
                int i2 = this.count;
                this.count = i2 + 1;
                if (i2 <= 0 && z) {
                    C1196a c1196a = new C1196a();
                    c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/uploaduserlocationinfo";
                    c1196a.fsI = 1154;
                    c1196a.fsK = new clr();
                    clq clq = new clq();
                    clq.latitude = (double) f2;
                    clq.longitude = (double) f;
                    clq.xjm = d2;
                    c1196a.fsJ = clq;
                    final float f3 = f;
                    final float f4 = f2;
                    final double d4 = d2;
                    C1226w.m2655a(c1196a.acD(), new C1224a() {
                        /* renamed from: a */
                        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                            AppMethodBeat.m2504i(129626);
                            C4990ab.m7411d("MicroMsg.AppBrandPushNewOrRedDotLogic", "locationReport, errType %d, errCode %d, errMsg %s, longitude %f, latitude %f, accuracy %f", Integer.valueOf(i), Integer.valueOf(i2), str, Float.valueOf(f3), Float.valueOf(f4), Double.valueOf(d4));
                            AppMethodBeat.m2505o(129626);
                            return 0;
                        }
                    }, true);
                }
                AppMethodBeat.m2505o(129627);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.r$b */
    public static final class C26774b implements C1837a {
        private static final C26774b gZU = new C26774b();

        static {
            AppMethodBeat.m2504i(129625);
            AppMethodBeat.m2505o(129625);
        }

        private C26774b() {
        }

        public static void axy() {
            AppMethodBeat.m2504i(129621);
            C42382q.axl();
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("wxareddot", gZU, true);
            AppMethodBeat.m2505o(129621);
        }

        public static void unregister() {
            AppMethodBeat.m2504i(129622);
            C42382q.axl();
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("wxareddot", gZU, true);
            AppMethodBeat.m2505o(129622);
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(129623);
            final String a = C1946aa.m4148a(c1197a.eAB.vED);
            if (C5046bo.isNullOrNil(a)) {
                AppMethodBeat.m2505o(129623);
                return;
            }
            C42677e.aNS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(129620);
                    C26774b.m42605yu(a);
                    AppMethodBeat.m2505o(129620);
                }
            });
            AppMethodBeat.m2505o(129623);
        }

        /* renamed from: yu */
        static /* synthetic */ void m42605yu(String str) {
            AppMethodBeat.m2504i(129624);
            C4990ab.m7417i("MicroMsg.AppBrandPushNewOrRedDotLogic", "parseThenProcess, accReady %b, received xml %s", Boolean.valueOf(C1720g.m3531RK()), str);
            if (C1720g.m3531RK()) {
                Map z = C5049br.m7595z(str, "sysmsg");
                if (z != null && z.size() > 0) {
                    Object obj = (String) z.get(".sysmsg.wxareddot.id");
                    int i = C5046bo.getInt((String) z.get(".sysmsg.wxareddot.activitytype"), 0);
                    if (!C5046bo.isNullOrNil(obj) && (i == 1 || i == 2)) {
                        int i2 = C5046bo.getInt((String) z.get(".sysmsg.wxareddot.close"), 0);
                        long j = C5046bo.getLong((String) z.get(".sysmsg.wxareddot.pushtime"), 0);
                        long j2 = C5046bo.getLong((String) z.get(".sysmsg.wxareddot.duration"), 0);
                        long j3 = C5046bo.getLong((String) z.get(".sysmsg.wxareddot.frequency"), 0);
                        z.get(".sysmsg.wxareddot.tips");
                        int i3 = C5046bo.getInt((String) z.get(".sysmsg.wxareddot.showType"), 0);
                        int i4 = C5046bo.getInt((String) z.get(".sysmsg.wxareddot.reason"), 0);
                        switch (i) {
                            case 1:
                                if (!(obj.equals((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, null)) || C19104i.axd() || C5046bo.m7542cc(C4996ah.getContext()).equals(AppBrandLauncherUI.class.getName()) || C42382q.axn() == C19112a.gZL)) {
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, obj);
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(j));
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_SHOWTYPE_INT, Integer.valueOf(i3));
                                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_REASON_INT, Integer.valueOf(i4));
                                    if (i2 == 1 && C26776r.axv()) {
                                        C26777e c26777e = C26777e.hab;
                                        C26777e.m42611a((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 4, C26777e.axE());
                                    }
                                    C26776r.m42610c(i2 != 1, j2);
                                    AppMethodBeat.m2505o(129624);
                                    return;
                                }
                            case 2:
                                if (!obj.equals((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_MSG_ID_STRING, null))) {
                                    C26776r.m42609b(i2 != 1, j2, j3);
                                    break;
                                }
                                break;
                        }
                    }
                    AppMethodBeat.m2505o(129624);
                    return;
                }
                AppMethodBeat.m2505o(129624);
                return;
            }
            AppMethodBeat.m2505o(129624);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.r$e */
    public static final class C26777e {
        public static final C26777e hab = new C26777e();

        static {
            AppMethodBeat.m2504i(129633);
            AppMethodBeat.m2505o(129633);
        }

        static void axC() {
            AppMethodBeat.m2504i(129629);
            C26777e.m42611a((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 3, C26777e.axE());
            AppMethodBeat.m2505o(129629);
        }

        public static void axD() {
            AppMethodBeat.m2504i(129630);
            C26777e.m42611a("", 0, 1, 1);
            AppMethodBeat.m2505o(129630);
        }

        static int axE() {
            AppMethodBeat.m2504i(129631);
            if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, false)) {
                AppMethodBeat.m2505o(129631);
                return 1;
            }
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_REASON_INT, Integer.valueOf(0))).intValue();
            if (intValue > 0) {
                intValue++;
            }
            AppMethodBeat.m2505o(129631);
            return intValue;
        }

        /* renamed from: a */
        static void m42611a(String str, long j, int i, int i2) {
            AppMethodBeat.m2504i(129632);
            C7060h.pYm.mo8381e(14112, Integer.valueOf(1), C5046bo.nullAsNil(str), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(129632);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.r$d */
    public static final class C26778d {
        public final String[] haa = new String[9];

        public C26778d() {
            AppMethodBeat.m2504i(129628);
            Arrays.fill(this.haa, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.haa[0] = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) "");
            this.haa[1] = String.valueOf(C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0)));
            this.haa[2] = String.valueOf(C5046bo.anT());
            AppMethodBeat.m2505o(129628);
        }

        public final void axz() {
            this.haa[3] = "1";
        }

        public final void axA() {
            this.haa[5] = "1";
        }

        public final void axB() {
            this.haa[8] = "1";
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m42609b(boolean z, long j, long j2) {
        AppMethodBeat.m2504i(129642);
        C26776r.m42607a(z, j, j2);
        AppMethodBeat.m2505o(129642);
    }

    /* renamed from: c */
    static /* synthetic */ void m42610c(boolean z, long j) {
        AppMethodBeat.m2504i(129641);
        C26776r.m42608b(z, j);
        AppMethodBeat.m2505o(129641);
    }

    /* renamed from: b */
    private static void m42608b(boolean z, long j) {
        AppMethodBeat.m2504i(129634);
        if (z) {
            long j2;
            if (j == 0) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = C5046bo.anT() + Math.max(0, j);
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(j2));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_SHOW_RED_DOT_ONCE_BOOLEAN, Boolean.TRUE);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN, Boolean.FALSE);
            C26777e c26777e = C26777e.hab;
            C26777e.m42611a((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 1, C26777e.axE());
            AppMethodBeat.m2505o(129634);
            return;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(0));
        AppMethodBeat.m2505o(129634);
    }

    /* renamed from: a */
    private static void m42607a(boolean z, long j, long j2) {
        long j3 = 0;
        AppMethodBeat.m2504i(129635);
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        C5127a c5127a = C5127a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_END_TIME_SECOND_LONG;
        if (z) {
            j3 = Math.max(0, j) + C5046bo.anT();
        }
        Ry.set(c5127a, Long.valueOf(j3));
        C7580z Ry2 = C1720g.m3536RP().mo5239Ry();
        C5127a c5127a2 = C5127a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_FREQUENCY_SECOND_LONG;
        if (!z) {
            j2 = Long.MAX_VALUE;
        }
        Ry2.set(c5127a2, Long.valueOf(j2));
        AppMethodBeat.m2505o(129635);
    }

    public static boolean axt() {
        AppMethodBeat.m2504i(129636);
        C42382q.axl();
        if (C1720g.m3531RK()) {
            boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_SHOW_RED_DOT_ONCE_BOOLEAN, Boolean.FALSE)).booleanValue();
            AppMethodBeat.m2505o(129636);
            return booleanValue;
        }
        AppMethodBeat.m2505o(129636);
        return false;
    }

    static C19114a axu() {
        int i = 0;
        AppMethodBeat.m2504i(129637);
        C19114a c19114a;
        if (C26776r.axv()) {
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_SHOWTYPE_INT, Integer.valueOf(0))).intValue();
            C19114a[] values = C19114a.values();
            int length = values.length;
            while (i < length) {
                c19114a = values[i];
                if (c19114a.value == intValue) {
                    AppMethodBeat.m2505o(129637);
                    return c19114a;
                }
                i++;
            }
            c19114a = C19114a.NONE;
            AppMethodBeat.m2505o(129637);
            return c19114a;
        }
        c19114a = C19114a.NONE;
        AppMethodBeat.m2505o(129637);
        return c19114a;
    }

    public static boolean axv() {
        AppMethodBeat.m2504i(129638);
        if (C1720g.m3531RK()) {
            long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(0))).longValue();
            boolean z = longValue > C5046bo.anT();
            if (!z && longValue > 0) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(0));
                C26777e c26777e = C26777e.hab;
                C26777e.axC();
            }
            AppMethodBeat.m2505o(129638);
            return z;
        }
        AppMethodBeat.m2505o(129638);
        return false;
    }

    static void axw() {
        AppMethodBeat.m2504i(129639);
        C42382q.axl();
        if (C1720g.m3531RK()) {
            C26777e c26777e = C26777e.hab;
            if (!((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                C26777e.m42611a((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 0, C26777e.axE());
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN, Boolean.TRUE);
            }
            AppMethodBeat.m2505o(129639);
            return;
        }
        AppMethodBeat.m2505o(129639);
    }

    public static void axx() {
        AppMethodBeat.m2504i(129640);
        if (C1720g.m3531RK()) {
            if (C26776r.axv()) {
                C26776r.m42608b(false, 0);
                C26776r.m42607a(false, 0, 0);
                C26777e c26777e = C26777e.hab;
                C26777e.m42611a((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 2, C26777e.axE());
            }
            AppMethodBeat.m2505o(129640);
            return;
        }
        AppMethodBeat.m2505o(129640);
    }

    static {
        AppMethodBeat.m2504i(129643);
        AppMethodBeat.m2505o(129643);
    }
}
