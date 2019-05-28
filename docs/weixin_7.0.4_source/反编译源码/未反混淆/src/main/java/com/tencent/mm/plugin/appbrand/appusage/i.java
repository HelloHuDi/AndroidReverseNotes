package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.r.a;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI;
import com.tencent.mm.protocal.protobuf.clq;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.z;

public enum i {
    ;
    
    public static final c<qp> gZa = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.i$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] gZc = null;

        static {
            AppMethodBeat.i(129534);
            gZc = new int[a.values().length];
            try {
                gZc[a.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gZc[a.REDDOT.ordinal()] = 2;
                AppMethodBeat.o(129534);
            } catch (NoSuchFieldError e2) {
                AppMethodBeat.o(129534);
            }
        }
    }

    static {
        gZa = new c<qp>() {
            {
                AppMethodBeat.i(129532);
                this.xxI = qp.class.getName().hashCode();
                AppMethodBeat.o(129532);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(129533);
                qp qpVar = (qp) bVar;
                qpVar.cMI.cMK = i.axb();
                if (qpVar.cMH.cMJ) {
                    qp.b bVar2 = qpVar.cMI;
                    qpVar.cMI.cML = false;
                    bVar2.cMM = false;
                    if (!i.axd()) {
                        switch (AnonymousClass2.gZc[r.axu().ordinal()]) {
                            case 1:
                                qpVar.cMI.cMM = true;
                                break;
                            case 2:
                                qpVar.cMI.cML = true;
                                break;
                        }
                    }
                    qpVar.cMI.cMM = true;
                    if (qpVar.cMI.cML || qpVar.cMI.cMM) {
                        r.axw();
                    }
                    r.c cVar = r.gZP;
                    q.axl();
                    if (g.RK() && w.adF()) {
                        long anT = bo.anT();
                        long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_END_TIME_SECOND_LONG, Long.valueOf(0))).longValue();
                        long longValue2 = ((Long) g.RP().Ry().get(ac.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_FREQUENCY_SECOND_LONG, Long.valueOf(Long.MAX_VALUE))).longValue() + ((Long) g.RP().Ry().get(ac.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_LAST_TIME_SECOND_LONG, Long.valueOf(0))).longValue();
                        if (longValue2 > 0 && anT < longValue && anT >= longValue2) {
                            ab.d("MicroMsg.AppBrandPushNewOrRedDotLogic", "doReport");
                            d.agz().b((com.tencent.mm.modelgeo.b.a) e.bB(new com.tencent.mm.modelgeo.b.a() {
                                int count = 0;

                                public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                                    AppMethodBeat.i(129627);
                                    com.tencent.mm.plugin.appbrand.s.e.at(this);
                                    com.tencent.mm.modelgeo.d.agz().c(this);
                                    int i2 = this.count;
                                    this.count = i2 + 1;
                                    if (i2 <= 0 && z) {
                                        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                                        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/uploaduserlocationinfo";
                                        aVar.fsI = 1154;
                                        aVar.fsK = new clr();
                                        clq clq = new clq();
                                        clq.latitude = (double) f2;
                                        clq.longitude = (double) f;
                                        clq.xjm = d2;
                                        aVar.fsJ = clq;
                                        final float f3 = f;
                                        final float f4 = f2;
                                        final double d4 = d2;
                                        w.a(aVar.acD(), new com.tencent.mm.ai.w.a() {
                                            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                                                AppMethodBeat.i(129626);
                                                ab.d("MicroMsg.AppBrandPushNewOrRedDotLogic", "locationReport, errType %d, errCode %d, errMsg %s, longitude %f, latitude %f, accuracy %f", Integer.valueOf(i), Integer.valueOf(i2), str, Float.valueOf(f3), Float.valueOf(f4), Double.valueOf(d4));
                                                AppMethodBeat.o(129626);
                                                return 0;
                                            }
                                        }, true);
                                    }
                                    AppMethodBeat.o(129627);
                                    return true;
                                }
                            }), true);
                            g.RP().Ry().set(ac.a.USERINFO_APP_BRAND_ENTRANCE_LOCATION_REPORT_LAST_TIME_SECOND_LONG, Long.valueOf(anT));
                        }
                    }
                }
                AppMethodBeat.o(129533);
                return true;
            }
        };
        AppMethodBeat.o(129546);
    }

    public static boolean axb() {
        AppMethodBeat.i(129537);
        if (!g.RK()) {
            AppMethodBeat.o(129537);
            return false;
        } else if (com.tencent.mm.m.g.Nu().getInt("WeAppForbiddenSwitch", 0) == 1) {
            ab.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
            AppMethodBeat.o(129537);
            return false;
        } else if (axg() || r.axt()) {
            AppMethodBeat.o(129537);
            return true;
        } else {
            AppMethodBeat.o(129537);
            return false;
        }
    }

    public static void axc() {
        AppMethodBeat.i(129538);
        if (g.RK()) {
            if (axd()) {
                r.e eVar = r.e.hab;
                r.e.a("", 0, 2, 1);
            }
            g.RP().Ry().set(ac.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, Boolean.FALSE);
            AppMethodBeat.o(129538);
            return;
        }
        AppMethodBeat.o(129538);
    }

    static boolean axd() {
        AppMethodBeat.i(129539);
        if (g.RK()) {
            boolean booleanValue = ((Boolean) g.RP().Ry().get(ac.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, Boolean.FALSE)).booleanValue();
            AppMethodBeat.o(129539);
            return booleanValue;
        }
        AppMethodBeat.o(129539);
        return false;
    }

    static void nx(int i) {
        boolean z = true;
        AppMethodBeat.i(129540);
        if (g.RK()) {
            z Ry = g.RP().Ry();
            g((i & 2) > 0, "");
            ac.a aVar = ac.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_FAVORITE_BOOLEAN;
            if ((i & 1) <= 0) {
                z = false;
            }
            Ry.set(aVar, Boolean.valueOf(z));
            AppMethodBeat.o(129540);
            return;
        }
        AppMethodBeat.o(129540);
    }

    private static void g(boolean z, String str) {
        AppMethodBeat.i(129541);
        if (g.RK()) {
            Object obj;
            Boolean bool = (Boolean) g.RP().Ry().get(ac.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN, null);
            if (bool == null || bool.booleanValue() || !z) {
                obj = null;
            } else {
                g.RP().Ry().set(ac.a.USERINFO_APP_BRAND_ENTRANCE_SHOW_NEW_BOOLEAN, Boolean.TRUE);
                r.e eVar = r.e.hab;
                r.e.axD();
                obj = 1;
            }
            g.RP().Ry().set(ac.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN, Boolean.valueOf(z));
            if (obj != null) {
                AppBrandGuideUI.a auN = f.auN();
                if (auN != null) {
                    auN.DV(str);
                }
            }
            AppMethodBeat.o(129541);
            return;
        }
        AppMethodBeat.o(129541);
    }

    static void yt(String str) {
        AppMethodBeat.i(129542);
        g(true, str);
        AppMethodBeat.o(129542);
    }

    public static boolean axe() {
        AppMethodBeat.i(129543);
        if (g.RK()) {
            boolean booleanValue = ((Boolean) g.RP().Ry().get(ac.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_HISTORY_BOOLEAN, Boolean.FALSE)).booleanValue();
            AppMethodBeat.o(129543);
            return booleanValue;
        }
        AppMethodBeat.o(129543);
        return false;
    }

    public static boolean axf() {
        AppMethodBeat.i(129544);
        t.axG();
        if (g.RK()) {
            boolean booleanValue = ((Boolean) g.RP().Ry().get(ac.a.USERINFO_APP_BRAND_USAGE_RECORD_HAS_FAVORITE_BOOLEAN, Boolean.FALSE)).booleanValue();
            AppMethodBeat.o(129544);
            return booleanValue;
        }
        AppMethodBeat.o(129544);
        return false;
    }

    public static boolean axg() {
        AppMethodBeat.i(129545);
        if (axf() || axe()) {
            AppMethodBeat.o(129545);
            return true;
        }
        AppMethodBeat.o(129545);
        return false;
    }
}
