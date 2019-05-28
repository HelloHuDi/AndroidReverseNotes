package com.tencent.p177mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.order.model.b */
public final class C39481b {
    public HashSet<String> pbV = new HashSet();

    public C39481b() {
        AppMethodBeat.m2504i(43750);
        m67457Km();
        AppMethodBeat.m2505o(43750);
    }

    /* renamed from: Km */
    private void m67457Km() {
        AppMethodBeat.m2504i(43751);
        this.pbV.clear();
        C1720g.m3537RQ();
        for (String str : C5046bo.m7508P(((String) C1720g.m3536RP().mo5239Ry().get(204803, (Object) "")).split(";"))) {
            if (!(C5046bo.isNullOrNil(str) || this.pbV.contains(str))) {
                this.pbV.add(str);
            }
        }
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(204817, Integer.valueOf(this.pbV.size()));
        C4990ab.m7410d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.pbV.size());
        AppMethodBeat.m2505o(43751);
    }

    public final void bYV() {
        AppMethodBeat.m2504i(43752);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.pbV.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!C5046bo.isNullOrNil(str)) {
                stringBuffer.append(str + ";");
            }
        }
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(204803, stringBuffer.toString());
        AppMethodBeat.m2505o(43752);
    }
}
