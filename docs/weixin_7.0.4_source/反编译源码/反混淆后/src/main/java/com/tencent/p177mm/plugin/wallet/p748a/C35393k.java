package com.tencent.p177mm.plugin.wallet.p748a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18286hp;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet.a.k */
public final class C35393k extends C4884c<C18286hp> {
    public C35393k() {
        AppMethodBeat.m2504i(45839);
        this.xxI = C18286hp.class.getName().hashCode();
        AppMethodBeat.m2505o(45839);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        int i = 0;
        AppMethodBeat.m2504i(45840);
        C18286hp c18286hp = (C18286hp) c4883b;
        if (c18286hp instanceof C18286hp) {
            c18286hp.cCu.cCw = C14241r.cPI().cQn();
            String bhp = C14241r.cPI().bhp();
            if (C5046bo.isNullOrNil(bhp)) {
                c18286hp.cCu.cCv = "";
            } else {
                String str = "";
                while (i < bhp.length() - 1) {
                    str = str + "*";
                    i++;
                }
                c18286hp.cCu.cCv = str + bhp.substring(bhp.length() - 1, bhp.length());
            }
            AppMethodBeat.m2505o(45840);
            return true;
        }
        AppMethodBeat.m2505o(45840);
        return false;
    }
}
