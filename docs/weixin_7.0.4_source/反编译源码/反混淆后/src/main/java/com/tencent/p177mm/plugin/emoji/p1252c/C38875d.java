package com.tencent.p177mm.plugin.emoji.p1252c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C37781pe;
import com.tencent.p177mm.plugin.emoji.model.C20378d;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.emoji.c.d */
public final class C38875d extends C4884c<C37781pe> {
    public C38875d() {
        AppMethodBeat.m2504i(52818);
        this.xxI = C37781pe.class.getName().hashCode();
        AppMethodBeat.m2505o(52818);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(52819);
        C37781pe c37781pe = (C37781pe) c4883b;
        if (c37781pe instanceof C37781pe) {
            if (c37781pe.cLt.cvx == 0) {
                C20378d bkh = C42952j.bkh();
                long j = c37781pe.cLt.cLw;
                bkh.kVf.put(Long.valueOf(j), c37781pe.cLt.cLu);
            } else {
                C4990ab.m7416i("MicroMsg.emoji.EmojiRevokeMsgListener", "has handle in sys cmd msg extension.");
            }
        }
        AppMethodBeat.m2505o(52819);
        return false;
    }
}
