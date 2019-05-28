package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.adq;
import com.tencent.mm.protocal.protobuf.adr;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.d;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class b {
    private static boolean apg = false;

    static /* synthetic */ void BL() {
        AppMethodBeat.i(118171);
        abg();
        AppMethodBeat.o(118171);
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(118169);
        abe();
        AppMethodBeat.o(118169);
    }

    static /* synthetic */ void kN(int i) {
        AppMethodBeat.i(118170);
        kM(i);
        AppMethodBeat.o(118170);
    }

    static void abc() {
        int i = 1;
        AppMethodBeat.i(118161);
        if (g.RK()) {
            long j;
            Long l = (Long) g.RP().Ry().get(a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, null);
            if (l == null) {
                j = 0;
            } else {
                j = l.longValue();
            }
            int i2;
            if (j == 0) {
                kM(new Random().nextInt(86400));
                abe();
                abg();
                ab.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", Integer.valueOf(i2));
            } else {
                Integer num = (Integer) g.RP().Ry().get(a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, null);
                if (num == null || num.intValue() == 0) {
                    i2 = 86400;
                } else {
                    i2 = num.intValue();
                }
                long j2 = (long) i2;
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String str = "MicroMsg.ABTestUpdater";
                String str2 = "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d";
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(currentTimeMillis > j + j2);
                objArr[1] = Long.valueOf(j);
                objArr[2] = Long.valueOf(j2);
                objArr[3] = Long.valueOf(currentTimeMillis);
                ab.i(str, str2, objArr);
                if (currentTimeMillis <= j + j2) {
                    i = 0;
                }
            }
            if (i == 0) {
                ab.v("MicroMsg.ABTestUpdater", "No need to update");
                AppMethodBeat.o(118161);
                return;
            } else if (apg) {
                ab.i("MicroMsg.ABTestUpdater", "Updating");
                AppMethodBeat.o(118161);
                return;
            } else {
                update();
                AppMethodBeat.o(118161);
                return;
            }
        }
        ab.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
        AppMethodBeat.o(118161);
    }

    static void abd() {
        AppMethodBeat.i(118162);
        if (!g.RK()) {
            ab.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
            AppMethodBeat.o(118162);
        } else if (apg) {
            ab.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
            AppMethodBeat.o(118162);
        } else {
            ab.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
            update();
            AppMethodBeat.o(118162);
        }
    }

    private static String c(LinkedList<za> linkedList) {
        AppMethodBeat.i(118163);
        String str = "";
        Iterator it = linkedList.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                za zaVar = (za) it.next();
                str = str2 + zaVar.wcM + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + zaVar.priority + "|";
            } else {
                AppMethodBeat.o(118163);
                return str2;
            }
        }
    }

    private static void update() {
        AppMethodBeat.i(118164);
        apg = true;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new adq();
        aVar.fsK = new adr();
        aVar.uri = "/cgi-bin/mmux-bin/getabtest";
        aVar.fsI = 1801;
        com.tencent.mm.ai.b acD = aVar.acD();
        adq adq = (adq) acD.fsG.fsP;
        adq.wlM = abf();
        adq.wlN = c.abi().drs();
        adq.wlN.addAll(c.abj().drs());
        ab.i("MicroMsg.ABTestUpdater", "update abtest: %s", c(adq.wlN));
        w.a(acD, new w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(118160);
                b.apg = false;
                if (i == 0 && i2 == 0) {
                    adr adr = (adr) bVar.fsH.fsP;
                    b.access$100();
                    b.kO(adr.Timestamp);
                    b.kN(adr.wlQ);
                    b.Y(adr.wlR);
                    b.Z(adr.wlP);
                    b.BL();
                    ab.i("MicroMsg.ABTestUpdater", "Update Interval: %d", Integer.valueOf(adr.wlQ));
                    AppMethodBeat.o(118160);
                } else {
                    ab.e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400));
                    b.access$100();
                    b.kN(86400);
                    b.BL();
                    AppMethodBeat.o(118160);
                }
                return 0;
            }
        }, true);
        AppMethodBeat.o(118164);
    }

    private static void abe() {
        AppMethodBeat.i(118165);
        g.RP().Ry().set(a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis() / 1000));
        AppMethodBeat.o(118165);
    }

    private static void kM(int i) {
        AppMethodBeat.i(118166);
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        g.RP().Ry().set(a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, Integer.valueOf(i2));
        AppMethodBeat.o(118166);
    }

    private static int abf() {
        AppMethodBeat.i(118167);
        Integer num = (Integer) g.RP().Ry().get(a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, null);
        if (num == null) {
            AppMethodBeat.o(118167);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(118167);
        return intValue;
    }

    private static void abg() {
        AppMethodBeat.i(118168);
        g.RP().Ry().dsb();
        AppMethodBeat.o(118168);
    }

    static /* synthetic */ void kO(int i) {
        AppMethodBeat.i(118172);
        g.RP().Ry().set(a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, Integer.valueOf(i));
        AppMethodBeat.o(118172);
    }

    static /* synthetic */ void Y(List list) {
        AppMethodBeat.i(118173);
        if (bo.ek(list)) {
            ab.w("MicroMsg.ABTestUpdater", "No expired Exp");
            AppMethodBeat.o(118173);
            return;
        }
        d abi = c.abi();
        if (!bo.ek(list)) {
            for (Integer num : list) {
                if (num != null) {
                    c cVar = new c();
                    cVar.field_expId = String.valueOf(num);
                    abi.a((com.tencent.mm.sdk.e.c) cVar, "expId");
                }
            }
        }
        com.tencent.mm.storage.b abj = c.abj();
        if (!bo.ek(list)) {
            for (Integer num2 : list) {
                if (num2 != null) {
                    com.tencent.mm.storage.a aVar = new com.tencent.mm.storage.a();
                    aVar.field_expId = String.valueOf(num2);
                    abj.a((com.tencent.mm.sdk.e.c) aVar, "expId");
                }
            }
        }
        AppMethodBeat.o(118173);
    }

    static /* synthetic */ void Z(List list) {
        AppMethodBeat.i(118174);
        if (list == null || list.size() == 0) {
            ab.w("MicroMsg.ABTestUpdater", "No Exp");
            AppMethodBeat.o(118174);
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (com.tencent.mm.bt.b a : list) {
            a.a pb = a.pb(aa.a(a));
            linkedList.addAll(pb.items);
            linkedList2.addAll(pb.foD);
        }
        c.abi().s(linkedList, 0);
        c.abj().s(linkedList2, 1);
        AppMethodBeat.o(118174);
    }
}
