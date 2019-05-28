package com.tencent.p177mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.welab.p1331d.p1332a.C23169a;
import com.tencent.p177mm.plugin.welab.p1563e.C46450b;
import com.tencent.p177mm.protocal.protobuf.C15402za;
import com.tencent.p177mm.protocal.protobuf.adq;
import com.tencent.p177mm.protocal.protobuf.adr;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.welab.e */
public final class C43996e {
    private static boolean DEBUG = false;
    private static boolean apg = false;

    /* renamed from: com.tencent.mm.plugin.welab.e$1 */
    static class C357371 implements C1224a {
        C357371() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(80543);
            C43996e.apg = false;
            if (i == 0 && i2 == 0) {
                adr adr = (adr) c7472b.fsH.fsP;
                C43996e.access$100();
                C43996e.m78987kO(adr.Timestamp);
                C43996e.m78986kN(adr.wlQ);
                C43996e.m78981Y(adr.wlR);
                C43996e.m78982Z(adr.wlP);
                C43996e.m78979BL();
                C4990ab.m7417i("MicroMsg.WelabUpdater", "Update Interval: %d", Integer.valueOf(adr.wlQ));
                AppMethodBeat.m2505o(80543);
            } else {
                C4990ab.m7413e("MicroMsg.WelabUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(86400));
                C43996e.access$100();
                C43996e.m78986kN(86400);
                C43996e.m78979BL();
                AppMethodBeat.m2505o(80543);
            }
            return 0;
        }
    }

    /* renamed from: BL */
    static /* synthetic */ void m78979BL() {
        AppMethodBeat.m2504i(80552);
        C43996e.abg();
        AppMethodBeat.m2505o(80552);
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.m2504i(80550);
        C43996e.abe();
        AppMethodBeat.m2505o(80550);
    }

    /* renamed from: kN */
    static /* synthetic */ void m78986kN(int i) {
        AppMethodBeat.m2504i(80551);
        C43996e.m78985kM(i);
        AppMethodBeat.m2505o(80551);
    }

    /* renamed from: aa */
    static void m78983aa(boolean z, boolean z2) {
        AppMethodBeat.m2504i(80544);
        C4990ab.m7417i("MicroMsg.WelabUpdater", "tryToUpdate isUpgrade %s, isManualAuth %s ", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (C1720g.m3534RN().mo5161QY()) {
            if (!(DEBUG || z || z2)) {
                long j;
                Object obj;
                Long l = (Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WELAB_LAST_UPDATE_TIME_LONG, null);
                if (l == null) {
                    j = 0;
                } else {
                    j = l.longValue();
                }
                int i;
                if (j == 0) {
                    C43996e.m78985kM(new Random().nextInt(86400));
                    C43996e.abe();
                    C43996e.abg();
                    C4990ab.m7417i("MicroMsg.WelabUpdater", "First update ignored. Next update: %d", Integer.valueOf(i));
                    obj = 1;
                } else {
                    Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WELAB_UPDATE_TIME_INTERVAL_INT, null);
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
                    C4990ab.m7417i(str, str2, objArr);
                    if (currentTimeMillis > j + j2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (obj == null) {
                    C4990ab.m7418v("MicroMsg.WelabUpdater", "No need to update");
                    AppMethodBeat.m2505o(80544);
                    return;
                }
            }
            if (apg) {
                C4990ab.m7416i("MicroMsg.WelabUpdater", "Updating");
                AppMethodBeat.m2505o(80544);
                return;
            }
            int i2;
            apg = true;
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new adq();
            c1196a.fsK = new adr();
            c1196a.uri = "/cgi-bin/mmux-bin/getlabsinfo";
            c1196a.fsI = 1816;
            C7472b acD = c1196a.acD();
            adq adq = (adq) acD.fsG.fsP;
            Integer num2 = (Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WELAB_SERVER_TIMESTAMP_INT, null);
            if (num2 == null) {
                i2 = 0;
            } else {
                i2 = num2.intValue();
            }
            adq.wlM = i2;
            adq.wlN = C43996e.ddl();
            adq.wlO = (int) C5046bo.anT();
            if (z) {
                adq.bJt |= 1;
            }
            if (z2) {
                adq.bJt |= 2;
            }
            C4990ab.m7417i("MicroMsg.WelabUpdater", "update abtest: %s", C43996e.m78984c(adq.wlN));
            C1226w.m2654a(acD, new C357371());
            AppMethodBeat.m2505o(80544);
            return;
        }
        C4990ab.m7416i("MicroMsg.WelabUpdater", "Update aborted, Account not ready.");
        AppMethodBeat.m2505o(80544);
    }

    /* renamed from: c */
    private static String m78984c(LinkedList<C15402za> linkedList) {
        AppMethodBeat.m2504i(80545);
        String str = "";
        Iterator it = linkedList.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                C15402za c15402za = (C15402za) it.next();
                str = str2 + c15402za.wcM + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c15402za.priority + "|";
            } else {
                AppMethodBeat.m2505o(80545);
                return str2;
            }
        }
    }

    private static LinkedList<C15402za> ddl() {
        AppMethodBeat.m2504i(80546);
        LinkedList linkedList = new LinkedList();
        try {
            for (C23169a c23169a : C29974a.ddj().uLQ.dds()) {
                if (!c23169a.ddw()) {
                    C15402za c15402za = new C15402za();
                    c15402za.wcM = C5046bo.getInt(c23169a.field_expId, 0);
                    c15402za.priority = c23169a.field_prioritylevel;
                    linkedList.add(c15402za);
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WelabUpdater", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(80546);
        return linkedList;
    }

    private static void abe() {
        AppMethodBeat.m2504i(80547);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WELAB_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis() / 1000));
        AppMethodBeat.m2505o(80547);
    }

    /* renamed from: kM */
    private static void m78985kM(int i) {
        AppMethodBeat.m2504i(80548);
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WELAB_UPDATE_TIME_INTERVAL_INT, Integer.valueOf(i2));
        AppMethodBeat.m2505o(80548);
    }

    private static void abg() {
        AppMethodBeat.m2504i(80549);
        C1720g.m3536RP().mo5239Ry().dsb();
        AppMethodBeat.m2505o(80549);
    }

    /* renamed from: kO */
    static /* synthetic */ void m78987kO(int i) {
        AppMethodBeat.m2504i(80553);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WELAB_SERVER_TIMESTAMP_INT, Integer.valueOf(i));
        AppMethodBeat.m2505o(80553);
    }

    /* renamed from: Y */
    static /* synthetic */ void m78981Y(List list) {
        AppMethodBeat.m2504i(80554);
        if (C5046bo.m7548ek(list)) {
            C4990ab.m7420w("MicroMsg.WelabUpdater", "No expired Exp");
            AppMethodBeat.m2505o(80554);
            return;
        }
        C4990ab.m7416i("MicroMsg.WelabUpdater", "expired exp ".concat(String.valueOf(list)));
        ArrayList arrayList = new ArrayList();
        for (Integer num : list) {
            C23169a c23169a = new C23169a();
            c23169a.field_expId = num.toString();
            C29974a.ddj().uLQ.mo10102b((C4925c) c23169a, "expId");
            if (!TextUtils.isEmpty(c23169a.field_LabsAppId)) {
                c23169a.field_Switch = 3;
                arrayList.add(c23169a);
            }
        }
        C29974a.ddj().uLQ.mo63727ee(arrayList);
        AppMethodBeat.m2505o(80554);
    }

    /* renamed from: Z */
    static /* synthetic */ void m78982Z(List list) {
        AppMethodBeat.m2504i(80555);
        if (list == null || list.size() == 0) {
            C4990ab.m7420w("MicroMsg.WelabUpdater", "No Exp");
            AppMethodBeat.m2505o(80555);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (C1332b a : list) {
            C23169a agK = C40363f.agK(C1946aa.m4147a(a));
            if (agK != null && agK.isValid()) {
                arrayList.add(agK);
                C46450b.ddC().mo74670f(agK);
                C40361d.m69199A(agK.field_LabsAppId, agK.field_expId, C46450b.ddC().mo74669e(agK));
            }
        }
        C4990ab.m7416i("MicroMsg.WelabUpdater", "save exp ".concat(String.valueOf(arrayList)));
        C29974a.ddj().uLQ.mo63727ee(arrayList);
        C29974a.ddj();
        C29974a.m47423ed(arrayList);
        AppMethodBeat.m2505o(80555);
    }
}
