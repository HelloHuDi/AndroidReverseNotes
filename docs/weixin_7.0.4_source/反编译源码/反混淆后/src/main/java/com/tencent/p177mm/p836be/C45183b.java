package com.tencent.p177mm.p836be;

import android.os.Handler;
import android.util.Base64;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.map.swlocation.api.LocationUpdateListener;
import com.tencent.map.swlocation.api.ServerMessageListener;
import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p230g.p231a.C26111d;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.platformtools.C37984af;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.be.b */
public final class C45183b {
    private static final byte[] fNj = "@wechat*weixin!!".getBytes();
    private static C45183b fNk;
    private boolean fNl = false;
    private C5004al fNm;
    int fNn = 5000;
    int fNo = 5000;
    int fNp = 30000;
    private int fNq = 3600;
    private C37510c fNr;
    private List<C45184d> fNs = new ArrayList();
    private List<C45184d> fNt = new ArrayList();
    private C4884c fNu = new C258563();
    private C7564ap fNv;
    private LocationUpdateListener fNw;
    private int fNx;
    private ServerMessageListener fNy;
    private long startTime = 0;

    /* renamed from: com.tencent.mm.be.b$4 */
    class C179794 implements C5015a {
        C179794() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(78531);
            C4990ab.m7416i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
            C45183b.aiL();
            C45183b.this.aiF();
            AppMethodBeat.m2505o(78531);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.be.b$3 */
    class C258563 extends C4884c<C26111d> {
        C258563() {
            AppMethodBeat.m2504i(78529);
            this.xxI = C26111d.class.getName().hashCode();
            AppMethodBeat.m2505o(78529);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(78530);
            if (!((C26111d) c4883b).crQ.crR) {
                C4990ab.m7417i("MicroMsg.SenseWhereHelper", "it is [deactivated mode], stop sense where sdk after %d", Integer.valueOf(Math.max(C45183b.this.fNo, C45183b.this.fNn)));
                C45183b.aiK();
                C45183b.m83236a(C45183b.this, r0);
            }
            AppMethodBeat.m2505o(78530);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.be.b$5 */
    class C258575 implements LocationUpdateListener {
        C258575() {
        }

        public final void onLocationUpdate(double d, double d2, int i, int i2, long j) {
            AppMethodBeat.m2504i(78532);
            C4990ab.m7411d("MicroMsg.SenseWhereHelper", "onLocationUpdate latitude[%f] longitude[%f] error[%d] floor[%d] buildingId[%d]", Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
            AppMethodBeat.m2505o(78532);
        }
    }

    /* renamed from: com.tencent.mm.be.b$6 */
    class C312656 implements ServerMessageListener {
        C312656() {
        }

        public final void onMessage(int i, String str) {
            AppMethodBeat.m2504i(78533);
            C4990ab.m7411d("MicroMsg.SenseWhereHelper", "onMessage code[%d] message[%s]", Integer.valueOf(i), str);
            if (i != 0 && C45183b.m83253o(C45183b.this) > 3) {
                C4990ab.m7417i("MicroMsg.SenseWhereHelper", "sense where error time more than %d, stop now.", Integer.valueOf(3));
                C45183b.aiM();
                C45183b.this.aiF();
            }
            AppMethodBeat.m2505o(78533);
        }
    }

    /* renamed from: com.tencent.mm.be.b$2 */
    class C375092 implements Runnable {
        C375092() {
        }

        public final void run() {
            AppMethodBeat.m2504i(78528);
            C4990ab.m7416i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
            C4879a.xxA.mo10053d(C45183b.this.fNu);
            SwEngine.stopContinousLocationUpdate();
            SwEngine.onDestroy();
            if (C45183b.this.fNr != null) {
                C45183b.this.fNr.finish();
                C45183b.this.fNr = null;
            }
            C45183b.m83250l(C45183b.this);
            C45183b.m83251m(C45183b.this);
            C45183b.m83252n(C45183b.this);
            C45183b.this.fNl = false;
            AppMethodBeat.m2505o(78528);
        }
    }

    static /* synthetic */ String aiI() {
        AppMethodBeat.m2504i(78544);
        String aiE = C45183b.aiE();
        AppMethodBeat.m2505o(78544);
        return aiE;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m83240b(C45183b c45183b) {
        AppMethodBeat.m2504i(78541);
        boolean aiG = c45183b.aiG();
        AppMethodBeat.m2505o(78541);
        return aiG;
    }

    static {
        AppMethodBeat.m2504i(78554);
        AppMethodBeat.m2505o(78554);
    }

    public static C45183b aiD() {
        AppMethodBeat.m2504i(78534);
        if (fNk == null) {
            fNk = new C45183b();
        }
        C45183b c45183b = fNk;
        AppMethodBeat.m2505o(78534);
        return c45183b;
    }

    public C45183b() {
        AppMethodBeat.m2504i(78535);
        C1720g.m3537RQ();
        this.fNv = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C179794(), false);
        this.fNw = new C258575();
        this.fNx = 0;
        this.fNy = new C312656();
        AppMethodBeat.m2505o(78535);
    }

    private static String aiE() {
        AppMethodBeat.m2504i(78536);
        String LK = C1427q.m3026LK();
        C1720g.m3534RN();
        String str = LK + "_" + new C1183p(C1668a.m3383QF()).toString();
        try {
            C37984af c37984af = new C37984af();
            byte[] bytes = str.getBytes("UTF-8");
            C4990ab.m7417i("MicroMsg.SenseWhereHelper", "create encrypt imei[%s], original imei[%s]", new String(Base64.encode(c37984af.mo60758a(bytes, bytes.length, fNj), 0), "UTF-8"), C5046bo.anv(str));
            AppMethodBeat.m2505o(78536);
            return LK;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SenseWhereHelper", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.SenseWhereHelper", "create imei error: " + e.toString());
            LK = "";
            AppMethodBeat.m2505o(78536);
            return LK;
        }
    }

    /* renamed from: a */
    public final void mo73167a(float f, float f2, int i, String str, String str2, int i2, int i3) {
        AppMethodBeat.m2504i(78537);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3534RN();
            if (!C1668a.m3393QT()) {
                C1720g.m3537RQ();
                final int i4 = i2;
                final float f3 = f;
                final float f4 = f2;
                final int i5 = i3;
                final int i6 = i;
                final String str3 = str;
                final String str4 = str2;
                C1720g.m3539RS().mo10302aa(new Runnable() {
                    final /* synthetic */ int fND = 0;

                    public final void run() {
                        AppMethodBeat.m2504i(78527);
                        if (C45183b.this.fNl) {
                            C4990ab.m7410d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
                            AppMethodBeat.m2505o(78527);
                        } else if (C45183b.m83240b(C45183b.this)) {
                            C45183b.aiH();
                            if (C45183b.this.fNt.size() == 0 && C45183b.this.fNs.size() == 0) {
                                C45183b.m83243e(C45183b.this);
                            }
                            if (C45183b.m83238a(C45183b.this, i4, f3, f4)) {
                                C4990ab.m7417i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", Integer.valueOf(i4), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i5));
                                C45183b.this.fNl = true;
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(C5046bo.anT()));
                                C4879a.xxA.mo10052c(C45183b.this.fNu);
                                if (C45183b.this.fNr != null) {
                                    C45183b.this.fNr.finish();
                                }
                                C45183b.this.fNx = 0;
                                C45183b.this.startTime = C5046bo.m7588yz();
                                C45183b.this.fNr = new C37510c(f3, f4, i6, this.fND, str3, str4, i4, i5);
                                SwEngine.setImei(C45183b.aiI());
                                SwEngine.creatLocationEngine(C4996ah.getContext(), C45183b.this.fNr);
                                SwEngine.startContinousLocationUpdate(C45183b.m83247i(C45183b.this), C45183b.this.fNn, C45183b.this.fNo, C45183b.this.fNw, C45183b.this.fNy);
                                C45183b.aiJ();
                                C45183b.m83236a(C45183b.this, C45183b.this.fNp);
                                AppMethodBeat.m2505o(78527);
                                return;
                            }
                            AppMethodBeat.m2505o(78527);
                        } else {
                            C4990ab.m7410d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
                            AppMethodBeat.m2505o(78527);
                        }
                    }
                });
                AppMethodBeat.m2505o(78537);
                return;
            }
        }
        AppMethodBeat.m2505o(78537);
    }

    public final void aiF() {
        AppMethodBeat.m2504i(78538);
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new C375092());
        AppMethodBeat.m2505o(78538);
    }

    private boolean aiG() {
        AppMethodBeat.m2504i(78539);
        C1720g.m3534RN();
        if (new C1183p(C1668a.m3383QF()).longValue() < 1000000) {
            C4990ab.m7416i("MicroMsg.SenseWhereHelper", "it boss uin do not start sense where.");
            AppMethodBeat.m2505o(78539);
            return false;
        }
        String value = C26373g.m41964Nu().getValue("AndroidSenseWhereArgs");
        if (C5046bo.isNullOrNil(value)) {
            C4990ab.m7416i("MicroMsg.SenseWhereHelper", "it has no config do not start sense where.");
            AppMethodBeat.m2505o(78539);
            return false;
        }
        try {
            C4990ab.m7410d("MicroMsg.SenseWhereHelper", "sense where config : ".concat(String.valueOf(value)));
            String[] split = value.split(";");
            int i = C5046bo.getInt(split[0], 0);
            C1720g.m3534RN();
            if (C1179i.m2593bL(C1668a.m3383QF() + 5, 100) > i) {
                C4990ab.m7411d("MicroMsg.SenseWhereHelper", "do not start sense where.uinhash %d, percent %d", Integer.valueOf(C1179i.m2593bL(C1668a.m3383QF() + 5, 100)), Integer.valueOf(i));
                AppMethodBeat.m2505o(78539);
                return false;
            }
            this.fNo = C5046bo.getInt(split[1], 5000);
            this.fNn = C5046bo.getInt(split[2], 5000);
            this.fNp = C5046bo.getInt(split[3], 30000);
            this.fNq = C5046bo.getInt(split[4], 3600);
            C4990ab.m7417i("MicroMsg.SenseWhereHelper", "check sense where report args[%d, %d, %d, %d]", Integer.valueOf(this.fNo), Integer.valueOf(this.fNn), Integer.valueOf(this.fNp), Integer.valueOf(this.fNq));
            if (C5046bo.m7549fp(((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(0))).longValue()) > ((long) this.fNq)) {
                AppMethodBeat.m2505o(78539);
                return true;
            }
            C4990ab.m7417i("MicroMsg.SenseWhereHelper", "it is not time out. diff[%d], collection interval[%d]", Long.valueOf(C5046bo.m7549fp(((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LAST_START_SENSE_WHERE_LONG, Long.valueOf(0))).longValue())), Integer.valueOf(this.fNq));
            AppMethodBeat.m2505o(78539);
            return false;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SenseWhereHelper", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.SenseWhereHelper", "check sense where config error: " + e.toString());
            C4990ab.m7416i("MicroMsg.SenseWhereHelper", "it default do not start sense where.");
            AppMethodBeat.m2505o(78539);
            return false;
        }
    }

    public static void aiH() {
        AppMethodBeat.m2504i(78540);
        if (C5046bo.m7549fp(C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG, null), 0)) * 1000 > 21600000) {
            C4990ab.m7416i("MicroMsg.SenseWhereHelper", "update sense where location package list.");
            C1720g.m3535RO().eJo.mo14541a(new C45181k(36), 0);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LAST_GET_SENSE_WHERE_LOCATION_LONG, Long.valueOf(C5046bo.anT()));
        }
        AppMethodBeat.m2505o(78540);
    }

    /* renamed from: e */
    static /* synthetic */ void m83243e(C45183b c45183b) {
        AppMethodBeat.m2504i(78542);
        c45183b.fNs.clear();
        c45183b.fNt.clear();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SENSE_WHERE_LOCATION_STRING, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.SenseWhereHelper", "sense where location xml is null.");
            AppMethodBeat.m2505o(78542);
            return;
        }
        Map z = C5049br.m7595z(str, "SenseWhere");
        if (z == null) {
            C4990ab.m7421w("MicroMsg.SenseWhereHelper", "parseLocation maps is null, xml[%s]", str);
            AppMethodBeat.m2505o(78542);
            return;
        }
        int i = 0;
        while (true) {
            String str2 = ".SenseWhere.item" + (i == 0 ? "" : Integer.valueOf(i));
            str = (String) z.get(str2 + ".$gpstype");
            if (C5046bo.isNullOrNil(str)) {
                C7060h.pYm.mo8378a(345, 6, 1, false);
                C4990ab.m7417i("MicroMsg.SenseWhereHelper", "parse location finish earth[%d] mars[%d]", Integer.valueOf(c45183b.fNt.size()), Integer.valueOf(c45183b.fNs.size()));
                AppMethodBeat.m2505o(78542);
                return;
            }
            C45184d c45184d = new C45184d();
            c45184d.fNM = str;
            c45184d.longitude = C5046bo.getDouble((String) z.get(str2 + ".$longitude"), 0.0d);
            c45184d.latitude = C5046bo.getDouble((String) z.get(str2 + ".$latitude"), 0.0d);
            c45184d.fNN = C5046bo.getDouble((String) z.get(str2 + ".$distance"), 0.0d);
            if (c45184d.fNN > 5500000.0d) {
                c45184d.fNN = 5500000.0d;
            }
            if ("1".equals(c45184d.fNM)) {
                c45183b.fNs.add(c45184d);
            } else {
                c45183b.fNt.add(c45184d);
            }
            i++;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m83238a(C45183b c45183b, int i, float f, float f2) {
        AppMethodBeat.m2504i(78543);
        List list;
        if (i == 1) {
            list = c45183b.fNs;
        } else {
            list = c45183b.fNt;
        }
        if (list == null || list.size() <= 0) {
            C4990ab.m7416i("MicroMsg.SenseWhereHelper", "it has not report location, do not start sense where.");
            AppMethodBeat.m2505o(78543);
            return false;
        }
        boolean z;
        long yz = C5046bo.m7588yz();
        for (C45184d c45184d : list) {
            C4990ab.m7411d("MicroMsg.SenseWhereHelper", "loc[%f, %f], config[%f, %f], dis[%f, %f]", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(c45184d.latitude), Double.valueOf(c45184d.longitude), Double.valueOf(TencentLocationUtils.distanceBetween(c45184d.latitude, c45184d.longitude, (double) f2, (double) f)), Double.valueOf(c45184d.fNN));
            if (TencentLocationUtils.distanceBetween(c45184d.latitude, c45184d.longitude, (double) f2, (double) f) <= c45184d.fNN) {
                z = true;
                break;
            }
        }
        z = false;
        C4990ab.m7417i("MicroMsg.SenseWhereHelper", "check location[%d, %f, %f] finish %b, cost time %d", Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f), Boolean.valueOf(z), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(78543);
        return z;
    }

    /* renamed from: i */
    static /* synthetic */ Handler m83247i(C45183b c45183b) {
        AppMethodBeat.m2504i(78545);
        c45183b.fNm = new C5004al("sensewhere");
        Handler fetchFreeHandler = C7306ak.fetchFreeHandler(c45183b.fNm.oAl.getLooper());
        AppMethodBeat.m2505o(78545);
        return fetchFreeHandler;
    }

    static /* synthetic */ void aiJ() {
        AppMethodBeat.m2504i(78546);
        C7060h.pYm.mo8378a(345, 1, 1, false);
        AppMethodBeat.m2505o(78546);
    }

    /* renamed from: l */
    static /* synthetic */ void m83250l(C45183b c45183b) {
        AppMethodBeat.m2504i(78548);
        if (c45183b.fNm != null) {
            c45183b.fNm.oAl.quit();
        }
        c45183b.fNm = null;
        AppMethodBeat.m2505o(78548);
    }

    /* renamed from: m */
    static /* synthetic */ void m83251m(C45183b c45183b) {
        AppMethodBeat.m2504i(78549);
        c45183b.fNv.stopTimer();
        AppMethodBeat.m2505o(78549);
    }

    /* renamed from: n */
    static /* synthetic */ void m83252n(C45183b c45183b) {
        AppMethodBeat.m2504i(78550);
        if (c45183b.startTime > 0) {
            C4990ab.m7411d("MicroMsg.SenseWhereHelper", "reportCollectionTime time %d, res %d", Long.valueOf((C5046bo.m7588yz() - c45183b.startTime) / 1000), Integer.valueOf(C5046bo.m7567h((Integer) C7060h.m11789a((int) ((C5046bo.m7588yz() - c45183b.startTime) / 1000), new int[]{5, 10, 20, 30}, 10, 14))));
            C7060h.pYm.mo8378a(345, (long) r0, 1, false);
        }
        AppMethodBeat.m2505o(78550);
    }

    static /* synthetic */ void aiK() {
        AppMethodBeat.m2504i(78551);
        C7060h.pYm.mo8378a(345, 5, 1, false);
        AppMethodBeat.m2505o(78551);
    }

    static /* synthetic */ void aiL() {
        AppMethodBeat.m2504i(78552);
        C7060h.pYm.mo8378a(345, 2, 1, false);
        AppMethodBeat.m2505o(78552);
    }

    /* renamed from: o */
    static /* synthetic */ int m83253o(C45183b c45183b) {
        int i = c45183b.fNx + 1;
        c45183b.fNx = i;
        return i;
    }

    static /* synthetic */ void aiM() {
        AppMethodBeat.m2504i(78553);
        C7060h.pYm.mo8378a(345, 3, 1, false);
        AppMethodBeat.m2505o(78553);
    }
}
