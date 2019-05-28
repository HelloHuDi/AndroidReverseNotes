package com.tencent.p177mm.plugin.card.p352b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26165ii;
import com.tencent.p177mm.plugin.card.model.C38743d;
import com.tencent.p177mm.plugin.card.model.C45784af;
import com.tencent.p177mm.plugin.card.p931d.C20134g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.card.b.n */
public final class C38732n extends C4884c<C26165ii> implements C1202f {
    private long cuQ;

    public C38732n() {
        AppMethodBeat.m2504i(87766);
        this.cuQ = 0;
        this.xxI = C26165ii.class.getName().hashCode();
        AppMethodBeat.m2505o(87766);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(87767);
        if (c1207m instanceof C45784af) {
            String str2 = ((C45784af) c1207m).cMD;
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.cuQ);
            if (i == 0 && i2 == 0) {
                jf.setStatus(2);
            } else {
                jf.setStatus(5);
            }
            C8910b me = C8910b.m16064me(jf.field_content);
            C38743d Hi = C20134g.m31147Hi(jf.field_content);
            Hi.cMD = str2;
            me.fhB = C20134g.m31150a(Hi);
            me.cDt = C8910b.m16061a(me, null, null);
            jf.setContent(C8910b.m16061a(me, null, null));
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.cuQ, jf);
            C1720g.m3535RO().eJo.mo14546b(652, (C1202f) this);
        }
        AppMethodBeat.m2505o(87767);
    }

    /* renamed from: a */
    private boolean m65696a(C26165ii c26165ii) {
        AppMethodBeat.m2504i(87768);
        if (c26165ii instanceof C26165ii) {
            C38743d Hi;
            String str = c26165ii.cDs.cDt;
            this.cuQ = c26165ii.cDs.cuQ;
            String str2 = c26165ii.cDs.cDu;
            C38743d Hi2 = C20134g.m31147Hi(str);
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.cuQ);
            jf.setStatus(1);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.cuQ, jf);
            if (Hi2 == null) {
                Hi = C20134g.m31147Hi(jf.field_content);
            } else {
                Hi = Hi2;
            }
            if (Hi != null) {
                C1720g.m3535RO().eJo.mo14539a(652, (C1202f) this);
                C1720g.m3535RO().eJo.mo14541a(new C45784af(Hi.cMC, str2, 17), 0);
            }
            AppMethodBeat.m2505o(87768);
            return true;
        }
        AppMethodBeat.m2505o(87768);
        return false;
    }
}
