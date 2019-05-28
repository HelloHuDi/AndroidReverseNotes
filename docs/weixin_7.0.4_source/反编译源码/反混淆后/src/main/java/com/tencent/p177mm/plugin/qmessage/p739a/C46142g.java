package com.tencent.p177mm.plugin.qmessage.p739a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.qmessage.C39534b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.qmessage.a.g */
public final class C46142g implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C34746e psR;
    private C39533f psS = new C39533f();
    private C7024a psT = new C7024a();
    private C39534b psU = new C39534b();

    /* renamed from: com.tencent.mm.plugin.qmessage.a.g$1 */
    static class C215181 implements C1366d {
        C215181() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C34746e.fnj;
        }
    }

    public C46142g() {
        AppMethodBeat.m2504i(24087);
        AppMethodBeat.m2505o(24087);
    }

    private static C46142g cbZ() {
        AppMethodBeat.m2504i(24088);
        C9638aw.m17184ZE();
        C46142g c46142g = (C46142g) C45439bw.m83697oJ("plugin.qmessage");
        if (c46142g == null) {
            c46142g = new C46142g();
            C9638aw.m17184ZE().mo73244a("plugin.qmessage", c46142g);
        }
        AppMethodBeat.m2505o(24088);
        return c46142g;
    }

    public static C34746e cca() {
        AppMethodBeat.m2504i(24089);
        C1720g.m3534RN().mo5159QU();
        if (C46142g.cbZ().psR == null) {
            C46142g cbZ = C46142g.cbZ();
            C9638aw.m17190ZK();
            cbZ.psR = new C34746e(C18628c.m29069Ru());
        }
        C34746e c34746e = C46142g.cbZ().psR;
        AppMethodBeat.m2505o(24089);
        return c34746e;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(24090);
        C1200d.m2637b(Integer.valueOf(36), this.psS);
        C1200d.m2637b(Integer.valueOf(39), this.psS);
        C4879a.xxA.mo10053d(this.psT);
        C4879a.xxA.mo10053d(this.psU);
        AppMethodBeat.m2505o(24090);
    }

    static {
        AppMethodBeat.m2504i(24095);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("QCONTACT_TABLE".hashCode()), new C215181());
        AppMethodBeat.m2505o(24095);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
        AppMethodBeat.m2504i(24091);
        C4990ab.m7410d("MicroMsg.SubCoreQMsg", "clear plugin");
        if ((i & 32) != 0) {
            C46142g.ccc();
        }
        AppMethodBeat.m2505o(24091);
    }

    public static void ccb() {
        AppMethodBeat.m2504i(24092);
        C9638aw.m17190ZK();
        if (C18628c.m29083XR().aoZ("qmessage") == null) {
            C7617ak c7617ak = new C7617ak();
            c7617ak.setUsername("qmessage");
            c7617ak.setContent("");
            c7617ak.mo14742eD(C5046bo.anU());
            c7617ak.mo14750hO(0);
            c7617ak.mo14748hM(0);
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo15807d(c7617ak);
            AppMethodBeat.m2505o(24092);
            return;
        }
        String str;
        C9638aw.m17190ZK();
        C7620bi Rb = C18628c.m29080XO().mo15248Rb("qmessage");
        C7617ak c7617ak2 = new C7617ak();
        c7617ak2.setUsername("qmessage");
        if (Rb == null) {
            str = "";
        } else {
            str = Rb.field_content;
        }
        c7617ak2.setContent(str);
        c7617ak2.mo14742eD(C5046bo.anU());
        c7617ak2.mo14750hO(0);
        c7617ak2.mo14748hM(0);
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo15767a(c7617ak2, "qmessage");
        AppMethodBeat.m2505o(24092);
    }

    public static void ccc() {
        AppMethodBeat.m2504i(24093);
        C1829bf.aab();
        C9638aw.m17190ZK();
        C18628c.m29083XR().aoY("@qqim");
        C9638aw.m17190ZK();
        C18628c.m29083XR().aoX("qmessage");
        AppMethodBeat.m2505o(24093);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(24094);
        C1200d.m2636a(Integer.valueOf(36), this.psS);
        C1200d.m2636a(Integer.valueOf(39), this.psS);
        C4879a.xxA.mo10052c(this.psT);
        C4879a.xxA.mo10052c(this.psU);
        AppMethodBeat.m2505o(24094);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }
}
