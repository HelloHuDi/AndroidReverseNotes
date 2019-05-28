package com.tencent.p177mm.plugin.soter.p1301e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.soter.p527b.C35151f;
import com.tencent.p177mm.plugin.soter.p527b.C35152g;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p644j.C7583c;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.p663a.C30954a;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C16165c;
import com.tencent.soter.p663a.p1106b.C46744e;
import com.tencent.soter.p663a.p1108f.C30958e;

/* renamed from: com.tencent.mm.plugin.soter.e.c */
public final class C29256c implements C5681a<Boolean, C7583c<Boolean, Boolean>> {
    private C5688b glt = null;

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.m2504i(59359);
        final C7583c c7583c = (C7583c) obj;
        C4990ab.m7418v("MicroMsg.SoterPrepareAskFunc", "alvinluo SoterPrepareAskFunc call");
        Boolean bool;
        if (((Boolean) c7583c.get(0)).booleanValue()) {
            this.glt = C5698f.dMj();
            if (C30954a.dRc()) {
                C35151f c35151f;
                if (C1720g.m3531RK()) {
                    c35151f = new C35151f();
                } else {
                    c35151f = new C35152g();
                }
                C30958e c30958e = c35151f;
                C4990ab.m7419v("MicroMsg.SoterPrepareAskFunc", "alvinluo has ask: %b", Boolean.valueOf(C40997a.dQQ()));
                this.glt.dMi();
                C30954a.m49587a(new C16164b<C16165c>() {
                    /* renamed from: a */
                    public final /* synthetic */ void mo17330a(C46744e c46744e) {
                        AppMethodBeat.m2504i(59358);
                        C16165c c16165c = (C16165c) c46744e;
                        C4990ab.m7417i("MicroMsg.SoterPrepareAskFunc", "alvinluo SoterPrepareAskFunc onResult errCode: %d, errMsg: %s", Integer.valueOf(c16165c.errCode), c16165c.aIm);
                        if (c16165c.isSuccess()) {
                            C29256c.this.glt.mo11581B(c7583c.get(1));
                            AppMethodBeat.m2505o(59358);
                            return;
                        }
                        C46261a.m86642fH(1, c16165c.errCode);
                        C29256c.this.glt.mo11582cR(C5698f.m8552E(Integer.valueOf(c16165c.errCode), c16165c.aIm));
                        AppMethodBeat.m2505o(59358);
                    }
                }, false, c30958e);
                C4990ab.m7419v("MicroMsg.SoterPrepareAskFunc", "alvinluo prepareask isNeedSaveDeviceInfo: %b", c7583c.get(1));
                bool = (Boolean) c7583c.get(1);
                AppMethodBeat.m2505o(59359);
                return bool;
            }
            Object obj2 = Boolean.FALSE;
            AppMethodBeat.m2505o(59359);
            return obj2;
        }
        C4990ab.m7416i("MicroMsg.SoterPrepareAskFunc", "alvinluo not need prepare ask, return");
        bool = (Boolean) c7583c.get(1);
        AppMethodBeat.m2505o(59359);
        return bool;
    }
}
