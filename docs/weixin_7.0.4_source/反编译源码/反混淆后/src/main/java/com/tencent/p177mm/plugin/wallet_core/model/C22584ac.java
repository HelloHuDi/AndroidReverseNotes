package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.ac */
public final class C22584ac {
    /* renamed from: ne */
    public static ArrayList<Bankcard> m34277ne(boolean z) {
        ArrayList<Bankcard> cQE;
        AppMethodBeat.m2504i(46914);
        C4990ab.m7417i("MicroMsg.WalletPayOrderMgr", "sort bankcard isPos: %s", Boolean.valueOf(z));
        if (z) {
            cQE = C14241r.cPI().cQE();
        } else {
            cQE = C14241r.cPI().mo38171nf(true);
        }
        List<C22591c> cQC = C14241r.cPI().cQC();
        if (cQC == null) {
            C4990ab.m7420w("MicroMsg.WalletPayOrderMgr", "empty bankinfo list");
            AppMethodBeat.m2505o(46914);
            return cQE;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        for (C22591c c22591c : cQC) {
            Bankcard h = C14241r.cPI().mo38170h(c22591c.pbo, true, true);
            if (h != null) {
                arrayList.add(h);
                cQE.remove(h);
            }
        }
        if (!cQE.isEmpty()) {
            C4990ab.m7420w("MicroMsg.WalletPayOrderMgr", "has unsort bankcard");
            arrayList.addAll(cQE);
        }
        AppMethodBeat.m2505o(46914);
        return arrayList;
    }

    public static List<Bankcard> cPS() {
        AppMethodBeat.m2504i(138993);
        ArrayList ne = C22584ac.m34277ne(false);
        AppMethodBeat.m2505o(138993);
        return ne;
    }
}
