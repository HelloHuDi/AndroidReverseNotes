package com.tencent.p177mm.p707ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.QbSdk;

/* renamed from: com.tencent.mm.ba.o */
public final class C9068o extends C4884c<C6523mp> {
    public C9068o() {
        AppMethodBeat.m2504i(78498);
        this.xxI = C6523mp.class.getName().hashCode();
        AppMethodBeat.m2505o(78498);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(78500);
        boolean aiv = C9068o.aiv();
        AppMethodBeat.m2505o(78500);
        return aiv;
    }

    private static boolean aiv() {
        boolean z;
        AppMethodBeat.m2504i(78499);
        if (C5046bo.m7549fp(C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(66818, null), 0)) * 1000 > 1800000) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(66820, null), (int) QbSdk.EXTENSION_INIT_FAILURE);
            if (a != QbSdk.EXTENSION_INIT_FAILURE) {
                C37907bv.m64020s(9, String.valueOf(a));
                C1720g.m3536RP().mo5239Ry().set(66820, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE));
            }
            C1720g.m3536RP().mo5239Ry().set(66818, Long.valueOf(C5046bo.anT()));
        }
        AppMethodBeat.m2505o(78499);
        return false;
    }
}
