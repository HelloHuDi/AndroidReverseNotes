package com.tencent.mm.plugin.appbrand.appusage;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import java.util.Arrays;
import java.util.Map;

public final class r {
    public static final c gZP = new c();

    public enum a {
        NONE(0),
        REDDOT(1),
        NEW(2);
        
        public final int value;

        static {
            AppMethodBeat.o(129619);
        }

        private a(int i) {
            this.value = i;
        }
    }

    public static final class c {
    }

    public static final class b implements com.tencent.mm.model.bz.a {
        private static final b gZU = new b();

        static {
            AppMethodBeat.i(129625);
            AppMethodBeat.o(129625);
        }

        private b() {
        }

        public static void axy() {
            AppMethodBeat.i(129621);
            q.axl();
            ((p) g.M(p.class)).getSysCmdMsgExtension().a("wxareddot", gZU, true);
            AppMethodBeat.o(129621);
        }

        public static void unregister() {
            AppMethodBeat.i(129622);
            q.axl();
            ((p) g.M(p.class)).getSysCmdMsgExtension().b("wxareddot", gZU, true);
            AppMethodBeat.o(129622);
        }

        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(129623);
            final String a = aa.a(aVar.eAB.vED);
            if (bo.isNullOrNil(a)) {
                AppMethodBeat.o(129623);
                return;
            }
            com.tencent.mm.plugin.appbrand.s.e.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(129620);
                    b.yu(a);
                    AppMethodBeat.o(129620);
                }
            });
            AppMethodBeat.o(129623);
        }

        static /* synthetic */ void yu(String str) {
            AppMethodBeat.i(129624);
            ab.i("MicroMsg.AppBrandPushNewOrRedDotLogic", "parseThenProcess, accReady %b, received xml %s", Boolean.valueOf(g.RK()), str);
            if (g.RK()) {
                Map z = br.z(str, "sysmsg");
                if (z != null && z.size() > 0) {
                    Object obj = (String) z.get(".sysmsg.wxareddot.id");
                    int i = bo.getInt((String) z.get(".sysmsg.wxareddot.activitytype"), 0);
                    if (!bo.isNullOrNil(obj) && (i == 1 || i == 2)) {
                        int i2 = bo.getInt((String) z.get(".sysmsg.wxareddot.close"), 0);
                        long j = bo.getLong((String) z.get(".sysmsg.wxareddot.pushtime"), 0);
                        long j2 = bo.getLong((String) z.get(".sysmsg.wxareddot.duration"), 0);
                        long j3 = bo.getLong((String) z.get(".sysmsg.wxareddot.frequency"), 0);
                        z.get(".sysmsg.wxareddot.tips");
                        int i3 = bo.getInt((String) z.get(".sysmsg.wxareddot.showType"), 0);
                        int i4 = bo.getInt((String) z.get(".sysmsg.wxareddot.reason"), 0);
                        switch (i) {
                            case 1:
                                if (!(obj.equals((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, null)) || i.axd() || bo.cc(ah.getContext()).equals(AppBrandLauncherUI.class.getName()) || q.axn() == a.gZL)) {
                                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, obj);
                                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(j));
                                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_SHOWTYPE_INT, Integer.valueOf(i3));
                                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_REASON_INT, Integer.valueOf(i4));
                                    if (i2 == 1 && r.axv()) {
                                        e eVar = e.hab;
                                        e.a((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 4, e.axE());
                                    }
                                    r.c(i2 != 1, j2);
                                    AppMethodBeat.o(129624);
                                    return;
                                }
                            case 2:
                                if (!obj.equals((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_MSG_ID_STRING, null))) {
                                    r.b(i2 != 1, j2, j3);
                                    break;
                                }
                                break;
                        }
                    }
                    AppMethodBeat.o(129624);
                    return;
                }
                AppMethodBeat.o(129624);
                return;
            }
            AppMethodBeat.o(129624);
        }
    }

    public static final class e {
        public static final e hab = new e();

        static {
            AppMethodBeat.i(129633);
            AppMethodBeat.o(129633);
        }

        static void axC() {
            AppMethodBeat.i(129629);
            a((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 3, axE());
            AppMethodBeat.o(129629);
        }

        public static void axD() {
            AppMethodBeat.i(129630);
            a("", 0, 1, 1);
            AppMethodBeat.o(129630);
        }

        static int axE() {
            AppMethodBeat.i(129631);
            if (g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, false)) {
                AppMethodBeat.o(129631);
                return 1;
            }
            int intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_REASON_INT, Integer.valueOf(0))).intValue();
            if (intValue > 0) {
                intValue++;
            }
            AppMethodBeat.o(129631);
            return intValue;
        }

        static void a(String str, long j, int i, int i2) {
            AppMethodBeat.i(129632);
            h.pYm.e(14112, Integer.valueOf(1), bo.nullAsNil(str), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(129632);
        }
    }

    public static final class d {
        public final String[] haa = new String[9];

        public d() {
            AppMethodBeat.i(129628);
            Arrays.fill(this.haa, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.haa[0] = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) "");
            this.haa[1] = String.valueOf(g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0)));
            this.haa[2] = String.valueOf(bo.anT());
            AppMethodBeat.o(129628);
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

    static /* synthetic */ void b(boolean z, long j, long j2) {
        AppMethodBeat.i(129642);
        a(z, j, j2);
        AppMethodBeat.o(129642);
    }

    static /* synthetic */ void c(boolean z, long j) {
        AppMethodBeat.i(129641);
        b(z, j);
        AppMethodBeat.o(129641);
    }

    private static void b(boolean z, long j) {
        AppMethodBeat.i(129634);
        if (z) {
            long j2;
            if (j == 0) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = bo.anT() + Math.max(0, j);
            }
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(j2));
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_RED_DOT_ONCE_BOOLEAN, Boolean.TRUE);
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN, Boolean.FALSE);
            e eVar = e.hab;
            e.a((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 1, e.axE());
            AppMethodBeat.o(129634);
            return;
        }
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(0));
        AppMethodBeat.o(129634);
    }

    private static void a(boolean z, long j, long j2) {
        long j3 = 0;
        AppMethodBeat.i(129635);
        z Ry = g.RP().Ry();
        com.tencent.mm.storage.ac.a aVar = com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_END_TIME_SECOND_LONG;
        if (z) {
            j3 = Math.max(0, j) + bo.anT();
        }
        Ry.set(aVar, Long.valueOf(j3));
        z Ry2 = g.RP().Ry();
        com.tencent.mm.storage.ac.a aVar2 = com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_FREQUENCY_SECOND_LONG;
        if (!z) {
            j2 = Long.MAX_VALUE;
        }
        Ry2.set(aVar2, Long.valueOf(j2));
        AppMethodBeat.o(129635);
    }

    public static boolean axt() {
        AppMethodBeat.i(129636);
        q.axl();
        if (g.RK()) {
            boolean booleanValue = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_RED_DOT_ONCE_BOOLEAN, Boolean.FALSE)).booleanValue();
            AppMethodBeat.o(129636);
            return booleanValue;
        }
        AppMethodBeat.o(129636);
        return false;
    }

    static a axu() {
        int i = 0;
        AppMethodBeat.i(129637);
        a aVar;
        if (axv()) {
            int intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_SHOWTYPE_INT, Integer.valueOf(0))).intValue();
            a[] values = a.values();
            int length = values.length;
            while (i < length) {
                aVar = values[i];
                if (aVar.value == intValue) {
                    AppMethodBeat.o(129637);
                    return aVar;
                }
                i++;
            }
            aVar = a.NONE;
            AppMethodBeat.o(129637);
            return aVar;
        }
        aVar = a.NONE;
        AppMethodBeat.o(129637);
        return aVar;
    }

    public static boolean axv() {
        AppMethodBeat.i(129638);
        if (g.RK()) {
            long longValue = ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(0))).longValue();
            boolean z = longValue > bo.anT();
            if (!z && longValue > 0) {
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_END_TIME_SECOND_LONG, Long.valueOf(0));
                e eVar = e.hab;
                e.axC();
            }
            AppMethodBeat.o(129638);
            return z;
        }
        AppMethodBeat.o(129638);
        return false;
    }

    static void axw() {
        AppMethodBeat.i(129639);
        q.axl();
        if (g.RK()) {
            e eVar = e.hab;
            if (!((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                e.a((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 0, e.axE());
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_HAS_REPORTED_SEE_RED_DOT_BOOLEAN, Boolean.TRUE);
            }
            AppMethodBeat.o(129639);
            return;
        }
        AppMethodBeat.o(129639);
    }

    public static void axx() {
        AppMethodBeat.i(129640);
        if (g.RK()) {
            if (axv()) {
                b(false, 0);
                a(false, 0, 0);
                e eVar = e.hab;
                e.a((String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_MSG_ID_STRING, (Object) ""), ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_ENTRANCE_RED_DOT_NEW_XML_PUSH_TIME_LONG, Long.valueOf(0))).longValue(), 2, e.axE());
            }
            AppMethodBeat.o(129640);
            return;
        }
        AppMethodBeat.o(129640);
    }

    static {
        AppMethodBeat.i(129643);
        AppMethodBeat.o(129643);
    }
}
