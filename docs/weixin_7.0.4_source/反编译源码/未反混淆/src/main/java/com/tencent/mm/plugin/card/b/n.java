package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bi;

public final class n extends c<ii> implements f {
    private long cuQ;

    public n() {
        AppMethodBeat.i(87766);
        this.cuQ = 0;
        this.xxI = ii.class.getName().hashCode();
        AppMethodBeat.o(87766);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(87767);
        if (mVar instanceof af) {
            String str2 = ((af) mVar).cMD;
            bi jf = ((j) g.K(j.class)).bOr().jf(this.cuQ);
            if (i == 0 && i2 == 0) {
                jf.setStatus(2);
            } else {
                jf.setStatus(5);
            }
            b me = b.me(jf.field_content);
            d Hi = com.tencent.mm.plugin.card.d.g.Hi(jf.field_content);
            Hi.cMD = str2;
            me.fhB = com.tencent.mm.plugin.card.d.g.a(Hi);
            me.cDt = b.a(me, null, null);
            jf.setContent(b.a(me, null, null));
            ((j) g.K(j.class)).bOr().a(this.cuQ, jf);
            g.RO().eJo.b(652, (f) this);
        }
        AppMethodBeat.o(87767);
    }

    private boolean a(ii iiVar) {
        AppMethodBeat.i(87768);
        if (iiVar instanceof ii) {
            d Hi;
            String str = iiVar.cDs.cDt;
            this.cuQ = iiVar.cDs.cuQ;
            String str2 = iiVar.cDs.cDu;
            d Hi2 = com.tencent.mm.plugin.card.d.g.Hi(str);
            bi jf = ((j) g.K(j.class)).bOr().jf(this.cuQ);
            jf.setStatus(1);
            ((j) g.K(j.class)).bOr().a(this.cuQ, jf);
            if (Hi2 == null) {
                Hi = com.tencent.mm.plugin.card.d.g.Hi(jf.field_content);
            } else {
                Hi = Hi2;
            }
            if (Hi != null) {
                g.RO().eJo.a(652, (f) this);
                g.RO().eJo.a(new af(Hi.cMC, str2, 17), 0);
            }
            AppMethodBeat.o(87768);
            return true;
        }
        AppMethodBeat.o(87768);
        return false;
    }
}
