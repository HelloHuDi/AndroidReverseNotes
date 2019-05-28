package com.tencent.mm.plugin.expt.c;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.b.a.q;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public final class d implements ActivityLifecycleCallbacks, c, com.tencent.mm.plugin.expt.a.c {
    private static int[] lNU = new int[]{10, 1000, Downloads.MIN_WAIT_FOR_NETWORK, 100000};
    private static boolean lNV = false;
    private static d lNW;
    private boolean lNX = false;
    private boolean lNY = false;
    private String lNZ = "";
    private HashSet<String> lOa = new HashSet();
    private com.tencent.mm.sdk.b.c<k> lOb = new com.tencent.mm.sdk.b.c<k>() {
        {
            AppMethodBeat.i(73531);
            this.xxI = k.class.getName().hashCode();
            AppMethodBeat.o(73531);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(73532);
            k kVar = (k) bVar;
            if (kVar != null) {
                a aVar;
                if (kVar.csh.csi) {
                    aVar = a.MMAppMgr_Activated;
                } else {
                    aVar = a.MMAppMgr_Deactivated;
                }
                d.this.a(aVar.name(), aVar, hashCode());
            }
            AppMethodBeat.o(73532);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c lOc = new com.tencent.mm.sdk.b.c<jt>() {
        {
            AppMethodBeat.i(73533);
            this.xxI = jt.class.getName().hashCode();
            AppMethodBeat.o(73533);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(73535);
            boolean bre = bre();
            AppMethodBeat.o(73535);
            return bre;
        }

        private boolean bre() {
            AppMethodBeat.i(73534);
            ab.i("MicroMsg.MMPageFlowService", "manual force login");
            if (!d.this.lNX) {
                d.this.lNX = true;
                com.tencent.mm.plugin.expt.hellhound.a.a.b.s(105, null, null);
                com.tencent.mm.plugin.expt.hellhound.a.a.b.bqF();
                com.tencent.mm.plugin.expt.hellhound.a.a.a.uY(7);
                com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.uX(7);
            }
            AppMethodBeat.o(73534);
            return false;
        }
    };

    private d() {
        AppMethodBeat.i(73537);
        if (!ah.bqo()) {
            lNV = true;
        }
        AppMethodBeat.o(73537);
    }

    private static void reset() {
        lNU = new int[]{10, 1000, Downloads.MIN_WAIT_FOR_NETWORK, 100000};
        lNV = false;
    }

    public static d brb() {
        AppMethodBeat.i(73538);
        if (lNW == null) {
            lNW = new d();
        }
        d dVar = lNW;
        AppMethodBeat.o(73538);
        return dVar;
    }

    private String aZm() {
        AppMethodBeat.i(73539);
        String str = hashCode();
        AppMethodBeat.o(73539);
        return str;
    }

    private void a(Activity activity, a aVar) {
        AppMethodBeat.i(73540);
        if (activity != null) {
            a(activity.getComponentName().getClassName(), aVar, activity.hashCode());
        }
        AppMethodBeat.o(73540);
    }

    public final void logout() {
        AppMethodBeat.i(73541);
        lNV = false;
        com.tencent.mm.plugin.expt.hellhound.a.a.b.s(106, null, null);
        com.tencent.mm.plugin.expt.hellhound.a.a.b.bqF();
        com.tencent.mm.plugin.expt.hellhound.a.a.a.uY(8);
        com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.uX(8);
        com.tencent.mm.plugin.expt.hellhound.a.a.a.gR(true);
        ab.i("MicroMsg.MMPageFlowService", "habbyge-mali, MMPageFlowService: logout补偿上报");
        AppMethodBeat.o(73541);
    }

    public static boolean brc() {
        return lNV;
    }

    private void a(String str, a aVar, int i, int i2, long j) {
        AppMethodBeat.i(73542);
        long yz = bo.yz();
        if (!ah.bqo()) {
            if (c.lNS == null) {
                c.lNS = new c();
            }
            c cVar = c.lNS;
            ab.i("MicroMsg.MMPageFlowSenderByIPCInvoker", "%s send page flow [%s-%d-%d] [%s]", cVar.hashCode(), str, Integer.valueOf(i), Long.valueOf(j), aVar);
            Bundle bundle = new Bundle();
            bundle.putInt("key_page_flow_type", aVar.value);
            bundle.putString("key_page_flow_name", str);
            bundle.putInt("key_page_flow_hashcode", i);
            bundle.putLong("key_page_flow_time_stamp", j);
            h.pYm.a(932, 100, 1, false);
            String string = bundle.getString("key_page_flow_name");
            int i3 = bundle.getInt("key_page_flow_type");
            int i4 = bundle.getInt("key_page_flow_hashcode", 0);
            long j2 = bundle.getLong("key_page_flow_time_stamp", 0);
            String str2 = (i4 + "_" + j2).hashCode();
            q qVar = new q();
            qVar.cWU = (long) i4;
            q eN = qVar.eN(string);
            eN.cWS = (long) i3;
            eN.aP(j2);
            b bqZ = b.bqZ();
            String Fj = qVar.Fj();
            as bra = bqZ.bra();
            if (bra != null) {
                bra.putString(str2, Fj);
            }
            f.a("com.tencent.mm", bundle, a.class, null);
            ab.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process NOT");
            lNV = true;
        }
        if (lNV) {
            ab.d("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process YES");
            if (ah.bqo()) {
                brd();
            }
            a(str, aVar, i, j, i2);
            ab.v("MicroMsg.MMPageFlowService", "report page Flow cost[%d]", Long.valueOf(bo.az(yz)));
            AppMethodBeat.o(73542);
            return;
        }
        ab.e("MicroMsg.MMPageFlowService", "reportPageFlow: mm-process isAccReady = FALSE");
        AppMethodBeat.o(73542);
    }

    public final void a(String str, a aVar, int i) {
        AppMethodBeat.i(73543);
        a(str, aVar, i, Process.myPid(), System.currentTimeMillis());
        AppMethodBeat.o(73543);
    }

    /* Access modifiers changed, original: protected|final */
    public final void brd() {
        AppMethodBeat.i(73544);
        if (ah.bqo()) {
            long yz = bo.yz();
            String[] allKeys = b.bqZ().allKeys();
            ArrayList<q> arrayList = new ArrayList();
            if (allKeys != null && allKeys.length > 0) {
                for (Object obj : allKeys) {
                    if (!this.lOa.contains(obj)) {
                        String str = b.bqZ().get(obj, "");
                        if (!bo.isNullOrNil(str)) {
                            q qVar = new q(str);
                            if (qVar.cWU > 0 && qVar.cWT > 0) {
                                arrayList.add(new q(str));
                                this.lOa.add(obj);
                            }
                            b.bqZ().remove(obj);
                        }
                    }
                    b.bqZ().remove(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                Collections.sort(arrayList, new Comparator<q>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return (int) (((q) obj).cWT - ((q) obj2).cWT);
                    }
                });
                for (q qVar2 : arrayList) {
                    a(qVar2.cWR, a.uW((int) qVar2.cWS), (int) qVar2.cWU, qVar2.cWT);
                }
                h.pYm.a(932, 102, (long) arrayList.size(), false);
                ab.i("MicroMsg.MMPageFlowService", "check mmkv list[%d] cost[%d]", Integer.valueOf(arrayList.size()), Long.valueOf(bo.az(yz)));
            }
            ab.d("MicroMsg.MMPageFlowService", "check mm kv cost[%d]", Long.valueOf(bo.az(yz)));
            AppMethodBeat.o(73544);
            return;
        }
        AppMethodBeat.o(73544);
    }

    private void a(String str, a aVar, int i, long j, int i2) {
        AppMethodBeat.i(73545);
        if (str.contains("WeChatSplashActivity") || str.contains("FakeSwitchAccountUI")) {
            AppMethodBeat.o(73545);
            return;
        }
        int i3;
        if (aVar.value <= 2) {
            i3 = 0;
        } else if (aVar.value <= 4) {
            i3 = 1;
        } else if (aVar.value <= 6) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        if (aVar == a.MMActivity_Back2Front) {
            this.lNY = true;
        }
        if (aVar == a.MMActivity_Front2Back) {
            this.lNY = false;
        }
        w wVar = new w();
        wVar.cWc = i2;
        w eT = wVar.eS(((com.tencent.mm.kernel.b.h) g.RM().Rn()).eHT).eT(str);
        int[] iArr = lNU;
        int i4 = iArr[i3];
        iArr[i3] = i4 + 1;
        eT.cYc = (long) i4;
        eT.cWS = (long) aVar.value;
        eT = eT.aQ(j);
        eT.cWU = (long) i;
        e.brf().a(eT);
        ab.d("MicroMsg.MMPageFlowService", "%s pure report [%s]", aZm(), eT.Fk());
        if (aVar == a.MMActivity_Back2Front || aVar == a.MMActivity_Front2Back) {
            ab.i("MicroMsg.MMPageFlowService", "habbyge-mali, %s frontback-pure-report [%s]", aZm(), eT.Fk());
        }
        if (ah.bqo() && (aVar == a.MMActivity_Back2Front || aVar == a.MMActivity_Front2Back)) {
            q(j, this.lNY);
            com.tencent.mm.plugin.expt.hellhound.core.a.b.putInt("page_hell_seq_mmkv_key", lNU[3]);
        }
        AppMethodBeat.o(73545);
    }

    public final void a(String str, a aVar, int i, long j) {
        AppMethodBeat.i(73546);
        a(str, aVar, i, j, Process.myPid());
        AppMethodBeat.o(73546);
    }

    public final void onAccountInitialized(e.c cVar) {
        boolean z = true;
        AppMethodBeat.i(73547);
        reset();
        lNV = true;
        com.tencent.mm.plugin.expt.e.c.bru();
        if (bo.getInt(com.tencent.mm.plugin.expt.e.c.a(com.tencent.mm.plugin.expt.a.a.a.clicfg_weixin_register_mm_app_active_event, "", false), 0) <= 0) {
            z = false;
        }
        if (z) {
            com.tencent.mm.sdk.b.a.xxA.b(this.lOb);
        }
        com.tencent.mm.sdk.b.a.xxA.b(this.lOc);
        AppMethodBeat.o(73547);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(73548);
        reset();
        com.tencent.mm.sdk.b.a.xxA.d(this.lOb);
        com.tencent.mm.sdk.b.a.xxA.d(this.lOc);
        this.lNX = false;
        AppMethodBeat.o(73548);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.i(73549);
        a(activity, a.MMLifeCall_OnResume);
        AppMethodBeat.o(73549);
    }

    public final void onActivityPaused(Activity activity) {
        AppMethodBeat.i(73550);
        a(activity, a.MMLifeCall_OnPause);
        AppMethodBeat.o(73550);
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(73551);
        String className = activity.getComponentName().getClassName();
        if (lNV && "com.tencent.mm.ui.LauncherUI".equals(className) && this.lNY) {
            String str = "MicroMsg.MMPageFlowService";
            String str2 = "%s launcher ui ondestroyed but wechat in foreground hashcode[%d]";
            Object[] objArr = new Object[2];
            objArr[0] = aZm();
            objArr[1] = Integer.valueOf(activity != null ? activity.hashCode() : -1);
            ab.i(str, str2, objArr);
        }
        AppMethodBeat.o(73551);
    }

    private void q(final long j, final boolean z) {
        AppMethodBeat.i(73552);
        if (lNV) {
            int a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_weixin_unread_records_rpt_time, 0);
            if (a <= 0) {
                AppMethodBeat.o(73552);
                return;
            }
            if (bo.anT() - g.RP().Ry().a(ac.a.USERINFO_WEIXIN_UNREAD_RECORDS_LAST_RPT_TIME_LONG, 0) < ((long) a)) {
                AppMethodBeat.o(73552);
                return;
            }
            com.tencent.mm.sdk.g.d.xDG.remove("calc_unread_task");
            com.tencent.mm.sdk.g.d.xDG.b(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(73536);
                    d.a(d.this, j, z);
                    AppMethodBeat.o(73536);
                }
            }, "calc_unread_task", 5000);
            AppMethodBeat.o(73552);
            return;
        }
        AppMethodBeat.o(73552);
    }
}
