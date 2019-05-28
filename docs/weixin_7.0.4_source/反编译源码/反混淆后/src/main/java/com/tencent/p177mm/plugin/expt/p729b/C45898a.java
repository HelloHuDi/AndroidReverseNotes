package com.tencent.p177mm.plugin.expt.p729b;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.C45270c;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C37748jt;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.p230g.p231a.C9333fa;
import com.tencent.p177mm.p230g.p232b.p233a.C26291ct;
import com.tencent.p177mm.p230g.p232b.p233a.C37829cu;
import com.tencent.p177mm.plugin.expt.p1257e.C20596b;
import com.tencent.p177mm.plugin.expt.p1257e.C27891a;
import com.tencent.p177mm.plugin.expt.p1257e.C27892c;
import com.tencent.p177mm.plugin.expt.p1257e.C34072d;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.expt.p396d.C7503a;
import com.tencent.p177mm.plugin.expt.p397ui.ExptDebugUI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3472n;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.welab.p753b.C14716c;
import com.tencent.p177mm.plugin.welab.p753b.C46449d;
import com.tencent.p177mm.plugin.welab.p753b.C7232a;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.protocal.protobuf.C30177dq;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p609h.C4970a;
import com.tencent.p177mm.sdk.p609h.C4971b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.expt.b.a */
public final class C45898a implements C1671c, C34069a {
    private static C45898a lNE;
    private int eCL = 0;
    private int frU = 0;
    public C34072d lNF;
    public C20596b lNG;
    private C1177f<Integer, C7503a> lNH = new C7598c(100);
    private C1177f<String, Integer> lNI = new C7598c(100);
    private int lNJ = 0;
    private C4884c lNK = new C389831();
    private C3472n lNL = new C340712();
    private C1202f lNM = new C68713();
    private C4884c<C37748jt> lNN = new C68724();

    /* renamed from: com.tencent.mm.plugin.expt.b.a$3 */
    class C68713 implements C1202f {
        C68713() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(73488);
            C4990ab.m7417i("MicroMsg.ExptService", "scene[%d] errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(c1207m.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
            if (c1207m instanceof C38984b) {
                C45898a.m85078d(C45898a.this);
            }
            AppMethodBeat.m2505o(73488);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.b.a$4 */
    class C68724 extends C4884c<C37748jt> {

        /* renamed from: com.tencent.mm.plugin.expt.b.a$4$1 */
        class C68731 implements Runnable {
            C68731() {
            }

            public final void run() {
                AppMethodBeat.m2504i(73489);
                C45898a.m85079va(2);
                AppMethodBeat.m2505o(73489);
            }
        }

        C68724() {
            AppMethodBeat.m2504i(73490);
            this.xxI = C37748jt.class.getName().hashCode();
            AppMethodBeat.m2505o(73490);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(73491);
            C7305d.xDG.mo10152b(new C68731(), "manual_get_expt", 60000);
            AppMethodBeat.m2505o(73491);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.b.a$2 */
    class C340712 implements C3472n {
        C340712() {
        }

        /* renamed from: a */
        public final C1198b mo7932a(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(73487);
            if (!"expt".equals(str)) {
                C4990ab.m7421w("MicroMsg.ExptService", "receive expt xml but subtype[%s] is error", str);
                AppMethodBeat.m2505o(73487);
            } else if (map == null || map.size() <= 0) {
                C4990ab.m7420w("MicroMsg.ExptService", "receive expt xml but map is null");
                AppMethodBeat.m2505o(73487);
            } else {
                C45898a.this.mo73723KY((String) map.get(".sysmsg.content"));
                AppMethodBeat.m2505o(73487);
            }
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.b.a$1 */
    class C389831 extends C4884c<C6523mp> {
        C389831() {
            super(0);
            AppMethodBeat.m2504i(73485);
            this.xxI = C6523mp.class.getName().hashCode();
            AppMethodBeat.m2505o(73485);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(73486);
            C45898a.this.lNJ = C45898a.this.lNJ + 1;
            C4990ab.m7411d("MicroMsg.ExptService", "got post sync event [%d]", Integer.valueOf(C45898a.this.lNJ));
            C45898a.m85076c(C45898a.this);
            AppMethodBeat.m2505o(73486);
            return false;
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void bqQ() {
        AppMethodBeat.m2504i(73492);
        this.lNH.clear();
        this.lNI.clear();
        AppMethodBeat.m2505o(73492);
    }

    public static C45898a bqR() {
        AppMethodBeat.m2504i(73493);
        if (lNE == null) {
            lNE = new C45898a();
        }
        C45898a c45898a = lNE;
        AppMethodBeat.m2505o(73493);
        return c45898a;
    }

    private C45898a() {
        AppMethodBeat.m2504i(73494);
        AppMethodBeat.m2505o(73494);
    }

    /* renamed from: t */
    public final void mo54615t(Context context, Intent intent) {
        AppMethodBeat.m2504i(73495);
        intent.setClass(context, ExptDebugUI.class);
        context.startActivity(intent);
        AppMethodBeat.m2505o(73495);
    }

    /* renamed from: a */
    public final boolean mo54614a(C11745a c11745a, boolean z) {
        AppMethodBeat.m2504i(73496);
        String a = mo54613a(c11745a, "");
        if (C5046bo.isNullOrNil(a)) {
            AppMethodBeat.m2505o(73496);
            return z;
        }
        int i;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        if (C5046bo.getInt(a, i) != 0) {
            AppMethodBeat.m2505o(73496);
            return true;
        }
        AppMethodBeat.m2505o(73496);
        return false;
    }

    /* renamed from: a */
    public final float mo54610a(C11745a c11745a, float f) {
        AppMethodBeat.m2504i(73497);
        String a = mo54613a(c11745a, "");
        if (C5046bo.isNullOrNil(a)) {
            AppMethodBeat.m2505o(73497);
            return f;
        }
        f = C5046bo.getFloat(a, f);
        AppMethodBeat.m2505o(73497);
        return f;
    }

    /* renamed from: a */
    public final int mo54611a(C11745a c11745a, int i) {
        AppMethodBeat.m2504i(73498);
        String a = mo54613a(c11745a, "");
        if (C5046bo.isNullOrNil(a)) {
            AppMethodBeat.m2505o(73498);
            return i;
        }
        i = C5046bo.getInt(a, i);
        AppMethodBeat.m2505o(73498);
        return i;
    }

    /* renamed from: a */
    public final long mo54612a(C11745a c11745a, long j) {
        AppMethodBeat.m2504i(73499);
        String a = mo54613a(c11745a, "");
        if (C5046bo.isNullOrNil(a)) {
            AppMethodBeat.m2505o(73499);
            return j;
        }
        j = C5046bo.getLong(a, j);
        AppMethodBeat.m2505o(73499);
        return j;
    }

    /* renamed from: a */
    public final String mo54613a(C11745a c11745a, String str) {
        AppMethodBeat.m2504i(73500);
        if (c11745a == null) {
            AppMethodBeat.m2505o(73500);
            return str;
        } else if (bqU()) {
            C27892c.bru();
            C4990ab.m7417i("MicroMsg.ExptService", "API check Expt from mmkv result[%s] key[%s] def[%s]", C27892c.m44337a(c11745a, str, true), c11745a, str);
            AppMethodBeat.m2505o(73500);
            return C27892c.m44337a(c11745a, str, true);
        } else {
            long yz = C5046bo.m7588yz();
            String name = c11745a.name();
            int KX = m85071KX(name);
            C37829cu c37829cu = new C37829cu();
            PBool pBool = new PBool();
            HashMap a = mo73724a(KX, true, c37829cu, pBool);
            if (a == null || a.size() <= 0) {
                AppMethodBeat.m2505o(73500);
                return str;
            }
            String str2 = (String) a.get(name);
            if (!C5046bo.isNullOrNil(str2) && pBool.value) {
                c37829cu.mo60544hJ(name).mo60545hK(str2).ajK();
            }
            C4990ab.m7417i("MicroMsg.ExptService", "API Got Expt result[%s] exptId[%d] key[%s %s] defStr[%s] cost[%d]", str2, Integer.valueOf(KX), c11745a, name, str, Long.valueOf(C5046bo.m7525az(yz)));
            if (C5046bo.isNullOrNil(str2)) {
                AppMethodBeat.m2505o(73500);
                return str;
            }
            AppMethodBeat.m2505o(73500);
            return str2;
        }
    }

    /* renamed from: uZ */
    public final C7503a mo73729uZ(int i) {
        AppMethodBeat.m2504i(73501);
        C7503a c7503a = (C7503a) this.lNH.get(Integer.valueOf(i));
        if (c7503a != null) {
            AppMethodBeat.m2505o(73501);
        } else {
            c7503a = this.lNF.mo54621vd(i);
            if (c7503a != null) {
                this.lNH.put(Integer.valueOf(i), c7503a);
            }
            AppMethodBeat.m2505o(73501);
        }
        return c7503a;
    }

    /* renamed from: KX */
    private int m85071KX(String str) {
        AppMethodBeat.m2504i(73502);
        Integer num = (Integer) this.lNI.get(str);
        int intValue;
        if (num != null) {
            intValue = num.intValue();
            AppMethodBeat.m2505o(73502);
            return intValue;
        }
        intValue = this.lNG.mo35861KX(str);
        if (intValue > 0) {
            this.lNI.put(str, Integer.valueOf(intValue));
        }
        AppMethodBeat.m2505o(73502);
        return intValue;
    }

    /* renamed from: a */
    public final HashMap<String, String> mo73724a(int i, boolean z, C37829cu c37829cu, PBool pBool) {
        AppMethodBeat.m2504i(73503);
        if (this.lNF == null) {
            C4990ab.m7413e("MicroMsg.ExptService", "Expt service is not init here! exptId[%d]", Integer.valueOf(i));
            AppMethodBeat.m2505o(73503);
            return null;
        } else if (i <= 0) {
            AppMethodBeat.m2505o(73503);
            return null;
        } else {
            long yz = C5046bo.m7588yz();
            HashMap<String, String> hashMap = null;
            String str = null;
            C7503a uZ = mo73729uZ(i);
            if (uZ == null || C5046bo.isNullOrNil(uZ.field_exptContent)) {
                C4990ab.m7420w("MicroMsg.ExptService", "expt item is null or expt content is null.");
            } else {
                str = uZ.field_exptContent;
                if (!z || uZ.isReady()) {
                    hashMap = uZ.brq();
                    if (uZ.brp()) {
                        pBool.value = true;
                        if (c37829cu != null) {
                            c37829cu.dig = (long) uZ.field_exptId;
                            c37829cu.dih = (long) uZ.field_groupId;
                            c37829cu.dii = (long) uZ.field_exptSeq;
                            c37829cu.cYo = uZ.field_startTime;
                            c37829cu.dij = uZ.field_endTime;
                        }
                    }
                } else {
                    C4990ab.m7421w("MicroMsg.ExptService", "expt time is invalid time[%d %d] seq[%d]", Long.valueOf(uZ.field_startTime), Long.valueOf(uZ.field_endTime), Integer.valueOf(uZ.field_exptSeq));
                }
            }
            String str2 = "MicroMsg.ExptService";
            String str3 = "get expt [%d] map[%s] expt[%s] cost[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = hashMap != null ? hashMap : Integer.valueOf(0);
            objArr[2] = str;
            objArr[3] = Long.valueOf(C5046bo.m7525az(yz));
            C4990ab.m7417i(str2, str3, objArr);
            AppMethodBeat.m2505o(73503);
            return hashMap;
        }
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(73504);
        C4990ab.m7417i("MicroMsg.ExptService", "onAccountInitialized, %d", Integer.valueOf(hashCode()));
        C4990ab.m7418v("MicroMsg.ExptService", "add listener ");
        if (C4996ah.bqo()) {
            C4879a.xxA.mo10051b(this.lNK);
            C4879a.xxA.mo10051b(this.lNN);
            C1720g.m3540Rg().mo14539a(2738, this.lNM);
            ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14901a("expt", this.lNL);
        }
        if (c1705c != null) {
            try {
                if (c1705c.eKe) {
                    C4990ab.m7417i("MicroMsg.ExptService", "client upgrade now, reset last update time. previous version [%d]", Integer.valueOf(c1705c.eKf));
                    this.frU = 0;
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(0));
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ExptService", e, "onAccountInitialized error[%s]", e.toString());
                AppMethodBeat.m2505o(73504);
                return;
            }
        }
        AppMethodBeat.m2505o(73504);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(73505);
        C4990ab.m7416i("MicroMsg.ExptService", "onAccountRelease");
        bqQ();
        C4879a.xxA.mo10053d(this.lNK);
        C4879a.xxA.mo10053d(this.lNN);
        C1720g.m3540Rg().mo14546b(2738, this.lNM);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14904b("expt", this.lNL);
        C7305d.xDG.remove("manual_get_expt");
        AppMethodBeat.m2505o(73505);
    }

    /* renamed from: KY */
    public final void mo73723KY(String str) {
        AppMethodBeat.m2504i(73506);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.ExptService", "receive expt xml but content is null");
            AppMethodBeat.m2505o(73506);
            return;
        }
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        C7503a c7503a = new C7503a();
        if (c7503a.mo16726La(str)) {
            ArrayList arrayList;
            if (c7503a.field_exptSeq < 0) {
                C7060h.pYm.mo8378a(863, 3, 1, false);
                C7503a uZ = mo73729uZ(c7503a.field_exptId);
                if (uZ != null && uZ.bro()) {
                    linkedList.add(Integer.valueOf(c7503a.field_exptId));
                }
                arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(c7503a.field_exptId));
                if (mo73726bB(arrayList) > 0) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                C7060h.pYm.mo8378a(863, 4, 1, false);
                arrayList = new ArrayList();
                arrayList.add(c7503a);
                z = mo73725bA(arrayList) > 0;
                if (c7503a.bro()) {
                    linkedList2.add(c7503a);
                }
                C26291ct c26291ct = new C26291ct();
                c26291ct.dig = (long) c7503a.field_exptId;
                c26291ct.dih = (long) c7503a.field_groupId;
                c26291ct.dii = (long) c7503a.field_exptSeq;
                c26291ct.ajK();
            }
            bqS();
        } else {
            z = false;
        }
        if (linkedList2.size() > 0 || linkedList.size() > 0) {
            C45898a.m85074a(linkedList2, null, linkedList);
        }
        C4990ab.m7417i("MicroMsg.ExptService", "received expt xml dbFlag[%b] [%s] ", Boolean.valueOf(z), str);
        AppMethodBeat.m2505o(73506);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bqS() {
        AppMethodBeat.m2504i(73507);
        C4879a.xxA.mo10055m(new C9333fa());
        SharedPreferences Mz = C1668a.m3382Mz();
        Mz.edit().putBoolean("keepaliveserviceswitch", mo54614a(C11745a.clicfg_keepaliveserviceswitch, false)).commit();
        C45898a.m85077d(Mz);
        bqV();
        bqT();
        AppMethodBeat.m2505o(73507);
    }

    private void bqT() {
        AppMethodBeat.m2504i(73508);
        int a = mo54611a(C11745a.clicfg_target26_start_service_switch, -1);
        if (!C5046bo.m7563gW(a, 0)) {
            String a2;
            String[] split;
            if (C5046bo.m7563gW(a, 2)) {
                a2 = mo54613a(C11745a.clicfg_target26_start_service_manu_exclusive, "");
                C4990ab.m7417i("MicroMsg.ExptService", "manufacturers:%s", C5046bo.m7532bc(a2, BuildConfig.COMMAND));
                if (C5046bo.isNullOrNil(a2)) {
                    C45270c.m83436bu(true);
                } else {
                    split = a2.split(",");
                    for (Object valueOf : split) {
                        if (String.valueOf(valueOf).equalsIgnoreCase(Build.MANUFACTURER)) {
                            C45270c.m83436bu(false);
                            a = 1;
                            break;
                        }
                    }
                    a = 0;
                    if (a == 0) {
                        C45270c.m83436bu(true);
                    }
                }
            } else if (C5046bo.m7563gW(a, 1)) {
                a2 = mo54613a(C11745a.clicfg_target26_start_service_manufacturer, "");
                C4990ab.m7417i("MicroMsg.ExptService", "manufacturers:%s", C5046bo.m7532bc(a2, BuildConfig.COMMAND));
                if (!C5046bo.isNullOrNil(a2)) {
                    split = a2.split(",");
                    for (Object valueOf2 : split) {
                        if (String.valueOf(valueOf2).equalsIgnoreCase(Build.MANUFACTURER)) {
                            C45270c.m83436bu(true);
                            a = 1;
                            break;
                        }
                    }
                    a = 0;
                    if (a == 0) {
                        C45270c.m83436bu(false);
                    }
                }
            }
            a = mo54611a(C11745a.clicfg_target26_start_service_switch_huawei, 0);
            if (!C1443d.m3068iW(26) && C5046bo.m7563gW(a, 0) && C4970a.dqu()) {
                a2 = mo54613a(C11745a.clicfg_target26_start_service_huawei_info, "");
                C4990ab.m7417i("MicroMsg.ExptService", "model:%s startServiceHuaweiInfo:%s", Build.MODEL.toLowerCase(), C5046bo.m7532bc(a2, BuildConfig.COMMAND));
                try {
                    if (C5046bo.isNullOrNil(a2)) {
                        C45270c.m83437ii(0);
                        AppMethodBeat.m2505o(73508);
                        return;
                    }
                    String[] split2 = a2.split(",");
                    for (String toLowerCase : split2) {
                        if (r3.startsWith(toLowerCase.toLowerCase())) {
                            C45270c.m83437ii(1);
                            a = 1;
                            break;
                        }
                    }
                    a = 0;
                    if (a == 0) {
                        C45270c.m83437ii(0);
                    }
                    AppMethodBeat.m2505o(73508);
                    return;
                } catch (Exception e) {
                    C4990ab.m7417i("MicroMsg.ExptService", "startServiceHuaweiInfo Exception:%s %s", e.getClass().getSimpleName(), e.getMessage());
                    C45270c.m83437ii(0);
                    AppMethodBeat.m2505o(73508);
                    return;
                }
            }
            C45270c.m83437ii(1);
            AppMethodBeat.m2505o(73508);
        }
        C45270c.m83436bu(false);
        a = mo54611a(C11745a.clicfg_target26_start_service_switch_huawei, 0);
        if (!C1443d.m3068iW(26)) {
        }
        C45270c.m83437ii(1);
        AppMethodBeat.m2505o(73508);
    }

    /* renamed from: d */
    private static void m85077d(SharedPreferences sharedPreferences) {
        boolean z = false;
        AppMethodBeat.m2504i(73509);
        int a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_specialscenesetingsswitch, -1);
        C4990ab.m7417i("MicroMsg.ExptService", "iniNotificationSpecialSceneSwitchEnable() enable:%s", Integer.valueOf(a));
        if (C5046bo.m7563gW(a, 1)) {
            String a2 = ((C34069a) C1720g.m3528K(C34069a.class)).mo54613a(C11745a.clicfg_specialscenesetingsswitchdetail, "");
            C4990ab.m7417i("MicroMsg.ExptService", "specialSceneDetail %s", a2);
            if (!C5046bo.isNullOrNil(a2)) {
                Map z2 = C5049br.m7595z(a2, "manufacturerlist");
                if (z2 != null) {
                    int i;
                    if (z2.containsKey(".manufacturerlist.size")) {
                        i = C5046bo.getInt((String) z2.get(".manufacturerlist.size"), 0);
                    } else {
                        boolean i2 = false;
                    }
                    int i3 = VERSION.SDK_INT;
                    for (int i4 = 0; i4 < i2; i4++) {
                        if (i4 == 0) {
                            if (String.valueOf(C5046bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer.name"))).equalsIgnoreCase(Build.MANUFACTURER)) {
                                z = C4971b.m7365g(i3, C5046bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer.sdkversionmin")), C5046bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer.sdkversionmax")), C5046bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer.versintime")));
                                break;
                            }
                        } else if (String.valueOf(C5046bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer" + i4 + ".name"))).equalsIgnoreCase(Build.MANUFACTURER)) {
                            z = C4971b.m7365g(i3, C5046bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer" + i4 + ".sdkversionmin")), C5046bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer" + i4 + ".sdkversionmax")), C5046bo.nullAsNil((String) z2.get(".manufacturerlist.manufacturer" + i4 + ".versintime")));
                            break;
                        }
                    }
                }
            }
            C45898a.m85073a(sharedPreferences, z);
            AppMethodBeat.m2505o(73509);
        } else if (C5046bo.m7563gW(a, 0)) {
            C45898a.m85073a(sharedPreferences, false);
            AppMethodBeat.m2505o(73509);
        } else {
            if (C5046bo.m7563gW(a, 2)) {
                C45898a.m85073a(sharedPreferences, true);
            }
            AppMethodBeat.m2505o(73509);
        }
    }

    /* renamed from: a */
    private static void m85073a(SharedPreferences sharedPreferences, boolean z) {
        int i;
        AppMethodBeat.m2504i(73510);
        Editor edit = sharedPreferences.edit();
        String str = "special_scene_enable";
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        edit.putInt(str, i).commit();
        C4990ab.m7417i("MicroMsg.ExptService", "setSpecialSceneEnable() enable: %s", Boolean.valueOf(z));
        AppMethodBeat.m2505o(73510);
    }

    /* renamed from: bA */
    public final int mo73725bA(List<C7503a> list) {
        AppMethodBeat.m2504i(73511);
        if (list.size() <= 0) {
            AppMethodBeat.m2505o(73511);
            return 0;
        }
        int bC;
        int bD;
        int i;
        List<C7503a> bH = this.lNF.mo54617bH(list);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        if (bH != null) {
            int size = bH.size();
            for (C7503a c7503a : bH) {
                this.lNH.put(Integer.valueOf(c7503a.field_exptId), c7503a);
                HashMap brq = c7503a.brq();
                if (brq != null) {
                    for (String str : brq.keySet()) {
                        C27891a Lc = this.lNG.mo35862Lc(str);
                        if (Lc == null) {
                            Lc = new C27891a();
                            Lc.field_exptId = c7503a.field_exptId;
                            Lc.field_exptKey = str;
                            linkedList2.add(Lc);
                        } else if (Lc.field_exptId != c7503a.field_exptId) {
                            Lc.field_exptId = c7503a.field_exptId;
                            linkedList.add(Lc);
                        }
                        C27891a c27891a = Lc;
                        this.lNI.put(c27891a.field_exptKey, Integer.valueOf(c27891a.field_exptId));
                    }
                }
            }
            bC = this.lNG.mo35863bC(linkedList2);
            bD = this.lNG.mo35864bD(linkedList);
            C27892c.bru().mo45792bF(bH);
            i = size;
        } else {
            bD = 0;
            bC = 0;
            i = 0;
        }
        C4990ab.m7417i("MicroMsg.ExptService", "replace ExptIds args[%d] db[%d] exptMap insert[list:%d  db:%d], update[list:%d db:%d]", Integer.valueOf(list.size()), Integer.valueOf(i), Integer.valueOf(linkedList2.size()), Integer.valueOf(bC), Integer.valueOf(linkedList.size()), Integer.valueOf(bD));
        AppMethodBeat.m2505o(73511);
        return i;
    }

    private boolean bqU() {
        if (this.lNF == null || this.lNG == null) {
            return true;
        }
        return false;
    }

    /* renamed from: va */
    public static void m85079va(int i) {
        AppMethodBeat.m2504i(73513);
        C1720g.m3540Rg().mo14541a(new C38984b(i), 0);
        AppMethodBeat.m2505o(73513);
    }

    /* renamed from: a */
    public static void m85074a(List<C7503a> list, List<C30177dq> list2, List<Integer> list3) {
        AppMethodBeat.m2504i(73514);
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (C7503a c7503a : list) {
                if (c7503a != null && c7503a.bro()) {
                    C14716c c14716c = new C14716c();
                    c14716c.uMa = c7503a.field_exptId;
                    c14716c.f2963Zb = c7503a.field_groupId;
                    c14716c.startTime = c7503a.field_startTime;
                    c14716c.endTime = c7503a.field_endTime;
                    c14716c.uMc = c7503a.field_exptContent;
                    c14716c.uMb = c7503a.field_exptSeq;
                    c14716c.cag = c7503a.brq();
                    linkedList.add(c14716c);
                }
            }
        }
        LinkedList linkedList2 = new LinkedList();
        if (list2 != null) {
            for (C30177dq c30177dq : list2) {
                C46449d c46449d = new C46449d();
                c46449d.appId = c30177dq.csB;
                c46449d.status = c30177dq.status;
                linkedList2.add(c46449d);
            }
        }
        ((C7232a) C1720g.m3528K(C7232a.class)).mo15607e(linkedList, linkedList2, list3);
        AppMethodBeat.m2505o(73514);
    }

    private void bqV() {
        AppMethodBeat.m2504i(73515);
        if (mo54611a(C11745a.clicfg_story_sns_story_open, -1) != -1) {
            C7060h.pYm.mo15419k(1006, 200, 1);
            C4990ab.m7417i("MicroMsg.ExptService", "snsStoryReport config[%d]", Integer.valueOf(r0));
        }
        AppMethodBeat.m2505o(73515);
    }

    /* renamed from: bB */
    public final int mo73726bB(List<Integer> list) {
        AppMethodBeat.m2504i(73512);
        int bB = this.lNF.mo54616bB(list);
        int bE = this.lNG.mo35865bE(list);
        C4990ab.m7417i("MicroMsg.ExptService", "delete expt ids deleteCount[%d] deleteMapCount[%d]", Integer.valueOf(bB), Integer.valueOf(bE));
        bqQ();
        C27892c.bru().mo45793bG(list);
        AppMethodBeat.m2505o(73512);
        return bB;
    }

    /* renamed from: c */
    static /* synthetic */ void m85076c(C45898a c45898a) {
        AppMethodBeat.m2504i(73516);
        if (!C1720g.m3531RK()) {
            C4990ab.m7420w("MicroMsg.ExptService", "account is not ready, don't get expt config");
            AppMethodBeat.m2505o(73516);
        } else if (C4996ah.bqo()) {
            if (c45898a.frU <= 0) {
                c45898a.frU = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GET_EXPT_LAST_TIME_SEC_INT, Integer.valueOf(0))).intValue();
            }
            if (c45898a.eCL <= 0) {
                c45898a.eCL = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GET_EXPT_INTERVAL_SEC_INT, Integer.valueOf(86400))).intValue();
                if (c45898a.eCL <= 3600) {
                    C4990ab.m7420w("MicroMsg.ExptService", "interval is less than 1 hour, something warn here!!!");
                    c45898a.eCL = 3600;
                }
            }
            if (C5046bo.m7549fp((long) c45898a.frU) >= ((long) c45898a.eCL)) {
                C45898a.m85079va(1);
            }
            AppMethodBeat.m2505o(73516);
        } else {
            C4990ab.m7420w("MicroMsg.ExptService", "it is not mm process, why you call update expt?");
            AppMethodBeat.m2505o(73516);
        }
    }
}
