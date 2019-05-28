package com.tencent.p177mm.p182ah;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p182ah.C41732d.C1195b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.avatar.C27440a;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ah.o */
public class C17884o implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C17881i fsp;
    private C41732d fsq;
    private C41731c fsr;
    private C17879g fss;
    private C7564ap fst = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C89183(), false);

    /* renamed from: com.tencent.mm.ah.o$3 */
    class C89183 implements C5015a {
        C89183() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(77954);
            if (!C1720g.m3534RN().mo5161QY() || C17884o.acd() == null) {
                C4990ab.m7421w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", Boolean.valueOf(C1720g.m3534RN().mo5161QY()), C17884o.acd());
                AppMethodBeat.m2505o(77954);
            } else {
                if (((Boolean) C1720g.m3536RP().mo5239Ry().get(90113, Boolean.FALSE)).booleanValue()) {
                    C17884o.acx();
                    C17884o.acw();
                }
                C1720g.m3536RP().mo5239Ry().set(90113, Boolean.FALSE);
                AppMethodBeat.m2505o(77954);
            }
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(77955);
            String str = super.toString() + "|upAssetsHandler";
            AppMethodBeat.m2505o(77955);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ah.o$1 */
    static class C178851 implements C1366d {
        C178851() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C17881i.fnj;
        }
    }

    /* renamed from: com.tencent.mm.ah.o$2 */
    static class C178862 implements C1366d {
        C178862() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C17879g.fnj;
        }
    }

    public static C17884o acs() {
        AppMethodBeat.m2504i(77956);
        C17884o c17884o = (C17884o) C7485q.m12925Y(C17884o.class);
        AppMethodBeat.m2505o(77956);
        return c17884o;
    }

    public C17884o() {
        AppMethodBeat.m2504i(77957);
        AppMethodBeat.m2505o(77957);
    }

    public static C17881i act() {
        AppMethodBeat.m2504i(77958);
        C1720g.m3534RN().mo5159QU();
        if (C17884o.acs().fsp == null) {
            C17884o.acs().fsp = new C17881i(C1720g.m3536RP().eJN);
        }
        C17881i c17881i = C17884o.acs().fsp;
        AppMethodBeat.m2505o(77958);
        return c17881i;
    }

    public static C41732d acd() {
        AppMethodBeat.m2504i(77959);
        C1720g.m3534RN().mo5159QU();
        if (C17884o.acs().fsq == null) {
            C17884o.acs().fsq = new C41732d();
        }
        C41732d c41732d = C17884o.acs().fsq;
        AppMethodBeat.m2505o(77959);
        return c41732d;
    }

    public static C17879g acu() {
        AppMethodBeat.m2504i(77960);
        C1720g.m3534RN().mo5159QU();
        if (C17884o.acs().fss == null) {
            C17884o.acs().fss = new C17879g(C1720g.m3536RP().eJN);
        }
        C17879g c17879g = C17884o.acs().fss;
        AppMethodBeat.m2505o(77960);
        return c17879g;
    }

    public static C41731c acv() {
        AppMethodBeat.m2504i(77961);
        C1720g.m3534RN().mo5159QU();
        if (C17884o.acs().fsr == null) {
            C17884o.acs().fsr = new C41731c();
        }
        C41731c c41731c = C17884o.acs().fsr;
        AppMethodBeat.m2505o(77961);
        return c41731c;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(77962);
        this.fst.stopTimer();
        if (C17884o.acs().fsq != null) {
            C41732d.reset();
        }
        C1202f c1202f = C17884o.acs().fsr;
        if (c1202f != null) {
            C1720g.m3540Rg().mo14546b(123, c1202f);
        }
        C17881i c17881i = C17884o.acs().fsp;
        if (c17881i != null) {
            c17881i.frZ.clear();
        }
        C44042b.m79162N("//avatar");
        AppMethodBeat.m2505o(77962);
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    static {
        AppMethodBeat.m2504i(77967);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new C178851());
        eaA.put(Integer.valueOf("HDHEADIMGINFO_TABLE".hashCode()), new C178862());
        AppMethodBeat.m2505o(77967);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(77963);
        if (z) {
            C4990ab.m7410d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
            C1720g.m3536RP().mo5239Ry().set(90113, Boolean.TRUE);
            try {
                String Yz = C1853r.m3846Yz();
                C41732d acd = C17884o.acd();
                C41732d.m73516E(Yz, false);
                C41732d.m73516E(Yz, true);
                acd.mo67504e(Yz, null);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SubCoreAvatar", e, "Failed to refresh avatar.", new Object[0]);
            }
        }
        this.fst.mo16770ae(10000, 10000);
        C44042b.m79163a(new C27440a(), "//avatar");
        AppMethodBeat.m2505o(77963);
    }

    static Context getContext() {
        AppMethodBeat.m2504i(77964);
        Context context = C4996ah.getContext();
        AppMethodBeat.m2505o(77964);
        return context;
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public static boolean acw() {
        AppMethodBeat.m2504i(77965);
        if (C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(59, null), false)) {
            AppMethodBeat.m2505o(77965);
            return true;
        }
        C17884o.acd();
        if (C41732d.m73524qe(C1853r.m3846Yz())) {
            AppMethodBeat.m2505o(77965);
            return true;
        }
        String Yz = C1853r.m3846Yz();
        if (C5046bo.isNullOrNil(Yz)) {
            AppMethodBeat.m2505o(77965);
            return false;
        }
        Bitmap ql = C1195b.m2629ql(C43217c.m76863XW() + "user_" + C1178g.m2591x(Yz.getBytes()) + ".png");
        if (ql == null || ql.isRecycled()) {
            AppMethodBeat.m2505o(77965);
            return false;
        }
        boolean f = C17884o.acd().mo67505f(Yz, ql);
        AppMethodBeat.m2505o(77965);
        return f;
    }

    static /* synthetic */ void acx() {
        AppMethodBeat.m2504i(77966);
        try {
            Context context = C4996ah.getContext();
            for (String str : C41732d.frx.keySet()) {
                int intValue;
                if (C41732d.frx.containsKey(str)) {
                    intValue = ((Integer) C41732d.frx.get(str)).intValue();
                } else {
                    intValue = 0;
                }
                if (intValue != 0) {
                    C4990ab.m7411d("MicroMsg.SubCoreAvatar", "updateAssetsAvatar user:%s ", str);
                    C17884o.acd().mo67505f(str, C1434a.decodeResource(context.getResources(), intValue));
                }
            }
            AppMethodBeat.m2505o(77966);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SubCoreAvatar", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(77966);
        }
    }
}
