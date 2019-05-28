package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.p181af.C1191k;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.chatting.C23698ah.C23699a;
import com.tencent.p177mm.p612ui.chatting.p616c.C46648j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;
import java.util.Set;

/* renamed from: com.tencent.mm.ui.chatting.i */
public final class C44308i {

    /* renamed from: com.tencent.mm.ui.chatting.i$a */
    static class C5344a implements C23499a {
        private Set<Long> yIu;
        private C44275p yIv;
        private C23698ah yIw;

        public C5344a(Set<Long> set, C44275p c44275p, C23698ah c23698ah) {
            this.yIu = set;
            this.yIv = c44275p;
            this.yIw = c23698ah;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(30529);
            Set<Long> set = this.yIu;
            LinkedList linkedList = new LinkedList();
            for (Long l : set) {
                C9638aw.m17190ZK();
                C7620bi jf = C18628c.m29080XO().mo15340jf(l.longValue());
                if (jf.field_msgId == l.longValue()) {
                    if (jf.bAA()) {
                        C45457b.fRa.mo73262c(jf, C1191k.m2615k(jf));
                    } else {
                        C45457b.fRa.mo73249E(jf);
                    }
                }
                linkedList.add(l);
                C18348nt c18348nt = new C18348nt();
                c18348nt.cJY.type = 3;
                c18348nt.cJY.cvx = l.longValue();
                C4879a.xxA.mo10055m(c18348nt);
            }
            C1829bf.m3740X(linkedList);
            if (this.yIw != null) {
                this.yIw.mo27932a(C23699a.del);
            }
            AppMethodBeat.m2505o(30529);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(30530);
            if (this.yIv != null) {
                this.yIv.dismiss();
                if (this.yIw != null) {
                    this.yIw.mo27933b(C23699a.del);
                }
            }
            AppMethodBeat.m2505o(30530);
            return true;
        }
    }

    /* renamed from: a */
    public static void m80089a(Context context, Set<Long> set, C23698ah c23698ah) {
        AppMethodBeat.m2504i(30531);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
            AppMethodBeat.m2505o(30531);
        } else if (set == null || set.isEmpty()) {
            C4990ab.m7420w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
            AppMethodBeat.m2505o(30531);
        } else {
            context.getString(C25738R.string.f9238tz);
            C46648j.yOM.mo39163e(new C5344a(set, C30379h.m48458b(context, context.getString(C25738R.string.b5b), false, null), c23698ah));
            C7060h.pYm.mo8381e(10811, Integer.valueOf(4), Integer.valueOf(set.size()));
            AppMethodBeat.m2505o(30531);
        }
    }
}
