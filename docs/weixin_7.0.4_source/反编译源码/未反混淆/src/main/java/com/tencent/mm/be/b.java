package com.tencent.mm.be;

import android.os.Handler;
import android.util.Base64;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.map.swlocation.api.LocationUpdateListener;
import com.tencent.map.swlocation.api.ServerMessageListener;
import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.a.p;
import com.tencent.mm.ba.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b {
    private static final byte[] fNj = "@wechat*weixin!!".getBytes();
    private static b fNk;
    private boolean fNl = false;
    private al fNm;
    int fNn = 5000;
    int fNo = 5000;
    int fNp = 30000;
    private int fNq = 3600;
    private c fNr;
    private List<d> fNs = new ArrayList();
    private List<d> fNt = new ArrayList();
    private c fNu = new c<d>() {
        {
            AppMethodBeat.i(78529);
            this.xxI = d.class.getName().hashCode();
            AppMethodBeat.o(78529);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(78530);
            if (!((d) bVar).crQ.crR) {
                ab.i("MicroMsg.SenseWhereHelper", "it is [deactivated mode], stop sense where sdk after %d", Integer.valueOf(Math.max(b.this.fNo, b.this.fNn)));
                b.aiK();
                b.a(b.this, r0);
            }
            AppMethodBeat.o(78530);
            return false;
        }
    };
    private ap fNv;
    private LocationUpdateListener fNw;
    private int fNx;
    private ServerMessageListener fNy;
    private long startTime = 0;

    static /* synthetic */ String aiI() {
        AppMethodBeat.i(78544);
        String aiE = aiE();
        AppMethodBeat.o(78544);
        return aiE;
    }

    static /* synthetic */ boolean b(b bVar) {
        AppMethodBeat.i(78541);
        boolean aiG = bVar.aiG();
        AppMethodBeat.o(78541);
        return aiG;
    }

    static {
        AppMethodBeat.i(78554);
        AppMethodBeat.o(78554);
    }

    public static b aiD() {
        AppMethodBeat.i(78534);
        if (fNk == null) {
            fNk = new b();
        }
        b bVar = fNk;
        AppMethodBeat.o(78534);
        return bVar;
    }

    public b() {
        AppMethodBeat.i(78535);
        g.RQ();
        this.fNv = new ap(g.RS().oAl.getLooper(), new a() {
            public final boolean BI() {
                AppMethodBeat.i(78531);
                ab.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
                b.aiL();
                b.this.aiF();
                AppMethodBeat.o(78531);
                return false;
            }
        }, false);
        this.fNw = new LocationUpdateListener() {
            public final void onLocationUpdate(double d, double d2, int i, int i2, long j) {
                AppMethodBeat.i(78532);
                ab.d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
                AppMethodBeat.o(78532);
            }
        };
        this.fNx = 0;
        this.fNy = new ServerMessageListener() {
            public final void onMessage(int i, String str) {
                AppMethodBeat.i(78533);
                ab.d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", Integer.valueOf(i), str);
                if (i != 0 && b.o(b.this) > 3) {
                    ab.i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", Integer.valueOf(3));
                    b.aiM();
                    b.this.aiF();
                }
                AppMethodBeat.o(78533);
            }
        };
        AppMethodBeat.o(78535);
    }

    private static String aiE() {
        AppMethodBeat.i(78536);
        String LK = q.LK();
        g.RN();
        String str = LK + "_" + new p(com.tencent.mm.kernel.a.QF()).toString();
        try {
            af afVar = new af();
            byte[] bytes = str.getBytes("UTF-8");
            ab.i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new String(Base64.encode(afVar.a(bytes, bytes.length, fNj), 0), "UTF-8"), bo.anv(str));
            AppMethodBeat.o(78536);
            return LK;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SenseWhereHelper", e, "", new Object[0]);
            ab.e("MicroMsg.SenseWhereHelper", "create imei error: " + e.toString());
            LK = "";
            AppMethodBeat.o(78536);
            return LK;
        }
    }

    public final void a(float f, float f2, int i, String str, String str2, int i2, int i3) {
        AppMethodBeat.i(78537);
        if (g.RN().QY()) {
            g.RN();
            if (!com.tencent.mm.kernel.a.QT()) {
                g.RQ();
                final int i4 = i2;
                final float f3 = f;
                final float f4 = f2;
                final int i5 = i3;
                final int i6 = i;
                final String str3 = str;
                final String str4 = str2;
                g.RS().aa(new Runnable() {
                    final /* synthetic */ int fND = 0;

                    public final void run() {
                        AppMethodBeat.i(78527);
                        if (b.this.fNl) {
                            ab.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
                            AppMethodBeat.o(78527);
                        } else if (b.b(b.this)) {
                            b.aiH();
                            if (b.this.fNt.size() == 0 && b.this.fNs.size() == 0) {
                                b.e(b.this);
                            }
                            if (b.a(b.this, i4, f3, f4)) {
                                ab.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", Integer.valueOf(i4), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i5));
                                b.this.fNl = true;
                                g.RP().Ry().set(ac.a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(bo.anT()));
                                com.tencent.mm.sdk.b.a.xxA.c(b.this.fNu);
                                if (b.this.fNr != null) {
                                    b.this.fNr.finish();
                                }
                                b.this.fNx = 0;
                                b.this.startTime = bo.yz();
                                b.this.fNr = new c(f3, f4, i6, this.fND, str3, str4, i4, i5);
                                SwEngine.setImei(b.aiI());
                                SwEngine.creatLocationEngine(ah.getContext(), b.this.fNr);
                                SwEngine.startContinousLocationUpdate(b.i(b.this), b.this.fNn, b.this.fNo, b.this.fNw, b.this.fNy);
                                b.aiJ();
                                b.a(b.this, b.this.fNp);
                                AppMethodBeat.o(78527);
                                return;
                            }
                            AppMethodBeat.o(78527);
                        } else {
                            ab.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
                            AppMethodBeat.o(78527);
                        }
                    }
                });
                AppMethodBeat.o(78537);
                return;
            }
        }
        AppMethodBeat.o(78537);
    }

    public final void aiF() {
        AppMethodBeat.i(78538);
        g.RQ();
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78528);
                ab.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
                com.tencent.mm.sdk.b.a.xxA.d(b.this.fNu);
                SwEngine.stopContinousLocationUpdate();
                SwEngine.onDestroy();
                if (b.this.fNr != null) {
                    b.this.fNr.finish();
                    b.this.fNr = null;
                }
                b.l(b.this);
                b.m(b.this);
                b.n(b.this);
                b.this.fNl = false;
                AppMethodBeat.o(78528);
            }
        });
        AppMethodBeat.o(78538);
    }

    private boolean aiG() {
        AppMethodBeat.i(78539);
        g.RN();
        if (new p(com.tencent.mm.kernel.a.QF()).longValue() < 1000000) {
            ab.i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
            AppMethodBeat.o(78539);
            return false;
        }
        String value = com.tencent.mm.m.g.Nu().getValue("AndroidSenseWhereArgs");
        if (bo.isNullOrNil(value)) {
            ab.i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
            AppMethodBeat.o(78539);
            return false;
        }
        try {
            ab.d("MicroMsg.SenseWhereHelper", "sense where config : ".concat(String.valueOf(value)));
            String[] split = value.split(";");
            int i = bo.getInt(split[0], 0);
            g.RN();
            if (i.bL(com.tencent.mm.kernel.a.QF() + 5, 100) > i) {
                ab.d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", Integer.valueOf(i.bL(com.tencent.mm.kernel.a.QF() + 5, 100)), Integer.valueOf(i));
                AppMethodBeat.o(78539);
                return false;
            }
            this.fNo = bo.getInt(split[1], 5000);
            this.fNn = bo.getInt(split[2], 5000);
            this.fNp = bo.getInt(split[3], 30000);
            this.fNq = bo.getInt(split[4], 3600);
            ab.i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", Integer.valueOf(this.fNo), Integer.valueOf(this.fNn), Integer.valueOf(this.fNp), Integer.valueOf(this.fNq));
            if (bo.fp(((Long) g.RP().Ry().get(ac.a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(0))).longValue()) > ((long) this.fNq)) {
                AppMethodBeat.o(78539);
                return true;
            }
            ab.i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", Long.valueOf(bo.fp(((Long) g.RP().Ry().get(ac.a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(0))).longValue())), Integer.valueOf(this.fNq));
            AppMethodBeat.o(78539);
            return false;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SenseWhereHelper", e, "", new Object[0]);
            ab.e("MicroMsg.SenseWhereHelper", "check sense where config error: " + e.toString());
            ab.i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
            AppMethodBeat.o(78539);
            return false;
        }
    }

    public static void aiH() {
        AppMethodBeat.i(78540);
        if (bo.fp(bo.a((Long) g.RP().Ry().get(ac.a.USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG, null), 0)) * 1000 > 21600000) {
            ab.i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
            g.RO().eJo.a(new k(36), 0);
            g.RP().Ry().set(ac.a.USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG, Long.valueOf(bo.anT()));
        }
        AppMethodBeat.o(78540);
    }

    static /* synthetic */ void e(b bVar) {
        AppMethodBeat.i(78542);
        bVar.fNs.clear();
        bVar.fNt.clear();
        String str = (String) g.RP().Ry().get(ac.a.USERINFO_SENSE_WHERE_LOCATION_STRING, (Object) "");
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.SenseWhereHelper", "sense where location xml is null.");
            AppMethodBeat.o(78542);
            return;
        }
        Map z = br.z(str, "SenseWhere");
        if (z == null) {
            ab.w("MicroMsg.SenseWhereHelper", "parseLocation maps is null, xml[%s]", str);
            AppMethodBeat.o(78542);
            return;
        }
        int i = 0;
        while (true) {
            String str2 = ".SenseWhere.item" + (i == 0 ? "" : Integer.valueOf(i));
            str = (String) z.get(str2 + ".$gpstype");
            if (bo.isNullOrNil(str)) {
                h.pYm.a(345, 6, 1, false);
                ab.i("MicroMsg.SenseWhereHelper", "parse location finish earth[%d] mars[%d]", Integer.valueOf(bVar.fNt.size()), Integer.valueOf(bVar.fNs.size()));
                AppMethodBeat.o(78542);
                return;
            }
            d dVar = new d();
            dVar.fNM = str;
            dVar.longitude = bo.getDouble((String) z.get(str2 + ".$longitude"), 0.0d);
            dVar.latitude = bo.getDouble((String) z.get(str2 + ".$latitude"), 0.0d);
            dVar.fNN = bo.getDouble((String) z.get(str2 + ".$distance"), 0.0d);
            if (dVar.fNN > 5500000.0d) {
                dVar.fNN = 5500000.0d;
            }
            if ("1".equals(dVar.fNM)) {
                bVar.fNs.add(dVar);
            } else {
                bVar.fNt.add(dVar);
            }
            i++;
        }
    }

    static /* synthetic */ boolean a(b bVar, int i, float f, float f2) {
        AppMethodBeat.i(78543);
        List list;
        if (i == 1) {
            list = bVar.fNs;
        } else {
            list = bVar.fNt;
        }
        if (list == null || list.size() <= 0) {
            ab.i("MicroMsg.SenseWhereHelper", "it has not report location, do not start sense where.");
            AppMethodBeat.o(78543);
            return false;
        }
        boolean z;
        long yz = bo.yz();
        for (d dVar : list) {
            ab.d("MicroMsg.SenseWhereHelper", "loc[%f, %f], config[%f, %f], dis[%f, %f]", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(dVar.latitude), Double.valueOf(dVar.longitude), Double.valueOf(TencentLocationUtils.distanceBetween(dVar.latitude, dVar.longitude, (double) f2, (double) f)), Double.valueOf(dVar.fNN));
            if (TencentLocationUtils.distanceBetween(dVar.latitude, dVar.longitude, (double) f2, (double) f) <= dVar.fNN) {
                z = true;
                break;
            }
        }
        z = false;
        ab.i("MicroMsg.SenseWhereHelper", "check location[%d, %f, %f] finish %b, cost time %d", Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f), Boolean.valueOf(z), Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(78543);
        return z;
    }

    static /* synthetic */ Handler i(b bVar) {
        AppMethodBeat.i(78545);
        bVar.fNm = new al("sensewhere");
        Handler fetchFreeHandler = ak.fetchFreeHandler(bVar.fNm.oAl.getLooper());
        AppMethodBeat.o(78545);
        return fetchFreeHandler;
    }

    static /* synthetic */ void aiJ() {
        AppMethodBeat.i(78546);
        h.pYm.a(345, 1, 1, false);
        AppMethodBeat.o(78546);
    }

    static /* synthetic */ void l(b bVar) {
        AppMethodBeat.i(78548);
        if (bVar.fNm != null) {
            bVar.fNm.oAl.quit();
        }
        bVar.fNm = null;
        AppMethodBeat.o(78548);
    }

    static /* synthetic */ void m(b bVar) {
        AppMethodBeat.i(78549);
        bVar.fNv.stopTimer();
        AppMethodBeat.o(78549);
    }

    static /* synthetic */ void n(b bVar) {
        AppMethodBeat.i(78550);
        if (bVar.startTime > 0) {
            ab.d("MicroMsg.SenseWhereHelper", "reportCollectionTime time %d, res %d", Long.valueOf((bo.yz() - bVar.startTime) / 1000), Integer.valueOf(bo.h((Integer) h.a((int) ((bo.yz() - bVar.startTime) / 1000), new int[]{5, 10, 20, 30}, 10, 14))));
            h.pYm.a(345, (long) r0, 1, false);
        }
        AppMethodBeat.o(78550);
    }

    static /* synthetic */ void aiK() {
        AppMethodBeat.i(78551);
        h.pYm.a(345, 5, 1, false);
        AppMethodBeat.o(78551);
    }

    static /* synthetic */ void aiL() {
        AppMethodBeat.i(78552);
        h.pYm.a(345, 2, 1, false);
        AppMethodBeat.o(78552);
    }

    static /* synthetic */ int o(b bVar) {
        int i = bVar.fNx + 1;
        bVar.fNx = i;
        return i;
    }

    static /* synthetic */ void aiM() {
        AppMethodBeat.i(78553);
        h.pYm.a(345, 3, 1, false);
        AppMethodBeat.o(78553);
    }
}
