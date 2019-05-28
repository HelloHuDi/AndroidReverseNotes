package com.tencent.p177mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelmulti.C42213c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18245ds;
import com.tencent.p177mm.p230g.p231a.C26116dr;
import com.tencent.p177mm.p230g.p231a.C32535dt;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.afi;
import com.tencent.p177mm.protocal.protobuf.atz;
import com.tencent.p177mm.protocal.protobuf.aub;
import com.tencent.p177mm.protocal.protobuf.aue;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.tencent.mm.booter.k */
public final class C9186k {
    private static C4884c ecA = new C91903();
    private static C26443d ecr;
    private static float ecs = -85.0f;
    private static float ect = -1000.0f;
    private static boolean ecu = false;
    private static Map<String, atz> ecv = new ConcurrentHashMap();
    private static List<atz> ecw = new CopyOnWriteArrayList();
    private static Boolean ecx = Boolean.FALSE;
    private static C42206a ecy = new C91871();
    private static C7564ap ecz = new C7564ap(Looper.getMainLooper(), new C91882(), true);

    /* renamed from: com.tencent.mm.booter.k$1 */
    static class C91871 implements C42206a {
        C91871() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(15854);
            if (z) {
                C4990ab.m7410d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
                C9186k.ecs = f2;
                C9186k.ect = f;
                C9186k.ecu = true;
                if (C9186k.ecr != null) {
                    C9186k.ecr.mo44208c(C9186k.ecy);
                    C9186k.ecu = false;
                }
            } else {
                C4990ab.m7420w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
            }
            AppMethodBeat.m2505o(15854);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.booter.k$2 */
    static class C91882 implements C5015a {
        C91882() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(15856);
            try {
                C9638aw.m17190ZK();
                Boolean valueOf = Boolean.valueOf(C5046bo.m7517a((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, null), false));
                List<String> Nl = C26373g.m41965Nv().mo5299Nl();
                if (Nl != null) {
                    for (String str : Nl) {
                        C4990ab.m7417i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + valueOf + ",iBeacon = %s", str);
                        C18245ds c18245ds = new C18245ds();
                        c18245ds.cxg.cxi = str;
                        c18245ds.cxg.cxf = false;
                        if (!valueOf.booleanValue()) {
                            C4879a.xxA.mo10055m(c18245ds);
                        }
                    }
                    aub aub = new aub();
                    aub.latitude = (double) C9186k.ecs;
                    aub.longitude = (double) C9186k.ect;
                    C9638aw.m17190ZK();
                    long a = C5046bo.m7514a((Long) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_SHOP_ID_LONG, null), 0);
                    if (C9186k.ecv.size() <= 0 || C9186k.ecx.booleanValue() || C9186k.ecw.size() <= 0) {
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                    } else {
                        C9186k.ecx = Boolean.TRUE;
                        final C1207m c42213c = new C42213c(C9186k.ecw, a, aub);
                        C4990ab.m7410d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + a + ",beaconInfos size " + C9186k.ecw.size() + ",info:" + C9186k.ecw.toString());
                        C9638aw.m17182Rg().mo14539a(1708, new C1202f() {
                            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                                AppMethodBeat.m2504i(15855);
                                if (i == 0 && i2 == 0) {
                                    afi afi = (afi) c42213c.fAT.fsH.fsP;
                                    if (afi.result == 0) {
                                        aue aue = afi.wmJ;
                                        atz atz = afi.wmL;
                                        Object obj = aue.title + "," + aue.desc + "," + aue.wyc + "," + aue.wyd + "," + atz.eCq + "," + atz.major + "," + atz.minor;
                                        C9638aw.m17190ZK();
                                        String[] split = C5046bo.m7532bc((String) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, null), "").split(",");
                                        Boolean bool = Boolean.FALSE;
                                        for (String equals : split) {
                                            if (equals.equals(atz.eCq + atz.major + atz.minor)) {
                                                bool = Boolean.TRUE;
                                            }
                                        }
                                        if (bool.booleanValue()) {
                                            C9638aw.m17190ZK();
                                            C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                                        } else {
                                            C7060h.pYm.mo8381e(12653, Integer.valueOf(1), Integer.valueOf(1));
                                            C7060h.pYm.mo8381e(12653, Integer.valueOf(2), Integer.valueOf(1));
                                            C9638aw.m17190ZK();
                                            C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, obj);
                                        }
                                    } else {
                                        C9638aw.m17190ZK();
                                        C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                                    }
                                } else {
                                    C9638aw.m17190ZK();
                                    C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                                }
                                C9638aw.m17190ZK();
                                C18628c.m29065QV();
                                C4879a.xxA.mo10055m(new C26116dr());
                                C9186k.ecx = Boolean.FALSE;
                                C9638aw.m17182Rg().mo14546b(1708, (C1202f) this);
                                AppMethodBeat.m2505o(15855);
                            }
                        });
                        C9638aw.m17182Rg().mo14541a(c42213c, 0);
                    }
                    C9186k.ecv.clear();
                    C9186k.ecw.clear();
                    C4879a.xxA.mo10053d(C9186k.ecA);
                }
                AppMethodBeat.m2505o(15856);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.PostTaskStartRangeForIBeacon", e.getMessage());
                AppMethodBeat.m2505o(15856);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.booter.k$3 */
    static class C91903 extends C4884c<C32535dt> {
        C91903() {
            AppMethodBeat.m2504i(15857);
            this.xxI = C32535dt.class.getName().hashCode();
            AppMethodBeat.m2505o(15857);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15858);
            C32535dt c32535dt = (C32535dt) c4883b;
            if (c32535dt != null && (c32535dt instanceof C32535dt)) {
                String str = c32535dt.cxk.cxi;
                int i = c32535dt.cxk.cxl;
                int i2 = c32535dt.cxk.cxm;
                if (!C9186k.ecv.containsKey(str + "," + i + "," + i2)) {
                    atz atz = new atz();
                    atz.eCq = str;
                    atz.major = i;
                    atz.minor = CdnLogic.kBizGeneric & i2;
                    atz.fNN = c32535dt.cxk.cxn;
                    C9186k.ecv.put(str + "," + i + "," + i2, atz);
                    if (c32535dt.cxk.cxn >= 0.0d && C9186k.ecw.size() > 0) {
                        int i3 = 0;
                        while (i3 < C9186k.ecw.size()) {
                            atz atz2 = (atz) C9186k.ecw.get(i3);
                            if (c32535dt.cxk.cxn >= atz2.fNN) {
                                if (i3 == C9186k.ecw.size() - 1 && c32535dt.cxk.cxn > atz2.fNN) {
                                    C9186k.ecw.add(atz);
                                    break;
                                }
                                i3++;
                            } else {
                                C9186k.ecw.add(i3, atz);
                                break;
                            }
                        }
                    }
                    C9186k.ecw.add(atz);
                }
                C4990ab.m7417i("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]result iBeacon = %s,beaconMap.size:%d", str + "," + i + "," + i2, Integer.valueOf(C9186k.ecv.size()));
            }
            AppMethodBeat.m2505o(15858);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(15860);
        AppMethodBeat.m2505o(15860);
    }

    public static void run() {
        AppMethodBeat.m2504i(15859);
        if (!C9638aw.m17179RK() || C9638aw.m17178QT()) {
            AppMethodBeat.m2505o(15859);
            return;
        }
        C9638aw.m17190ZK();
        Boolean valueOf = Boolean.valueOf(C5046bo.m7517a((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
        C4990ab.m7416i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is ".concat(String.valueOf(valueOf)));
        if (valueOf.booleanValue()) {
            long anT = C5046bo.anT();
            C9638aw.m17190ZK();
            long a = C5046bo.m7514a((Long) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, null), 0);
            C9638aw.m17190ZK();
            if (anT - a > C5046bo.m7514a((Long) C18628c.m29072Ry().get(C5127a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, null), 0)) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.FALSE);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, (Object) "");
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                C9638aw.m17190ZK();
                C18628c.m29065QV();
                AppMethodBeat.m2505o(15859);
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (VERSION.SDK_INT < 18 || defaultAdapter == null || defaultAdapter.getState() != 12) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                AppMethodBeat.m2505o(15859);
                return;
            }
            List<String> Nl = C26373g.m41965Nv().mo5299Nl();
            if (Nl != null) {
                for (String str : Nl) {
                    C4990ab.m7417i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", str);
                    C18245ds c18245ds = new C18245ds();
                    c18245ds.cxg.cxi = str;
                    c18245ds.cxg.cxf = true;
                    C4879a.xxA.mo10055m(c18245ds);
                }
                ecr = C26443d.agz();
                if (ecz.doT()) {
                    ecz.mo16770ae(3000, 3000);
                }
                if (!(ecu || ecr == null)) {
                    ecr.mo44204a(ecy, true);
                }
                C4879a.xxA.mo10052c(ecA);
            }
            AppMethodBeat.m2505o(15859);
            return;
        }
        AppMethodBeat.m2505o(15859);
    }
}
