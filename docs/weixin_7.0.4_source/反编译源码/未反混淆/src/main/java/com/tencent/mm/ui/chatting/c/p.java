package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.l;
import com.tencent.mm.ui.chatting.c.b.n;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.o;

@a(dFp = n.class)
public class p extends a implements n {
    private long[] yJa = null;
    private boolean yPE = false;
    private o yPF = null;

    public final void dxx() {
        AppMethodBeat.i(31404);
        this.yPE = this.cgL.yTx.getBooleanExtra("expose_edit_mode", false).booleanValue();
        this.yJa = this.cgL.yTx.getArguments().getLongArray("expose_selected_ids");
        AppMethodBeat.o(31404);
    }

    public final void dxz() {
        AppMethodBeat.i(31406);
        super.dxz();
        if (this.yPF != null) {
            o oVar = this.yPF;
            h hVar = (h) oVar.cgL.aF(h.class);
            ((z) oVar.cgL.aF(z.class)).dEP();
            hVar.dCW();
            hVar.dCR();
            if (oVar.yJa != null) {
                for (long nf : oVar.yJa) {
                    hVar.nf(nf);
                }
            }
            ChatFooter dDX = ((com.tencent.mm.ui.chatting.c.b.o) oVar.cgL.aF(com.tencent.mm.ui.chatting.c.b.o.class)).dDX();
            if (dDX != null) {
                dDX.setVisibility(8);
            }
            ChatFooterCustom dDY = ((com.tencent.mm.ui.chatting.c.b.o) oVar.cgL.aF(com.tencent.mm.ui.chatting.c.b.o.class)).dDY();
            if (dDY != null) {
                dDY.setVisibility(8);
            }
            ((l) oVar.cgL.aF(l.class)).dDV();
            oVar.cgL.aqX();
            ((aj) oVar.cgL.aF(aj.class)).dFn();
            oVar.cgL.qv(true);
        }
        AppMethodBeat.o(31406);
    }

    public final boolean dDW() {
        return this.yPE;
    }

    public final void dxy() {
        AppMethodBeat.i(31405);
        if (this.yPE && this.yPF == null) {
            this.yPF = new o(this.cgL, this.yJa);
        }
        AppMethodBeat.o(31405);
    }
}
