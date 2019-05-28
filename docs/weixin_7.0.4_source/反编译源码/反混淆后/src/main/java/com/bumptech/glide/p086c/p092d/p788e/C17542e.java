package com.bumptech.glide.p086c.p092d.p788e;

import com.bumptech.glide.p086c.p088b.C41547q;
import com.bumptech.glide.p086c.p092d.p787c.C25449b;
import com.bumptech.glide.p095h.C45002j;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.e.e */
public final class C17542e extends C25449b<C37186c> implements C41547q {
    public C17542e(C37186c c37186c) {
        super(c37186c);
    }

    /* renamed from: mK */
    public final Class<C37186c> mo2232mK() {
        return C37186c.class;
    }

    public final int getSize() {
        AppMethodBeat.m2504i(92334);
        C25452g c25452g = ((C37186c) this.drawable).aFU.aGa;
        int j = C45002j.m82424j(c25452g.mo42492nD().getWidth(), c25452g.mo42492nD().getHeight(), c25452g.mo42492nD().getConfig()) + c25452g.aGb.mo42438lW();
        AppMethodBeat.m2505o(92334);
        return j;
    }

    public final void recycle() {
        AppMethodBeat.m2504i(92335);
        ((C37186c) this.drawable).stop();
        C37186c c37186c = (C37186c) this.drawable;
        c37186c.aBU = true;
        C25452g c25452g = c37186c.aFU.aGa;
        c25452g.callbacks.clear();
        c25452g.mo42493nF();
        c25452g.isRunning = false;
        if (c25452g.aGf != null) {
            c25452g.awX.mo18674c(c25452g.aGf);
            c25452g.aGf = null;
        }
        if (c25452g.aGh != null) {
            c25452g.awX.mo18674c(c25452g.aGh);
            c25452g.aGh = null;
        }
        if (c25452g.aGj != null) {
            c25452g.awX.mo18674c(c25452g.aGj);
            c25452g.aGj = null;
        }
        c25452g.aGb.clear();
        c25452g.aGg = true;
        AppMethodBeat.m2505o(92335);
    }

    public final void initialize() {
        AppMethodBeat.m2504i(92336);
        ((C37186c) this.drawable).mo59276ny().prepareToDraw();
        AppMethodBeat.m2505o(92336);
    }
}
