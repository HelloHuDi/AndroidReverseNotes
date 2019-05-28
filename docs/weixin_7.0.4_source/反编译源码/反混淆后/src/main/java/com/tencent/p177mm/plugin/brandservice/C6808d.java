package com.tencent.p177mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C42043qi;
import com.tencent.p177mm.plugin.brandservice.p349ui.p927a.C42805b;
import com.tencent.p177mm.plugin.brandservice.p349ui.p927a.C45761d;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p1476a.C38707b;
import com.tencent.p177mm.plugin.brandservice.p926b.C42795k;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.brandservice.d */
public class C6808d implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C6809a jKr;
    private C38707b jKs;

    /* renamed from: com.tencent.mm.plugin.brandservice.d$a */
    public static class C6809a extends C4884c<C42043qi> {
        public C6809a() {
            AppMethodBeat.m2504i(13815);
            this.xxI = C42043qi.class.getName().hashCode();
            AppMethodBeat.m2505o(13815);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(13816);
            C42043qi c42043qi = (C42043qi) c4883b;
            if (c42043qi instanceof C42043qi) {
                if (!(c42043qi.cMy == null || C5046bo.isNullOrNil(c42043qi.cMy.cKE) || c42043qi.cMy.cMz == null)) {
                    C1207m c42795k = new C42795k(c42043qi.cMy.cKE, c42043qi.cMy.cMz);
                    C1720g.m3537RQ();
                    C1720g.m3540Rg().mo14541a(c42795k, 0);
                }
                AppMethodBeat.m2505o(13816);
                return true;
            }
            C4990ab.m7414f("MicroMsg.BrandService.SubCoreBrandService", "mismatched event");
            AppMethodBeat.m2505o(13816);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.d$1 */
    static class C68101 implements C1366d {
        C68101() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C38707b.fjY;
        }
    }

    private static C6808d aVS() {
        AppMethodBeat.m2504i(13817);
        C6808d c6808d = (C6808d) C7485q.m12925Y(C6808d.class);
        AppMethodBeat.m2505o(13817);
        return c6808d;
    }

    static {
        AppMethodBeat.m2504i(13821);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("BIZAPPMSGREPORTCCONTEXT_TABLE".hashCode()), new C68101());
        AppMethodBeat.m2505o(13821);
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

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(13818);
        C4990ab.m7410d("MicroMsg.BrandService.SubCoreBrandService", "on sub core brand service reset");
        if (this.jKr == null) {
            this.jKr = new C6809a();
        }
        C4879a.xxA.mo10052c(this.jKr);
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C45761d());
        ((C12029n) C1720g.m3530M(C12029n.class)).registerFTSUILogic(new C42805b());
        AppMethodBeat.m2505o(13818);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(13819);
        if (this.jKr != null) {
            C4879a.xxA.mo10053d(this.jKr);
        }
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(96);
        ((C12029n) C1720g.m3530M(C12029n.class)).unregisterFTSUILogic(4208);
        AppMethodBeat.m2505o(13819);
    }

    public static C38707b aVT() {
        AppMethodBeat.m2504i(13820);
        C1720g.m3534RN().mo5159QU();
        if (C6808d.aVS().jKs == null) {
            C6808d.aVS().jKs = new C38707b(C1720g.m3536RP().eJN);
        }
        C38707b c38707b = C6808d.aVS().jKs;
        AppMethodBeat.m2505o(13820);
        return c38707b;
    }
}
