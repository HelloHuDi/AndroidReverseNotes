package com.tencent.p177mm.modelvoice;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C41765i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18359oy;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C30300cd;
import java.util.HashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelvoice.m */
public class C26500m implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C18719u fZZ;
    private C30300cd gaa;
    private C41765i gab;
    private C9744r gac = new C9744r();
    private C4884c gad = new C265011();

    /* renamed from: com.tencent.mm.modelvoice.m$3 */
    static class C66963 implements C1366d {
        C66963() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C30300cd.fnj;
        }
    }

    /* renamed from: com.tencent.mm.modelvoice.m$a */
    static class C9743a implements C44041a {
        C9743a() {
        }

        /* renamed from: a */
        public final boolean mo7165a(Context context, String[] strArr, String str) {
            AppMethodBeat.m2504i(116596);
            String str2 = strArr[0];
            int i = -1;
            switch (str2.hashCode()) {
                case -1560895490:
                    if (str2.equals("//voicetrymore")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    if (strArr.length > 1 && strArr[1] != null) {
                        boolean z;
                        if (C5046bo.getInt(strArr[1], 1) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        C41765i.cqY = z;
                        C4990ab.m7417i("MicroMsg.SubCoreVoice", "summervoicetrymore enable[%d]", Integer.valueOf(r3));
                        AppMethodBeat.m2505o(116596);
                        return true;
                    }
            }
            AppMethodBeat.m2505o(116596);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.modelvoice.m$1 */
    class C265011 extends C4884c<C18359oy> {
        C265011() {
            AppMethodBeat.m2504i(116594);
            this.xxI = C18359oy.class.getName().hashCode();
            AppMethodBeat.m2505o(116594);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(116595);
            C32850q.m53724mu((int) ((C18359oy) c4883b).cLn.csG.field_msgId);
            AppMethodBeat.m2505o(116595);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.modelvoice.m$2 */
    static class C265022 implements C1366d {
        C265022() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C18719u.fnj;
        }
    }

    public C26500m() {
        AppMethodBeat.m2504i(116597);
        AppMethodBeat.m2505o(116597);
    }

    private static C26500m alZ() {
        AppMethodBeat.m2504i(116598);
        C26500m c26500m = (C26500m) C7485q.m12925Y(C26500m.class);
        AppMethodBeat.m2505o(116598);
        return c26500m;
    }

    public static C18719u ama() {
        AppMethodBeat.m2504i(116599);
        C1720g.m3534RN().mo5159QU();
        if (C26500m.alZ().fZZ == null) {
            Assert.assertTrue("dataDB is null ", C1720g.m3536RP().eJN != null);
            C26500m.alZ().fZZ = new C18719u(C1720g.m3536RP().eJN);
        }
        C18719u c18719u = C26500m.alZ().fZZ;
        AppMethodBeat.m2505o(116599);
        return c18719u;
    }

    public static C30300cd amb() {
        AppMethodBeat.m2504i(116600);
        C1720g.m3534RN().mo5159QU();
        if (C26500m.alZ().gaa == null) {
            Assert.assertTrue("dataDB is null ", C1720g.m3536RP().eJN != null);
            C26500m.alZ().gaa = new C30300cd(C1720g.m3536RP().eJN);
        }
        C30300cd c30300cd = C26500m.alZ().gaa;
        AppMethodBeat.m2505o(116600);
        return c30300cd;
    }

    public static C41765i amc() {
        AppMethodBeat.m2504i(116601);
        C1720g.m3534RN().mo5159QU();
        if (C26500m.alZ().gab == null) {
            C26500m.alZ().gab = new C41765i();
        }
        C41765i c41765i = C26500m.alZ().gab;
        AppMethodBeat.m2505o(116601);
        return c41765i;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(116602);
        if (C26500m.alZ().gab != null) {
            C26500m.alZ().gab.cqV = 0;
        }
        C1200d.m2637b(Integer.valueOf(34), this.gac);
        C4879a.xxA.mo10053d(this.gad);
        C44042b.m79162N("//voicetrymore");
        AppMethodBeat.m2505o(116602);
    }

    static {
        AppMethodBeat.m2504i(116604);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("VOICE_TABLE".hashCode()), new C265022());
        eaA.put(Integer.valueOf("VOICETRANSTEXT_TABLE".hashCode()), new C66963());
        AppMethodBeat.m2505o(116604);
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
        AppMethodBeat.m2504i(116603);
        C1200d.m2636a(Integer.valueOf(34), this.gac);
        C4879a.xxA.mo10052c(this.gad);
        C44042b.m79163a(new C9743a(), "//voicetrymore");
        AppMethodBeat.m2505o(116603);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }
}
