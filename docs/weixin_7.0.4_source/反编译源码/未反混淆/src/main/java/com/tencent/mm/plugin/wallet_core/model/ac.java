package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class ac {
    public static ArrayList<Bankcard> ne(boolean z) {
        ArrayList<Bankcard> cQE;
        AppMethodBeat.i(46914);
        ab.i("MicroMsg.WalletPayOrderMgr", "sort bankcard isPos: %s", Boolean.valueOf(z));
        if (z) {
            cQE = r.cPI().cQE();
        } else {
            cQE = r.cPI().nf(true);
        }
        List<c> cQC = r.cPI().cQC();
        if (cQC == null) {
            ab.w("MicroMsg.WalletPayOrderMgr", "empty bankinfo list");
            AppMethodBeat.o(46914);
            return cQE;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        for (c cVar : cQC) {
            Bankcard h = r.cPI().h(cVar.pbo, true, true);
            if (h != null) {
                arrayList.add(h);
                cQE.remove(h);
            }
        }
        if (!cQE.isEmpty()) {
            ab.w("MicroMsg.WalletPayOrderMgr", "has unsort bankcard");
            arrayList.addAll(cQE);
        }
        AppMethodBeat.o(46914);
        return arrayList;
    }

    public static List<Bankcard> cPS() {
        AppMethodBeat.i(138993);
        ArrayList ne = ne(false);
        AppMethodBeat.o(138993);
        return ne;
    }
}
