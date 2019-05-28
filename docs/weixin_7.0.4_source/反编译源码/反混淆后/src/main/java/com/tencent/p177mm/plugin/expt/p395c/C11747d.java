package com.tencent.p177mm.plugin.expt.p395c;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p230g.p231a.C37748jt;
import com.tencent.p177mm.p230g.p231a.C6504k;
import com.tencent.p177mm.p230g.p232b.p233a.C1599q;
import com.tencent.p177mm.p230g.p232b.p233a.C26295w;
import com.tencent.p177mm.plugin.expt.hellhound.core.p1258a.C20599b;
import com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity.C27897a;
import com.tencent.p177mm.plugin.expt.hellhound.p958a.p959a.C11752a;
import com.tencent.p177mm.plugin.expt.hellhound.p958a.p959a.C34073b;
import com.tencent.p177mm.plugin.expt.p1257e.C27892c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.expt.p394a.C43014c;
import com.tencent.p177mm.plugin.expt.p394a.C43014c.C38982a;
import com.tencent.p177mm.plugin.expt.p395c.C27889c.C3004a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.expt.c.d */
public final class C11747d implements ActivityLifecycleCallbacks, C1671c, C43014c {
    private static int[] lNU = new int[]{10, 1000, Downloads.MIN_WAIT_FOR_NETWORK, 100000};
    private static boolean lNV = false;
    private static C11747d lNW;
    private boolean lNX = false;
    private boolean lNY = false;
    private String lNZ = "";
    private HashSet<String> lOa = new HashSet();
    private C4884c<C6504k> lOb = new C117512();
    private C4884c lOc = new C117483();

    /* renamed from: com.tencent.mm.plugin.expt.c.d$3 */
    class C117483 extends C4884c<C37748jt> {
        C117483() {
            AppMethodBeat.m2504i(73533);
            this.xxI = C37748jt.class.getName().hashCode();
            AppMethodBeat.m2505o(73533);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(73535);
            boolean bre = bre();
            AppMethodBeat.m2505o(73535);
            return bre;
        }

        private boolean bre() {
            AppMethodBeat.m2504i(73534);
            C4990ab.m7416i("MicroMsg.MMPageFlowService", "manual force login");
            if (!C11747d.this.lNX) {
                C11747d.this.lNX = true;
                C34073b.m55845s(105, null, null);
                C34073b.bqF();
                C11752a.m19560uY(7);
                C27897a.m44362uX(7);
            }
            AppMethodBeat.m2505o(73534);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.c.d$1 */
    class C117501 implements Comparator<C1599q> {
        C117501() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return (int) (((C1599q) obj).cWT - ((C1599q) obj2).cWT);
        }
    }

    /* renamed from: com.tencent.mm.plugin.expt.c.d$2 */
    class C117512 extends C4884c<C6504k> {
        C117512() {
            AppMethodBeat.m2504i(73531);
            this.xxI = C6504k.class.getName().hashCode();
            AppMethodBeat.m2505o(73531);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(73532);
            C6504k c6504k = (C6504k) c4883b;
            if (c6504k != null) {
                C38982a c38982a;
                if (c6504k.csh.csi) {
                    c38982a = C38982a.MMAppMgr_Activated;
                } else {
                    c38982a = C38982a.MMAppMgr_Deactivated;
                }
                C11747d.this.mo23509a(c38982a.name(), c38982a, hashCode());
            }
            AppMethodBeat.m2505o(73532);
            return false;
        }
    }

    private C11747d() {
        AppMethodBeat.m2504i(73537);
        if (!C4996ah.bqo()) {
            lNV = true;
        }
        AppMethodBeat.m2505o(73537);
    }

    private static void reset() {
        lNU = new int[]{10, 1000, Downloads.MIN_WAIT_FOR_NETWORK, 100000};
        lNV = false;
    }

    public static C11747d brb() {
        AppMethodBeat.m2504i(73538);
        if (lNW == null) {
            lNW = new C11747d();
        }
        C11747d c11747d = lNW;
        AppMethodBeat.m2505o(73538);
        return c11747d;
    }

    private String aZm() {
        AppMethodBeat.m2504i(73539);
        String str = hashCode();
        AppMethodBeat.m2505o(73539);
        return str;
    }

    /* renamed from: a */
    private void m19547a(Activity activity, C38982a c38982a) {
        AppMethodBeat.m2504i(73540);
        if (activity != null) {
            mo23509a(activity.getComponentName().getClassName(), c38982a, activity.hashCode());
        }
        AppMethodBeat.m2505o(73540);
    }

    public final void logout() {
        AppMethodBeat.m2504i(73541);
        lNV = false;
        C34073b.m55845s(106, null, null);
        C34073b.bqF();
        C11752a.m19560uY(8);
        C27897a.m44362uX(8);
        C11752a.m19559gR(true);
        C4990ab.m7416i("MicroMsg.MMPageFlowService", "habbyge-mali, MMPageFlowService: logout补偿上报");
        AppMethodBeat.m2505o(73541);
    }

    public static boolean brc() {
        return lNV;
    }

    /* renamed from: a */
    private void m19549a(String str, C38982a c38982a, int i, int i2, long j) {
        AppMethodBeat.m2504i(73542);
        long yz = C5046bo.m7588yz();
        if (!C4996ah.bqo()) {
            if (C27889c.lNS == null) {
                C27889c.lNS = new C27889c();
            }
            C27889c c27889c = C27889c.lNS;
            C4990ab.m7417i("MicroMsg.MMPageFlowSenderByIPCInvoker", "%s send page flow [%s-%d-%d] [%s]", c27889c.hashCode(), str, Integer.valueOf(i), Long.valueOf(j), c38982a);
            Bundle bundle = new Bundle();
            bundle.putInt("key_page_flow_type", c38982a.value);
            bundle.putString("key_page_flow_name", str);
            bundle.putInt("key_page_flow_hashcode", i);
            bundle.putLong("key_page_flow_time_stamp", j);
            C7060h.pYm.mo8378a(932, 100, 1, false);
            String string = bundle.getString("key_page_flow_name");
            int i3 = bundle.getInt("key_page_flow_type");
            int i4 = bundle.getInt("key_page_flow_hashcode", 0);
            long j2 = bundle.getLong("key_page_flow_time_stamp", 0);
            String str2 = (i4 + "_" + j2).hashCode();
            C1599q c1599q = new C1599q();
            c1599q.cWU = (long) i4;
            C1599q eN = c1599q.mo5045eN(string);
            eN.cWS = (long) i3;
            eN.mo5044aP(j2);
            C38985b bqZ = C38985b.bqZ();
            String Fj = c1599q.mo4982Fj();
            C5018as bra = bqZ.bra();
            if (bra != null) {
                bra.putString(str2, Fj);
            }
            C9549f.m17012a("com.tencent.mm", bundle, C3004a.class, null);
            C4990ab.m7410d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process NOT");
            lNV = true;
        }
        if (lNV) {
            C4990ab.m7410d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process YES");
            if (C4996ah.bqo()) {
                brd();
            }
            m19550a(str, c38982a, i, j, i2);
            C4990ab.m7419v("MicroMsg.MMPageFlowService", "report page Flow cost[%d]", Long.valueOf(C5046bo.m7525az(yz)));
            AppMethodBeat.m2505o(73542);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process isAccReady = FALSE");
        AppMethodBeat.m2505o(73542);
    }

    /* renamed from: a */
    public final void mo23509a(String str, C38982a c38982a, int i) {
        AppMethodBeat.m2504i(73543);
        m19549a(str, c38982a, i, Process.myPid(), System.currentTimeMillis());
        AppMethodBeat.m2505o(73543);
    }

    /* Access modifiers changed, original: protected|final */
    public final void brd() {
        AppMethodBeat.m2504i(73544);
        if (C4996ah.bqo()) {
            long yz = C5046bo.m7588yz();
            String[] allKeys = C38985b.bqZ().allKeys();
            ArrayList<C1599q> arrayList = new ArrayList();
            if (allKeys != null && allKeys.length > 0) {
                for (Object obj : allKeys) {
                    if (!this.lOa.contains(obj)) {
                        String str = C38985b.bqZ().get(obj, "");
                        if (!C5046bo.isNullOrNil(str)) {
                            C1599q c1599q = new C1599q(str);
                            if (c1599q.cWU > 0 && c1599q.cWT > 0) {
                                arrayList.add(new C1599q(str));
                                this.lOa.add(obj);
                            }
                            C38985b.bqZ().remove(obj);
                        }
                    }
                    C38985b.bqZ().remove(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                Collections.sort(arrayList, new C117501());
                for (C1599q c1599q2 : arrayList) {
                    mo23510a(c1599q2.cWR, C38982a.m66222uW((int) c1599q2.cWS), (int) c1599q2.cWU, c1599q2.cWT);
                }
                C7060h.pYm.mo8378a(932, 102, (long) arrayList.size(), false);
                C4990ab.m7417i("MicroMsg.MMPageFlowService", "check mmkv list[%d] cost[%d]", Integer.valueOf(arrayList.size()), Long.valueOf(C5046bo.m7525az(yz)));
            }
            C4990ab.m7411d("MicroMsg.MMPageFlowService", "check mm kv cost[%d]", Long.valueOf(C5046bo.m7525az(yz)));
            AppMethodBeat.m2505o(73544);
            return;
        }
        AppMethodBeat.m2505o(73544);
    }

    /* renamed from: a */
    private void m19550a(String str, C38982a c38982a, int i, long j, int i2) {
        AppMethodBeat.m2504i(73545);
        if (str.contains("WeChatSplashActivity") || str.contains("FakeSwitchAccountUI")) {
            AppMethodBeat.m2505o(73545);
            return;
        }
        int i3;
        if (c38982a.value <= 2) {
            i3 = 0;
        } else if (c38982a.value <= 4) {
            i3 = 1;
        } else if (c38982a.value <= 6) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        if (c38982a == C38982a.MMActivity_Back2Front) {
            this.lNY = true;
        }
        if (c38982a == C38982a.MMActivity_Front2Back) {
            this.lNY = false;
        }
        C26295w c26295w = new C26295w();
        c26295w.cWc = i2;
        C26295w eT = c26295w.mo44065eS(((C6624h) C1720g.m3533RM().mo5224Rn()).eHT).mo44066eT(str);
        int[] iArr = lNU;
        int i4 = iArr[i3];
        iArr[i3] = i4 + 1;
        eT.cYc = (long) i4;
        eT.cWS = (long) c38982a.value;
        eT = eT.mo44064aQ(j);
        eT.cWU = (long) i;
        C27890e.brf().mo45791a(eT);
        C4990ab.m7411d("MicroMsg.MMPageFlowService", "%s pure report [%s]", aZm(), eT.mo4983Fk());
        if (c38982a == C38982a.MMActivity_Back2Front || c38982a == C38982a.MMActivity_Front2Back) {
            C4990ab.m7417i("MicroMsg.MMPageFlowService", "habbyge-mali, %s frontback-pure-report [%s]", aZm(), eT.mo4983Fk());
        }
        if (C4996ah.bqo() && (c38982a == C38982a.MMActivity_Back2Front || c38982a == C38982a.MMActivity_Front2Back)) {
            m19553q(j, this.lNY);
            C20599b.putInt("page_hell_seq_mmkv_key", lNU[3]);
        }
        AppMethodBeat.m2505o(73545);
    }

    /* renamed from: a */
    public final void mo23510a(String str, C38982a c38982a, int i, long j) {
        AppMethodBeat.m2504i(73546);
        m19550a(str, c38982a, i, j, Process.myPid());
        AppMethodBeat.m2505o(73546);
    }

    public final void onAccountInitialized(C1705c c1705c) {
        boolean z = true;
        AppMethodBeat.m2504i(73547);
        C11747d.reset();
        lNV = true;
        C27892c.bru();
        if (C5046bo.getInt(C27892c.m44337a(C11745a.clicfg_weixin_register_mm_app_active_event, "", false), 0) <= 0) {
            z = false;
        }
        if (z) {
            C4879a.xxA.mo10051b(this.lOb);
        }
        C4879a.xxA.mo10051b(this.lOc);
        AppMethodBeat.m2505o(73547);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(73548);
        C11747d.reset();
        C4879a.xxA.mo10053d(this.lOb);
        C4879a.xxA.mo10053d(this.lOc);
        this.lNX = false;
        AppMethodBeat.m2505o(73548);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.m2504i(73549);
        m19547a(activity, C38982a.MMLifeCall_OnResume);
        AppMethodBeat.m2505o(73549);
    }

    public final void onActivityPaused(Activity activity) {
        AppMethodBeat.m2504i(73550);
        m19547a(activity, C38982a.MMLifeCall_OnPause);
        AppMethodBeat.m2505o(73550);
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.m2504i(73551);
        String className = activity.getComponentName().getClassName();
        if (lNV && "com.tencent.mm.ui.LauncherUI".equals(className) && this.lNY) {
            String str = "MicroMsg.MMPageFlowService";
            String str2 = "%s launcher ui ondestroyed but wechat in foreground hashcode[%d]";
            Object[] objArr = new Object[2];
            objArr[0] = aZm();
            objArr[1] = Integer.valueOf(activity != null ? activity.hashCode() : -1);
            C4990ab.m7417i(str, str2, objArr);
        }
        AppMethodBeat.m2505o(73551);
    }

    /* renamed from: q */
    private void m19553q(final long j, final boolean z) {
        AppMethodBeat.m2504i(73552);
        if (lNV) {
            int a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_weixin_unread_records_rpt_time, 0);
            if (a <= 0) {
                AppMethodBeat.m2505o(73552);
                return;
            }
            if (C5046bo.anT() - C1720g.m3536RP().mo5239Ry().mo16814a(C5127a.USERINFO_WEIXIN_UNREAD_RECORDS_LAST_RPT_TIME_LONG, 0) < ((long) a)) {
                AppMethodBeat.m2505o(73552);
                return;
            }
            C7305d.xDG.remove("calc_unread_task");
            C7305d.xDG.mo10152b(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(73536);
                    C11747d.m19548a(C11747d.this, j, z);
                    AppMethodBeat.m2505o(73536);
                }
            }, "calc_unread_task", 5000);
            AppMethodBeat.m2505o(73552);
            return;
        }
        AppMethodBeat.m2505o(73552);
    }
}
