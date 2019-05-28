package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.p428f.C20964d;
import com.tencent.p177mm.plugin.game.p731d.C12110ad;
import com.tencent.p177mm.plugin.game.p731d.C12123y;
import com.tencent.p177mm.plugin.game.p731d.C43160bc;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.game.model.ad */
public final class C41285ad extends C39216x {
    /* renamed from: a */
    public static void m71915a(C43160bc c43160bc) {
        AppMethodBeat.m2504i(111377);
        if (c43160bc == null || C5046bo.m7548ek(c43160bc.nbU)) {
            AppMethodBeat.m2505o(111377);
            return;
        }
        Iterator it = c43160bc.nbU.iterator();
        while (it.hasNext()) {
            C12110ad c12110ad = (C12110ad) it.next();
            if (c12110ad.naE != null && c12110ad.naE.mZk != null) {
                C20964d.m32218a(C39216x.m66823a(c12110ad.naE.mZk));
            } else if (c12110ad.naG != null && !C5046bo.m7548ek(c12110ad.naG.mZK)) {
                Iterator it2 = c12110ad.naG.mZK.iterator();
                while (it2.hasNext()) {
                    C20964d.m32218a(C39216x.m66823a(((C12123y) it2.next()).mZk));
                }
            } else if (!(c12110ad.naF == null || c12110ad.naF.mZk == null)) {
                C20964d.m32218a(C39216x.m66823a(c12110ad.naF.mZk));
            }
        }
        AppMethodBeat.m2505o(111377);
    }
}
