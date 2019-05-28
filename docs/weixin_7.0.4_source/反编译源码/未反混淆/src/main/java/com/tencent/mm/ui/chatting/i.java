package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.k;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.c.j;
import java.util.LinkedList;
import java.util.Set;

public final class i {

    static class a implements com.tencent.mm.sdk.platformtools.az.a {
        private Set<Long> yIu;
        private p yIv;
        private ah yIw;

        public a(Set<Long> set, p pVar, ah ahVar) {
            this.yIu = set;
            this.yIv = pVar;
            this.yIw = ahVar;
        }

        public final boolean acf() {
            AppMethodBeat.i(30529);
            Set<Long> set = this.yIu;
            LinkedList linkedList = new LinkedList();
            for (Long l : set) {
                aw.ZK();
                bi jf = c.XO().jf(l.longValue());
                if (jf.field_msgId == l.longValue()) {
                    if (jf.bAA()) {
                        b.fRa.c(jf, k.k(jf));
                    } else {
                        b.fRa.E(jf);
                    }
                }
                linkedList.add(l);
                nt ntVar = new nt();
                ntVar.cJY.type = 3;
                ntVar.cJY.cvx = l.longValue();
                com.tencent.mm.sdk.b.a.xxA.m(ntVar);
            }
            bf.X(linkedList);
            if (this.yIw != null) {
                this.yIw.a(com.tencent.mm.ui.chatting.ah.a.del);
            }
            AppMethodBeat.o(30529);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.i(30530);
            if (this.yIv != null) {
                this.yIv.dismiss();
                if (this.yIw != null) {
                    this.yIw.b(com.tencent.mm.ui.chatting.ah.a.del);
                }
            }
            AppMethodBeat.o(30530);
            return true;
        }
    }

    public static void a(Context context, Set<Long> set, ah ahVar) {
        AppMethodBeat.i(30531);
        if (context == null) {
            ab.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
            AppMethodBeat.o(30531);
        } else if (set == null || set.isEmpty()) {
            ab.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
            AppMethodBeat.o(30531);
        } else {
            context.getString(R.string.tz);
            j.yOM.e(new a(set, h.b(context, context.getString(R.string.b5b), false, null), ahVar));
            com.tencent.mm.plugin.report.service.h.pYm.e(10811, Integer.valueOf(4), Integer.valueOf(set.size()));
            AppMethodBeat.o(30531);
        }
    }
}
