package com.tencent.p177mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C26415ao.C26414e;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.network.C9763x;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.p217ci.C41931h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;
import java.util.HashMap;

/* renamed from: com.tencent.mm.modelstat.q */
public class C42225q implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C18694l fUk = new C18694l();
    private C41931h<C31275m> fUl = new C41931h(new C422241());
    private C9763x fUm = new C9763x();
    private C41931h<C18692g> fUn = new C41931h(new C97122());
    private C1923n fyJ = new C264863();

    /* renamed from: com.tencent.mm.modelstat.q$2 */
    class C97122 implements C32467c<C18692g> {
        C97122() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(78788);
            C18692g c18692g = new C18692g(C5128ac.eSj);
            AppMethodBeat.m2505o(78788);
            return c18692g;
        }
    }

    /* renamed from: com.tencent.mm.modelstat.q$4 */
    static class C187044 implements C1366d {
        C187044() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C31275m.fnj;
        }
    }

    /* renamed from: com.tencent.mm.modelstat.q$3 */
    class C264863 extends C1924a {

        /* renamed from: com.tencent.mm.modelstat.q$3$1 */
        class C264871 implements Runnable {
            C264871() {
            }

            public final void run() {
                AppMethodBeat.m2504i(78789);
                if (C1720g.m3534RN().mo5161QY()) {
                    C42225q.akq().aki();
                    AppMethodBeat.m2505o(78789);
                    return;
                }
                AppMethodBeat.m2505o(78789);
            }

            public final String toString() {
                AppMethodBeat.m2504i(78790);
                String str = super.toString() + "|onNetworkChange";
                AppMethodBeat.m2505o(78790);
                return str;
            }
        }

        C264863() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(78791);
            if (i == 4 || i == 6) {
                C1720g.m3539RS().mo10310m(new C264871(), 3000);
                C4990ab.m7411d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", Integer.valueOf(i));
                C18698o.m29229mg(2);
                AppMethodBeat.m2505o(78791);
                return;
            }
            AppMethodBeat.m2505o(78791);
        }
    }

    /* renamed from: com.tencent.mm.modelstat.q$5 */
    class C312765 implements C26414e {
        C312765() {
        }

        /* renamed from: cm */
        public final void mo44184cm(int i, int i2) {
            AppMethodBeat.m2504i(78792);
            C4990ab.m7411d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), C5046bo.dpG());
            C9711n.m17287cm(i, i2);
            AppMethodBeat.m2505o(78792);
        }
    }

    /* renamed from: com.tencent.mm.modelstat.q$1 */
    class C422241 implements C32467c<C31275m> {
        C422241() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(78787);
            C31275m c31275m = new C31275m(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(78787);
            return c31275m;
        }
    }

    public C42225q() {
        AppMethodBeat.m2504i(78793);
        AppMethodBeat.m2505o(78793);
    }

    public static C18692g akq() {
        AppMethodBeat.m2504i(78794);
        C1720g.m3534RN().mo5159QU();
        C18692g c18692g = (C18692g) C42225q.akr().fUn.get();
        AppMethodBeat.m2505o(78794);
        return c18692g;
    }

    private static C42225q akr() {
        AppMethodBeat.m2504i(78795);
        C42225q c42225q = (C42225q) C7485q.m12925Y(C42225q.class);
        AppMethodBeat.m2505o(78795);
        return c42225q;
    }

    public static C31275m aks() {
        AppMethodBeat.m2504i(78796);
        C1720g.m3534RN().mo5159QU();
        C31275m c31275m = (C31275m) C42225q.akr().fUl.get();
        AppMethodBeat.m2505o(78796);
        return c31275m;
    }

    /* renamed from: e */
    public static void m74517e(C1902e c1902e) {
        boolean z;
        AppMethodBeat.m2504i(78797);
        String str = "MicroMsg.SubCoreStat";
        String str2 = "dknetstat setNetworkMoniter  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        if (c1902e == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = C5046bo.dpG();
        C4990ab.m7411d(str, str2, objArr);
        if (c1902e != null) {
            c1902e.mo5521a(C42225q.akr().fUk);
        }
        AppMethodBeat.m2505o(78797);
    }

    /* renamed from: f */
    public static void m74518f(C1902e c1902e) {
        AppMethodBeat.m2504i(78798);
        String str = "MicroMsg.SubCoreStat";
        String str2 = "setKVReportMonitor  isnull:%b  ,  %s ";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(c1902e == null);
        objArr[1] = C5046bo.dpG();
        C4990ab.m7411d(str, str2, objArr);
        if (c1902e != null) {
            c1902e.mo5523a(C42225q.akr().fUm);
        }
        AppMethodBeat.m2505o(78798);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(78799);
        C1720g.m3535RO().mo5188b(this.fyJ);
        C1200d.m2637b(Integer.valueOf(9998), this.fUk);
        this.fUk = new C18694l();
        C26417a.flv = null;
        AppMethodBeat.m2505o(78799);
    }

    static {
        AppMethodBeat.m2504i(78801);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new C187044());
        AppMethodBeat.m2505o(78801);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(78800);
        C1200d.m2636a(Integer.valueOf(9998), this.fUk);
        C1720g.m3535RO().mo5187a(this.fyJ);
        C26417a.flv = new C312765();
        AppMethodBeat.m2505o(78800);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }
}
