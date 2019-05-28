package com.tencent.p177mm.model.p262c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C37915a.C9654a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C15402za;
import com.tencent.p177mm.protocal.protobuf.adq;
import com.tencent.p177mm.protocal.protobuf.adr;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C23510b;
import com.tencent.p177mm.storage.C46618a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7623d;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* renamed from: com.tencent.mm.model.c.b */
public final class C26421b {
    private static boolean apg = false;

    /* renamed from: com.tencent.mm.model.c.b$1 */
    static class C264221 implements C1224a {
        C264221() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(118160);
            C26421b.apg = false;
            if (i == 0 && i2 == 0) {
                adr adr = (adr) c7472b.fsH.fsP;
                C26421b.access$100();
                C26421b.m42076kO(adr.Timestamp);
                C26421b.m42075kN(adr.wlQ);
                C26421b.m42071Y(adr.wlR);
                C26421b.m42072Z(adr.wlP);
                C26421b.m42069BL();
                C4990ab.m7417i("MicroMsg.ABTestUpdater", "Update Interval: %d", Integer.valueOf(adr.wlQ));
                AppMethodBeat.m2505o(118160);
            } else {
                C4990ab.m7413e("MicroMsg.ABTestUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400));
                C26421b.access$100();
                C26421b.m42075kN(86400);
                C26421b.m42069BL();
                AppMethodBeat.m2505o(118160);
            }
            return 0;
        }
    }

    /* renamed from: BL */
    static /* synthetic */ void m42069BL() {
        AppMethodBeat.m2504i(118171);
        C26421b.abg();
        AppMethodBeat.m2505o(118171);
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.m2504i(118169);
        C26421b.abe();
        AppMethodBeat.m2505o(118169);
    }

    /* renamed from: kN */
    static /* synthetic */ void m42075kN(int i) {
        AppMethodBeat.m2504i(118170);
        C26421b.m42074kM(i);
        AppMethodBeat.m2505o(118170);
    }

    static void abc() {
        int i = 1;
        AppMethodBeat.m2504i(118161);
        if (C1720g.m3531RK()) {
            long j;
            Long l = (Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, null);
            if (l == null) {
                j = 0;
            } else {
                j = l.longValue();
            }
            int i2;
            if (j == 0) {
                C26421b.m42074kM(new Random().nextInt(86400));
                C26421b.abe();
                C26421b.abg();
                C4990ab.m7417i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", Integer.valueOf(i2));
            } else {
                Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, null);
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
                C4990ab.m7417i(str, str2, objArr);
                if (currentTimeMillis <= j + j2) {
                    i = 0;
                }
            }
            if (i == 0) {
                C4990ab.m7418v("MicroMsg.ABTestUpdater", "No need to update");
                AppMethodBeat.m2505o(118161);
                return;
            } else if (apg) {
                C4990ab.m7416i("MicroMsg.ABTestUpdater", "Updating");
                AppMethodBeat.m2505o(118161);
                return;
            } else {
                C26421b.update();
                AppMethodBeat.m2505o(118161);
                return;
            }
        }
        C4990ab.m7416i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
        AppMethodBeat.m2505o(118161);
    }

    static void abd() {
        AppMethodBeat.m2504i(118162);
        if (!C1720g.m3531RK()) {
            C4990ab.m7416i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
            AppMethodBeat.m2505o(118162);
        } else if (apg) {
            C4990ab.m7416i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
            AppMethodBeat.m2505o(118162);
        } else {
            C4990ab.m7416i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
            C26421b.update();
            AppMethodBeat.m2505o(118162);
        }
    }

    /* renamed from: c */
    private static String m42073c(LinkedList<C15402za> linkedList) {
        AppMethodBeat.m2504i(118163);
        String str = "";
        Iterator it = linkedList.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                C15402za c15402za = (C15402za) it.next();
                str = str2 + c15402za.wcM + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c15402za.priority + "|";
            } else {
                AppMethodBeat.m2505o(118163);
                return str2;
            }
        }
    }

    private static void update() {
        AppMethodBeat.m2504i(118164);
        apg = true;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new adq();
        c1196a.fsK = new adr();
        c1196a.uri = "/cgi-bin/mmux-bin/getabtest";
        c1196a.fsI = 1801;
        C7472b acD = c1196a.acD();
        adq adq = (adq) acD.fsG.fsP;
        adq.wlM = C26421b.abf();
        adq.wlN = C18624c.abi().drs();
        adq.wlN.addAll(C18624c.abj().drs());
        C4990ab.m7417i("MicroMsg.ABTestUpdater", "update abtest: %s", C26421b.m42073c(adq.wlN));
        C1226w.m2655a(acD, new C264221(), true);
        AppMethodBeat.m2505o(118164);
    }

    private static void abe() {
        AppMethodBeat.m2504i(118165);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis() / 1000));
        AppMethodBeat.m2505o(118165);
    }

    /* renamed from: kM */
    private static void m42074kM(int i) {
        AppMethodBeat.m2504i(118166);
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_ABTEST_UPDATE_TIME_INTERVAL_INT, Integer.valueOf(i2));
        AppMethodBeat.m2505o(118166);
    }

    private static int abf() {
        AppMethodBeat.m2504i(118167);
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, null);
        if (num == null) {
            AppMethodBeat.m2505o(118167);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(118167);
        return intValue;
    }

    private static void abg() {
        AppMethodBeat.m2504i(118168);
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(118168);
    }

    /* renamed from: kO */
    static /* synthetic */ void m42076kO(int i) {
        AppMethodBeat.m2504i(118172);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_ABTEST_SERVER_TIMESTAMP_INT, Integer.valueOf(i));
        AppMethodBeat.m2505o(118172);
    }

    /* renamed from: Y */
    static /* synthetic */ void m42071Y(List list) {
        AppMethodBeat.m2504i(118173);
        if (C5046bo.m7548ek(list)) {
            C4990ab.m7420w("MicroMsg.ABTestUpdater", "No expired Exp");
            AppMethodBeat.m2505o(118173);
            return;
        }
        C7623d abi = C18624c.abi();
        if (!C5046bo.m7548ek(list)) {
            for (Integer num : list) {
                if (num != null) {
                    C5141c c5141c = new C5141c();
                    c5141c.field_expId = String.valueOf(num);
                    abi.mo16760a((C4925c) c5141c, "expId");
                }
            }
        }
        C23510b abj = C18624c.abj();
        if (!C5046bo.m7548ek(list)) {
            for (Integer num2 : list) {
                if (num2 != null) {
                    C46618a c46618a = new C46618a();
                    c46618a.field_expId = String.valueOf(num2);
                    abj.mo16760a((C4925c) c46618a, "expId");
                }
            }
        }
        AppMethodBeat.m2505o(118173);
    }

    /* renamed from: Z */
    static /* synthetic */ void m42072Z(List list) {
        AppMethodBeat.m2504i(118174);
        if (list == null || list.size() == 0) {
            C4990ab.m7420w("MicroMsg.ABTestUpdater", "No Exp");
            AppMethodBeat.m2505o(118174);
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (C1332b a : list) {
            C9654a pb = C37915a.m64038pb(C1946aa.m4147a(a));
            linkedList.addAll(pb.items);
            linkedList2.addAll(pb.foD);
        }
        C18624c.abi().mo17132s(linkedList, 0);
        C18624c.abj().mo39178s(linkedList2, 1);
        AppMethodBeat.m2505o(118174);
    }
}
