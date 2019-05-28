package com.tencent.p177mm.p612ui.chatting.p616c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.C23810o;
import com.tencent.p177mm.p612ui.chatting.ChatFooterCustom;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15611aj;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30468n;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46642l;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter;

@C15590a(dFp = C30468n.class)
/* renamed from: com.tencent.mm.ui.chatting.c.p */
public class C23760p extends C44291a implements C30468n {
    private long[] yJa = null;
    private boolean yPE = false;
    private C23810o yPF = null;

    public final void dxx() {
        AppMethodBeat.m2504i(31404);
        this.yPE = this.cgL.yTx.getBooleanExtra("expose_edit_mode", false).booleanValue();
        this.yJa = this.cgL.yTx.getArguments().getLongArray("expose_selected_ids");
        AppMethodBeat.m2505o(31404);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31406);
        super.dxz();
        if (this.yPF != null) {
            C23810o c23810o = this.yPF;
            C15612h c15612h = (C15612h) c23810o.cgL.mo74857aF(C15612h.class);
            ((C23733z) c23810o.cgL.mo74857aF(C23733z.class)).dEP();
            c15612h.dCW();
            c15612h.dCR();
            if (c23810o.yJa != null) {
                for (long nf : c23810o.yJa) {
                    c15612h.mo27825nf(nf);
                }
            }
            ChatFooter dDX = ((C15614o) c23810o.cgL.mo74857aF(C15614o.class)).dDX();
            if (dDX != null) {
                dDX.setVisibility(8);
            }
            ChatFooterCustom dDY = ((C15614o) c23810o.cgL.mo74857aF(C15614o.class)).dDY();
            if (dDY != null) {
                dDY.setVisibility(8);
            }
            ((C46642l) c23810o.cgL.mo74857aF(C46642l.class)).dDV();
            c23810o.cgL.aqX();
            ((C15611aj) c23810o.cgL.mo74857aF(C15611aj.class)).dFn();
            c23810o.cgL.mo74883qv(true);
        }
        AppMethodBeat.m2505o(31406);
    }

    public final boolean dDW() {
        return this.yPE;
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31405);
        if (this.yPE && this.yPF == null) {
            this.yPF = new C23810o(this.cgL, this.yJa);
        }
        AppMethodBeat.m2505o(31405);
    }
}
