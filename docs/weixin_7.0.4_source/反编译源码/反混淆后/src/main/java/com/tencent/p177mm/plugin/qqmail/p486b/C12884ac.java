package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.qqmail.b.ac */
public class C12884ac implements C1816at {
    private C28730ab puY;
    private C39540v pvA;
    private C28739b pvB = new C28739b();

    /* renamed from: com.tencent.mm.plugin.qqmail.b.ac$1 */
    class C128851 implements Runnable {
        C128851() {
        }

        public final void run() {
            AppMethodBeat.m2504i(68059);
            if (C1720g.m3531RK()) {
                long currentTimeMillis = System.currentTimeMillis();
                C46151y c46151y = new C46151y();
                if (c46151y.puW.oof.size() > 0) {
                    for (int i = 0; i < c46151y.puW.oof.size(); i++) {
                        C46151y.m86146Vm(((C46150w) c46151y.puW.oof.get(i)).ptN);
                    }
                    c46151y.puW.oof.clear();
                    c46151y.save();
                }
                C4990ab.m7417i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(68059);
                return;
            }
            AppMethodBeat.m2505o(68059);
        }
    }

    public C12884ac() {
        AppMethodBeat.m2504i(68060);
        AppMethodBeat.m2505o(68060);
    }

    private static C12884ac ccB() {
        AppMethodBeat.m2504i(68061);
        C12884ac c12884ac = (C12884ac) C7485q.m12925Y(C12884ac.class);
        AppMethodBeat.m2505o(68061);
        return c12884ac;
    }

    public static C39540v ccC() {
        AppMethodBeat.m2504i(68062);
        C1720g.m3534RN().mo5159QU();
        if (C12884ac.ccB().pvA == null) {
            C12884ac.ccB().pvA = new C39540v(C7243d.vxo, C7243d.eSg);
        }
        C39540v c39540v = C12884ac.ccB().pvA;
        AppMethodBeat.m2505o(68062);
        return c39540v;
    }

    public static C28730ab ccD() {
        AppMethodBeat.m2504i(68063);
        C1720g.m3534RN().mo5159QU();
        if (C12884ac.ccB().puY == null) {
            C12884ac.ccB().puY = new C28730ab();
        }
        C28730ab c28730ab = C12884ac.ccB().puY;
        AppMethodBeat.m2505o(68063);
        return c28730ab;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(68064);
        C39540v c39540v = C12884ac.ccB().pvA;
        if (c39540v != null) {
            c39540v.reset();
        }
        C4879a.xxA.mo10053d(this.pvB);
        AppMethodBeat.m2505o(68064);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
        AppMethodBeat.m2504i(68065);
        if ((i & 1) != 0) {
            C12884ac.ccE();
        }
        AppMethodBeat.m2505o(68065);
    }

    public static void ccE() {
        AppMethodBeat.m2504i(68066);
        C1829bf.m3757oD("qqmail");
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX("qqmail");
        C12884ac.ccC().clearData();
        AppMethodBeat.m2505o(68066);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(68067);
        C4879a.xxA.mo10052c(this.pvB);
        C1720g.m3539RS().mo10302aa(new C128851());
        AppMethodBeat.m2505o(68067);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }
}
