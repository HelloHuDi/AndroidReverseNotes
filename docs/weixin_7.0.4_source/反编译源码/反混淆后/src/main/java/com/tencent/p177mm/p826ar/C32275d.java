package com.tencent.p177mm.p826ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.subapp.C22330a;
import com.tencent.p177mm.pluginsdk.C23243g;
import com.tencent.p177mm.pluginsdk.C40437i;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35850h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C4738c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ar.d */
public class C32275d implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C32269b fCQ;
    private C32272c fCR;

    /* renamed from: com.tencent.mm.ar.d$1 */
    static class C322761 implements C1366d {
        C322761() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C32269b.fnj;
        }
    }

    private static C32275d agL() {
        C32275d c32275d;
        AppMethodBeat.m2504i(16488);
        C9638aw.m17184ZE();
        C22330a c22330a = (C22330a) C45439bw.m83697oJ("plugin.subapp");
        C32275d c32275d2 = c22330a == null ? null : (C32275d) c22330a.abh(C32275d.class.getName());
        if (c32275d2 == null) {
            c32275d2 = new C32275d();
            c22330a.mo37875b(C32275d.class.getName(), c32275d2);
            c32275d = c32275d2;
        } else {
            c32275d = c32275d2;
        }
        AppMethodBeat.m2505o(16488);
        return c32275d;
    }

    public static C32269b agM() {
        AppMethodBeat.m2504i(16489);
        C1720g.m3534RN().mo5159QU();
        if (C32275d.agL().fCQ == null) {
            C32275d agL = C32275d.agL();
            C9638aw.m17190ZK();
            agL.fCQ = new C32269b(C18628c.m29069Ru());
        }
        C32269b c32269b = C32275d.agL().fCQ;
        AppMethodBeat.m2505o(16489);
        return c32269b;
    }

    public final void onAccountRelease() {
    }

    static {
        AppMethodBeat.m2504i(16491);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("GETCONTACTINFO_TABLE".hashCode()), new C322761());
        AppMethodBeat.m2505o(16491);
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
        AppMethodBeat.m2504i(16490);
        if (this.fCR == null) {
            this.fCR = new C32272c();
        }
        C26417a.flu = this.fCR;
        C4990ab.m7417i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", this.fCR);
        C1720g.m3542a(C23243g.class, new C4738c());
        C1720g.m3542a(C40437i.class, new C35850h());
        AppMethodBeat.m2505o(16490);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }
}
