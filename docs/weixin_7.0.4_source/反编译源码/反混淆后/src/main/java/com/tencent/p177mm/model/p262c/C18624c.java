package com.tencent.p177mm.model.p262c;

import android.annotation.SuppressLint;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.model.p262c.C37915a.C9654a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26111d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.auth.p1239a.C19933a;
import com.tencent.p177mm.plugin.auth.p1239a.C19934b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.protocal.C4824j.C4825f;
import com.tencent.p177mm.protocal.C4824j.C4826g;
import com.tencent.p177mm.protocal.C4824j.C4827a;
import com.tencent.p177mm.protocal.C4842v.C4844b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C23510b;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7623d;
import com.tencent.p177mm.vending.p636b.C7358b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.model.c.c */
public class C18624c implements C1816at {
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, C1366d> eaA;
    private C7623d foE;
    private C23510b foF;
    private C1837a foG = new C96551();
    private C4884c foH = new C186252();
    private C4931a foI = new C66743();
    private C7358b foJ = null;
    private final C19933a foK = new C18384();

    /* renamed from: com.tencent.mm.model.c.c$4 */
    class C18384 implements C19933a {
        C18384() {
        }

        /* renamed from: a */
        public final void mo5415a(C4825f c4825f, C4826g c4826g, boolean z) {
            AppMethodBeat.m2504i(118179);
            if (z) {
                if (c4825f != null && (c4825f instanceof C4827a) && c4825f.vyf == 12) {
                    C26421b.abd();
                    AppMethodBeat.m2505o(118179);
                    return;
                }
            } else if (c4825f != null && c4825f.vyf == 16) {
                C26421b.abd();
            }
            AppMethodBeat.m2505o(118179);
        }

        /* renamed from: a */
        public final void mo5416a(C4844b c4844b, String str, int i, String str2, String str3, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.model.c.c$3 */
    class C66743 implements C4931a {
        C66743() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(118178);
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                C5141c ll = C18624c.abi().mo17131ll("100205");
                if (ll.isValid()) {
                    Map dru = ll.dru();
                    int i = C5046bo.getInt((String) dru.get("main_thread_watch_enable"), CdnLogic.kBizGeneric);
                    int i2 = C5046bo.getInt((String) dru.get("main_thread_watch_timeout"), 5000);
                    int i3 = C5046bo.getInt((String) dru.get("main_thread_watch_log_loop"), 0);
                    C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).edit().putInt("main_thread_watch_enable", i).putInt("main_thread_watch_timeout", i2).putInt("main_thread_watch_log_loop", i3).putInt("main_thread_watch_report", C5046bo.getInt((String) dru.get("main_thread_watch_report"), 0)).commit();
                    C4990ab.m7417i("MicroMsg.SubCoreNewABTest", "summeranr MM_MAIN_THREAD_WATCH enable[%d] timeout[%d], loop[%d] report[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(r0));
                }
                C18624c.abk();
            }
            AppMethodBeat.m2505o(118178);
        }
    }

    /* renamed from: com.tencent.mm.model.c.c$1 */
    class C96551 implements C1837a {
        C96551() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(118175);
            String a = C1946aa.m4148a(c1197a.eAB.vED);
            C4990ab.m7410d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s".concat(String.valueOf(a)));
            C9654a pb = C37915a.m64038pb(a);
            if (pb == null) {
                AppMethodBeat.m2505o(118175);
                return;
            }
            C18624c.abi().mo17132s(pb.items, 1);
            C18624c.abj().mo39178s(pb.foD, 2);
            AppMethodBeat.m2505o(118175);
        }
    }

    /* renamed from: com.tencent.mm.model.c.c$2 */
    class C186252 extends C4884c<C26111d> {
        C186252() {
            super(0);
            AppMethodBeat.m2504i(118176);
            this.xxI = C26111d.class.getName().hashCode();
            AppMethodBeat.m2505o(118176);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(118177);
            if (((C26111d) c4883b).crQ.crR) {
                C26421b.abc();
            }
            AppMethodBeat.m2505o(118177);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.c.c$5 */
    static class C186265 implements C1366d {
        C186265() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7623d.fnj;
        }
    }

    /* renamed from: com.tencent.mm.model.c.c$6 */
    static class C186276 implements C1366d {
        C186276() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C23510b.fnj;
        }
    }

    public C18624c() {
        AppMethodBeat.m2504i(118180);
        AppMethodBeat.m2505o(118180);
    }

    private static synchronized C18624c abh() {
        C18624c c18624c;
        synchronized (C18624c.class) {
            AppMethodBeat.m2504i(118181);
            c18624c = (C18624c) C7485q.m12925Y(C18624c.class);
            AppMethodBeat.m2505o(118181);
        }
        return c18624c;
    }

    public static C7623d abi() {
        AppMethodBeat.m2504i(118182);
        C1720g.m3534RN().mo5159QU();
        if (C18624c.abh().foE == null) {
            C18624c.abh().foE = new C7623d(C1720g.m3536RP().eJN);
        }
        C7623d c7623d = C18624c.abh().foE;
        AppMethodBeat.m2505o(118182);
        return c7623d;
    }

    public static C23510b abj() {
        AppMethodBeat.m2504i(118183);
        C1720g.m3534RN().mo5159QU();
        if (C18624c.abh().foF == null) {
            C18624c.abh().foF = new C23510b(C1720g.m3536RP().eJN);
        }
        C23510b c23510b = C18624c.abh().foF;
        AppMethodBeat.m2505o(118183);
        return c23510b;
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(118184);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("newabtest", this.foG, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("newabtestinfo", this.foG, true);
        C4879a.xxA.mo10052c(this.foH);
        C18624c.abi().mo10116c(this.foI);
        this.foJ = ((C19934b) C1720g.m3530M(C19934b.class)).addHandleAuthResponse(this.foK);
        AppMethodBeat.m2505o(118184);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(118185);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("newabtest", this.foG, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("newabtestinfo", this.foG, true);
        C4879a.xxA.mo10053d(this.foH);
        C18624c.abi().mo10117d(this.foI);
        if (this.foJ != null) {
            this.foJ.dead();
            this.foJ = null;
        }
        AppMethodBeat.m2505o(118185);
    }

    static {
        AppMethodBeat.m2504i(118187);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("NEW_ABTEST_TABLE".hashCode()), new C186265());
        eaA.put(Integer.valueOf("NEW_ABTEST_INFO_TABLE".hashCode()), new C186276());
        AppMethodBeat.m2505o(118187);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    static /* synthetic */ void abk() {
        AppMethodBeat.m2504i(118186);
        C5141c ll = C18624c.abi().mo17131ll("100229");
        if (ll.isValid()) {
            Map dru = ll.dru();
            int i = C5046bo.getInt((String) dru.get("UseSvrTime"), 0);
            C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).edit().putInt("client_server_diff_time_enable", i).putInt("client_server_diff_time_interval", C5046bo.getInt((String) dru.get("MinDiffTime"), 0)).commit();
            C4990ab.m7417i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time enable[%d] diffTime[%d]", Integer.valueOf(i), Integer.valueOf(r0));
            AppMethodBeat.m2505o(118186);
            return;
        }
        C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).edit().remove("client_server_diff_time_enable").remove("client_server_diff_time_interval").commit();
        C4990ab.m7416i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time abtest is not valid, then delete data");
        AppMethodBeat.m2505o(118186);
    }
}
