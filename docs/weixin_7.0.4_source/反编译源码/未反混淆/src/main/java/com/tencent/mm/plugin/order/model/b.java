package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    public HashSet<String> pbV = new HashSet();

    public b() {
        AppMethodBeat.i(43750);
        Km();
        AppMethodBeat.o(43750);
    }

    private void Km() {
        AppMethodBeat.i(43751);
        this.pbV.clear();
        g.RQ();
        for (String str : bo.P(((String) g.RP().Ry().get(204803, (Object) "")).split(";"))) {
            if (!(bo.isNullOrNil(str) || this.pbV.contains(str))) {
                this.pbV.add(str);
            }
        }
        g.RQ();
        g.RP().Ry().set(204817, Integer.valueOf(this.pbV.size()));
        ab.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.pbV.size());
        AppMethodBeat.o(43751);
    }

    public final void bYV() {
        AppMethodBeat.i(43752);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.pbV.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!bo.isNullOrNil(str)) {
                stringBuffer.append(str + ";");
            }
        }
        g.RQ();
        g.RP().Ry().set(204803, stringBuffer.toString());
        AppMethodBeat.o(43752);
    }
}
