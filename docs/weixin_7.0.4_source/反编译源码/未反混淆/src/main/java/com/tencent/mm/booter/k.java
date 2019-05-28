package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.aue;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class k {
    private static c ecA = new c<dt>() {
        {
            AppMethodBeat.i(15857);
            this.xxI = dt.class.getName().hashCode();
            AppMethodBeat.o(15857);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(15858);
            dt dtVar = (dt) bVar;
            if (dtVar != null && (dtVar instanceof dt)) {
                String str = dtVar.cxk.cxi;
                int i = dtVar.cxk.cxl;
                int i2 = dtVar.cxk.cxm;
                if (!k.ecv.containsKey(str + "," + i + "," + i2)) {
                    atz atz = new atz();
                    atz.eCq = str;
                    atz.major = i;
                    atz.minor = CdnLogic.kBizGeneric & i2;
                    atz.fNN = dtVar.cxk.cxn;
                    k.ecv.put(str + "," + i + "," + i2, atz);
                    if (dtVar.cxk.cxn >= 0.0d && k.ecw.size() > 0) {
                        int i3 = 0;
                        while (i3 < k.ecw.size()) {
                            atz atz2 = (atz) k.ecw.get(i3);
                            if (dtVar.cxk.cxn >= atz2.fNN) {
                                if (i3 == k.ecw.size() - 1 && dtVar.cxk.cxn > atz2.fNN) {
                                    k.ecw.add(atz);
                                    break;
                                }
                                i3++;
                            } else {
                                k.ecw.add(i3, atz);
                                break;
                            }
                        }
                    }
                    k.ecw.add(atz);
                }
                ab.i("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]result iBeacon = %s,beaconMap.size:%d", str + "," + i + "," + i2, Integer.valueOf(k.ecv.size()));
            }
            AppMethodBeat.o(15858);
            return false;
        }
    };
    private static d ecr;
    private static float ecs = -85.0f;
    private static float ect = -1000.0f;
    private static boolean ecu = false;
    private static Map<String, atz> ecv = new ConcurrentHashMap();
    private static List<atz> ecw = new CopyOnWriteArrayList();
    private static Boolean ecx = Boolean.FALSE;
    private static a ecy = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(15854);
            if (z) {
                ab.d("MicroMsg.PostTaskStartRangeForIBeacon", "on location get ok");
                k.ecs = f2;
                k.ect = f;
                k.ecu = true;
                if (k.ecr != null) {
                    k.ecr.c(k.ecy);
                    k.ecu = false;
                }
            } else {
                ab.w("MicroMsg.PostTaskStartRangeForIBeacon", "getLocation fail");
            }
            AppMethodBeat.o(15854);
            return false;
        }
    };
    private static ap ecz = new ap(Looper.getMainLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(15856);
            try {
                aw.ZK();
                Boolean valueOf = Boolean.valueOf(bo.a((Boolean) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_IBEACON_PUSH_IS_IN_SHAKEUI_BOOLEAN, null), false));
                List<String> Nl = g.Nv().Nl();
                if (Nl != null) {
                    for (String str : Nl) {
                        ab.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=false,isInShakeUI:" + valueOf + ",iBeacon = %s", str);
                        ds dsVar = new ds();
                        dsVar.cxg.cxi = str;
                        dsVar.cxg.cxf = false;
                        if (!valueOf.booleanValue()) {
                            com.tencent.mm.sdk.b.a.xxA.m(dsVar);
                        }
                    }
                    aub aub = new aub();
                    aub.latitude = (double) k.ecs;
                    aub.longitude = (double) k.ect;
                    aw.ZK();
                    long a = bo.a((Long) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_IBEACON_PUSH_SHOP_ID_LONG, null), 0);
                    if (k.ecv.size() <= 0 || k.ecx.booleanValue() || k.ecw.size() <= 0) {
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                    } else {
                        k.ecx = Boolean.TRUE;
                        final m cVar = new com.tencent.mm.modelmulti.c(k.ecw, a, aub);
                        ab.d("MicroMsg.PostTaskStartRangeForIBeacon", "[shakezb]PostTaskStartRangeForIBeacon[kevinkma] shopId " + a + ",beaconInfos size " + k.ecw.size() + ",info:" + k.ecw.toString());
                        aw.Rg().a(1708, new f() {
                            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                AppMethodBeat.i(15855);
                                if (i == 0 && i2 == 0) {
                                    afi afi = (afi) cVar.fAT.fsH.fsP;
                                    if (afi.result == 0) {
                                        aue aue = afi.wmJ;
                                        atz atz = afi.wmL;
                                        Object obj = aue.title + "," + aue.desc + "," + aue.wyc + "," + aue.wyd + "," + atz.eCq + "," + atz.major + "," + atz.minor;
                                        aw.ZK();
                                        String[] split = bo.bc((String) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, null), "").split(",");
                                        Boolean bool = Boolean.FALSE;
                                        for (String equals : split) {
                                            if (equals.equals(atz.eCq + atz.major + atz.minor)) {
                                                bool = Boolean.TRUE;
                                            }
                                        }
                                        if (bool.booleanValue()) {
                                            aw.ZK();
                                            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                                        } else {
                                            h.pYm.e(12653, Integer.valueOf(1), Integer.valueOf(1));
                                            h.pYm.e(12653, Integer.valueOf(2), Integer.valueOf(1));
                                            aw.ZK();
                                            com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, obj);
                                        }
                                    } else {
                                        aw.ZK();
                                        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                                    }
                                } else {
                                    aw.ZK();
                                    com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                                }
                                aw.ZK();
                                com.tencent.mm.model.c.QV();
                                com.tencent.mm.sdk.b.a.xxA.m(new dr());
                                k.ecx = Boolean.FALSE;
                                aw.Rg().b(1708, (f) this);
                                AppMethodBeat.o(15855);
                            }
                        });
                        aw.Rg().a(cVar, 0);
                    }
                    k.ecv.clear();
                    k.ecw.clear();
                    com.tencent.mm.sdk.b.a.xxA.d(k.ecA);
                }
                AppMethodBeat.o(15856);
            } catch (Exception e) {
                ab.e("MicroMsg.PostTaskStartRangeForIBeacon", e.getMessage());
                AppMethodBeat.o(15856);
            }
            return false;
        }
    }, true);

    static {
        AppMethodBeat.i(15860);
        AppMethodBeat.o(15860);
    }

    public static void run() {
        AppMethodBeat.i(15859);
        if (!aw.RK() || aw.QT()) {
            AppMethodBeat.o(15859);
            return;
        }
        aw.ZK();
        Boolean valueOf = Boolean.valueOf(bo.a((Boolean) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
        ab.i("MicroMsg.PostTaskStartRangeForIBeacon", "the range road status is ".concat(String.valueOf(valueOf)));
        if (valueOf.booleanValue()) {
            long anT = bo.anT();
            aw.ZK();
            long a = bo.a((Long) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, null), 0);
            aw.ZK();
            if (anT - a > bo.a((Long) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, null), 0)) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.FALSE);
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_PUSH_LAST_BEACONINFO_STRING, (Object) "");
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                aw.ZK();
                com.tencent.mm.model.c.QV();
                AppMethodBeat.o(15859);
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (VERSION.SDK_INT < 18 || defaultAdapter == null || defaultAdapter.getState() != 12) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, (Object) "");
                AppMethodBeat.o(15859);
                return;
            }
            List<String> Nl = g.Nv().Nl();
            if (Nl != null) {
                for (String str : Nl) {
                    ab.i("MicroMsg.PostTaskStartRangeForIBeacon", "op=true,iBeacon = %s", str);
                    ds dsVar = new ds();
                    dsVar.cxg.cxi = str;
                    dsVar.cxg.cxf = true;
                    com.tencent.mm.sdk.b.a.xxA.m(dsVar);
                }
                ecr = d.agz();
                if (ecz.doT()) {
                    ecz.ae(3000, 3000);
                }
                if (!(ecu || ecr == null)) {
                    ecr.a(ecy, true);
                }
                com.tencent.mm.sdk.b.a.xxA.c(ecA);
            }
            AppMethodBeat.o(15859);
            return;
        }
        AppMethodBeat.o(15859);
    }
}
