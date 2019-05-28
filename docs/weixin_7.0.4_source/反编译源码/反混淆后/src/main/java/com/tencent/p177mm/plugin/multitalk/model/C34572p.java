package com.tencent.p177mm.plugin.multitalk.model;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C1841cc.C1840a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.multitalk.p1492a.C39418c;
import com.tencent.p177mm.plugin.multitalk.p1492a.C43319a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.multitalk.model.p */
public class C34572p implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C1840a mBB = new C345733();
    private C34574a oHA;
    private C34566h oHB;
    private C43319a oHC;
    private C39418c oHD;
    private C34565g oHE;
    private C28535d oHw;
    private C12630f oHx;
    private C3516m oHy;
    private C34569i oHz;

    /* renamed from: com.tencent.mm.plugin.multitalk.model.p$2 */
    static class C69852 implements C1366d {
        C69852() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C39418c.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.p$1 */
    static class C126511 implements C1366d {
        C126511() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C43319a.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.p$3 */
    class C345733 implements C1840a {
        C345733() {
        }

        public final boolean aaG() {
            AppMethodBeat.m2504i(54088);
            C4990ab.m7420w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
            if (C34572p.this.oHx != null) {
                C34572p.this.oHx.bGT();
                if (C34572p.this.oHx.oGh != null) {
                    C4990ab.m7417i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", C34571j.m56700h(C34572p.this.oHx.oGh));
                }
            }
            AppMethodBeat.m2505o(54088);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.p$a */
    class C34574a implements C1837a {
        C34574a() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(54089);
            C34565g bSi = C34572p.bSi();
            String a = C1946aa.m4148a(c1197a.eAB.vED);
            Map z = C5049br.m7595z(a, "sysmsg");
            if (((String) z.get(".sysmsg.multivoip.notfriendnotifydata")) != null) {
                C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:".concat(String.valueOf(a)));
                AppMethodBeat.m2505o(54089);
                return;
            }
            String str = (String) z.get(".sysmsg.multivoip.notifydata");
            if (str != null) {
                byte[] decode = Base64.decode(C5046bo.m7532bc(str, "").getBytes(), 0);
                C4990ab.m7416i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + C1946aa.m4148a(c1197a.eAB.vED) + " buffer len " + decode.length);
                C34572p.bSe().oFP.mo58364bR(C5046bo.m7567h((Integer) C1720g.m3536RP().eJH.get(1)), C1853r.m3846Yz());
                C34572p.bSe().oFP.mo58365ck(decode);
                AppMethodBeat.m2505o(54089);
                return;
            }
            str = (String) z.get(".sysmsg.multivoip.banner");
            if (str != null) {
                bSi.mo55108a(str, c1197a);
            }
            AppMethodBeat.m2505o(54089);
        }
    }

    public C34572p() {
        AppMethodBeat.m2504i(54090);
        AppMethodBeat.m2505o(54090);
    }

    static {
        AppMethodBeat.m2504i(54102);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new C126511());
        eaA.put(Integer.valueOf("MULTITALKMEMBER_TABLE".hashCode()), new C69852());
        AppMethodBeat.m2505o(54102);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    private static C34572p bSa() {
        AppMethodBeat.m2504i(54091);
        C34572p c34572p = (C34572p) C7485q.m12925Y(C34572p.class);
        AppMethodBeat.m2505o(54091);
        return c34572p;
    }

    public static C43319a bSb() {
        AppMethodBeat.m2504i(54092);
        C1720g.m3534RN();
        if (C1668a.m3383QF() == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(54092);
            throw c1819b;
        }
        if (C34572p.bSa().oHC == null) {
            C34572p.bSa().oHC = new C43319a(C1720g.m3536RP().eJN);
        }
        C43319a c43319a = C34572p.bSa().oHC;
        AppMethodBeat.m2505o(54092);
        return c43319a;
    }

    public static C39418c bSc() {
        AppMethodBeat.m2504i(54093);
        C1720g.m3534RN();
        if (C1668a.m3383QF() == 0) {
            C1819b c1819b = new C1819b();
            AppMethodBeat.m2505o(54093);
            throw c1819b;
        }
        if (C34572p.bSa().oHD == null) {
            C34572p.bSa().oHD = new C39418c(C1720g.m3536RP().eJN);
        }
        C39418c c39418c = C34572p.bSa().oHD;
        AppMethodBeat.m2505o(54093);
        return c39418c;
    }

    public static C34569i bSd() {
        AppMethodBeat.m2504i(54094);
        C1720g.m3534RN().mo5159QU();
        if (C34572p.bSa().oHz == null) {
            C34572p.bSa().oHz = new C34569i();
        }
        C34569i c34569i = C34572p.bSa().oHz;
        AppMethodBeat.m2505o(54094);
        return c34569i;
    }

    public static C28535d bSe() {
        AppMethodBeat.m2504i(54095);
        C1720g.m3534RN().mo5159QU();
        if (C34572p.bSa().oHw == null) {
            C34572p.bSa().oHw = new C28535d();
        }
        C28535d c28535d = C34572p.bSa().oHw;
        AppMethodBeat.m2505o(54095);
        return c28535d;
    }

    public static C12630f bSf() {
        AppMethodBeat.m2504i(54096);
        C1720g.m3534RN().mo5159QU();
        if (C34572p.bSa().oHx == null) {
            C34572p.bSa().oHx = new C12630f();
        }
        C12630f c12630f = C34572p.bSa().oHx;
        AppMethodBeat.m2505o(54096);
        return c12630f;
    }

    public static C3516m bSg() {
        AppMethodBeat.m2504i(54097);
        C1720g.m3534RN().mo5159QU();
        if (C34572p.bSa().oHy == null) {
            C34572p.bSa().oHy = new C3516m();
        }
        C3516m c3516m = C34572p.bSa().oHy;
        AppMethodBeat.m2505o(54097);
        return c3516m;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(54098);
        this.oHw = new C28535d();
        this.oHA = new C34574a();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("multivoip", this.oHA, true);
        C1720g.m3538RR().mo5418a(this.mBB);
        C1720g.m3542a(C39419a.class, C34572p.bSh());
        C34572p.bSh().bRT();
        AppMethodBeat.m2505o(54098);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(54099);
        if (this.oHw != null) {
            C1202f c1202f = this.oHw;
            C1720g.m3540Rg().mo14546b(1918, c1202f);
            C1720g.m3540Rg().mo14546b(1919, c1202f);
            C1720g.m3540Rg().mo14546b(1927, c1202f);
            C1720g.m3540Rg().mo14546b(1928, c1202f);
            C1720g.m3540Rg().mo14546b(1929, c1202f);
            C1720g.m3540Rg().mo14546b(1931, c1202f);
            C1720g.m3540Rg().mo14546b(1932, c1202f);
            C1720g.m3540Rg().mo14546b(1933, c1202f);
            C1720g.m3540Rg().mo14546b(1935, c1202f);
            C1720g.m3540Rg().mo14546b(1937, c1202f);
            C1720g.m3540Rg().mo14546b(1938, c1202f);
            C1720g.m3540Rg().mo14546b(1939, c1202f);
            this.oHw = null;
        }
        if (this.oHx != null) {
            C12630f c12630f = this.oHx;
            C4996ah.getContext().unregisterReceiver(c12630f.oGz);
            C4879a.xxA.mo10053d(c12630f.oGA);
            c12630f.mo24587h(false, false, false);
            this.oHx = null;
        }
        if (this.oHy != null) {
            this.oHy.bRZ();
            this.oHy = null;
        }
        if (this.oHz != null) {
            this.oHz.reset();
            this.oHz = null;
        }
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("multivoip", this.oHA, true);
        C1720g.m3538RR().mo5419b(this.mBB);
        C1720g.m3529L(C39419a.class);
        AppMethodBeat.m2505o(54099);
    }

    public static C34566h bSh() {
        AppMethodBeat.m2504i(54100);
        if (C34572p.bSa().oHB == null) {
            C34572p.bSa().oHB = new C34566h();
        }
        C34566h c34566h = C34572p.bSa().oHB;
        AppMethodBeat.m2505o(54100);
        return c34566h;
    }

    public static C34565g bSi() {
        AppMethodBeat.m2504i(54101);
        if (C34572p.bSa().oHE == null) {
            C34572p.bSa().oHE = new C34565g();
        }
        C34565g c34565g = C34572p.bSa().oHE;
        AppMethodBeat.m2505o(54101);
        return c34565g;
    }
}
