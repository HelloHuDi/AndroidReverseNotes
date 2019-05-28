package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.adq;
import com.tencent.mm.protocal.protobuf.adr;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class e {
    private static boolean DEBUG = false;
    private static boolean apg = false;

    static /* synthetic */ void BL() {
        AppMethodBeat.i(80552);
        abg();
        AppMethodBeat.o(80552);
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(80550);
        abe();
        AppMethodBeat.o(80550);
    }

    static /* synthetic */ void kN(int i) {
        AppMethodBeat.i(80551);
        kM(i);
        AppMethodBeat.o(80551);
    }

    static void aa(boolean z, boolean z2) {
        AppMethodBeat.i(80544);
        ab.i("MicroMsg.WelabUpdater", "tryToUpdate isUpgrade %s, isManualAuth %s ", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (g.RN().QY()) {
            if (!(DEBUG || z || z2)) {
                long j;
                Object obj;
                Long l = (Long) g.RP().Ry().get(a.USERINFO_WELAB_LAST_UPDATE_TIME_LONG, null);
                if (l == null) {
                    j = 0;
                } else {
                    j = l.longValue();
                }
                int i;
                if (j == 0) {
                    kM(new Random().nextInt(86400));
                    abe();
                    abg();
                    ab.i("MicroMsg.WelabUpdater", "First update ignored. Next update: %d", Integer.valueOf(i));
                    obj = 1;
                } else {
                    Integer num = (Integer) g.RP().Ry().get(a.USERINFO_WELAB_UPDATE_TIME_INTERVAL_INT, null);
                    if (num == null || num.intValue() == 0) {
                        i = 86400;
                    } else {
                        i = num.intValue();
                    }
                    long j2 = (long) i;
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    String str = "MicroMsg.WelabUpdater";
                    String str2 = "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d";
                    Object[] objArr = new Object[4];
                    objArr[0] = Boolean.valueOf(currentTimeMillis > j + j2);
                    objArr[1] = Long.valueOf(j);
                    objArr[2] = Long.valueOf(j2);
                    objArr[3] = Long.valueOf(currentTimeMillis);
                    ab.i(str, str2, objArr);
                    if (currentTimeMillis > j + j2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (obj == null) {
                    ab.v("MicroMsg.WelabUpdater", "No need to update");
                    AppMethodBeat.o(80544);
                    return;
                }
            }
            if (apg) {
                ab.i("MicroMsg.WelabUpdater", "Updating");
                AppMethodBeat.o(80544);
                return;
            }
            int i2;
            apg = true;
            b.a aVar = new b.a();
            aVar.fsJ = new adq();
            aVar.fsK = new adr();
            aVar.uri = "/cgi-bin/mmux-bin/getlabsinfo";
            aVar.fsI = 1816;
            b acD = aVar.acD();
            adq adq = (adq) acD.fsG.fsP;
            Integer num2 = (Integer) g.RP().Ry().get(a.USERINFO_WELAB_SERVER_TIMESTAMP_INT, null);
            if (num2 == null) {
                i2 = 0;
            } else {
                i2 = num2.intValue();
            }
            adq.wlM = i2;
            adq.wlN = ddl();
            adq.wlO = (int) bo.anT();
            if (z) {
                adq.bJt |= 1;
            }
            if (z2) {
                adq.bJt |= 2;
            }
            ab.i("MicroMsg.WelabUpdater", "update abtest: %s", c(adq.wlN));
            w.a(acD, new w.a() {
                public final int a(int i, int i2, String str, b bVar, m mVar) {
                    AppMethodBeat.i(80543);
                    e.apg = false;
                    if (i == 0 && i2 == 0) {
                        adr adr = (adr) bVar.fsH.fsP;
                        e.access$100();
                        e.kO(adr.Timestamp);
                        e.kN(adr.wlQ);
                        e.Y(adr.wlR);
                        e.Z(adr.wlP);
                        e.BL();
                        ab.i("MicroMsg.WelabUpdater", "Update Interval: %d", Integer.valueOf(adr.wlQ));
                        AppMethodBeat.o(80543);
                    } else {
                        ab.e("MicroMsg.WelabUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400));
                        e.access$100();
                        e.kN(86400);
                        e.BL();
                        AppMethodBeat.o(80543);
                    }
                    return 0;
                }
            });
            AppMethodBeat.o(80544);
            return;
        }
        ab.i("MicroMsg.WelabUpdater", "Update aborted, Account not ready.");
        AppMethodBeat.o(80544);
    }

    private static String c(LinkedList<za> linkedList) {
        AppMethodBeat.i(80545);
        String str = "";
        Iterator it = linkedList.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                za zaVar = (za) it.next();
                str = str2 + zaVar.wcM + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + zaVar.priority + "|";
            } else {
                AppMethodBeat.o(80545);
                return str2;
            }
        }
    }

    private static LinkedList<za> ddl() {
        AppMethodBeat.i(80546);
        LinkedList linkedList = new LinkedList();
        try {
            for (com.tencent.mm.plugin.welab.d.a.a aVar : a.ddj().uLQ.dds()) {
                if (!aVar.ddw()) {
                    za zaVar = new za();
                    zaVar.wcM = bo.getInt(aVar.field_expId, 0);
                    zaVar.priority = aVar.field_prioritylevel;
                    linkedList.add(zaVar);
                }
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WelabUpdater", e, "", new Object[0]);
        }
        AppMethodBeat.o(80546);
        return linkedList;
    }

    private static void abe() {
        AppMethodBeat.i(80547);
        g.RP().Ry().set(a.USERINFO_WELAB_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis() / 1000));
        AppMethodBeat.o(80547);
    }

    private static void kM(int i) {
        AppMethodBeat.i(80548);
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        g.RP().Ry().set(a.USERINFO_WELAB_UPDATE_TIME_INTERVAL_INT, Integer.valueOf(i2));
        AppMethodBeat.o(80548);
    }

    private static void abg() {
        AppMethodBeat.i(80549);
        g.RP().Ry().dsb();
        AppMethodBeat.o(80549);
    }

    static /* synthetic */ void kO(int i) {
        AppMethodBeat.i(80553);
        g.RP().Ry().set(a.USERINFO_WELAB_SERVER_TIMESTAMP_INT, Integer.valueOf(i));
        AppMethodBeat.o(80553);
    }

    static /* synthetic */ void Y(List list) {
        AppMethodBeat.i(80554);
        if (bo.ek(list)) {
            ab.w("MicroMsg.WelabUpdater", "No expired Exp");
            AppMethodBeat.o(80554);
            return;
        }
        ab.i("MicroMsg.WelabUpdater", "expired exp ".concat(String.valueOf(list)));
        ArrayList arrayList = new ArrayList();
        for (Integer num : list) {
            com.tencent.mm.plugin.welab.d.a.a aVar = new com.tencent.mm.plugin.welab.d.a.a();
            aVar.field_expId = num.toString();
            a.ddj().uLQ.b((c) aVar, "expId");
            if (!TextUtils.isEmpty(aVar.field_LabsAppId)) {
                aVar.field_Switch = 3;
                arrayList.add(aVar);
            }
        }
        a.ddj().uLQ.ee(arrayList);
        AppMethodBeat.o(80554);
    }

    static /* synthetic */ void Z(List list) {
        AppMethodBeat.i(80555);
        if (list == null || list.size() == 0) {
            ab.w("MicroMsg.WelabUpdater", "No Exp");
            AppMethodBeat.o(80555);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mm.bt.b a : list) {
            com.tencent.mm.plugin.welab.d.a.a agK = f.agK(aa.a(a));
            if (agK != null && agK.isValid()) {
                arrayList.add(agK);
                com.tencent.mm.plugin.welab.e.b.ddC().f(agK);
                d.A(agK.field_LabsAppId, agK.field_expId, com.tencent.mm.plugin.welab.e.b.ddC().e(agK));
            }
        }
        ab.i("MicroMsg.WelabUpdater", "save exp ".concat(String.valueOf(arrayList)));
        a.ddj().uLQ.ee(arrayList);
        a.ddj();
        a.ed(arrayList);
        AppMethodBeat.o(80555);
    }
}
